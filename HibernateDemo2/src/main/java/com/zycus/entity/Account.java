package com.zycus.entity;

import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name = "ACCOUNT")
public class Account {

	@Id
	private int AccountNum;

	private String holderName;
	private String accountType;
	private float balance;
	
	@OneToMany(mappedBy = "account")
	private Set<AccountLog> accountsLog;

	@Override
	public String toString() {
		return "Account [AccountNum=" + AccountNum + ", holderName=" + holderName + ", accountType=" + accountType
				+ ", balance=" + balance  + "]";
	}

	public int getAccountNum() {
		return AccountNum;
	}

	public void setAccountNum(int accountNum) {
		AccountNum = accountNum;
	}

	public String getHolderName() {
		return holderName;
	}

	public void setHolderName(String holderName) {
		this.holderName = holderName;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public float getBalance() {
		return balance;
	}

	public void setBalance(float balance) {
		this.balance = balance;
	}

	public Set<AccountLog> getAccountsLog() {
		return accountsLog;
	}

	public void setAccountsLog(Set<AccountLog> accountsLog) {
		this.accountsLog = accountsLog;
	}

}
