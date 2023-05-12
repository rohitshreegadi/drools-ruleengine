package com.iab.bootdrools.service;

//import java.io.FileInputStream;
//import java.io.FileNotFoundException;
//import java.net.URLDecoder;
//
//import javax.json.Json;
//import javax.json.stream.JsonParser.Event;
//
//import org.springframework.stereotype.Service;
//
//import com.codeusingjava.bootdrools.model.SessionStartObject;
//import com.google.gson.Gson;
//import com.google.gson.JsonParser;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.json.Json;
import javax.json.stream.JsonParser;
import javax.json.stream.JsonParser.Event;

import org.json.JSONObject;
import org.springframework.stereotype.Service;

import com.github.wnameless.json.flattener.JsonFlattener;
import com.google.gson.Gson;
import com.iab.bootdrools.model.LoadedObject;

@Service
public class JSONParserService {
	
	public LoadedObject jsonFlattenLoaded(String jsonObject) {

		String flattenedJson = JsonFlattener.flatten(jsonObject.toString())
				.replaceAll("data.", "").replace("viewport.", "").replaceAll("adView.", "");
		LoadedObject loadedObject;
		//System.err.println(flattenedJson);
		JSONObject jsonObj = new JSONObject(flattenedJson);
        JSONObject newJsonObj = new JSONObject();
        
        for (String key : jsonObj.keySet()) {
            String newKey = key.replace(".", "");
            Object value = jsonObj.get(key);
            newJsonObj.put(newKey, value);
        }
        
        String newJsonStr = newJsonObj.toString();
       // System.err.println(newJsonStr);
		Gson g = new Gson();
		loadedObject = g.fromJson(newJsonStr, LoadedObject.class);
		return loadedObject;
	}

	public LoadedObject getloadedObject() {
		JsonParser jsonParser;
		LoadedObject loadedObject = null;
		try {
			jsonParser = Json.createParser(new FileInputStream("src/main/resources/Charles.json"));
			boolean flag = false;

			while (jsonParser.hasNext()) {
				int i=1;
				Event event = jsonParser.next();
				System.err.println(i++);
				switch (event) {
				case VALUE_STRING:
				//	System.err.println(flag);
					if (!flag) {
						String input = jsonParser.getString();
//						System.err.println(event);
//						System.err.println(input);
						Pattern pattern = Pattern.compile("type=(.*?)&");
						Matcher matcher = pattern.matcher(input);

						if (matcher.find()) {
						    String data = matcher.group(1);
						    System.out.println(data +"################ "); // output: "success"
						
						if (jsonParser.getString().contains(data)) {
							
							System.err.println();
							int startIndex = jsonParser.getString().indexOf("rawJSON=");
							String omsdkJson = URLDecoder.decode(jsonParser.getString().substring(startIndex + 8));
							// System.out.println("String values: " + omsdkJson);
							 loadedObject = jsonFlattenLoaded(omsdkJson);
							
							flag = true;
							Map<String , Object> map = new HashMap<>();
						//	map.put(data, map)
						}
					}
					}

//					break;
//
//				default:
//					break;
				}
			}

			//jsonParser.close();

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return loadedObject;

	}

//	public SessionStartObject jsonFlatten(String jsonObject) {
//		String flattenedJson = JsonFlattener.flatten(jsonObject.toString()).replaceAll("data.context.", "")
//				.replaceAll("data.", "").replace("app.", "").replaceAll("omidNativeInfo.", "").replaceAll("omidJsInfo.", "").replace("deviceInfo.", "");
//		SessionStartObject sessionStartObject;
//		System.err.println(flattenedJson);
//		Gson g = new Gson();
//		sessionStartObject = g.fromJson(flattenedJson, SessionStartObject.class);
//
//		return sessionStartObject;
//	}
	

//	public SessionStartObject getSessionObject() {
//		JsonParser jsonParser;
//		SessionStartObject sessionStartObject = null;
//		try {
//			jsonParser = Json.createParser(new FileInputStream("src/main/resources/Charles.json"));
//			boolean flag = false;
//
//			while (jsonParser.hasNext()) {
//				Event event = jsonParser.next();
//				switch (event) {
//				case VALUE_STRING:
//					if (!flag) {
//						if (jsonParser.getString().contains("sessionStart")) {
//							// System.out.println("String values initial: " +
//							// URLDecoder.decode(jsonParser.getString()));
//							// String finalJson = URLDecoder.decode(finalJson);
//							int startIndex = jsonParser.getString().indexOf("rawJSON=");
//							String omsdkJson = URLDecoder.decode(jsonParser.getString().substring(startIndex + 8));
//							 System.out.println("String values: " + omsdkJson);
//							sessionStartObject = jsonFlatten(omsdkJson);
//							// JsonObject jsonObj =
//							// gsonParserService.getJSONObjectByGson(URLDecoder.decode(omsdkJson));
//							// sessionStartedbject.setAdSessionId(sessionStartedbject.getAdSessionId());
//							sessionStartObject.setAdSessionIdLength(sessionStartObject.getAdSessionId().length());
//							// sessionStartedbject.setType(sessionStartedbject.getType());
//							// runRuleEngine(s);
//							System.out.println(sessionStartObject.getAdSessionId() + " " + sessionStartObject.getType()
//									+ " " + sessionStartObject.getVerificationParameters());
//							flag = true;
//							return sessionStartObject;
//						}
//					}
//					break;
//
//				default:
//					break;
//				}
//			}
//			jsonParser.close();
//
//		} catch (FileNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return sessionStartObject;
//	}
	
//	public GeometryChangeObject jsonFlattenGeometry(String jsonObject) {
//
//		String flattenedJson = JsonFlattener.flatten(jsonObject.toString())
//				.replaceAll("data.", "").replace("viewport.", "").replaceAll("adView.", "");
//		GeometryChangeObject GeometryChangeObject;
//		//System.err.println(flattenedJson);
//		JSONObject jsonObj = new JSONObject(flattenedJson);
//        JSONObject newJsonObj = new JSONObject();
//        
//        for (String key : jsonObj.keySet()) {
//            String newKey = key.replace(".", "");
//            Object value = jsonObj.get(key);
//            newJsonObj.put(newKey, value);
//        }
//        
//        String newJsonStr = newJsonObj.toString();
//        System.err.println(newJsonStr);
//		Gson g = new Gson();
//		GeometryChangeObject = g.fromJson(newJsonStr, GeometryChangeObject.class);
//		return GeometryChangeObject;
//	}

//	public GeometryChangeObject getGeometryObject() {
//		JsonParser jsonParser;
//		GeometryChangeObject geometryChangeObject = null;
//		try {
//			jsonParser = Json.createParser(new FileInputStream("src/main/resources/Charles.json"));
//			boolean flag = false;
//
//			while (jsonParser.hasNext()) {
//				Event event = jsonParser.next();
//				switch (event) {
//				case VALUE_STRING:
//					if (!flag) {
//						if (jsonParser.getString().contains("geometryChange")) {
//							// System.out.println("String values initial: " +
//							// URLDecoder.decode(jsonParser.getString()));
//							// String finalJson = URLDecoder.decode(finalJson);
//							int startIndex = jsonParser.getString().indexOf("rawJSON=");
//
//							String omsdkJson = URLDecoder.decode(jsonParser.getString().substring(startIndex + 8));
//							 System.out.println("String values: " + omsdkJson);
//
//							 geometryChangeObject = jsonFlattenGeometry(omsdkJson);
//							// JsonObject jsonObj =
//							// gsonParserService.getJSONObjectByGson(URLDecoder.decode(omsdkJson));
//							// sessionStartedbject.setAdSessionId(sessionStartedbject.getAdSessionId());
////							 geometryChangeObject.setAdSessionIdLength(geometryChangeObject.getAdSessionId().length());
//							// sessionStartedbject.setType(sessionStartedbject.getType());
//							// runRuleEngine(s);
////							System.out.println(geometryChangeObject.getAdSessionId() + " " + geometryChangeObject.getType()
////									+ " " + geometryChangeObject.getVerificationParameters());
//							flag = true;
//							return geometryChangeObject;
//						}
//					}
//
//					break;
//
//				default:
//					break;
//				}
//			}
//
//			jsonParser.close();
//
//		} catch (FileNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return geometryChangeObject;
//
//	}
	

	
	
//	public ImpressionObject jsonFlattenImpression(String jsonObject) {
//
//		String flattenedJson = JsonFlattener.flatten(jsonObject.toString())
//				.replaceAll("data.", "").replace("viewport.", "").replaceAll("adView.", "");
//		ImpressionObject impressionObject;
//		//System.err.println(flattenedJson);
//		JSONObject jsonObj = new JSONObject(flattenedJson);
//        JSONObject newJsonObj = new JSONObject();
//        
//        for (String key : jsonObj.keySet()) {
//            String newKey = key.replace(".", "");
//            Object value = jsonObj.get(key);
//            newJsonObj.put(newKey, value);
//        }
//        
//        String newJsonStr = newJsonObj.toString();
//        System.err.println(newJsonStr);
//		Gson g = new Gson();
//		impressionObject = g.fromJson(newJsonStr, ImpressionObject.class);
//		return impressionObject;
//	}

//	public ImpressionObject getImpressionObject() {
//		JsonParser jsonParser;
//		ImpressionObject impressionObject = null;
//		try {
//			jsonParser = Json.createParser(new FileInputStream("src/main/resources/Charles.json"));
//			boolean flag = false;
//
//			while (jsonParser.hasNext()) {
//				Event event = jsonParser.next();
//				switch (event) {
//				case VALUE_STRING:
//					if (!flag) {
//						if (jsonParser.getString().contains("impression")) {
//							// System.out.println("String values initial: " +
//							// URLDecoder.decode(jsonParser.getString()));
//							// String finalJson = URLDecoder.decode(finalJson);
//							int startIndex = jsonParser.getString().indexOf("rawJSON=");
//
//							String omsdkJson = URLDecoder.decode(jsonParser.getString().substring(startIndex + 8));
//							 System.out.println("String values: " + omsdkJson);
//
//							 impressionObject = jsonFlattenImpression(omsdkJson);
//////							// JsonObject jsonObj =
//////							// gsonParserService.getJSONObjectByGson(URLDecoder.decode(omsdkJson));
//////							// sessionStartedbject.setAdSessionId(sessionStartedbject.getAdSessionId());
////////							 geometryChangeObject.setAdSessionIdLength(geometryChangeObject.getAdSessionId().length());
//////							// sessionStartedbject.setType(sessionStartedbject.getType());
//////							// runRuleEngine(s);
////////							System.out.println(geometryChangeObject.getAdSessionId() + " " + geometryChangeObject.getType()
////////									+ " " + geometryChangeObject.getVerificationParameters());
//							flag = true;
//							return impressionObject;
//						}
//					}
//
//					break;
//
//				default:
//					break;
//				}
//			}
//
//			jsonParser.close();
//
//		} catch (FileNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return impressionObject;
//
//	}
//	public SessionFinishObject jsonFlattenSessionFinish(String jsonObject) {
//		String flattenedJson = JsonFlattener.flatten(jsonObject.toString())
//				.replaceAll("data.", "").replace("viewport.", "").replaceAll("adView.", "");
//		SessionFinishObject sessionFinishObject;
//		//System.err.println(flattenedJson);
//		JSONObject jsonObj = new JSONObject(flattenedJson);
//        JSONObject newJsonObj = new JSONObject();
//        for (String key : jsonObj.keySet()) {
//            String newKey = key.replace(".", "");
//            Object value = jsonObj.get(key);
//            newJsonObj.put(newKey, value);
//        }
//        String newJsonStr = newJsonObj.toString();
//        //System.err.println(newJsonStr);
//		Gson g = new Gson();
//		sessionFinishObject = g.fromJson(newJsonStr, SessionFinishObject.class);
//		return sessionFinishObject;
//	}

//	public SessionFinishObject getSessionFinishObject() {
//		JsonParser jsonParser;
//		SessionFinishObject sessionFinishObject = null;
//		try {
//			jsonParser = Json.createParser(new FileInputStream("src/main/resources/Charles.json"));
//			boolean flag = false;
//
//			while (jsonParser.hasNext()) {
//				Event event = jsonParser.next();
//				switch (event) {
//				case VALUE_STRING:
//					if (!flag) {
//						if (jsonParser.getString().contains("sessionFinish")) {
//							// System.out.println("String values initial: " +
//							// URLDecoder.decode(jsonParser.getString()));
//							// String finalJson = URLDecoder.decode(finalJson);
//							int startIndex = jsonParser.getString().indexOf("rawJSON=");
//
//							String omsdkJson = URLDecoder.decode(jsonParser.getString().substring(startIndex + 8));
//							 System.out.println("String values: " + omsdkJson);
//
//							 sessionFinishObject = jsonFlattenSessionFinish(omsdkJson);
//							// JsonObject jsonObj =
//							// gsonParserService.getJSONObjectByGson(URLDecoder.decode(omsdkJson));
//							// sessionStartedbject.setAdSessionId(sessionStartedbject.getAdSessionId());
////							 geometryChangeObject.setAdSessionIdLength(geometryChangeObject.getAdSessionId().length());
//							// sessionStartedbject.setType(sessionStartedbject.getType());
//							// runRuleEngine(s);
////							System.out.println(geometryChangeObject.getAdSessionId() + " " + geometryChangeObject.getType()
////									+ " " + geometryChangeObject.getVerificationParameters());
//							flag = true;
//							System.err.println(sessionFinishObject.getAdSessionId());
//							return sessionFinishObject;
//						}
//					}
//
//					break;
//
//				default:
//					break;
//				}
//			}
//
//			jsonParser.close();
//
//		} catch (FileNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return sessionFinishObject;
//
//	}
}
