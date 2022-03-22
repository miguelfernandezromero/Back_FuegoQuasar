package com.edesafio.quasar.api;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;

import com.edesafio.quasar.dto.SatelliteDTO;
import com.edesafio.quasar.dto.SatellitesDTO;

import io.swagger.annotations.ApiParam;



public interface FuegoQuasarApi {
	
	public ResponseEntity<Object> topsecret(
			@ApiParam(name = "response", value = "get the location of the ship and the message", required = true) SatellitesDTO satellites,
			BindingResult result);
	
	public ResponseEntity<Object> topsecretSplitPost(
			@ApiParam(name = "satellite_name", value = "satellite name", required = true) String satelliteName,
			@ApiParam(name = "response", value = "get the location of the ship and the message", required = true) SatelliteDTO satellite,
			BindingResult result);
	
	public ResponseEntity<Object> topsecretSplitGet();

}
