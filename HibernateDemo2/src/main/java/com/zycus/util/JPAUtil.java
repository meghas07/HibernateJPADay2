package com.zycus.util;

import javax.persistence.*;

public class JPAUtil {
	private static final EntityManagerFactory EntityManagerFactory = buildEntityManagerFactory();

	private static EntityManagerFactory buildEntityManagerFactory() {
		try {
			// Create the EntityManagerFactory from META-INF/persistence.xml
			return Persistence.createEntityManagerFactory("persistence-test");
		} catch (Throwable ex) {
			// Make sure you log the exception, as it might be swallowed
			System.err.println("Initial EntityManagerFactory creation failed." + ex);
			throw new ExceptionInInitializerError(ex);
		}
	}

	public static EntityManagerFactory getEntityManagerFactory() {
		return EntityManagerFactory;
	}

}
