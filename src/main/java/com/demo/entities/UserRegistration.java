package com.demo.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "user_registration")
public class UserRegistration {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer userId;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "status_id", nullable = false)
	private StatusMain statusMain;

	@Column(name = "company_id")
	private Integer companyId;

	@Column(name = "user_name", nullable = false, length = 50)
	private String userName;

	@Column(name = "password", nullable = false, length = 250)
	private String password;
	
	@JoinColumn(name = "role_id", unique = true)
	@OneToOne(cascade = CascadeType.ALL)
	private Role role;

	@Column(name = "type_id", nullable = false)
	private Integer typeId;

	@Column(name = "type_name", nullable = false, length = 50)
	private String typeName;

	@Column(name = "first_name", nullable = false, length = 50)
	private String firstName;

	@Column(name = "privilege", length = 500)
	private String privilege;

	@Column(name = "forgot_key", length = 50)
	private String forgotKey;

	@Column(name = "time_zone", length = 50)
	private String timeZone;

	@Column(name = "last_login_time", length = 25)
	private String lastLoginTime;

	@Column(name = "last_logout_time", length = 25)
	private String lastLogoutTime;

	@Column(name = "ip_address", length = 15)
	private String ipAddress;

	@Column(name = "clocks_display_enable", length = 15)
	private String clocksEnable;

	@Column(name = "digital_fmt", length = 10)
	private String digitalFormat;

	@Column(name = "date_display", length = 10)
	private String dateDisplay;

	@Column(name = "gmt_offset", length = 10)
	private String gmtDisplay;

	@Column(name = "time_fmt", length = 10)
	private String timeDisplay;

	@Column(name = "timezone_fmt", length = 10)
	private String countryDisplay;

	@Column(name = "is_agent_admin", length = 5)
	private String isAgentAdmin;

	@Column(name = "default_company_Id")
	private Integer defaultCompanyId;

	@Column(name = "calendar_user_id", length = 250)
	private String calendarUserId;

	public UserRegistration() {
		super();
	}

	public UserRegistration(StatusMain statusMain, String userName, String password, Integer typeId, String typeName,
			String firstName) {
		this.statusMain = statusMain;
		this.userName = userName;
		this.password = password;
		this.typeId = typeId;
		this.typeName = typeName;
		this.firstName = firstName;
	}

	public UserRegistration(StatusMain statusMain, Integer companyId, String userName, String password, Role role, Integer typeId,
			String typeName, String firstName, String privilege, String forgotKey, String timeZone,
			String lastLoginTime, String lastLogoutTime, String ipAddress, String clocksEnable, String digitalFormat,
			String dateDisplay, String gmtDisplay, String timeDisplay, String countryDisplay, String isAgentAdmin,
			Integer defaultCompanyId, String calendarUserId) {
		super();
		this.statusMain = statusMain;
		this.companyId = companyId;
		this.userName = userName;
		this.password = password;
		this.role = role;
		this.typeId = typeId;
		this.typeName = typeName;
		this.firstName = firstName;
		this.privilege = privilege;
		this.forgotKey = forgotKey;
		this.timeZone = timeZone;
		this.lastLoginTime = lastLoginTime;
		this.lastLogoutTime = lastLogoutTime;
		this.ipAddress = ipAddress;
		this.clocksEnable = clocksEnable;
		this.digitalFormat = digitalFormat;
		this.dateDisplay = dateDisplay;
		this.gmtDisplay = gmtDisplay;
		this.timeDisplay = timeDisplay;
		this.countryDisplay = countryDisplay;
		this.isAgentAdmin = isAgentAdmin;
		this.defaultCompanyId = defaultCompanyId;
		this.calendarUserId = calendarUserId;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public StatusMain getStatusMain() {
		return statusMain;
	}

	public void setStatusMain(StatusMain statusMain) {
		this.statusMain = statusMain;
	}

	public Integer getCompanyId() {
		return companyId;
	}

	public void setCompanyId(Integer companyId) {
		this.companyId = companyId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public Integer getTypeId() {
		return typeId;
	}

	public void setTypeId(Integer typeId) {
		this.typeId = typeId;
	}

	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getPrivilege() {
		return privilege;
	}

	public void setPrivilege(String privilege) {
		this.privilege = privilege;
	}

	public String getForgotKey() {
		return forgotKey;
	}

	public void setForgotKey(String forgotKey) {
		this.forgotKey = forgotKey;
	}

	public String getTimeZone() {
		return timeZone;
	}

	public void setTimeZone(String timeZone) {
		this.timeZone = timeZone;
	}

	public String getLastLoginTime() {
		return lastLoginTime;
	}

	public void setLastLoginTime(String lastLoginTime) {
		this.lastLoginTime = lastLoginTime;
	}

	public String getLastLogoutTime() {
		return lastLogoutTime;
	}

	public void setLastLogoutTime(String lastLogoutTime) {
		this.lastLogoutTime = lastLogoutTime;
	}

	public String getIpAddress() {
		return ipAddress;
	}

	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}

	public String getClocksEnable() {
		return clocksEnable;
	}

	public void setClocksEnable(String clocksEnable) {
		this.clocksEnable = clocksEnable;
	}

	public String getDigitalFormat() {
		return digitalFormat;
	}

	public void setDigitalFormat(String digitalFormat) {
		this.digitalFormat = digitalFormat;
	}

	public String getDateDisplay() {
		return dateDisplay;
	}

	public void setDateDisplay(String dateDisplay) {
		this.dateDisplay = dateDisplay;
	}

	public String getGmtDisplay() {
		return gmtDisplay;
	}

	public void setGmtDisplay(String gmtDisplay) {
		this.gmtDisplay = gmtDisplay;
	}

	public String getTimeDisplay() {
		return timeDisplay;
	}

	public void setTimeDisplay(String timeDisplay) {
		this.timeDisplay = timeDisplay;
	}

	public String getCountryDisplay() {
		return countryDisplay;
	}

	public void setCountryDisplay(String countryDisplay) {
		this.countryDisplay = countryDisplay;
	}

	public String getIsAgentAdmin() {
		return isAgentAdmin;
	}

	public void setIsAgentAdmin(String isAgentAdmin) {
		this.isAgentAdmin = isAgentAdmin;
	}

	public Integer getDefaultCompanyId() {
		return defaultCompanyId;
	}

	public void setDefaultCompanyId(Integer defaultCompanyId) {
		this.defaultCompanyId = defaultCompanyId;
	}

	public String getCalendarUserId() {
		return calendarUserId;
	}

	public void setCalendarUserId(String calendarUserId) {
		this.calendarUserId = calendarUserId;
	}
}