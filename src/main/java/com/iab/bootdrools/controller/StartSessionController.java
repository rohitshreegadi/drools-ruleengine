package com.iab.bootdrools.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.iab.bootdrools.service.StartSessionService;

@RestController
public class StartSessionController {

	@Autowired
	private StartSessionService startSessionService;


//	@GetMapping("/getBannerResult")
//	public ResponseEntity<List<Object>> getBannerResult() {
//		List<Object> results = startSessionService.getBanner();
//		return new ResponseEntity<>(results, HttpStatus.OK);
//	}
	
	@PostMapping("/upload")
	public List<Object> handleFileUpload(@RequestParam("file") MultipartFile file) throws IllegalArgumentException, IllegalAccessException {
	    try {
	        File convertedFile = convertMultiPartToFile(file);
	        FileInputStream fileInputStream = new FileInputStream(convertedFile);
	        List<Object> results =    startSessionService.getBanner(convertedFile);
	        // Process the file using FileInputStream
	        // ...

	        fileInputStream.close();
	        convertedFile.delete(); // Clean up the temporary file
	        return results;
	    } catch (IOException e) {
	        return null;
	    }
	}

	private File convertMultiPartToFile(MultipartFile file) throws IOException {
	    File convertedFile = new File(file.getOriginalFilename());
	    try (OutputStream outputStream = new FileOutputStream(convertedFile)) {
	        outputStream.write(file.getBytes());
	    }
	    return convertedFile;
	}

}
