package com.multifinance.model.response.parent;

import java.util.List;

import com.multifinance.model.response.child.OfficeTreeModel;

public class OfficeTreeParent {

	private List<OfficeTreeModel> office;

	public OfficeTreeParent(List<OfficeTreeModel> office) {
		super();
		this.office = office;
	}

	public OfficeTreeParent() {
		super();
	}

	public List<OfficeTreeModel> getOffice() {
		return office;
	}

	public void setOffice(List<OfficeTreeModel> office) {
		this.office = office;
	}

}
