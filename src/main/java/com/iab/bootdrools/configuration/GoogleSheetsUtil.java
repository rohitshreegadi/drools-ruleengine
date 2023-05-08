package com.iab.bootdrools.configuration;

import java.io.IOException;
import java.security.GeneralSecurityException;

import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.services.sheets.v4.Sheets;

public class GoogleSheetsUtil {

	private static final String APPLICATION_NAME = "boot-drools";
	public static final String SHEET_URL_PREFIX = "https://docs.google.com/spreadsheets/d/";
	public static final String SHEET_URL_SUFFIX = "/export?format=xlsx";

	public static Sheets getSheets() throws GeneralSecurityException, IOException {
		NetHttpTransport HTTP_TRANSPORT = null;
		try {
			HTTP_TRANSPORT = GoogleNetHttpTransport.newTrustedTransport();
		} catch (GeneralSecurityException | IOException e) {
			e.printStackTrace();
		}
		JsonFactory JSON_FACTORY = JacksonFactory.getDefaultInstance();
		Sheets sheets = new Sheets.Builder(HTTP_TRANSPORT, JSON_FACTORY, GoogleSheetsCredential.getCredential())
				.setApplicationName(APPLICATION_NAME).build();
		return sheets;
	}
	
	public static String getDownloadUrl(String sheetId) {
		return SHEET_URL_PREFIX + sheetId + SHEET_URL_SUFFIX;
	}

}
