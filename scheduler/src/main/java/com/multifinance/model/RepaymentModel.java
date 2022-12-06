package com.multifinance.model;

import java.math.BigDecimal;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_EMPTY)
public class RepaymentModel {
	
	private BigDecimal plafondPengajuan;
	private BigDecimal labaOperasional;
	private double sukuBunga;
	private double tenor;
	private BigDecimal plafondFinal;
		
	public RepaymentModel(){
		super();
	}
	
	public BigDecimal getPlafondPengajuan() {
		return plafondPengajuan;
	}
	
	public void setPlafondPengajuan(BigDecimal plafondPengajuan) {
		this.plafondPengajuan = plafondPengajuan;
	}
	
	public BigDecimal getLabaOperasional() {
		return labaOperasional;
	}
	
	public void setLabaOperasional(BigDecimal labaOperasionalBD) {
		this.labaOperasional = labaOperasionalBD;
	}
	
	public double getSukuBunga() {
		return sukuBunga;
	}
	
	public void setSukuBunga(double sukuBunga) {
		this.sukuBunga = sukuBunga;
	}
	
	public double getTenor() {
		return tenor;
	}
	
	public void setTenor(double tenor) {
		this.tenor = tenor;
	}
	
	public BigDecimal getPlafondFinal() {
		return plafondFinal;
	}
	
	public void setPlafondFinal(BigDecimal plafondFinal) {
		this.plafondFinal = plafondFinal;
	}
	
}