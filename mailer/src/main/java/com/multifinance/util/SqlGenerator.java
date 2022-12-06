package com.multifinance.util;

import com.multifinance.model.OfficeModel;

public class SqlGenerator {

	public static String OfficeGenerateSql(OfficeModel officeModel) {
		StringBuilder query = new StringBuilder();
		query.append("UPDATE multifinance.offc SET ");
		query.append(CheckUtil.isNotNull(officeModel.getOfficeHeadId()) ? "offc_head_id = ?, " : "");
		query.append(CheckUtil.isNotNull(officeModel.getName()) ? "name = ?, " : "");
		query.append(CheckUtil.isNotNull(officeModel.getOfficeType()) ? "office_type = ?, " : "");
		query.append(CheckUtil.isNotNull(officeModel.getAddress()) ? "address = ?, " : "");
		query.append(CheckUtil.isNotNull(officeModel.getCity()) ? "city = ?, " : "");
		query.append(CheckUtil.isNotNull(officeModel.getDistrict()) ? "district = ?, " : "");
		query.append(CheckUtil.isNotNull(officeModel.getVillage()) ? "village = ?, " : "");
		query.append(CheckUtil.isNotNull(officeModel.getState()) ? "state = ?, " : "");
		query.append(CheckUtil.isNotNull(officeModel.getHamletNumber()) ? "hamlet_number = ?, " : "");
		query.append(CheckUtil.isNotNull(officeModel.getNeighbourhoodNumber()) ? "neighbourhood_number = ?, " : "");
		query.append(CheckUtil.isNotNull(officeModel.getZipcode()) ? "zipcode = ?, " : "");
		query.append("updated_by = ?, updated_at = now() ");
		query.append("WHERE offc_id = ? ;");
		return query.toString();
	}
}