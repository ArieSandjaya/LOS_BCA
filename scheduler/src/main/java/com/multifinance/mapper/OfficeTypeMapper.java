package com.multifinance.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.multifinance.model.response.child.OfficeLookupModel;


public class OfficeTypeMapper implements RowMapper<OfficeLookupModel> {

	@Override
	public OfficeLookupModel mapRow(ResultSet rs, int rowNum) throws SQLException {
		OfficeLookupModel lookupModel = new OfficeLookupModel();
		lookupModel.setLabel(rs.getString("lookup_value"));
		lookupModel.setValue(rs.getString("lookup_key"));
		
		return lookupModel;
	}

}
