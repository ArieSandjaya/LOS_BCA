package com.multifinance.service;

import org.springframework.http.ResponseEntity;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.multifinance.model.RepaymentModel;
import com.multifinance.model.SentMailModel;

public interface GetService {
	
	ResponseEntity<String> pengajuanAwal(RepaymentModel repaymentModel) throws JsonProcessingException;
	
	ResponseEntity<String> simulasiPinjaman(RepaymentModel repaymentModel) throws JsonProcessingException;
	
	ResponseEntity<String> simulasiTenor(RepaymentModel repaymentModel) throws JsonProcessingException;

}
