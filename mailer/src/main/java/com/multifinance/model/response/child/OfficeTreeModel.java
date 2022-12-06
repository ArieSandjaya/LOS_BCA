package com.multifinance.model.response.child;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_EMPTY)
public class OfficeTreeModel {

	private Long id;
	private String officeId;
	private Long officeHeadId;
	private String label;
	private String officeType;
	private String zipcode;
	private String type = "office";
	private String styleClass = "ui-office";
	private Boolean expanded = true;
	private List<OfficeTreeModel> children;

	public OfficeTreeModel() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getOfficeId() {
		return officeId;
	}

	public void setOfficeId(String officeId) {
		this.officeId = officeId;
	}

	public Long getOfficeHeadId() {
		return officeHeadId;
	}

	public void setOfficeHeadId(Long officeHeadId) {
		this.officeHeadId = officeHeadId;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public String getOfficeType() {
		return officeType;
	}

	public void setOfficeType(String officeType) {
		this.officeType = officeType;
	}

	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getStyleClass() {
		return styleClass;
	}

	public void setStyleClass(String styleClass) {
		this.styleClass = styleClass;
	}

	public Boolean getExpanded() {
		return expanded;
	}

	public void setExpanded(Boolean expanded) {
		this.expanded = expanded;
	}

	public List<OfficeTreeModel> getChildren() {
		return children;
	}

	public void setChildren(List<OfficeTreeModel> children) {
		this.children = children;
	}

	@Override
	public String toString() {
		return "OfficeTreeModel [id=" + id + ", officeId=" + officeId + ", officeHeadId=" + officeHeadId + ", label="
				+ label + ", officeType=" + officeType + ", zipcode=" + zipcode + ", type=" + type + ", styleClass="
				+ styleClass + ", expanded=" + expanded + ", children=" + children + "]";
	}

}
