package com.multifinance.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.multifinance.model.OfficeModel;


public class OfficePostMapper implements RowMapper<OfficeModel> {

	@Override
	public OfficeModel mapRow(ResultSet rs, int rowNum) throws SQLException {
		OfficeModel officeModel = new OfficeModel();
		officeModel.setOfficeHeadId(rs.getString("id"));
		officeModel.setName(rs.getString("name"));
		
		return officeModel;
	}

}
