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

		/*
		 * log("\n=====Flatten As Map=====\n" + flattenedJson);
		 * log("\n=====sessionStartObject As Map=====\n" + sessionStartObject);
		 * flattenedJsonMap.forEach((k,v) -> System.out.println("Key = " + k +
		 * ", Value = " + v)); // We are using Java8 forEach loop. More info:
		 * http://crunchify.me/1VIwm0l flattenedJsonMap.forEach((k, v) -> log(k + " : "
		 * + v)); // Unflatten it back to original JSON String nestedJson =
		 * JsonUnflattener.unflatten(flattenedJson); //
		 * System.out.println("\n===== Unflatten it back to original JSON ===== \n" +
		 * nestedJson);
		 */
		//System.err.println(sessionStartObject);
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

	public SessionStartObject getStartSessionObject() {
		// TODO Auto-generated method stub
		return null;
	}

}
