package com.multifinance.dao;

public interface GetLookUpValueDao {

	public String getLookUpValue(String key, String lookupName);
	
	public String getLookUpKey(String value, String lookupName);
	
	public String getName(String id);
	
	public String getHeadId(String name);

}