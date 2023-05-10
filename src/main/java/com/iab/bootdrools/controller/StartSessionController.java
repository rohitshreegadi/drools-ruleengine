package com.iab.bootdrools.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.iab.bootdrools.model.SessionFinishResult;
import com.iab.bootdrools.service.StartSessionService;

@RestController
public class StartSessionController {

	@Autowired
	private StartSessionService startSessionService;

//	@GetMapping("/getSessionStartResult")
//	public ResponseEntity<SessionStartResult> getDiscount() {
//		SessionStartResult results = startSessionService.getSessionStartResults();
//		return new ResponseEntity<>(results, HttpStatus.OK);
//	}
	
//	@GetMapping("/getGeometryChangeResult")
//	public ResponseEntity<GeometryChangeResult> getGeometryChange() {
//		GeometryChangeResult results = startSessionService.getGeometryChange();
//		return new ResponseEntity<>(results, HttpStatus.OK);
//	}

//	@GetMapping("/getLoadedResult")
//	public ResponseEntity<LoadedResult> getLoadedResult() {
//		LoadedResult results = startSessionService.getLoaded();
//		return new ResponseEntity<>(results, HttpStatus.OK);
//	}
	
//	@GetMapping("/getImpressionResult")
//    public ResponseEntity<ImpressionResult> getImpressionResult() {
//        ImpressionResult results = startSessionService.getImpression();
//        return new ResponseEntity<>(results, HttpStatus.OK);
//    }
	
	@GetMapping("/getSessionFinishResult")
	public ResponseEntity<SessionFinishResult> getSessionFinishResult() {
		SessionFinishResult results = startSessionService.getSessionFinish();
		return new ResponseEntity<>(results, HttpStatus.OK);
	}
}
