package com.multifinance.model.response;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.multifinance.model.EmployeeModel;

@JsonInclude(Include.NON_EMPTY)
public class EmployeeList {

	private List<EmployeeModel> employee;

	public EmployeeList() {
		super();
	}

	public EmployeeList(List<EmployeeModel> employee) {
		super();
		this.employee = employee;
	}

	public List<EmployeeModel> getEmployee() {
		return employee;
	}

	public void setEmployee(List<EmployeeModel> employee) {
		this.employee = employee;
	}

	
}
