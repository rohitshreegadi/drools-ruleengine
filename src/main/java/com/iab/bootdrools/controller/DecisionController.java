package com.iab.bootdrools.controller;

import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.iab.bootdrools.model.DepositRequest;
import com.iab.bootdrools.model.SessionStartObject;
import com.iab.bootdrools.service.JSONParserService;

@RestController
public class DecisionController {

	@Autowired
	private KieContainer kieContainer;

	@Autowired
	private JSONParserService jsonParserService; 
	
//	@RequestMapping(value = "/getInterestRate", method = RequestMethod.GET, produces = "application/json")
//	public String getInterest(@RequestParam(required = true) String loanType,
//			@RequestParam(required = true) Integer durationInYear, @RequestParam(required = true) Integer age) {
//		KieSession kieSession = kieContainer.newKieSession();
//		DepositRequest depositRequest = new DepositRequest(loanType, durationInYear, age);
//		kieSession.insert(depositRequest);
//		kieSession.fireAllRules();
//		kieSession.dispose();
//		return "The interest rate for this application is " + depositRequest.getInterestRate();
//	}
	
	@RequestMapping(value = "/testSessionStarted", method = RequestMethod.GET, produces = "application/json")
	public String getComplainceTest() {
		KieSession kieSession = kieContainer.newKieSession();
	//	DepositRequest depositRequest = new DepositRequest(adSessionId);
		// SessionStartObject sessionObject = new SessionStartObject(adSessionId,type,timestamp);
		SessionStartObject sessionObject= jsonParserService.getSessionObject();
		kieSession.insert(sessionObject);
		kieSession.fireAllRules();
		kieSession.dispose();
		return "sessionStart: AdSessionId " + sessionObject.getAdSessionIdExists() ;
	}
}