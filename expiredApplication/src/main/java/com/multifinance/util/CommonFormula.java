package com.multifinance.util;

import java.math.BigDecimal;

public class CommonFormula {
	
	public static double PV(double rate, double nper, BigDecimal pmt) {
		return (pmt.doubleValue() / rate) * (1 - Math.pow(1 + rate, -nper));
	}
	
	public static double NPER(double rate, double payment, double present) {
		return Math.log10(payment / (payment + present * rate)) / Math.log10(1 + rate);
	}
	
}
