package com.iab.bootdrools.service;

import java.io.File;
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
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
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
import org.springframework.web.multipart.MultipartFile;

import com.github.wnameless.json.flattener.JsonFlattener;
import com.google.gson.Gson;
import com.iab.bootdrools.model.ImpressionObject;
import com.iab.bootdrools.model.QueryData;

@Service
public class JSONParserService {
	
	public String jsonFlattenBanner(String jsonObject) {

		String flattenedJson = JsonFlattener.flatten(jsonObject)
				.replaceAll("data.", "").replace("viewport.", "").replaceAll("adView.", "").replaceAll("data.context.", "").replaceAll("context.", "")
				.replace("app.", "").replaceAll("omidNativeInfo.", "").replaceAll("omidJsInfo.", "").replace("deviceInfo.", "");
		JSONObject jsonObj = new JSONObject(flattenedJson);
        JSONObject newJsonObj = new JSONObject();
        
        for (String key : jsonObj.keySet()) {
            String newKey = key.replace(".", "");
            Object value = jsonObj.get(key);
            newJsonObj.put(newKey, value);
        }
        
        String newJsonStr = newJsonObj.toString();
		return newJsonStr;

	}

	public Map<String, Object> getBannerObject(MultipartFile fileInputStream) {
		
		 
		JsonParser jsonParser;
		Map<String, Object> map = new HashMap<>();
		String bannerObject = null;
//		Object loadedObject1 = null;
		int i = 1;
		try {
			File convertedFile = convertMultiPartToFile(fileInputStream);
	        FileInputStream file = new FileInputStream(convertedFile);
//			jsonParser = Json.createParser(new FileInputStream("src/main/resources/Charles.json"));
			jsonParser = Json.createParser(file);
			boolean flag = false;
			while (jsonParser.hasNext()) {
				Event event = jsonParser.next();
//				System.err.println(i++);
				switch (event) {
				case VALUE_STRING:
					// System.err.println(flag);
					if (!flag) {
						String input = jsonParser.getString();
						if (!input.contains("/logapi/logomsdk?")) {
							Pattern pattern = Pattern.compile("type=(.*?)&");
							Matcher matcher = pattern.matcher(input);
							if (matcher.find()) {
								String data = matcher.group(1);
								System.out.println("data :" + data); // output: "success"
								if (jsonParser.getString().contains(data)) {
									
									int startIndex = jsonParser.getString().indexOf("rawJSON=");
									int startIndexQuery = jsonParser.getString().indexOf("&rawJSON=");
								
									String omsdkJson = URLDecoder
											.decode(jsonParser.getString().substring(startIndex + 8));

									String query = URLDecoder
											.decode(jsonParser.getString().substring(0, startIndexQuery).concat("&rawJSON=").concat(omsdkJson));
									 System.out.println("String values: " + omsdkJson);
									bannerObject = jsonFlattenBanner(omsdkJson);
									System.err.println(bannerObject);
									
									Map<String, String> nastedMap = new HashMap<>();
									nastedMap.put("drool", bannerObject);
									nastedMap.put("original", query);
									map.put(data + i++, nastedMap);
									flag = false;
								}
							}
						}
					}
					// break;
//				default:
//					break;
				}
			}
			// jsonParser.close();
//			file.close();
//			  convertedFile.delete(); // Clean up the temporary file
		} catch (IOException e) {
			e.printStackTrace();
		}
		return map;
	}
	
	private File convertMultiPartToFile(MultipartFile file) throws IOException {
	    File convertedFile = new File(file.getOriginalFilename());
	    try (OutputStream outputStream = new FileOutputStream(convertedFile)) {
	        outputStream.write(file.getBytes());
	    }
	    return convertedFile;
	}
	
}
