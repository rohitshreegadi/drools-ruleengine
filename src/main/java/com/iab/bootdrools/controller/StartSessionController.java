package com.iab.bootdrools.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.iab.bootdrools.service.StartSessionService;

@RestController
public class StartSessionController {

	@Autowired
	private StartSessionService startSessionService;


	@GetMapping("/getLoadedResult")
	public ResponseEntity<Object> getLoadedResult() {
		Object results = startSessionService.getLoaded();
		return new ResponseEntity<>(results, HttpStatus.OK);
	}
	
}
