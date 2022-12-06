package com.multifinance.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_EMPTY)
public class OfficeModel {

	private String officeId;
	private String officeHeadId;
	private String name;
	private String officeType;
	private String address;
	private String city;
	private String district;
	private String village;
	private String state;
	private String hamletNumber;
	private String neighbourhoodNumber;
	private String zipcode;
	private Integer compId;
	private Long updateBy;

	public OfficeModel() {
		super();
	}

	public String getOfficeId() {
		return officeId;
	}

	public void setOfficeId(String officeId) {
		this.officeId = officeId;
	}

	public String getOfficeHeadId() {
		return officeHeadId;
	}

	public void setOfficeHeadId(String officeHeadId) {
		this.officeHeadId = officeHeadId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getOfficeType() {
		return officeType;
	}

	public void setOfficeType(String officeType) {
		this.officeType = officeType;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getVillage() {
		return village;
	}

	public void setVillage(String village) {
		this.village = village;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getHamletNumber() {
		return hamletNumber;
	}

	public void setHamletNumber(String hamletNumber) {
		this.hamletNumber = hamletNumber;
	}

	public String getNeighbourhoodNumber() {
		return neighbourhoodNumber;
	}

	public void setNeighbourhoodNumber(String neighbourhoodNumber) {
		this.neighbourhoodNumber = neighbourhoodNumber;
	}

	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	public Integer getCompId() {
		return compId;
	}

	public void setCompId(Integer compId) {
		this.compId = compId;
	}

	public Long getUpdateBy() {
		return updateBy;
	}

	public void setUpdateBy(Long updateBy) {
		this.updateBy = updateBy;
	}

}