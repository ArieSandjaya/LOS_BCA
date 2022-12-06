package com.multifinance.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.multifinance.dao.ErrorResponseDao;
import com.multifinance.dao.GetDao;
import com.multifinance.dao.PutDao;
import com.multifinance.model.OfficeModel;
import com.multifinance.model.SentMailModel;
import com.multifinance.model.response.ErrorModel;
import com.multifinance.model.response.Office;
import com.multifinance.service.PutService;
import com.multifinance.util.CommonUtil;
import com.multifinance.util.CustomLoggerUtil;
import com.multifinance.util.ErrorResponseUtil;
import com.multifinance.util.validation.UpdateValidation;

@Service
public class PutServiceImpl implements PutService {
	
	
}
