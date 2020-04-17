package br.com.k9care.dao.impl;

import javax.persistence.EntityManager;

import br.com.k9care.dao.AdocaoDAO;
import br.com.k9care.entity.Adocao;

public class AdocaoDAOImpl extends GenericDAOImpl<Adocao, Integer> implements AdocaoDAO{

	public AdocaoDAOImpl(EntityManager em) {
		super(em);
	}
}
