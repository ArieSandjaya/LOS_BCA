package com.multifinance.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.jdbc.core.RowMapper;

import com.multifinance.model.response.ErrorModel;
import com.multifinance.util.ErrorResponseUtil;


public class ErrorResponseMapper implements RowMapper<ErrorModel> {

	@Override
	public ErrorModel mapRow(ResultSet rs, int rowNum) throws SQLException {
		ErrorModel errorResponseModel = new ErrorModel();
		errorResponseModel.setTimestamp(DateTimeFormatter.ISO_OFFSET_DATE_TIME.format(ZonedDateTime.now()));
		errorResponseModel.setStatus(rs.getString("error_code"));
		errorResponseModel.setErrorCode(rs.getString("error_name"));
		errorResponseModel.setErrorMessage(rs.getString("error_message"));
		errorResponseModel.setDescription(ErrorResponseUtil.getDescription(errorResponseModel.getStatus()));

		return errorResponseModel;
	}

}
