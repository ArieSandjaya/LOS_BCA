package com.multifinance.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.multifinance.service.ApplStatService;

@RestController
@CrossOrigin(origins="*")
public class PostController {
	
	@Autowired
	private ApplStatService appStatService;
	
	  @PostMapping(path = "scheduler/app-idle", produces = "application/json")
	  public ResponseEntity<String> appIdle() throws JsonProcessingException {
	  return appStatService.expiringIdleApplStat(); }
	 
	  @PostMapping(path = "scheduler/app-max", produces = "application/json")
	  public ResponseEntity<String> appMax() throws JsonProcessingException {
	  return appStatService.expiringMaxApplStat(); }
	  
	 @PostMapping(path = "scheduler/app-max-submit", produces =
	 "application/json") public ResponseEntity<String> appMaxSubmit() throws
	 JsonProcessingException { return
	 appStatService.expiringMaxApplStatAfterSubmit(); }
	
	@PostMapping(path = "scheduler/app-notif", produces = "application/json")
	public ResponseEntity<String> appMailer() throws JsonProcessingException {
		return appStatService.notifApplStat();
	}
	
}
	
