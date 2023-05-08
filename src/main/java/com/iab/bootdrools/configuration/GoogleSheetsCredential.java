package com.iab.bootdrools.configuration;

import java.io.IOException;
import java.io.InputStream;
import java.util.Collections;

import com.google.api.client.auth.oauth2.Credential;
import com.google.api.client.googleapis.auth.oauth2.GoogleCredential;
import com.google.api.services.sheets.v4.SheetsScopes;
import com.google.api.services.sheets.v4.model.ValueRange;


@SuppressWarnings("deprecation")
public class GoogleSheetsCredential {

    public static Credential credential;
    public static ValueRange response;
	private static final String CREDENTIALS_FILE_PATH = "/credentials.json";

  		
  		public static Credential getCredential() throws IOException {
  	        if (credential == null) {
  	            InputStream is = GoogleSheetsCredential.class.getResourceAsStream(CREDENTIALS_FILE_PATH);
  	            credential = GoogleCredential.fromStream(is).createScoped(Collections.singleton(SheetsScopes.SPREADSHEETS));
  	        }
  	        return credential;
  	    }

}
