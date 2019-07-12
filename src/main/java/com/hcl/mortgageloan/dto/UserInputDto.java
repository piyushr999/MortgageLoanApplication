package com.hcl.mortgageloan.dto;

import java.util.Date;

public class UserInputDto {

	private String applicantName;

	private String contactNumber;

	private Date dateOfBirth;

	private String email;

	private String sex;

	private String pan;

	private Double monthlySalary;

	private String propType;

	private String propAddress;

	private String propertyPinCode;

	private Double propAreaSize;

	public String getApplicantName() {
		return applicantName;
	}

	public void setApplicantName(String applicantName) {
		this.applicantName = applicantName;
	}

	public String getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getPan() {
		return pan;
	}

	public void setPan(String pan) {
		this.pan = pan;
	}

	public Double getMonthlySalary() {
		return monthlySalary;
	}

	public void setMonthlySalary(Double monthlySalary) {
		this.monthlySalary = monthlySalary;
	}

	public String getPropType() {
		return propType;
	}

	public void setPropType(String propType) {
		this.propType = propType;
	}

	public String getPropAddress() {
		return propAddress;
	}

	public void setPropAddress(String propAddress) {
		this.propAddress = propAddress;
	}

	public String getPropertyPinCode() {
		return propertyPinCode;
	}

	public void setPropertyPinCode(String propertyPinCode) {
		this.propertyPinCode = propertyPinCode;
	}

	public Double getPropAreaSize() {
		return propAreaSize;
	}

	public void setPropAreaSize(Double propAreaSize) {
		this.propAreaSize = propAreaSize;
	}

	@Override
	public String toString() {
		return "UserInput [applicantName=" + applicantName + ", contactNumber=" + contactNumber + ", dateOfBirth="
				+ dateOfBirth + ", email=" + email + ", sex=" + sex + ", pan=" + pan + ", monthlySalary="
				+ monthlySalary + ", propType=" + propType + ", propAddress=" + propAddress + ", propertyPinCode="
				+ propertyPinCode + ", propAreaSize=" + propAreaSize + "]";
	}

}
