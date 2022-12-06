package com.multifinance.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.multifinance.exception.ResourceNotFoundException;
import com.multifinance.model.ApplStatModel;
import com.multifinance.repository.ApplStatRepository;
import com.multifinance.service.impl.GetServiceImpl;

@CrossOrigin(origins="*")
@RestController
public class GetController {
	
}
