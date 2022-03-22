package com.edesafio.quasar.utility;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.edesafio.quasar.dto.SatelliteDTO;
import com.edesafio.quasar.entity.SatellitesRqEntity;

@Component
public class Mapper {
	
	public SatellitesRqEntity dtoToSatelliteRq(SatelliteDTO satellite, String name) {
		SatellitesRqEntity saveSatellite = new SatellitesRqEntity();
		saveSatellite.setName(name);
		saveSatellite.setDistance(satellite.getDistance());
		saveSatellite.setMessage(satellite.getMessage());
		return saveSatellite;
	}
	
	public List<SatelliteDTO> entityToSatelliteDTO(List<SatellitesRqEntity> entity) {
		
		List<SatelliteDTO> response = new ArrayList<>();
		for (SatellitesRqEntity satellitesRqEntity : entity) {
			SatelliteDTO satellite = new SatelliteDTO();
			satellite.setName(satellitesRqEntity.getName());
			satellite.setDistance(satellitesRqEntity.getDistance());
			satellite.setMessage(satellitesRqEntity.getMessage());
			response.add(satellite);
			
		}
		
		return response;
		
	}

}
