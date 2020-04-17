package br.com.k9care.dao.impl;

import java.lang.reflect.ParameterizedType;

import javax.persistence.EntityManager;

import br.com.k9care.dao.GenericDAO;
import br.com.k9care.exception.CommitException;
import br.com.k9care.exception.KeyNotFoundException;

public class GenericDAOImpl<T,K> implements GenericDAO<T, K> {


	EntityManager em;
	private Class<T> clazz;

	@SuppressWarnings("all")
	public GenericDAOImpl(EntityManager em) {
		this.em = em;

		this.clazz = (Class<T>) ((ParameterizedType) 
				getClass().getGenericSuperclass())
				.getActualTypeArguments()[0];
	}


	@Override
	public void inserir(T entidade) {
		em.persist(entidade);
	}

	@Override
	public void atualizar(T entidade) {
		em.merge(entidade);
	}

	@Override
	public T pesquisar(K id) {
		return em.find(clazz, id);
	}

	@Override
	public void remover(K id) throws KeyNotFoundException {
		T entidade = pesquisar(id);
		if(entidade != null) {
			em.remove(id);
			return;
		}
		throw new KeyNotFoundException();
	}

	@Override
	public void commit() throws CommitException {
		try {
			em.getTransaction().begin();
			em.getTransaction().commit();
		}catch(Exception e) {
			e.printStackTrace();
			em.getTransaction().rollback();
			throw new CommitException();
		}
	}

}
