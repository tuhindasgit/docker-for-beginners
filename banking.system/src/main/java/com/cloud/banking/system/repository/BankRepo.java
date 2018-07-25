
package com.cloud.banking.system.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cloud.banking.system.model.Bank;

/**
 * @author tuhindas
 *
 */
public interface BankRepo extends JpaRepository<Bank, Integer>{
	/**
	 * Query for finding a by specific Id
	 * @param bankId
	 * @return
	 */
	Optional<Bank> findByBankId(Integer bankId);
	

}
