package com.zycus.service;

import java.util.ArrayList;
import java.util.List;

import com.zycus.dao.AccountDao;
import com.zycus.dao.GenericDao;
import com.zycus.entity.Account;
import com.zycus.entity.AccountLog;

public class AccountService {
	private AccountDao dao = new AccountDao();

	public void addAccount(Account account) {
		GenericDao dao = new GenericDao();
		dao.add(account);

	}

	public void deposit(int acno, float amount) {
		GenericDao dao = new GenericDao();
		Account account = dao.fetchById(Account.class, acno);
		float initialBalance = account.getBalance();
		float finalBalance = initialBalance + amount;
		account.setBalance(finalBalance);
		dao.update(account);
		AccountLog log = new AccountLog();
		java.util.Date date = new java.util.Date();
		java.sql.Timestamp currentTime = new java.sql.Timestamp(date.getTime());
		log.setTimestamp(currentTime);
		log.setAmount(amount);
		log.setOperationTye("deposit");
		log.setAccount(account);
		dao.add(log);

	}

	public boolean withdraw(int acno, float amount) {
		GenericDao dao = new GenericDao();
		Account account = dao.fetchById(Account.class, acno);
		float initialBalance = account.getBalance();
		float tempBal = initialBalance - amount;
		if (tempBal < 1000)
			return false;

		account.setBalance(tempBal);
		dao.update(account);
		AccountLog log = new AccountLog();
		java.util.Date date = new java.util.Date();
		java.sql.Timestamp currentTime = new java.sql.Timestamp(date.getTime());
		log.setTimestamp(currentTime);
		log.setAmount(amount);
		log.setOperationTye("withdraw");
		log.setAccount(account);
		dao.add(log);
		return true;

	}

	public boolean transfer(int fromacno, int toacno, float amount) {
		boolean withdrawalSuccessful = withdraw(fromacno, amount);
		if (withdrawalSuccessful) {
			deposit(toacno, amount);
			return true;

		}
		return false;

	}

	public void displayBalance(int acno) {

		float balance = dao.fetchBalance(acno);
		System.out.println(balance);
	}

	public List<AccountLog> miniStatement(int acno) {
		List<AccountLog> miniLog = dao.fetchLog(acno);
		return miniLog;

	}

	public List<Account> joinLogByAmount(float amount) {
		List<Account> allAccountsLog = dao.fetchAccountByAmount(amount);
		return allAccountsLog;

	}

	public List<Object[]> accountWithMaxAmount() {
		return dao.fetchAccountWithHighestTransactionAmount();
		

	}

}
