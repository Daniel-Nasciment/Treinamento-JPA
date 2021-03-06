package br.com.alura.loja.dao;

import javax.persistence.EntityManager;

import br.com.alura.loja.entity.Categoria;
import br.com.alura.loja.entity.CategoriaId;

public class CategoriaDAO {

	private EntityManager em;

	public CategoriaDAO(EntityManager em) {
		this.em = em;
	}

	public void salvar(Categoria categoria) {

		this.em.persist(categoria);

	}

	public Categoria buscaComChaveComposta(String nome, String tipo) {

		return em.find(Categoria.class, new CategoriaId(nome, tipo));
	}

}
