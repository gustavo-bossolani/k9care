package br.com.k9care.view;

import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import br.com.k9care.dao.AdocaoDAO;
import br.com.k9care.dao.impl.AdocaoDAOImpl;
import br.com.k9care.entity.Adocao;
import br.com.k9care.entity.Animal;
import br.com.k9care.entity.Padrinho;
import br.com.k9care.entity.Pedigree;
import br.com.k9care.enums.Especie;
import br.com.k9care.enums.Sexo;
import br.com.k9care.exception.CommitException;
import br.com.k9care.singleton.EntityManagerFactorySingleton;

public class View {

	public static void main(String[] args) {
		EntityManagerFactory factory = EntityManagerFactorySingleton.getInstance();
		EntityManager em = factory.createEntityManager();

		Pedigree pedigree = new Pedigree("Mel","Cocker", Sexo.FEMININO, 
				"Bege",new GregorianCalendar(2011, Calendar.JULY, 14));

		Animal mel = new Animal(Especie.CACHORRO,pedigree);
		mel.setPedigree(pedigree);


		Padrinho gustavo = new Padrinho
				("12345678910", "Gustavo Bossolani", "551112345678", Sexo.MASCULINO);

		Adocao adocao = new Adocao(gustavo);
		adocao.adotar(mel);
		
		AdocaoDAO dao = new AdocaoDAOImpl(em);
		dao.inserir(adocao);
		
		try {
			dao.commit();
		} catch (CommitException e) {
			e.printStackTrace();
		}
	}
}
