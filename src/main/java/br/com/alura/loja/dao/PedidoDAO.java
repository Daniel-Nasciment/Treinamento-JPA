package br.com.alura.loja.dao;

import java.math.BigDecimal;

import javax.persistence.EntityManager;

import br.com.alura.loja.entity.Pedido;

public class PedidoDAO {

	private EntityManager em;

	public PedidoDAO(EntityManager em) {
		this.em = em;
	}

	public void salvar(Pedido pedido) {

		this.em.persist(pedido);

	}

	public BigDecimal somaTotalVendido() {

		String jpql = "SELECT SUM(p.valorTotal) FROM Pedido p";

		return em.createQuery(jpql, BigDecimal.class).getSingleResult();
	}
}
