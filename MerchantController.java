package com.mosambee.configuration.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.mosambee.configuration.service.MerchantService;

@RestController
@RequestMapping("/api/v1")
public class MerchantController {

	@Autowired MerchantService merchantService;
	
	@PostMapping("/upload-merchant")
	public ResponseEntity<String> uploadMerchant(@RequestParam("file") MultipartFile file){
		String result = merchantService.uploadMerchant(file);
		return ResponseEntity.ok(result);
	}
}
