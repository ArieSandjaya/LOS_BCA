package com.multifinance.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.multifinance.model.response.child.OfficeTreeModel;

public class OfficeTreeMapper implements RowMapper<OfficeTreeModel>{

	@Override
	public OfficeTreeModel mapRow(ResultSet rs, int rowNum) throws SQLException {
		OfficeTreeModel officeTree = new OfficeTreeModel();
		officeTree.setId(rs.getLong("id"));
		officeTree.setOfficeId(rs.getString("offc_id"));
		officeTree.setOfficeHeadId(rs.getLong("offc_head_id"));
		officeTree.setOfficeType(rs.getString("office_type"));
		officeTree.setZipcode(rs.getString("zipcode"));
		officeTree.setLabel(rs.getString("name"));
		return officeTree;
	}



}
