package com.multifinance.util.validation;

import com.multifinance.model.OfficeModel;

public class UpdateValidation {

	public static String checkOffice(OfficeModel officeModel) {
		if (officeModel.getOfficeHeadId() == null && officeModel.getName() == null && officeModel.getOfficeType() == null
				&& officeModel.getCity() == null && officeModel.getDistrict() == null
				&& officeModel.getVillage() == null && officeModel.getState() == null
				&& officeModel.getHamletNumber() == null && officeModel.getNeighbourhoodNumber() == null
				&& officeModel.getZipcode() == null) {
			return "AQ-EP010";
		}
		if (officeModel.getUpdateBy() == null) {
			return "AQ-EP011";
		}
		return "OK";
	}

}