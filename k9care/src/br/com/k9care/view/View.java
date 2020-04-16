package br.com.k9care.view;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import br.com.k9care.entity.Animal;
import br.com.k9care.enums.Especie;
import br.com.k9care.singleton.EntityManagerFactorySingleton;

public class View {

	public static void main(String[] args) {
		EntityManagerFactory factory = EntityManagerFactorySingleton.getInstance();
		EntityManager em = factory.createEntityManager();
		
//		Pedigree pedigree = new Pedigree("Spyke","Indefinido", Sexo.MASCULINO, "Branco", new GregorianCalendar(),
//				new GregorianCalendar(2018, Calendar.JANUARY, 15));
//		
//		Animal mel = new Animal(Especie.CACHORRO,pedigree);
//		em.persist(mel);
		
		
		Animal animal = em.find(Animal.class, 4);
		animal.setEspecie(Especie.CACHORRO);
		animal.getPedigree().setCor("Preto");
		
		em.merge(animal);
		
		em.getTransaction().begin();
		em.getTransaction().commit();
		em.close();

	}

}
