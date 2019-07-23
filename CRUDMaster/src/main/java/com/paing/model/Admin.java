package com.paing.model;

import java.util.Date;

import javax.validation.constraints.NotNull;

public class Admin {

	private Integer adminId;
	@NotNull
	private String adminName;
	@NotNull
	private Integer age;
	@NotNull
	private String phoneNumber;
	@NotNull
	private String address;
	private Date createdDate;

	public String getAddress() {
		return address;
	}

	public Integer getAdminId() {
		return adminId;
	}

	public void setAdminId(Integer adminId) {
		this.adminId = adminId;
	}

	public String getAdminName() {
		return adminName;
	}

	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public void setAddress(String address) {
		this.address = address;
	}
}
