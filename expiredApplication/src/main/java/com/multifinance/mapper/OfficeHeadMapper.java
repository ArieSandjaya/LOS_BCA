package com.multifinance.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.multifinance.model.response.child.OfficeLookupModel;

public class OfficeHeadMapper implements RowMapper<OfficeLookupModel> {

	@Override
	public OfficeLookupModel mapRow(ResultSet rs, int rowNum) throws SQLException {
		OfficeLookupModel lookupModel = new OfficeLookupModel();
		lookupModel.setUuid(rs.getString("offc_id"));
		lookupModel.setLabel(rs.getString("name"));
		lookupModel.setValue(rs.getString("id"));
		
		return lookupModel;
	}

}
