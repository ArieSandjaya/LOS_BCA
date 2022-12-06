package com.multifinance.model.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_EMPTY)
public class Office {

	private String officeId;
	private String response;

	public Office(String officeId, String response) {
		super();
		this.officeId = officeId;
		this.response = response;
	}

	public Office() {
		super();
	}

	public String getOfficeId() {
		return officeId;
	}

	public void setOfficeId(String officeId) {
		this.officeId = officeId;
	}

	public String getResponse() {
		return response;
	}

	public void setResponse(String response) {
		this.response = response;
	}

	@Override
	public String toString() {
		return "OfficeResponseModel [officeId=" + officeId + ", response=" + response + "]";
	}

}