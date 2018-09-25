package com.demo.dto;

public class CompanyDTO {

	private String companyCode;
	private String companyName;
	private String createdDate;

	public CompanyDTO() {

	}

	public CompanyDTO(String companyCode, String companyName, String createdDate) {
		this.companyCode = companyCode;
		this.companyName = companyName;
		this.createdDate = createdDate;
	}

	public String getCompanyCode() {
		return companyCode;
	}

	public void setCompanyCode(String companyCode) {
		this.companyCode = companyCode;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}
}