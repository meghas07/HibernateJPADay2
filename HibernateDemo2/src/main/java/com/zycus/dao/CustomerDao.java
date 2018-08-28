package com.zycus.dao;

import org.hibernate.Transaction;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.zycus.entity.Customer;
import com.zycus.util.JPAUtil;

public class CustomerDao {

	public void add(Customer customer) {

		EntityManagerFactory entityManagerFactory = JPAUtil.getEntityManagerFactory();
		EntityManager entityManager = entityManagerFactory.createEntityManager();

		EntityTransaction tx = entityManager.getTransaction();
		tx.begin();
		entityManager.persist(customer);
		tx.commit();

	}

	public void update(Customer customer) {

		// Step 1 Create/Obtain SessionFactory object
		EntityManagerFactory entityManagerFactory = JPAUtil.getEntityManagerFactory();

		// Create/Obtain session object
		EntityManager entityManager = entityManagerFactory.createEntityManager();

		// Bind the session with a Transaction
		EntityTransaction tx = entityManager.getTransaction();
		tx.begin();
		// now insert/update etc all sql queries
		entityManager.merge(customer);// save method generates insert query
		tx.commit();

	}

	public void delete(int customerId) {

		EntityManagerFactory entityManagerFactory = JPAUtil.getEntityManagerFactory();
		EntityManager entityManager = entityManagerFactory.createEntityManager();

		EntityTransaction tx = entityManager.getTransaction();
		tx.begin();
		Customer customer = (Customer) entityManager.find(Customer.class, customerId);
		entityManager.remove(customer);

		tx.commit();

	}

	public Customer fetchById(int customerId) {

		EntityManagerFactory entityManagerFactory = JPAUtil.getEntityManagerFactory();
		EntityManager entityManager = entityManagerFactory.createEntityManager();

		try {

			Customer customer = (Customer) entityManager.find(Customer.class, customerId);
			return customer;

		} finally {
			entityManager.close();
		}

	}

	public List<Customer> fetchAll() {

		EntityManagerFactory entityManagerFactory = JPAUtil.getEntityManagerFactory();
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		Query query = entityManager.createQuery("select c from Customer as c");
		try {
			return query.getResultList();
		} finally {
			entityManager.close();
		}

	}
}
