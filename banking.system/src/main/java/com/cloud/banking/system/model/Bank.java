package com.cloud.banking.system.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
/**
 * @author tuhindas
 * bank POJO
 */
@Entity
public class Bank {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer bankId;
	private BigDecimal amount;
	/**
	 * mapping between customer and bank
	 */
	@OneToMany(targetEntity=Customer.class,mappedBy="bankId")
	private List<Customer> bankCustomerList = new ArrayList<>();
	/**
	 * @return the bankId
	 */
	public Integer getBankId() {
		return bankId;
	}
	/**
	 * @param bankId the bankId to set
	 */
	public void setBankId(final Integer bankId) {
		this.bankId = bankId;
	}
	/**
	 * @return the amount
	 */
	public BigDecimal getAmount() {
		return amount;
	}
	/**
	 * @param amount the amount to set
	 */
	public void setAmount(final BigDecimal amount) {
		this.amount = amount;
	}

	/**
	 * @return the bankCustomerList
	 */
	public List<Customer> getBankCustomerList() {
		return bankCustomerList;
	}
	/**
	 * no parameter constructor
	 */
	public Bank() {
		super();
	}

	/**
	 * to print object
	 */
	@Override
	public String toString() {
		return "Bank [bankId=" + bankId + ", amount=" + amount + "]";
	}
	public Bank(Integer bankId, BigDecimal amount) {
		super();
		this.bankId = bankId;
		this.amount = amount;
	}
	

}
