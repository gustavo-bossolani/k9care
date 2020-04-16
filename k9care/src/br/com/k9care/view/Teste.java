package br.com.k9care.view;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Teste {

	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("postgres");
		EntityManager em = factory.createEntityManager();
		em.getTransaction().begin();
		em.getTransaction().commit();
		em.close();
	}

}
