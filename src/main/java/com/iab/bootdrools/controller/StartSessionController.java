package com.iab.bootdrools.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.iab.bootdrools.model.GeometryChangeResult;
import com.iab.bootdrools.model.SessionStartResult;
import com.iab.bootdrools.service.StartSessionService;

@RestController
public class StartSessionController {

	@Autowired
	private StartSessionService startSessionService;

	@GetMapping("/getSessionStartResult")
	public ResponseEntity<SessionStartResult> getDiscount() {
		SessionStartResult results = startSessionService.getSessionStartResults();
		return new ResponseEntity<>(results, HttpStatus.OK);
	}
	
	@GetMapping("/getGeometryChangeResult")
	public ResponseEntity<GeometryChangeResult> getGeometryChange() {
		GeometryChangeResult results = startSessionService.getGeometryChange();
		return new ResponseEntity<>(results, HttpStatus.OK);
	}

}
