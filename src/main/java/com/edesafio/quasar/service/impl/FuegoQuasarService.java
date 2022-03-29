package com.edesafio.quasar.service.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.transaction.Transactional;

import com.lemmingapex.trilateration.NonLinearLeastSquaresSolver;
import com.lemmingapex.trilateration.TrilaterationFunction;
import org.apache.commons.math3.fitting.leastsquares.LevenbergMarquardtOptimizer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import com.edesafio.quasar.dto.PositionDto;
import com.edesafio.quasar.dto.ResponseDTO;
import com.edesafio.quasar.dto.SatelliteDTO;
import com.edesafio.quasar.dto.SatellitesDTO;
import com.edesafio.quasar.entity.SatellitesRqEntity;
import com.edesafio.quasar.repository.SatellitesRqRepository;
import com.edesafio.quasar.service.IFuegoQuasarService;
import com.edesafio.quasar.utility.Mapper;

@Service
public class FuegoQuasarService implements IFuegoQuasarService {

	@Autowired
	MessageService messageService;

	@Autowired
	SatellitesRqRepository rqRepository;

	@Autowired
	Mapper mapper;
	
	@Autowired
	LocationService locationService;

	public ResponseDTO topsecret(SatellitesDTO satellites) {
		ResponseDTO response = new ResponseDTO();

		List<SatelliteDTO> satellite = satellites.getSatellite();

		double[] result = locationService.getLocation(locationService.getCoordinates(),
				locationService.getDistance(satellite));

		PositionDto position = new PositionDto();
		position.setX(result[0]);
		position.setY(result[1]);
		response.setPosition(position);
		response.setMessage(messageService.getMessage(satellites));

		return response;
	}

	@Override
	public ResponseDTO topsecretSplitPost(String satelliteName, SatelliteDTO satellite) {

		SatellitesRqEntity searchSatellite = rqRepository.findByName(satelliteName);
		if (searchSatellite != null) {
			searchSatellite.setDistance(satellite.getDistance());
			searchSatellite.setMessage(satellite.getMessage());
			rqRepository.save(searchSatellite);

		} else {
			SatellitesRqEntity entity = mapper.dtoToSatelliteRq(satellite, satelliteName);
			rqRepository.save(entity);
		}

		ResponseDTO response = new ResponseDTO();
		return response;
	}

	@Override
	public SatellitesDTO topsecretSplitGet() {
		List<SatellitesRqEntity> entity = rqRepository.findAll();	
		return new SatellitesDTO(mapper.entityToSatelliteDTO(entity));
	}

};