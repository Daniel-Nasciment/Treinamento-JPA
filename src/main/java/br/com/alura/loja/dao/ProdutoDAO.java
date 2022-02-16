package br.com.alura.loja.dao;

import javax.persistence.EntityManager;

import br.com.alura.loja.entity.Produto;

public class ProdutoDAO {

	private EntityManager em;

	public ProdutoDAO(EntityManager em) {
		this.em = em;
	}

	public void salvar(Produto produto) {

		this.em.persist(produto);

	}

}
