package com.multifinance.dao;

import java.util.List;

import com.multifinance.model.EmployeeModel;
import com.multifinance.model.OfficeModel;
import com.multifinance.model.response.child.OfficeLookupModel;
import com.multifinance.model.response.child.OfficeTreeModel;

public interface GetDao {

	List<OfficeLookupModel> lookupOfficeType(String compId);

	OfficeModel getOfficeById(String id);

	List<OfficeLookupModel> lookupOfficeHead();

	int offcIdCheck(String id);

	List<OfficeTreeModel> lookupOfficeTree();

	List<EmployeeModel> getEmployeeByOffice(String offcId);

	void closeSession();

}
