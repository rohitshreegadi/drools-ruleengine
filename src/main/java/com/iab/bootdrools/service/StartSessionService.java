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
	
	public SessionStartResult getSessionStartResults(Object sessionStartObject) {   
		
		SessionStartResult sessionStartResult = new SessionStartResult();
		KieSession kieSession = kieContainer.newKieSession();
		kieSession.setGlobal("sessionStartResult", sessionStartResult);
		kieSession.insert(sessionStartObject);
		kieSession.fireAllRules();
		kieSession.dispose();
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

	public Object getBanner() {
		Map<String, Object> bannerObject = jsonParserService.getBannerObject();
		Map<String, Object> map=  new HashMap<>(); 
		for (String key : bannerObject.keySet()) {
		    Map<String , String> getvalue = (Map<String, String>) bannerObject.get(key);
		   String value = getvalue.get("drool");
		   String query = getvalue.get("original");
		    String keys = key.replaceAll("\\d", "");
		switch (keys) {
		case "loaded":
			Gson g = new Gson();
			LoadedObject	loaded = g.fromJson(value, LoadedObject.class);
			LoadedResult loadedResult=	getloadedTest(loaded);
			loadedResult.setQuery(query);
//			list.add(result);
			map.put(key, loadedResult);
			
			break;

		case "sessionFinish":
			Gson sessionFinish = new Gson();
			SessionFinishObject	sessionFinishObject = sessionFinish.fromJson(value, SessionFinishObject.class);
			SessionFinishResult sessionFinishresult=	getSessionFinish(sessionFinishObject);
			sessionFinishresult.setQuery(query);
			map.put(key, sessionFinishresult);
			break;
		
		case "sessionStart":
			Gson sessionStart = new Gson();
			SessionStartObject	sessionStartObject = sessionStart.fromJson(value, SessionStartObject.class);
			SessionStartResult sessionStartresult=	getSessionStartResults(sessionStartObject);
			sessionStartresult.setQuery(query);
			map.put(key, sessionStartresult);
			break;	
			
		case "geometryChange":
			Gson geometry = new Gson();
			GeometryChangeObject	geometryObj = geometry.fromJson(value, GeometryChangeObject.class);
			GeometryChangeResult geometryresult=	getGeometryChange(geometryObj);
			geometryresult.setQuery(query);
			map.put(key, geometryresult);
			break;		
			
		case "impression":
			Gson impression = new Gson();
			ImpressionObject	impressionObj = impression.fromJson(value, ImpressionObject.class);
			ImpressionResult impressionresult=	getImpression(impressionObj);
			impressionresult.setQuery(query);
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
		return sessionFinishResult;
	}
	
	public LoadedResult getloadedTest(Object sessionFinishObject) {
		LoadedResult sessionFinishResult = new LoadedResult();
		KieSession kieSession = kieContainer.newKieSession();
		kieSession.setGlobal("loadedResult", sessionFinishResult);
		kieSession.insert(sessionFinishObject);
		kieSession.fireAllRules();
		kieSession.dispose();
		return sessionFinishResult;
	}

	}
