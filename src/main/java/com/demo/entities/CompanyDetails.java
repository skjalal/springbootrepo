package com.demo.entities;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "company_details")
public class CompanyDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "company_id")
	private Integer companyId;

	@Column(name = "company_name", nullable = false)
	private String companyName;

	@Column(name = "address")
	private String address;

	@Column(name = "city")
	private String city;

	@Column(name = "state")
	private String state;

	@Column(name = "country")
	private String country;

	@Column(name = "pin")
	private String pin;

	@Column(name = "phone")
	private String phone;

	@Column(name = "fax")
	private String fax;

	@Column(name = "status_flag")
	private Integer statusFlag;

	@Column(name = "license_count")
	private Integer licenseCount;

	@Column(name = "fromdate")
	private Timestamp fromdate;

	@Column(name = "todate")
	private Timestamp todate;

	@Column(name = "total_License")
	private String totalLicense;

	@Column(name = "comp_url")
	private String compUrl;

	@Column(name = "company")
	private String company;

	public CompanyDetails() {
		super();
	}

	public CompanyDetails(String companyName, String address, String city, String state, String country, String pin,
			String phone, String fax, Integer statusFlag, Integer licenseCount, Timestamp fromdate, Timestamp todate,
			String totalLicense, String compUrl, String company) {
		super();
		this.companyName = companyName;
		this.address = address;
		this.city = city;
		this.state = state;
		this.country = country;
		this.pin = pin;
		this.phone = phone;
		this.fax = fax;
		this.statusFlag = statusFlag;
		this.licenseCount = licenseCount;
		this.fromdate = fromdate;
		this.todate = todate;
		this.totalLicense = totalLicense;
		this.compUrl = compUrl;
		this.company = company;
	}

	public Integer getCompanyId() {
		return companyId;
	}

	public void setCompanyId(Integer companyId) {
		this.companyId = companyId;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
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

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getPin() {
		return pin;
	}

	public void setPin(String pin) {
		this.pin = pin;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getFax() {
		return fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	public Integer getStatusFlag() {
		return statusFlag;
	}

	public void setStatusFlag(Integer statusFlag) {
		this.statusFlag = statusFlag;
	}

	public Integer getLicenseCount() {
		return licenseCount;
	}

	public void setLicenseCount(Integer licenseCount) {
		this.licenseCount = licenseCount;
	}

	public Timestamp getFromdate() {
		return fromdate;
	}

	public void setFromdate(Timestamp fromdate) {
		this.fromdate = fromdate;
	}

	public Timestamp getTodate() {
		return todate;
	}

	public void setTodate(Timestamp todate) {
		this.todate = todate;
	}

	public String getTotalLicense() {
		return totalLicense;
	}

	public void setTotalLicense(String totalLicense) {
		this.totalLicense = totalLicense;
	}

	public String getCompUrl() {
		return compUrl;
	}

	public void setCompUrl(String compUrl) {
		this.compUrl = compUrl;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}
}