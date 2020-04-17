package br.com.k9care.dao.impl;

import javax.persistence.EntityManager;

import br.com.k9care.dao.PedigreeDAO;
import br.com.k9care.entity.Pedigree;

public class PedigreeDAOImpl extends GenericDAOImpl<Pedigree, Integer> implements PedigreeDAO {

	public PedigreeDAOImpl(EntityManager em) {
		super(em);
	}
}
