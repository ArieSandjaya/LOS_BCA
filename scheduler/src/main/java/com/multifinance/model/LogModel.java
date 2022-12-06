package com.multifinance.model;

public class LogModel {

	
	
	private int severityLevel;
	private String serviceName;
	private String eventType;
	private String eventResult;
	private int actor;
	private String serverName;
	private String ipAddress;
	private String device;
	private String os;


	public int getSeverityLevel() {
		return severityLevel;
	}

	public void setSeverityLevel(int severityLevel) {
		this.severityLevel = severityLevel;
	}

	public String getServiceName() {
		return serviceName;
	}

	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}

	public String getEventType() {
		return eventType;
	}

	public void setEventType(String eventType) {
		this.eventType = eventType;
	}

	public String getEventResult() {
		return eventResult;
	}

	public void setEventResult(String eventResult) {
		this.eventResult = eventResult;
	}

	public int getActor() {
		return actor;
	}

	public void setActor(int actor) {
		this.actor = actor;
	}

	public String getServerName() {
		return serverName;
	}

	public void setServerName(String serverName) {
		this.serverName = serverName;
	}

	public String getIpAddress() {
		return ipAddress;
	}

	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}

	public String getDevice() {
		return device;
	}

	public void setDevice(String device) {
		this.device = device;
	}

	public String getOs() {
		return os;
	}

	public void setOs(String os) {
		this.os = os;
	}

	public LogModel(int severityLevel, String serviceName, String eventType, String eventResult, int actor,
			String serverName, String ipAddress, String device, String os) {
		super();
		this.severityLevel = severityLevel;
		this.serviceName = serviceName;
		this.eventType = eventType;
		this.eventResult = eventResult;
		this.actor = actor;
		this.serverName = serverName;
		this.ipAddress = ipAddress;
		this.device = device;
		this.os = os;
	}

	public LogModel() {
		super();
	}

	@Override
	public String toString() {
		return "logModel [severityLevel=" + severityLevel + ", serviceName=" + serviceName + ", eventType=" + eventType
				+ ", eventResult=" + eventResult + ", actor=" + actor + ", serverName=" + serverName + ", ipAddress="
				+ ipAddress + ", device=" + device + ", os=" + os + "]";
	}

}
