/**
 * 
 */
package com.cloud.banking.system.service;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import com.cloud.banking.system.exception.BankException;
import com.cloud.banking.system.model.Bank;
import com.cloud.banking.system.repository.BankRepo;

/**
 * @author tuhindas
 * 
 */
@Service
@Configuration
@PropertySource("classpath:message.properties")
public class BankServiceImpl implements BankService {

	private static final Logger log=LoggerFactory.getLogger(BankServiceImpl.class);
	@Autowired
	BankRepo bankRepo;
	@Autowired
	Environment env;
	/**
	 * creating new bank 
	 * sending bank object
	 */
	@Override
	public Bank createBank(Bank bank) throws BankException {
		if (bank.getAmount().intValue()<0) {
			throw new BankException(env.getProperty("BankInvalidData"));
		} else {
			log.info("customer Created");
			return bankRepo.save(bank);
		
			
		}
	}

	/**
	 * Retrieve a specific BankDetails
	 * @param bankId
	 * @return Bank Object
	  */
	@Override
	public Bank findBankById(Integer bankId) throws BankException{
		final Optional<Bank> bank = bankRepo.findByBankId(bankId);
		if(bank.isPresent())
		{
			log.info("customer Details:  " +bank.get());
				return bank.get();
		}
		else
		{
					throw new BankException(env.getProperty("BankId"));
		}
	}

	/**
	 * method to check for a customer is present or not
	 */
	@Override
	public Optional<Bank> findById(Integer bankId) throws BankException {
		
		return bankRepo.findByBankId(bankId);
	}

}
