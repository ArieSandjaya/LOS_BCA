package com.multifinance.dao.impl;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.multifinance.dao.PutDao;
import com.multifinance.model.OfficeModel;
import com.multifinance.util.ParamGenerator;
import com.multifinance.util.SqlGenerator;

@Repository
public class PutDaoImpl implements PutDao {
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Override
	public void updateOffice(String id, OfficeModel officeModel) {
		String query = SqlGenerator.OfficeGenerateSql(officeModel);
		jdbcTemplate.update(query, ParamGenerator.paramOffice(id, officeModel).toArray());
	}
	
	@Override
	public int getId(String id) {
		String query = "SELECT id FROM multifinance.offc WHERE offc_id = ?; ";
		return jdbcTemplate.queryForObject(query, new Object[] { UUID.fromString(id) },
				Integer.class);
	}
	
	@Override
	public int offcNamePutCheck(String name, String id) {
		String query = "SELECT COUNT (id) FROM multifinance.offc WHERE UPPER(name) = UPPER(?) AND offc_id <> ?; ";

		return jdbcTemplate.queryForObject(query, new Object[] { name, UUID.fromString(id) }, Integer.class);
	}
}
