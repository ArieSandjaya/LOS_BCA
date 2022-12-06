package com.multifinance.service.impl;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.TimeUnit;

import com.multifinance.model.SentMailModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.multifinance.dao.ErrorResponseDao;
import com.multifinance.service.GetService;
import com.multifinance.util.CommonUtil;
import com.multifinance.util.ErrorResponseUtil;
import com.multifinance.model.ApplStatModel;
import com.multifinance.model.ApplModel;
import com.multifinance.model.CustModel;
import com.multifinance.model.UsrProfileModel;
import com.multifinance.model.NtfeModel;
import com.multifinance.model.RepaymentModel;
import com.multifinance.model.response.ErrorModel;
import com.multifinance.repository.ApplRepository;
import com.multifinance.repository.ApplStatRepository;
import com.multifinance.repository.CustRepository;
import com.multifinance.repository.NtfeRepository;
import com.multifinance.repository.UsrProfileRepository;
import com.multifinance.util.CommonFormula;
import org.springframework.scheduling.annotation.Scheduled;
@Service
public class GetServiceImpl implements GetService {

	@Value("${service.logs.url}")
	private String logs;

	@Value("${repayment.appl.idle}")
	private long applIdle;

	@Value("${repayment.appl.max}")
	private long applMax;

	@Value("${repayment.appl.notif}")
	private long applNotif;
	
	@Autowired
	private ApplStatRepository applStatRepository;
	
	@Autowired
	private NtfeRepository ntfeRepository;

	@Autowired
	private PostServiceImpl postServiceImpl;
	@Autowired
	private ApplRepository applRepository;
	@Autowired
	private CustRepository custRepository;
	@Autowired
	private UsrProfileRepository usrRepository;
	@Override
	public ResponseEntity<String> pengajuanAwal(RepaymentModel repaymentModel) throws JsonProcessingException {
		ErrorModel errorResponseModel = new ErrorModel();
		
		try {
			double sukuBunga = repaymentModel.getSukuBunga();
			double tenor = repaymentModel.getTenor();
			double sukuBungaPerBulan = (double)sukuBunga / 100 / 12;
			double PV = CommonFormula.PV(sukuBungaPerBulan, tenor, repaymentModel.getLabaOperasional());
			BigDecimal calculatedPlafond = new BigDecimal(Math.ceil(PV));
			
			if (calculatedPlafond.compareTo(repaymentModel.getPlafondPengajuan()) > 0) {
				repaymentModel.setPlafondFinal(repaymentModel.getPlafondPengajuan());
			} else {
				repaymentModel.setPlafondFinal(calculatedPlafond);
			}
			
			return new ResponseEntity<>(CommonUtil.modelToString(repaymentModel), HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			errorResponseModel.setErrorMessage("Ada kesalahan data");
			errorResponseModel.setStatus(HttpStatus.BAD_REQUEST.toString());
			return new ResponseEntity<>(CommonUtil.modelToString(errorResponseModel), ErrorResponseUtil.getHttpStat(errorResponseModel.getStatus()));
		}
		
	}
	
	@Override
	public ResponseEntity<String> simulasiPinjaman(RepaymentModel repaymentModel) throws JsonProcessingException {
		ErrorModel errorResponseModel = new ErrorModel();
		
		try {
			double sukuBunga = repaymentModel.getSukuBunga();
			double tenor = repaymentModel.getTenor();
			
			double sukuBungaPerBulan = (double)sukuBunga / 100 / 12;
			double PV = CommonFormula.PV(sukuBungaPerBulan, tenor, repaymentModel.getLabaOperasional());
			repaymentModel.setPlafondFinal(new BigDecimal(Math.ceil(PV)));
						
			return new ResponseEntity<>(CommonUtil.modelToString(repaymentModel), HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			errorResponseModel.setErrorMessage("Ada kesalahan data");
			errorResponseModel.setStatus(HttpStatus.BAD_REQUEST.toString());
			return new ResponseEntity<>(CommonUtil.modelToString(errorResponseModel), ErrorResponseUtil.getHttpStat(errorResponseModel.getStatus()));
		}
	}
	
	@Override
	public ResponseEntity<String> simulasiTenor(RepaymentModel repaymentModel) throws JsonProcessingException {
		ErrorModel errorResponseModel = new ErrorModel();
		
		try {
			BigDecimal plafondPengajuan = repaymentModel.getPlafondPengajuan();
			BigDecimal labaOperasional = repaymentModel.getLabaOperasional();
			double sukuBunga = repaymentModel.getSukuBunga();
			
			double sukuBungaPerBulan = (double)sukuBunga / 100 / 12;
			double NPER = CommonFormula.NPER(sukuBungaPerBulan, labaOperasional.doubleValue(), plafondPengajuan.negate().doubleValue());
			repaymentModel.setTenor(Math.round(NPER));
					
			return new ResponseEntity<>(CommonUtil.modelToString(repaymentModel), HttpStatus.OK);
		} catch(Exception e) {
			e.printStackTrace();
			errorResponseModel.setErrorMessage("Ada kesalahan data");
			errorResponseModel.setStatus(HttpStatus.BAD_REQUEST.toString());
			return new ResponseEntity<>(CommonUtil.modelToString(errorResponseModel), ErrorResponseUtil.getHttpStat(errorResponseModel.getStatus()));
		}
		
	}
}
