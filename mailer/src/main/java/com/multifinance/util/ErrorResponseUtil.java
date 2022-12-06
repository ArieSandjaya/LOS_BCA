package com.multifinance.util;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import org.springframework.http.HttpStatus;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.multifinance.model.response.ErrorModel;

public class ErrorResponseUtil {
	public static String getError(String status, String description, String errorCode, String errorMessage)
			throws JsonProcessingException {
		ObjectMapper mapper = new ObjectMapper();
		return mapper.writeValueAsString(
				new ErrorModel(DateTimeFormatter.ISO_OFFSET_DATE_TIME.format(ZonedDateTime.now()), status,
						description, errorCode, errorMessage))
				.toString();
	}

	public static HttpStatus getHttpStat(String status) {
		switch (status) {
		case "400":
			return HttpStatus.BAD_REQUEST;
		case "404":
			return HttpStatus.NOT_FOUND;
		default:
			return HttpStatus.BAD_REQUEST;
		}
	}

	public static String getDescription(String status) {
		switch (status) {
		case "400":
			return "Bad Request";
		case "404":
			return "Not Found";
		default:
			return "Bad Request";
		}
	}
}