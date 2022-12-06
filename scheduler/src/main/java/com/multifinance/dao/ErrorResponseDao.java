package com.multifinance.dao;

import com.multifinance.model.response.ErrorModel;

public interface ErrorResponseDao {
	
	public ErrorModel getErrorMessage(String error);

}
