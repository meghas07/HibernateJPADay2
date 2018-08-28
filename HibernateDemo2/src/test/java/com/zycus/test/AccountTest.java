package com.zycus.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import com.zycus.entity.Account;
import com.zycus.entity.AccountLog;
import com.zycus.service.AccountService;

public class AccountTest {

	@Test
	public void addAccountTest() {
		Account account = new Account();
		account.setAccountNum(2);
		account.setHolderName("Diksha Singh");
		account.setAccountType("Savings");
		account.setBalance(100);

		AccountService service = new AccountService();
		service.addAccount(account);

	}

	@Test
	public void depositTest() {
		AccountService service = new AccountService();
		service.deposit(1, 1000);

	}

	@Test
	public void withdrawTest() {
		AccountService service = new AccountService();
		boolean success = service.withdraw(1, 500);
		if (!success)
			fail("Insufficient Balance for transaction");

	}

	@Test
	public void transferTest() {
		AccountService service = new AccountService();
		boolean success = service.transfer(1, 2, 500);
		if (!success)
			fail("Insufficient Balance for transaction");

	}

	@Test
	public void fecthBalanceTest() {
		AccountService service = new AccountService();
		service.displayBalance(1);

	}

	@Test
	public void miniStatementTest() {
		AccountService service = new AccountService();
		List<AccountLog> accountLog = service.miniStatement(1);
		for (AccountLog log : accountLog)
			System.out.println(log.toString());

	}

	@Test
	public void amountLogTest() {
		AccountService service = new AccountService();
		List<Account> accountLog = service.joinLogByAmount(500);
		for (Account log : accountLog)
			System.out.println(log.toString());

	}

	@Test
	public void accountWithMaxAmountTest() {
		AccountService service = new AccountService();
		List<Object[]> accountMax=service.accountWithMaxAmount();
		for(Object[] o:accountMax){			
			Account a = (Account) o[0]; 
			float d = (Float) o[1]; 
			System.out.println(a + " | " + d);
		}

	}

}
