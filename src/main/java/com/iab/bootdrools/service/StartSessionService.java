package com.iab.bootdrools.service;

import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iab.bootdrools.model.GeometryChangeObject;
import com.iab.bootdrools.model.GeometryChangeResult;
import com.iab.bootdrools.model.SessionStartObject;
import com.iab.bootdrools.model.SessionStartResult;

@Service
public class StartSessionService {

	@Autowired
	private JSONParserService jsonParserService;


	@Autowired
    private KieContainer kieContainer;
	//Todo
	//getSessionStartResults multiple sheet code Not woking -Nikhil 
	
	public SessionStartResult getSessionStartResults() {   
		SessionStartObject sessionObject = jsonParserService.getSessionObject();
		SessionStartResult sessionStartResult = new SessionStartResult();
		KieSession kieSession = kieContainer.newKieSession();
		kieSession.setGlobal("sessionStartResult", sessionStartResult);
		kieSession.insert(sessionObject);
		kieSession.fireAllRules();
		kieSession.dispose();
		return sessionStartResult;
	}
	
	public GeometryChangeResult getGeometryChange() {
		GeometryChangeObject geometryChangeObject = jsonParserService.getGeometryObject();
		GeometryChangeResult geometryChangeResult = new GeometryChangeResult();
		KieSession kieSession = kieContainer.newKieSession();
		kieSession.setGlobal("geometryChangeResult", geometryChangeResult);
		kieSession.insert(geometryChangeObject);
		kieSession.fireAllRules();
		kieSession.dispose();
		return geometryChangeResult;
	}

	}
