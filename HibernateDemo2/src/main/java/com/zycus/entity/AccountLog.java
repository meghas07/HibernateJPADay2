package com.zycus.entity;

import java.sql.Timestamp;

import javax.persistence.*;

@Entity
@Table(name = "AccountLog")
public class AccountLog {

	@Id
	@GeneratedValue
	private int logId;

	private Timestamp timestamp;
	private float amount;
	private String operationTye;
	

	@ManyToOne
	@JoinColumn(name = "AccountNum")
	private Account account;

	public int getLogId() {
		return logId;
	}

	public void setLogId(int logId) {
		this.logId = logId;
	}

	public Timestamp getTimestamp() {
		return timestamp;
	}

	@Override
	public String toString() {
		return "AccountLog [logId=" + logId + ", timestamp=" + timestamp + ", amount=" + amount + ", operationTye="
				+ operationTye  + "]";
	}

	public void setTimestamp(Timestamp timestamp) {
		this.timestamp = timestamp;
	}

	public float getAmount() {
		return amount;
	}

	public void setAmount(float amount) {
		this.amount = amount;
	}

	public String getOperationTye() {
		return operationTye;
	}

	public void setOperationTye(String operationTye) {
		this.operationTye = operationTye;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	

}
