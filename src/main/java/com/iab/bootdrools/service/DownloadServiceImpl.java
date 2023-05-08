package com.iab.bootdrools.service;

import java.util.Collection;
import java.util.List;

import org.springframework.context.annotation.Configuration;
import org.springframework.util.StringUtils;

import com.google.api.services.sheets.v4.Sheets;
import com.google.api.services.sheets.v4.model.Spreadsheet;
import com.google.api.services.sheets.v4.model.ValueRange;
import com.iab.bootdrools.configuration.GoogleSheetsUtil;
@Configuration
public class DownloadServiceImpl {
	

	public Collection<Object> getRangeFromSheet(String spreadsheetId) throws Exception {
		
		Sheets sheetsService = GoogleSheetsUtil.getSheets();
		Spreadsheet vr = sheetsService.spreadsheets().get(spreadsheetId).execute();
		return vr.values();
	}
	
	

}
