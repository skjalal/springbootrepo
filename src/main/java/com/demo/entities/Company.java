package com.demo.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "company")
public class Company implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "company_id")
	private Integer companyId;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "status_id", nullable = false)
	private StatusMain statusMain;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "last_modified_by", nullable = false)
	private UserRegistration lastModifiedBy;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "created_by", nullable = false)
	private UserRegistration createdBy;

	@Column(name = "company_name", unique = true, length = 50)
	private String companyName;

	@Column(name = "created_date", length = 19)
	private Date createdDate;

	@Column(name = "last_modified_date", length = 19)
	private Date lastModifiedDate;

	@Column(nullable = false, length = 50, unique = true)
	private String code;

	@Column(length = 50, nullable = false)
	private String name;

	@Column(length = 100, unique = true, nullable = false)
	private String email;

	@Column(length = 50, nullable = false, name = "last_name")
	private String lastName;

	public Company() {

	}

	public Company(StatusMain statusMain, UserRegistration lastModifiedBy, UserRegistration createdBy,
			String companyName, Date createdDate, Date lastModifiedDate, String code, String name, String email,
			String lastName) {
		this.statusMain = statusMain;
		this.lastModifiedBy = lastModifiedBy;
		this.createdBy = createdBy;
		this.companyName = companyName;
		this.createdDate = createdDate;
		this.lastModifiedDate = lastModifiedDate;
		this.code = code;
		this.name = name;
		this.email = email;
		this.lastName = lastName;
	}

	public Integer getCompanyId() {
		return companyId;
	}

	public void setCompanyId(Integer companyId) {
		this.companyId = companyId;
	}

	public StatusMain getStatusMain() {
		return statusMain;
	}

	public void setStatusMain(StatusMain statusMain) {
		this.statusMain = statusMain;
	}

	public UserRegistration getLastModifiedBy() {
		return lastModifiedBy;
	}

	public void setLastModifiedBy(UserRegistration lastModifiedBy) {
		this.lastModifiedBy = lastModifiedBy;
	}

	public UserRegistration getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(UserRegistration createdBy) {
		this.createdBy = createdBy;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Date getLastModifiedDate() {
		return lastModifiedDate;
	}

	public void setLastModifiedDate(Date lastModifiedDate) {
		this.lastModifiedDate = lastModifiedDate;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
}