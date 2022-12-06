package com.multifinance.dao;

import com.multifinance.model.OfficeModel;

public interface PutDao {
	
	public void updateOffice(String id, OfficeModel officeModel);

	int getId(String id);

	public int offcNamePutCheck(String name, String id);
}
