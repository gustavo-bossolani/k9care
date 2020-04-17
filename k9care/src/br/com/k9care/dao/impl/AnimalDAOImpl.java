package br.com.k9care.dao.impl;

import javax.persistence.EntityManager;

import br.com.k9care.dao.AnimalDAO;
import br.com.k9care.entity.Animal;

public class AnimalDAOImpl extends GenericDAOImpl<Animal, Integer> implements AnimalDAO{

	public AnimalDAOImpl(EntityManager em) {
		super(em);
	}
}
