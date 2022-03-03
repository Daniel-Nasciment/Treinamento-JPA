package br.com.alura.loja.dao;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;

import br.com.alura.loja.entity.Pedido;
import br.com.alura.loja.vo.RelatorioVendasVO;

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

	public List<RelatorioVendasVO> relatorioVendas() {

		String jpql = "SELECT new br.com.alura.loja.vo.RelatorioVendasVO(prod.nome, SUM(itens.quantidade), MAX(ped.data)) "
				+ "FROM Pedido ped " 
				+ "JOIN ItemPedido itens on itens.pedido.id = ped.id " 
				+ "JOIN  Produto prod on itens.produto.id = prod.id " 
				+ "GROUP BY prod.nome "
				+ "ORDER BY itens.quantidade";

		return em.createQuery(jpql, RelatorioVendasVO.class).getResultList();

	}

}
