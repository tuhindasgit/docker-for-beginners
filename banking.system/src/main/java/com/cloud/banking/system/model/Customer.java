
package com.cloud.banking.system.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 * @author tuhindas
 *
 */
@Entity
public class Customer {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
    private Integer customerId;
	private String name;
	private Integer pin;
	private Integer bankId;
	
	/**
	 * @return the customerId
	 */
	public Integer getCustomerId() {
		return customerId;
	}
	/**
	 * @param customerId the customerId to set
	 */
	public void setCustomerId(final Integer customerId) {
		this.customerId = customerId;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(final String name) {
		this.name = name;
	}
	/**
	 * @return the pin
	 */
	public Integer getPin() {
		return pin;
	}
	/**
	 * @param pin the pin to set
	 */
	public void setPin(final Integer pin) {
		this.pin = pin;
	}
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
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", name=" + name + ", pin=" + pin + ", bankId=" + bankId + "]";
	}

	
}
