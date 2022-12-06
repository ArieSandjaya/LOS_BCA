package com.multifinance.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.multifinance.model.OfficeModel;


public class OfficeMapper implements RowMapper<OfficeModel>{

	@Override
	public OfficeModel mapRow(ResultSet rs, int rowNum) throws SQLException {
		OfficeModel officeModel = new OfficeModel();
		officeModel.setOfficeHeadId(rs.getString("offc_head_id"));
		officeModel.setName(rs.getString("name"));
		officeModel.setOfficeType(rs.getString("office_type"));
		officeModel.setAddress(rs.getString("address"));
		officeModel.setCity(rs.getString("city"));
		officeModel.setDistrict(rs.getString("district"));
		officeModel.setVillage(rs.getString("village"));
		officeModel.setState(rs.getString("state"));
		officeModel.setHamletNumber(rs.getString("hamlet_number"));
		officeModel.setNeighbourhoodNumber(rs.getString("neighbourhood_number"));
		officeModel.setZipcode(rs.getString("zipcode"));
		return officeModel;
	}

}
