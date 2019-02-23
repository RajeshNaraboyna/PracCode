package com.criteria;

import java.util.function.Consumer;
import javax.persistence.EntityManager;
import com.criteria.Supplier;;

public class QueryTest {
	private void doWithEntityManager(Consumer<EntityManager> command) {
		EntityManager em = JPASessionUtil.getEntityManager("chapter10");
		em.getTransaction().begin();

		command.accept(em);
		if (em.getTransaction().isActive() && !em.getTransaction().getRollbackOnly()) {
			em.getTransaction().commit();
		} else {
			em.getTransaction().rollback();
		}

		em.close();
	}

	public void populateData() {
		doWithEntityManager((em) -> {
			Supplier supplier = new Supplier("Hardware, Inc.");
			supplier.getProducts().add(new Product(supplier, "Optical Wheel Mouse", "Mouse", 5.00));
			supplier.getProducts().add(new Product(supplier, "Trackball Mouse", "Mouse", 22.00));
			em.persist(supplier);

			supplier = new Supplier("Hardware Are We");
			supplier.getProducts().add(new Software(supplier, "SuperDetect", "Antivirus", 14.95, "1.0"));
			supplier.getProducts().add(new Software(supplier, "Wildcat", "Browser", 19.95, "2.2"));
			supplier.getProducts().add(new Product(supplier, "AxeGrinder", "Gaming Mouse", 42.00));
			supplier.getProducts().add(new Product(supplier, "I5 Tablet", "Computer", 849.99));
			supplier.getProducts().add(new Product(supplier, "I7 Desktop", "Computer", 1599.99));
			em.persist(supplier);
		});
	}

}