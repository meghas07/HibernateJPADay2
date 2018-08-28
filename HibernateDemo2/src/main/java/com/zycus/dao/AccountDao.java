package com.zycus.dao;

import java.util.List;

import javax.persistence.*;
import javax.persistence.EntityManagerFactory;

import com.zycus.entity.Account;
import com.zycus.entity.AccountLog;

import com.zycus.util.JPAUtil;

public class AccountDao extends GenericDao {

	public float fetchBalance(int accountno) {
		EntityManagerFactory entityManagerFactory = JPAUtil.getEntityManagerFactory();
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		String jpql = "select a.balance from Account a where a.AccountNum=:acno";
		Query query = entityManager.createQuery(jpql);
		query.setParameter("acno", accountno);
		return (Float) query.getSingleResult();

	}

	public List<AccountLog> fetchLog(int accountNum) {
		EntityManagerFactory entityManagerFactory = JPAUtil.getEntityManagerFactory();
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		String jpql = "select log from AccountLog log where log.account.AccountNum=:accountNum order by timestamp desc";
		Query query = entityManager.createQuery(jpql);
		query.setParameter("accountNum", accountNum);
		query.setMaxResults(3);
		return (List<AccountLog>) query.getResultList();

	}

	public List<Account> fetchAccountByAmount(float amount) {
		EntityManagerFactory entityManagerFactory = JPAUtil.getEntityManagerFactory();
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		String jpql = "select acc from Account acc join acc.accountsLog log where log.amount>=:amt";
		Query query = entityManager.createQuery(jpql);
		query.setParameter("amt", amount);
		return (List<Account>) query.getResultList();

	}

	public List<Object[]> fetchAccountWithHighestTransactionAmount() {
		EntityManagerFactory entityManagerFactory = JPAUtil.getEntityManagerFactory();
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		String jpql = "select distinct acc, log.amount from Account acc join acc.accountsLog log where log.amount=(select MAX(amount) from AccountLog)";
//		String jpql = "select acc, max(txn.amount) from Account acc, acc.accountsLog txn where acc.AccountNum = txn.account.AccountNum";
		Query query = entityManager.createQuery(jpql);
		
		return (List<Object[]>) query.getResultList();
		
		

	}

}
