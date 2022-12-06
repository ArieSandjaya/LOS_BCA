package com.multifinance.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.multifinance.dao.GetLookUpValueDao;

@Repository
public class GetLookUpValueDaoImpl implements GetLookUpValueDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public String getLookUpValue(String key, String lookupName) {

		String query = "SELECT lookup_value FROM parameters.lookup_detail "
				+ "LEFT JOIN parameters.lookup ON lookup.id = lookup_detail.lookup_head_id "
				+ "WHERE UPPER(TRIM(lookup.lookup_name))=? AND UPPER(TRIM(lookup_detail.lookup_key))=?";

		return jdbcTemplate.queryForObject(query, new Object[] { lookupName.trim().toUpperCase(),
				key.trim().toUpperCase() },
				String.class);
	}

	@Override
	public String getLookUpKey(String value, String lookupName) {

		String query = " SELECT lookup_key FROM parameters.v_lookup WHERE (group_value = 'Office' AND upper(lookup_name) = ?) AND"
				+ "  upper(lookup_value) = ?;";

		return jdbcTemplate.queryForObject(query, new Object[] { lookupName.toUpperCase(), value.toUpperCase() },
				String.class);
	}

	public String getName(String id) {
		String query = "SELECT name FROM multifinance.offc WHERE id = ?";
		return jdbcTemplate.queryForObject(query, new Object[] { Integer.valueOf(id) }, String.class);
	}

	public String getHeadId(String name) {
		String query = "SELECT id FROM multifinance.offc WHERE name = ?";

		return jdbcTemplate.queryForObject(query, new Object[] { name }, String.class);
	}

}