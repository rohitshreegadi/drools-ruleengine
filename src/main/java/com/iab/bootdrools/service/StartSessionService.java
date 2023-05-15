package com.iab.bootdrools.service;

import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iab.bootdrools.model.LoadedObject;
import com.iab.bootdrools.model.LoadedResult;
import com.iab.bootdrools.model.SessionFinishObject;
import com.iab.bootdrools.model.SessionFinishResult;

@Service
public class StartSessionService {

	@Autowired
	private JSONParserService jsonParserService;


	@Autowired
    private KieContainer kieContainer;
	//Todo
	//getSessionStartResults multiple sheet code Not woking -Nikhil 
	
//	public SessionStartResult getSessionStartResults() {   
//		SessionStartObject sessionObject = jsonParserService.getSessionObject();
//		SessionStartResult sessionStartResult = new SessionStartResult();
//		KieSession kieSession = kieContainer.newKieSession();
//		kieSession.setGlobal("sessionStartResult", sessionStartResult);
//		kieSession.insert(sessionObject);
//		kieSession.fireAllRules();
//		kieSession.dispose();
//		return sessionStartResult;
//	}
	
//	public GeometryChangeResult getGeometryChange() {
//        GeometryChangeObject geometryChangeObject = jsonParserService.getGeometryObject();
//        GeometryChangeResult geometryChangeResult = new GeometryChangeResult();
//        KieSession kieSession = kieContainer.newKieSession();
//        kieSession.setGlobal("geometryChangeResult", geometryChangeResult);
//        kieSession.insert(geometryChangeObject);
//        kieSession.fireAllRules();
//        kieSession.dispose();
//        return geometryChangeResult;
//    }

	public Object getLoaded() {
		Object loadedObject = jsonParserService.getloadedObject();
		System.err.println(loadedObject);
		LoadedResult loadedResult = new LoadedResult();
		KieSession kieSession = kieContainer.newKieSession();
		kieSession.setGlobal("loadedResult", loadedResult);
		kieSession.insert(loadedObject);
		kieSession.fireAllRules();
		kieSession.dispose();
		return loadedResult;
	}
	
//	public ImpressionResult getImpression() {
//        ImpressionObject impressionObject = jsonParserService.getImpressionObject();
//        ImpressionResult impressionResult = new ImpressionResult();
//        KieSession kieSession = kieContainer.newKieSession();
//        kieSession.setGlobal("impressionResult", impressionResult);
//        kieSession.insert(impressionObject);
//        kieSession.fireAllRules();
//        kieSession.dispose();
//        return impressionResult;
//    }
	
//	public SessionFinishResult getSessionFinish() {
//		SessionFinishObject sessionFinishObject = jsonParserService.getSessionFinishObject();
//		SessionFinishResult sessionFinishResult = new SessionFinishResult();
//		KieSession kieSession = kieContainer.newKieSession();
//		kieSession.setGlobal("sessionFinishResult", sessionFinishResult);
//		kieSession.insert(sessionFinishObject);
//		kieSession.fireAllRules();
//		kieSession.dispose();
//		return sessionFinishResult;
//	}

	}
