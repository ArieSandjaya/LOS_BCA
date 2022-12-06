package com.multifinance.model.response;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.multifinance.model.OfficeModel;

@JsonInclude(Include.NON_EMPTY)
public class OfficeList {

	private List<OfficeModel> office;

	public OfficeList() {
		super();
	}

	public List<OfficeModel> getOffice() {
		return office;
	}

	public void setOffice(List<OfficeModel> office) {
		this.office = office;
	}

}
