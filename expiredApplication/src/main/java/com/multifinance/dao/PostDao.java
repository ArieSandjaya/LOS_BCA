package com.multifinance.dao;

import java.util.List;

import com.multifinance.model.OfficeModel;


public interface PostDao {
	
	public String entryOffice(OfficeModel officeModel);

	public List<OfficeModel> getOfficeAll();

	public int offcNameCheck(String name);

}
