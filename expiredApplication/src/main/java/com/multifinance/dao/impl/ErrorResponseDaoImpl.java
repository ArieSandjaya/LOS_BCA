package com.multifinance.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.multifinance.dao.ErrorResponseDao;
import com.multifinance.mapper.ErrorResponseMapper;
import com.multifinance.model.response.ErrorModel;

@Repository
public class ErrorResponseDaoImpl implements ErrorResponseDao {

	@Autowired
	JdbcTemplate jdbcTemplate;

	@Override
	public ErrorModel getErrorMessage(String errorName) {
		String query = "SELECT error_code, error_name, error_message FROM parameters.error_code WHERE TRIM(error_name) = ? ;";
		return jdbcTemplate.queryForObject(query, new Object[] { errorName }, new ErrorResponseMapper());
	}

}
