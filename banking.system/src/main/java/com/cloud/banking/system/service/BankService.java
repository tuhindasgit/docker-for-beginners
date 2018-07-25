
package com.cloud.banking.system.service;

import java.util.Optional;

import com.cloud.banking.system.exception.BankException;
import com.cloud.banking.system.model.Bank;

/**
 * @author tuhindas
 *
 */
public interface BankService {

	/**
	 * creating a bank
	 */
	Bank createBank(Bank bank) throws BankException;
	/**
	 * Retrieve a bank by Id
	 */
	Bank findBankById(Integer bankId) throws BankException;
	/**
	 * for condition checking
	 * @param bankId
	 * @return
	 * @throws BankException
	 */
	Optional<Bank> findById(Integer bankId) throws BankException;
	
}
