package com.multifinance.model.response.child;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_EMPTY)
public class OfficeLookupModel {

	private String uuid;
	private String label;
	private String value;

	public OfficeLookupModel(String uuid, String label, String value) {
		super();
		this.uuid = uuid;
		this.label = label;
		this.value = value;
	}

	public OfficeLookupModel() {
		super();
	}

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

}