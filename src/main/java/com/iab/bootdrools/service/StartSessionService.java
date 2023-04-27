package com.iab.bootdrools.service;

import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iab.bootdrools.model.SessionStartObject;
import com.iab.bootdrools.model.SessionStartResult;

@Service
public class StartSessionService {

	@Autowired
	private JSONParserService jsonParserService;

	@Autowired
    private KieContainer kieContainer;
	
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

}
