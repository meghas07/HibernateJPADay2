package com.zycus.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import com.zycus.entity.Customer;
import com.zycus.util.JPAUtil;

public class GenericDao {

	public <T> void add(T myObject) {
		EntityManagerFactory entityManagerFactory = JPAUtil.getEntityManagerFactory();
		EntityManager entityManager = entityManagerFactory.createEntityManager();

		EntityTransaction tx = entityManager.getTransaction();
		tx.begin();
		entityManager.persist(myObject);
		//System.out.println(myObject);
		tx.commit();
	}

	public <T> T fetchById(Class<T> className, Object id) {

		EntityManagerFactory entityManagerFactory = JPAUtil.getEntityManagerFactory();
		EntityManager entityManager = entityManagerFactory.createEntityManager();

		try {

			T myGenericObject = entityManager.find(className, id);
			return myGenericObject;

		} finally {
			entityManager.close();
		}

	}

	public <T> void update(T myGenericObject) {

		
		EntityManagerFactory entityManagerFactory = JPAUtil.getEntityManagerFactory();
		EntityManager entityManager = entityManagerFactory.createEntityManager();

		
		EntityTransaction tx = entityManager.getTransaction();
		tx.begin();
	
		entityManager.merge(myGenericObject);
		System.out.println(myGenericObject);
		tx.commit();

	}
	public <T> void delete(Class<T> className,Object id) {

		EntityManagerFactory entityManagerFactory = JPAUtil.getEntityManagerFactory();
		EntityManager entityManager = entityManagerFactory.createEntityManager();

		EntityTransaction tx = entityManager.getTransaction();
		tx.begin();
		T t = entityManager.find(className, id);
		entityManager.remove(t);
		tx.commit();

	}
	
	public <T> List<T> fetchAll(Class<T> className) {

		EntityManagerFactory entityManagerFactory = JPAUtil.getEntityManagerFactory();
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		Query query = entityManager.createQuery("select t from "+className.getName()+" as t");
		try {
			return query.getResultList();
		} finally {
			entityManager.close();
		}

	}


}
