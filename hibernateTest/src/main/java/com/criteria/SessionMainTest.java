package com.criteria;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import com.dcl.Message;

public class SessionMainTest {

	private static SessionFactory sessionFactory;

	public static void main(String[] args) {
		StandardServiceRegistry standardServiceRegistry = new StandardServiceRegistryBuilder().configure().build();
		sessionFactory = new MetadataSources(standardServiceRegistry).buildMetadata().buildSessionFactory();
		
		
	}

	static class MesagesDao {

		void saveEntity(Message message) {
			Session session = sessionFactory.openSession();
			session.save(message);
		}

		Message getEntity(String id) {
			Session session = sessionFactory.openSession();
			return (Message) session.get(id, Message.class);
		}

	}

}
