package com.multifinance.model;

public class OfficeListModel {

	private String nameFilter ="";
	private Integer compId;

	public OfficeListModel(String nameFilter, Integer compId) {
		super();
		this.nameFilter = nameFilter;
		this.compId = compId;
	}

	public OfficeListModel() {
		super();
	}

	public String getNameFilter() {
		return nameFilter;
	}

	public void setNameFilter(String nameFilter) {
		this.nameFilter = nameFilter;
	}

	public Integer getCompId() {
		return compId;
	}

	public void setCompId(Integer compId) {
		this.compId = compId;
	}

}
