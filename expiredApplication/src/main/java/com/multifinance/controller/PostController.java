package com.multifinance.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.multifinance.model.RepaymentModel;
import com.multifinance.model.SentMailModel;
import com.multifinance.service.GetService;
import com.multifinance.service.MailService;

@RestController
@CrossOrigin(origins="*")
public class PostController {

	@Autowired
	private GetService repaymentService;

	@Autowired
	private MailService mailService;

	@PostMapping(path = "repayment/pengajuan-awal", produces = "application/json")	
	public ResponseEntity<String> pengajuanAwal(@RequestBody RepaymentModel repaymentModel) throws JsonProcessingException {
		return repaymentService.pengajuanAwal(repaymentModel);
	}
	
	@PostMapping(path = "repayment/simulasi-pinjaman", produces = "application/json")	
	public ResponseEntity<String> simulasiPinjaman(@RequestBody RepaymentModel repaymentModel) throws JsonProcessingException {
		return repaymentService.simulasiPinjaman(repaymentModel);
	}
	
	@PostMapping(path = "repayment/simulasi-tenor", produces = "application/json")	
	public ResponseEntity<String> simulasiTenor(@RequestBody RepaymentModel repaymentModel) throws JsonProcessingException {
		return repaymentService.simulasiTenor(repaymentModel);
	}
	@PostMapping(path = "repayment/notifikasi-email", produces = "application/json")
	public ResponseEntity<String> sentMailSchedule(@RequestBody SentMailModel sentMailModel) throws JsonProcessingException{
		return mailService.sendMail(sentMailModel);
	}
}