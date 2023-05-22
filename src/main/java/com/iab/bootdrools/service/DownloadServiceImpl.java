//package com.iab.bootdrools.service;
//
//import java.io.ByteArrayInputStream;
//import java.io.ByteArrayOutputStream;
//import java.io.FileNotFoundException;
//import java.io.FileOutputStream;
//import java.io.IOException;
//import java.io.OutputStream;
//import java.security.GeneralSecurityException;
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//import java.util.stream.Collectors;
//
//import org.apache.poi.ss.usermodel.Cell;
//import org.apache.poi.ss.usermodel.Row;
//import org.apache.poi.ss.usermodel.Sheet;
//import org.apache.poi.ss.usermodel.Workbook;
//import org.apache.poi.ss.usermodel.WorkbookFactory;
//import org.kie.api.KieServices;
//import org.kie.api.runtime.KieContainer;
//import org.kie.api.runtime.KieSession;
//
//import com.google.api.client.http.HttpResponseException;
//import com.google.api.client.http.javanet.NetHttpTransport;
//import com.google.api.client.json.jackson2.JacksonFactory;
//import com.google.api.services.sheets.v4.Sheets;
//import com.google.api.services.sheets.v4.model.ValueRange;
//import com.iab.bootdrools.configuration.GoogleSheetsCredential;
//import com.iab.bootdrools.configuration.GoogleSheetsUtil;
////@Configuration
//public class DownloadServiceImpl {
//	
////	private static final String APPLICATION_NAME = "My Sheets Downloader";
////    private static final String SPREADSHEET_ID = "your-spreadsheet-id-here";
////    private static final String RANGE = "Sheet1!A1:E";
////	
////	public Collection<Object> getRangeFromSheet(String spreadsheetId) throws Exception {
////		
////		Sheets sheetsService = GoogleSheetsUtil.getSheets();
////		Spreadsheet vr = sheetsService.spreadsheets().get(spreadsheetId).execute();
////		return vr.values();
////	}
//	
//	 // Build a Google Sheets API client
//   
////	public static void main(String[] args) throws FileNotFoundException, IOException {
////		
////		// First, authenticate with the Google API using OAuth 2.0
//////		GoogleCredential credential = GoogleCredential.fromStream(new FileInputStream(CREDENTIALS_FILE_PATH))
//////		    .createScoped(Collections.singleton(DriveScopes.DRIVE_READONLY));
////		
////			Sheets sheetsService = new Sheets.Builder(new NetHttpTransport(), new JacksonFactory(), GoogleSheetsCredential.getCredential()).build();
////
////			// Next, retrieve the Excel file from Google Drive
////			String spreadsheetId = "1cyIgdqbcZ6bv3oafiOQXQeYikf4HeNNpevrHK3hVMEE";
////			ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
////			sheetsService.spreadsheets().get(spreadsheetId)
////			    .executeAndDownloadTo(outputStream);
////			byte[] excelBytes = outputStream.toByteArray();
////
////			// Read the Excel data into a Java object
////			
////			Workbook workbook = WorkbookFactory.create(new ByteArrayInputStream(excelBytes));
////			Sheet sheet = workbook.getSheetAt(0);
////			List<Map<String, Object>> rows = new ArrayList<>();
////			for (Row row : sheet) {
////			    Map<String, Object> rowData = new HashMap<>();
////			    for (Cell cell : row) {
////			        rowData.put(cell.getStringCellValue(), cell.getNumericCellValue());
////			    }
////			    rows.add(rowData);
////			}
////
////			// Pass the Java object as input to the Drools rule engine
////			KieServices kieServices = KieServices.Factory.get();
////			KieContainer kieContainer = kieServices.getKieClasspathContainer();
////			KieSession kieSession = kieContainer.newKieSession();
////			for (Map<String, Object> row : rows) {
////			    kieSession.insert(row);
////			}
////			kieSession.fireAllRules();
////
////
////	}
//	
////	public void GoogleAuthTest() throws GeneralSecurityException, IOException
////	{
////		 // Build a Google Sheets API client
////        // Build a Google Sheets API client
////        Sheets sheetsService = GoogleSheetsUtil.getSheets();
////        
////        // Define the request parameters
////        Sheets.Spreadsheets.Values.Get request = sheetsService.spreadsheets().values().get(SPREADSHEET_ID, RANGE);
////        
////        // Download the spreadsheet data
////        try {
////            ValueRange response = request.execute();
////            
////            // Save the spreadsheet data to a file
////            OutputStream outputStream = new FileOutputStream("VaiMain111.xls");
////            for (List<Object> row : response.getValues()) {
////                List<String> rowStrings = row.stream().map(Object::toString).collect(Collectors.toList());
////                outputStream.write((String.join(",", rowStrings) + "\n").getBytes());
////            }
////            outputStream.close();
////        } catch (HttpResponseException e) {
////            System.err.println(e.getStatusMessage());
////        }
////	}
//}
