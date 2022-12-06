package com.multifinance.model.response;

public class ErrorModel {

	private String timestamp;
	private String status;
	private String description;
	private String errorCode;
	private String errorMessage;

	public ErrorModel(String timestamp, String status, String description, String errorCode,
			String errorMessage) {
		super();
		this.timestamp = timestamp;
		this.status = status;
		this.description = description;
		this.errorCode = errorCode;
		this.errorMessage = errorMessage;
	}

	public ErrorModel() {
		super();
	}

	public String getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	@Override
	public String toString() {
		return "ResponseErrorModel [timestamp=" + timestamp + ", status=" + status + ", description=" + description
				+ ", errorCode=" + errorCode + ", errorMessage=" + errorMessage + "]";
	}

}
