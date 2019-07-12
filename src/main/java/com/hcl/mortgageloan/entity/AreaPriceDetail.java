package com.hcl.mortgageloan.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class AreaPriceDetail {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String pinCode;

	private Double areaPrice;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPinCode() {
		return pinCode;
	}

	public void setPinCode(String pinCode) {
		this.pinCode = pinCode;
	}

	public Double getAreaPrice() {
		return areaPrice;
	}

	public void setAreaPrice(Double areaPrice) {
		this.areaPrice = areaPrice;
	}

	@Override
	public String toString() {
		return "AreaPriceDetail [id=" + id + ", pinCode=" + pinCode + ", areaPrice=" + areaPrice + "]";
	}

}
