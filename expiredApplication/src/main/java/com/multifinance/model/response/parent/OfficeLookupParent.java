package com.multifinance.model.response.parent;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.multifinance.model.response.child.OfficeLookupModel;

@JsonInclude(Include.NON_EMPTY)
public class OfficeLookupParent {

	private List<OfficeLookupModel> lookup;

	public OfficeLookupParent(List<OfficeLookupModel> lookup) {
		super();
		this.lookup = lookup;
	}

	public OfficeLookupParent() {
		super();
	}

	public List<OfficeLookupModel> getLookup() {
		return lookup;
	}

	public void setLookup(List<OfficeLookupModel> lookup) {
		this.lookup = lookup;
	}

}
