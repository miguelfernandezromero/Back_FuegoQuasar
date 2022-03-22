package com.edesafio.quasar.service;

import java.util.List;

import com.edesafio.quasar.dto.ResponseDTO;
import com.edesafio.quasar.dto.SatelliteDTO;
import com.edesafio.quasar.dto.SatellitesDTO;

public interface IFuegoQuasarService {
	
	ResponseDTO topsecret(SatellitesDTO satellites);
	
	ResponseDTO topsecretSplitPost(String satelliteName, SatelliteDTO satellite);
	
	SatellitesDTO topsecretSplitGet();

}
