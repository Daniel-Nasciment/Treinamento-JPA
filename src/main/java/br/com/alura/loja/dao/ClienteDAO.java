package br.com.alura.loja.dao;

import javax.persistence.EntityManager;

import br.com.alura.loja.entity.Cliente;

public class ClienteDAO {

	private EntityManager em;

	public ClienteDAO(EntityManager em) {
		this.em = em;
	}

	public void salvar(Cliente cliente) {

		this.em.persist(cliente);

	}

	public Cliente buscarPorId(Long id) {

		String jpql = "SELECT c FROM Cliente c WHERE c.id = :id";

		return em.createQuery(jpql, Cliente.class).setParameter("id", id).getSingleResult();
	}

}
