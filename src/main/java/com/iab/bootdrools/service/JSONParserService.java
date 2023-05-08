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

import javax.json.Json;
import javax.json.stream.JsonParser;
import javax.json.stream.JsonParser.Event;

import org.springframework.stereotype.Service;

import com.github.wnameless.json.flattener.JsonFlattener;
import com.google.gson.Gson;
import com.iab.bootdrools.model.GeometryChangeObject;
import com.iab.bootdrools.model.SessionStartObject;

@Service
public class JSONParserService {

	public SessionStartObject jsonFlatten(String jsonObject) {
		String flattenedJson = JsonFlattener.flatten(jsonObject.toString()).replaceAll("data.context.", "")
				.replaceAll("data.", "").replace("app.", "").replaceAll("omidNativeInfo.", "").replaceAll("omidJsInfo.", "").replace("deviceInfo.", "");
		SessionStartObject sessionStartObject;
		System.err.println(flattenedJson);
		Gson g = new Gson();
		sessionStartObject = g.fromJson(flattenedJson, SessionStartObject.class);

		return sessionStartObject;
	}
	

	public SessionStartObject getSessionObject() {
		JsonParser jsonParser;
		SessionStartObject sessionStartObject = null;
		try {
			jsonParser = Json.createParser(new FileInputStream("src/main/resources/Charles.json"));
			boolean flag = false;

			while (jsonParser.hasNext()) {
				Event event = jsonParser.next();
				switch (event) {
				case VALUE_STRING:
					if (!flag) {
						if (jsonParser.getString().contains("sessionStart")) {
							// System.out.println("String values initial: " +
							// URLDecoder.decode(jsonParser.getString()));
							// String finalJson = URLDecoder.decode(finalJson);
							int startIndex = jsonParser.getString().indexOf("rawJSON=");
							String omsdkJson = URLDecoder.decode(jsonParser.getString().substring(startIndex + 8));
							 System.out.println("String values: " + omsdkJson);
							sessionStartObject = jsonFlatten(omsdkJson);
							// JsonObject jsonObj =
							// gsonParserService.getJSONObjectByGson(URLDecoder.decode(omsdkJson));
							// sessionStartedbject.setAdSessionId(sessionStartedbject.getAdSessionId());
							sessionStartObject.setAdSessionIdLength(sessionStartObject.getAdSessionId().length());
							// sessionStartedbject.setType(sessionStartedbject.getType());
							// runRuleEngine(s);
							System.out.println(sessionStartObject.getAdSessionId() + " " + sessionStartObject.getType()
									+ " " + sessionStartObject.getVerificationParameters());
							flag = true;
							return sessionStartObject;
						}
					}
					break;

				default:
					break;
				}
			}
			jsonParser.close();

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return sessionStartObject;
	}
	public GeometryChangeObject jsonFlattenGeometry(String jsonObject) {

		String flattenedJson = JsonFlattener.flatten(jsonObject.toString())
				.replaceAll("data.", "").replace("viewport.", "").replaceAll("adView.", "");
		GeometryChangeObject GeometryChangeObject;
		System.err.println(flattenedJson);
		Gson g = new Gson();
		GeometryChangeObject = g.fromJson(flattenedJson, GeometryChangeObject.class);
		return GeometryChangeObject;
	}

	public GeometryChangeObject getGeometryObject() {
		JsonParser jsonParser;
		GeometryChangeObject geometryChangeObject = null;
		try {
			jsonParser = Json.createParser(new FileInputStream("src/main/resources/Charles.json"));
			boolean flag = false;

			while (jsonParser.hasNext()) {
				Event event = jsonParser.next();
				switch (event) {
				case VALUE_STRING:
					if (!flag) {
						if (jsonParser.getString().contains("geometryChange")) {
							// System.out.println("String values initial: " +
							// URLDecoder.decode(jsonParser.getString()));
							// String finalJson = URLDecoder.decode(finalJson);
							int startIndex = jsonParser.getString().indexOf("rawJSON=");

							String omsdkJson = URLDecoder.decode(jsonParser.getString().substring(startIndex + 8));
							 System.out.println("String values: " + omsdkJson);

							 geometryChangeObject = jsonFlattenGeometry(omsdkJson);
							// JsonObject jsonObj =
							// gsonParserService.getJSONObjectByGson(URLDecoder.decode(omsdkJson));
							// sessionStartedbject.setAdSessionId(sessionStartedbject.getAdSessionId());
//							 geometryChangeObject.setAdSessionIdLength(geometryChangeObject.getAdSessionId().length());
							// sessionStartedbject.setType(sessionStartedbject.getType());
							// runRuleEngine(s);
//							System.out.println(geometryChangeObject.getAdSessionId() + " " + geometryChangeObject.getType()
//									+ " " + geometryChangeObject.getVerificationParameters());
							flag = true;
							return geometryChangeObject;
						}
					}

					break;

				default:
					break;
				}
			}

			jsonParser.close();

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return geometryChangeObject;

	}


}
