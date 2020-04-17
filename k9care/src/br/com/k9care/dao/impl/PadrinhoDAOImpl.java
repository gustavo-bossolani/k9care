package br.com.k9care.dao.impl;

import javax.persistence.EntityManager;

import br.com.k9care.dao.PadrinhoDAO;
import br.com.k9care.entity.Padrinho;

public class PadrinhoDAOImpl extends GenericDAOImpl<Padrinho, String> implements PadrinhoDAO {

	public PadrinhoDAOImpl(EntityManager em) {
		super(em);
	}
}
