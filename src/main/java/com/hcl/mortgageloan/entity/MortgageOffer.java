package com.hcl.mortgageloan.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @author Administrator
 *
 */
@Entity
public class MortgageOffer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long mortgageId;

	private Double loanAmount;

	private int tenureInMonths;

	private Double interestRate;

	private Double emiPerMonth;

	public Long getMortgageId() {
		return mortgageId;
	}

	public void setMortgageId(Long mortgageId) {
		this.mortgageId = mortgageId;
	}

	public Double getLoanAmount() {
		return loanAmount;
	}

	public void setLoanAmount(Double loanAmount) {
		this.loanAmount = loanAmount;
	}

	public int getTenureInMonths() {
		return tenureInMonths;
	}

	public void setTenureInMonths(int tenureInMonths) {
		this.tenureInMonths = tenureInMonths;
	}

	public Double getInterestRate() {
		return interestRate;
	}

	public void setInterestRate(Double interestRate) {
		this.interestRate = interestRate;
	}

	public Double getEmiPerMonth() {
		return emiPerMonth;
	}

	public void setEmiPerMonth(Double emiPerMonth) {
		this.emiPerMonth = emiPerMonth;
	}

	@Override
	public String toString() {
		return "MortgageOffer [mortgageId=" + mortgageId + ", loanAmount=" + loanAmount + ", tenureInMonths="
				+ tenureInMonths + ", interestRate=" + interestRate + ", emiPerMonth=" + emiPerMonth + "]";
	}

}
