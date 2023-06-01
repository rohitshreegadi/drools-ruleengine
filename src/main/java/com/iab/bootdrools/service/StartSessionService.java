package com.iab.bootdrools.service;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.iab.bootdrools.model.GeometryChangeObject;
import com.iab.bootdrools.model.GeometryChangeResult;
import com.iab.bootdrools.model.ImpressionObject;
import com.iab.bootdrools.model.ImpressionResult;
import com.iab.bootdrools.model.LoadedObject;
import com.iab.bootdrools.model.LoadedResult;
import com.iab.bootdrools.model.QueryData;
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

	public List<Object> getBanner(MultipartFile convertedFile) throws IOException {
		Map<String, Object> bannerObject = jsonParserService.getBannerObject(convertedFile);
		List<Object> list = new ArrayList<>();
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
			ObjectMapper om = new ObjectMapper();
			List<String> keyName = new ArrayList<>();
			int i = 0;
			long milliseconds = Long.parseLong(loaded.getTimestamp());
	    	Timestamp ts = new Timestamp(milliseconds);
			//System.err.println("*******"+loaded.getTimestamp());
			
			Map<String,String> map = (Map<String, String>) om.convertValue(loadedResult, Map.class);
			  for (String mainkey: map.keySet()) {
		            if("doesntexists".equalsIgnoreCase(map.get(mainkey))) {
		            	i++;
		            	keyName.add(mainkey);
		            }
		        }
			  Map<String,String> newcheck = new HashMap<>();
			  ObjectMapper om1 = new ObjectMapper();
			  Map<String,String> map1 = (Map<String, String>) om1.convertValue(loaded, Map.class);
			  for (String mainkey: map1.keySet()) {
		            if(keyName.contains(mainkey)) {
		            	newcheck.put(mainkey, map1.get(mainkey));
		            }
			  }   
			  QueryData queryData= new QueryData();
			    queryData.setQuery(query);
			    queryData.setCount(i);
			    queryData.setErrorMessage(newcheck);
			loadedResult.setQueryData(queryData);
			loadedResult.setEventType(keys);
			loadedResult.setTimestamp(ts.toString());
			list.add(loadedResult);
			
			break;
//
//		case "sessionFinish":
//			Gson sessionFinish = new Gson();
//			SessionFinishObject	sessionFinishObject = sessionFinish.fromJson(value, SessionFinishObject.class);
//			SessionFinishResult sessionFinishresult=	getSessionFinish(sessionFinishObject);
//			sessionFinishresult.setQueryData(queryData);
//			sessionFinishresult.setEventType(keys);
//			list.add(sessionFinishresult);
//			
//			break;
//		
//		case "sessionStart":
//			Gson sessionStart = new Gson();
//			SessionStartObject	sessionStartObject = sessionStart.fromJson(value, SessionStartObject.class);
//			SessionStartResult sessionStartresult=	getSessionStartResults(sessionStartObject);
//			sessionStartresult.setQueryData(queryData);
//			sessionStartresult.setEventType(keys);
//			list.add(sessionStartresult);
//			break;	
//			
//		case "geometryChange":
//			Gson geometry = new Gson();
//			GeometryChangeObject	geometryObj = geometry.fromJson(value, GeometryChangeObject.class);
//			GeometryChangeResult geometryresult=	getGeometryChange(geometryObj);
//			geometryresult.setQueryData(queryData);
//			geometryresult.setEventType(keys);
//			list.add(geometryresult);
//			break;		
			
//		case "impression":
//			Gson impression = new Gson();
//			ImpressionObject	impressionObj = impression.fromJson(value, ImpressionObject.class);
//			ImpressionResult impressionresult=	getImpression(impressionObj);
//			impressionresult.setQueryData(queryData);
//			impressionresult.setEventType(keys);
//			list.add(impressionresult);
//			break;		
		default:
			break;
		}

		}
		return list;
		
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
