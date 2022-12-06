package com.multifinance.util;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.multifinance.model.OfficeModel;

public class ParamGenerator {

	public static List<Object> paramOffice(String id, OfficeModel officeModel) {
		List<Object> param = new ArrayList<>();
		if (officeModel.getOfficeHeadId() != null)
			param.add(Integer.valueOf(officeModel.getOfficeHeadId()));
		if (officeModel.getName() != null)
			param.add(CommonUtil.toTitleCase(officeModel.getName()));
		if (officeModel.getOfficeType() != null)
			param.add(officeModel.getOfficeType());
		if (officeModel.getAddress() != null)
			param.add(CommonUtil.toTitleCase(officeModel.getAddress()));
		if (officeModel.getCity() != null)
			param.add(CommonUtil.toTitleCase(officeModel.getCity()));
		if (officeModel.getDistrict() != null)
			param.add(CommonUtil.toTitleCase(officeModel.getDistrict()));
		if (officeModel.getVillage() != null)
			param.add(CommonUtil.toTitleCase(officeModel.getVillage()));
		if (officeModel.getState() != null)
			param.add(CommonUtil.toTitleCase(officeModel.getState()));
		if (officeModel.getHamletNumber() != null)
			param.add(officeModel.getHamletNumber());
		if (officeModel.getNeighbourhoodNumber() != null)
			param.add(officeModel.getNeighbourhoodNumber());
		if (officeModel.getZipcode() != null)
			param.add(officeModel.getZipcode());
		if (officeModel.getUpdateBy() != null)
			param.add(officeModel.getUpdateBy());
		param.add(UUID.fromString(id));
		return param;
	}
}