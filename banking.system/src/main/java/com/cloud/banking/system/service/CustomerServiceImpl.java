package com.cloud.banking.system.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import com.cloud.banking.system.exception.BankException;
import com.cloud.banking.system.model.Bank;
import com.cloud.banking.system.model.Customer;
import com.cloud.banking.system.repository.CustomerRepo;

/**
 * @author tuhindas
 *
 */
@Service
@Configuration
@PropertySource("classpath:message.properties")
public class CustomerServiceImpl implements CustomerService{

	@Autowired
	CustomerRepo customerRepo;
	
	@Autowired
	BankService bankservice;
	
	@Autowired
	Environment env;
	/**
	 * Customer Service for Creating a customer
	 */
	@Override
	public Customer createCustomer(Customer customer) throws BankException {
		final Integer id=customer.getBankId();
		final Optional<Bank> bank=bankservice.findById(id);
		if (bank.isPresent()) {
			final Customer cust = customerRepo.save(customer);
			return cust;
		} else {
			throw new BankException(env.getProperty("CustomerBankId"));

		}
	}

	/**
	 * finding a specific customer finding by customer Id
	 */
	@Override
	public Customer getCustomerDetails(Integer customerId) throws BankException {
		final Optional<Customer> customerOption = customerRepo.findByCustomerId(customerId);
		if(customerOption.isPresent())
		{
		
			return customerOption.get();
		}
		else
		{
			throw new BankException(env.getProperty("CustomerId"));
		}
	}
	

	/**
	 * updating a customer name with customer id provided
	 */
	@Override
	public Customer updateCustomer(Integer customerId, String customerName) throws BankException {
		final Optional<Customer> customerOption = customerRepo.findByCustomerId(customerId);

		if(customerOption.isPresent())
		{
			
			Customer customer= customerOption.get();
		
				//Customer oldCustomer=newCustomer.clone();
			
//			Audit audit=new Audit();
//			audit.setEventDate(new Date());
//			audit.setEventName(BankEnum.eventName.CUSTOMER.toString());
//			audit.setEventType(BankEnum.eventType.UPDATE.toString());
//			audit.setUserId(newCustomer.getUserId());
//			audit.setNewValue(newCustomer);
//			audit.setOldValue(oldCustomer);
			
			
			customer.setName(customerName);
		
			//controller.eurekaConnect(audit);
			return customerRepo.save(customer);
	}
		else
			{
			throw new BankException(env.getProperty("CustomerUpdate"));
			}}
	}


