package br.com.k9care.dao;

import br.com.k9care.exception.CommitException;
import br.com.k9care.exception.KeyNotFoundException;

public interface GenericDAO<T,K> {

	void inserir(T entidade);

	void atualizar(T entidade);

	T pesquisar(K id);

	void remover(K id) throws KeyNotFoundException;

	void commit() throws CommitException;
}
