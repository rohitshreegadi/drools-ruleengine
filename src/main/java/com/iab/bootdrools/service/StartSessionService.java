package com.iab.bootdrools.service;

import java.util.HashMap;
import java.util.Map;

import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.iab.bootdrools.model.GeometryChangeObject;
import com.iab.bootdrools.model.GeometryChangeResult;
import com.iab.bootdrools.model.ImpressionObject;
import com.iab.bootdrools.model.ImpressionResult;
import com.iab.bootdrools.model.LoadedObject;
import com.iab.bootdrools.model.LoadedResult;
import com.iab.bootdrools.model.SessionFinishObject;
import com.iab.bootdrools.model.SessionFinishResult;
import com.iab.bootdrools.model.SessionStartObject;
import com.iab.bootdrools.model.SessionStartResult;

@Service
public class StartSessionService {

	@Autowired
	private JSONParserService jsonParserService;


	@Autowired
    private KieContainer kieContainer;
	
	public SessionStartResult getSessionStartResults(Object Object1) {   
		
		SessionStartResult sessionStartResult = new SessionStartResult();
		KieSession kieSession = kieContainer.newKieSession();
		kieSession.setGlobal("sessionStartResult", sessionStartResult);
		kieSession.insert(Object1);
		kieSession.fireAllRules();
		kieSession.dispose();
		System.err.println(sessionStartResult);
		return sessionStartResult;
	}
	
	public GeometryChangeResult getGeometryChange(Object geometryChangeObject) {
        GeometryChangeResult geometryChangeResult = new GeometryChangeResult();
        KieSession kieSession = kieContainer.newKieSession();
        kieSession.setGlobal("geometryChangeResult", geometryChangeResult);
        kieSession.insert(geometryChangeObject);
        kieSession.fireAllRules();
        kieSession.dispose();
        return geometryChangeResult;
    }

	public Object getLoaded() {
		Map<String, String> loadedObject = jsonParserService.getloadedObject();
//		List<Object> list = new ArrayList<>();
		Map<String, Object> map=  new HashMap<>(); 
		//LoadedResult loadedResult = new LoadedResult();
		for (String key : loadedObject.keySet()) {
		    String value = loadedObject.get(key);
		    String keys = key.replaceAll("\\d", "");
		switch (keys) {
		case "loaded":
			Gson g = new Gson();
			LoadedObject	Object1 = g.fromJson(value, LoadedObject.class);
			LoadedResult result=	getloadedTest(Object1);
//			list.add(result);
			map.put(key, result);
			
			break;

		case "sessionFinish":
			Gson g1 = new Gson();
			SessionFinishObject	Object11 = g1.fromJson(value, SessionFinishObject.class);
			SessionFinishResult result1=	getSessionFinish(Object11);
//			list.add(result1);
			map.put(key, result1);
			break;
		
		case "sessionStart":
			Gson g11 = new Gson();
			SessionStartObject	Object111 = g11.fromJson(value, SessionStartObject.class);
			SessionStartResult result11=	getSessionStartResults(Object111);
//			list.add(result1);
			map.put(key, result11);
			break;	
			
		case "geometryChange":
			Gson geometry = new Gson();
			GeometryChangeObject	geometryObj = geometry.fromJson(value, GeometryChangeObject.class);
			GeometryChangeResult geometryresult=	getGeometryChange(geometryObj);
//			list.add(result1);
			map.put(key, geometryresult);
			break;		
			
		case "impression":
			Gson impression = new Gson();
			ImpressionObject	impressionObj = impression.fromJson(value, ImpressionObject.class);
			ImpressionResult impressionresult=	getImpression(impressionObj);
//			list.add(result1);
			map.put(key, impressionresult);
			break;		
		default:
			break;
		}

		}
		return map;
		
	}
	
	public ImpressionResult getImpression(Object impressionObject) {
		
        ImpressionResult impressionResult = new ImpressionResult();
        KieSession kieSession = kieContainer.newKieSession();
        kieSession.setGlobal("impressionResult", impressionResult);
        kieSession.insert(impressionObject);
        kieSession.fireAllRules();
        kieSession.dispose();
        return impressionResult;
    }
	
	public SessionFinishResult getSessionFinish(Object sessionFinishObject) {
		SessionFinishResult sessionFinishResult = new SessionFinishResult();
		KieSession kieSession = kieContainer.newKieSession();
		kieSession.setGlobal("sessionFinishResult", sessionFinishResult);
		kieSession.insert(sessionFinishObject);
		kieSession.fireAllRules();
		kieSession.dispose();
		System.err.println(sessionFinishResult);
		return sessionFinishResult;
	}
	
	public LoadedResult getloadedTest(Object sessionFinishObject) {
		LoadedResult sessionFinishResult = new LoadedResult();
		KieSession kieSession = kieContainer.newKieSession();
		kieSession.setGlobal("loadedResult", sessionFinishResult);
		kieSession.insert(sessionFinishObject);
		kieSession.fireAllRules();
		kieSession.dispose();
		System.err.println(sessionFinishResult);
		return sessionFinishResult;
	}

	}
