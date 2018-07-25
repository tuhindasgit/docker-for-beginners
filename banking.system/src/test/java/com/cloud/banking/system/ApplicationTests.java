package com.cloud.banking.system;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;
import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.env.Environment;
import org.springframework.test.context.junit4.SpringRunner;

import com.cloud.banking.system.exception.BankException;
import com.cloud.banking.system.model.Bank;
import com.cloud.banking.system.repository.BankRepo;
import com.cloud.banking.system.service.BankServiceImpl;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationTests {

	@Mock
	BankRepo bankRepo;
	@InjectMocks
	private BankServiceImpl bankserviceimpl;
	@Mock
	private Environment env;
	
	private Bank bank;
	@org.junit.Before
	public void beforeTest() {
		bank=new Bank();
	}
	/**
	 * positive test case for creating bank
	 * @throws BankException 
	 */
	@Test
	public void testBankP() throws BankException
	{
		bank.setBankId(5);
		bank.setAmount(new BigDecimal(102));
		when(bankRepo.save(Mockito.<Bank>any())).thenReturn(bank);
		assertEquals(new BigDecimal(102),bankserviceimpl.createBank(bank).getAmount());
	}
	/**
	 * negative test case for bank creation
	 * @throws BankException 
	 */
	@Test(expected=BankException.class)
	public void testBankF() throws BankException {
		bank.setAmount(new BigDecimal(-102));
		bank.setBankId(5);
		System.out.println(bank);
		when(env.getProperty(Mockito.anyString())).thenReturn("BankInvalidData");
		bankserviceimpl.createBank(bank);
		
	}
	/**
	 * test case for finding a bank by bankId
	 * @throws BankException 
	 */
	@Test
	public void testFindByBankId() throws BankException
	{
		bank=new Bank();
		bank.setAmount(new BigDecimal(102));
		bank.setBankId(5);
		Optional<Bank> opBank=Optional.of(bank);
		when(bankRepo.findByBankId(Mockito.<Integer>any())).thenReturn(opBank);
		assertEquals(new BigDecimal(102),bankserviceimpl.findBankById(5).getAmount());

	}
	/**
	 * negative test case for finding by bankId
	 * @throws BankException 
	 */
	@Test(expected=BankException.class)
	public void testFindByBankIdF() throws BankException {
		Optional<Bank> opBank=Optional.empty();
		when(bankRepo.findByBankId(8)).thenReturn(opBank);
		when(env.getProperty(Mockito.anyString())).thenReturn("BankId");
		bankserviceimpl.findBankById(8);
		
	}
	
}
