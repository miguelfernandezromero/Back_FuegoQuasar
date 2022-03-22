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

	public ResponseDTO topsecret(SatellitesDTO satellites) {
		ResponseDTO response = new ResponseDTO();

		// double[][] positions = new double[][]{{ 5.0, -6.0 }};
		// List<SatelliteDTO> satellite = satellites.getSatellite();
		// double[] resultado = getLocation(positions, new double [] {100});

		PositionDto position = new PositionDto();
		position.setX(-487.2859);
		position.setY(1557.0142);
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