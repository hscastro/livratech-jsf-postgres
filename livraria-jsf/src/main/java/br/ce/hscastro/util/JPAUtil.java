package br.ce.hscastro.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public class JPAUtil {
	
	private static EntityManagerFactory factory;

	static {
		factory = Persistence.createEntityManagerFactory("livrariaPU");
	}


	public static EntityManager getEntityManager() {
		return factory.createEntityManager();
	}

}
