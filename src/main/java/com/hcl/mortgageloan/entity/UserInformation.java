package com.hcl.mortgageloan.entity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @author Administrator
 *
 */
@Entity
public class UserInformation {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long userId;

	private String fullName;

	private String phoneNumber;

	private LocalDate dob;

	private String emailId;

	private String gender;

	private String panNumber;

	private Double salary;

	private String propertyType;

	private String propertyAddress;

	private String pinCode;

	private Double propertyAreaSize;

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public LocalDate getDob() {
		return dob;
	}

	public void setDob(LocalDate dob) {
		this.dob = dob;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getPanNumber() {
		return panNumber;
	}

	public void setPanNumber(String panNumber) {
		this.panNumber = panNumber;
	}

	public Double getSalary() {
		return salary;
	}

	public void setSalary(Double salary) {
		this.salary = salary;
	}

	public String getPropertyType() {
		return propertyType;
	}

	public void setPropertyType(String propertyType) {
		this.propertyType = propertyType;
	}

	public String getPropertyAddress() {
		return propertyAddress;
	}

	public void setPropertyAddress(String propertyAddress) {
		this.propertyAddress = propertyAddress;
	}

	public String getPinCode() {
		return pinCode;
	}

	public void setPinCode(String pinCode) {
		this.pinCode = pinCode;
	}

	public Double getPropertyAreaSize() {
		return propertyAreaSize;
	}

	public void setPropertyAreaSize(Double propertyAreaSize) {
		this.propertyAreaSize = propertyAreaSize;
	}

	@Override
	public String toString() {
		return "UserInformation [userId=" + userId + ", fullName=" + fullName + ", phoneNumber=" + phoneNumber
				+ ", dob=" + dob + ", emailId=" + emailId + ", gender=" + gender + ", panNumber=" + panNumber
				+ ", salary=" + salary + ", propertyType=" + propertyType + ", propertyAddress=" + propertyAddress
				+ ", pinCode=" + pinCode + ", propertyAreaSize=" + propertyAreaSize + "]";
	}
}
