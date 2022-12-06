package com.multifinance.util.validation;

import com.multifinance.model.OfficeListModel;
import com.multifinance.model.OfficeModel;

public class OfficeValidation {


	public static String checkOffice(OfficeModel officeModel) {
		if (officeModel.getName() == null) {
			return "AQ-EP006";
		}
		if (officeModel.getAddress() == null) {
			return "AQ-EP032";
		}
		if (officeModel.getCity() == null) {
			return "AQ-EP033";
		}
		if (officeModel.getState() == null) {
			return "AQ-EP036";
		}
		if (officeModel.getZipcode() == null) {
			return "AQ-EP039";
		}
		if (officeModel.getCompId() == null) {
			return "AQ-EP005";
		}
		if (officeModel.getUpdateBy() == null) {
			return "AQ-EP011";
		}
		return "OK";
	}

	public static String checkOfficeGet(OfficeListModel getModel) {
		if (getModel.getCompId() == null) {
			return "AQ-EP005";
		}
		return "OK";
	}


}
