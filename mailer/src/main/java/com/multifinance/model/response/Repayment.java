package com.multifinance.model.response;

import java.math.BigDecimal;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_EMPTY)
public class Repayment {
	
	private BigDecimal plafondPengajuan;
	private BigDecimal labaOperasional;
	private double sukuBunga;
	private double tenor;
	private BigDecimal plafondFinal;
	private String response;
	
	public Repayment(BigDecimal plafondPengajuan, BigDecimal labaOperasional, 
						double sukuBunga, double tenor, BigDecimal plafondFinal, 
						String response) {
		super();
		this.plafondPengajuan = plafondPengajuan;
		this.labaOperasional = labaOperasional;
		this.sukuBunga = sukuBunga;
		this.tenor = tenor;
		this.plafondFinal = plafondFinal;
	}
	
	public Repayment() {
		super();
	}
	
	public BigDecimal getPlafondPengajuan() {
		return plafondPengajuan;
	}
	
	public void setPlafondPengajuan(BigDecimal plafondPengajuan) {
		this.plafondPengajuan = plafondPengajuan;
	}
	
	public BigDecimal getPlafondFinal() {
		return plafondFinal;
	}
	
	public void setPlafondFinal(BigDecimal plafondFinal) {
		this.plafondFinal = plafondFinal;
	}
	
	public BigDecimal getLabaOperasional() {
		return labaOperasional;
	}
	
	public void setLabaOperasional(BigDecimal labaOperasional) {
		this.labaOperasional = labaOperasional;
	}
	
	public double getSukuBunga() {
		return sukuBunga;
	}
	
	public void setSukuBunga(Double sukuBunga) {
		this.sukuBunga = sukuBunga;
	}
	
	public Double getTenor() {
		return tenor;
	}
	
	public void setTenor(Double tenor) {
		this.tenor = tenor;
	}
	
	public String getResponse() {
		return response;
	}

	public void setResponse(String response) {
		this.response = response;
	}
	
	@Override
	public String toString() {
		return "RepaymentResponseModel [plafondPengajuan=" + plafondPengajuan + ", labaOperasional="+ labaOperasional 
				+", sukuBunga="+ sukuBunga +", tenor="+ tenor +", plafondFinal="+ plafondFinal +", response=" + response + "]";
	}
}
