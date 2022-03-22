package com.edesafio.quasar.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.edesafio.quasar.api.FuegoQuasarApi;
import com.edesafio.quasar.dto.SatelliteDTO;
import com.edesafio.quasar.dto.SatellitesDTO;
import com.edesafio.quasar.service.IFuegoQuasarService;


import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@RestController
public class FuegoQuasarController implements FuegoQuasarApi {
	
	@Autowired
	private IFuegoQuasarService service;

	@Override
	@PostMapping(value = "/topsecret/")
	public ResponseEntity<Object> topsecret(@RequestBody SatellitesDTO satellites, BindingResult result) {		
		return new ResponseEntity<>(service.topsecret(satellites), HttpStatus.OK);
	}

	@Override
	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping(value = "/topsecret_split/{satellite_name}")
	public ResponseEntity<Object> topsecretSplitPost(
			@PathVariable("satellite_name") String satelliteName, 
			@RequestBody SatelliteDTO satellite,
			BindingResult result) {
		service.topsecretSplitPost(satelliteName, satellite);
		return new ResponseEntity<>(null, HttpStatus.CREATED);
	}

	@Override
	@GetMapping(value = "/topsecret_split/")
	public ResponseEntity<Object> topsecretSplitGet() {		
		return new ResponseEntity<>(service.topsecretSplitGet(), HttpStatus.OK);
	}



}
