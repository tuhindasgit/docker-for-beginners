
package com.cloud.banking.system.service;

import com.cloud.banking.system.exception.BankException;
import com.cloud.banking.system.model.Customer;

/**
 * @author tuhindas
 *
 */
public interface CustomerService {

	/**
	 * Interface for creating a new customer
	 */
	Customer createCustomer(Customer customer) throws BankException;
	/**
	 * 
	 * @param customerId
	 * @return Customer
	 */
	public Customer getCustomerDetails(Integer customerId) throws BankException;
	/**
	 * 
	 * @param customerId
	 * @param customerName
	 * @return Customer
	 * @throws BankException 
	 */
	public Customer updateCustomer(Integer customerId,String customerName) throws BankException;
	
}
