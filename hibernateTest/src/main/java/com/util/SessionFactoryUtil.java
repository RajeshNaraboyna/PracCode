package com.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public final class SessionFactoryUtil {

	private static SessionFactory sessionFactory;

	static {
		StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
		sessionFactory = new MetadataSources(registry).getMetadataBuilder().build().buildSessionFactory();
	}

	private SessionFactoryUtil() {

	}

	public static final Session getSession() {
		return sessionFactory.openSession();
	}

}
