package br.ce.hscastro.util;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


@ApplicationScoped
public class JPAUtil {
	
	private static EntityManagerFactory factory;

	static {
		factory = Persistence.createEntityManagerFactory("livrariaPU");
	}

	@Produces
	@RequestScoped
	public static EntityManager getEntityManager() {
		return factory.createEntityManager();
	}

}
