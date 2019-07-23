package com.paing.model;

import java.util.Date;

import javax.validation.constraints.NotNull;

public class Customer {

	private Integer customerId;

	@NotNull
	private String customerName;

	@NotNull
	private Integer age;

	@NotNull
	private String gender;

	@NotNull
	private String phoneNumber;

	@NotNull
	private String address;

	private Date createdDate;
	private Date updatedDate;

	public String getAddress() {
		return address;
	}

	public Integer getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
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

	public Date getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}

	public void setAddress(String address) {
		this.address = address;
	}

}
