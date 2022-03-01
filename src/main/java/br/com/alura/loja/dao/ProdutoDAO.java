package br.com.alura.loja.dao;

import java.math.BigDecimal;
import java.util.List;

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

	public Produto buscaPorId(Long id) {
		return em.find(Produto.class, id);
	}

	public List<Produto> buscaTodos() {
		// DEVO COLOCAR O NOME DA CLASSE, NÃO O NOME DA TABELA
		String jpql = "select p from Produto p";
		return em.createQuery(jpql, Produto.class).getResultList();
	}

	public List<Produto> buscaPorNome(String nome) {
		String jpql = "select p from Produto p where p.nome = :nome";
		return em.createQuery(jpql, Produto.class).setParameter("nome", nome).getResultList();
	}

	public List<Produto> buscaPorNomeCategoria(String nome) {
		String jpql = "select p from Produto p where p.categoria.nome = :nome";
		return em.createQuery(jpql, Produto.class).setParameter("nome", nome).getResultList();
	}

	public BigDecimal buscaPrecoPeloNome(String nome) {
		String jpql = "select p.preco from Produto p where p.nome = :nome";
		return em.createQuery(jpql, BigDecimal.class).setParameter("nome", nome).getSingleResult();
	}

	public Produto buscarPorIdCarregandoCliente(Long id) {

		// COMO O RELACIONAMENTO COM CLIENTE FOI ALTERADO PARA CARREGAMENTO LAZI
		// PARA PREVINIR EXCEPTION CASO O ENTITY MANAGER ESTEJA FECHADO
		// É BOA PRATICA UTILIZAR QUERYS PLANEJADAS COM JOIN FETCH
		String jpql = "SELECT p FROM Produto p JOIN FETCH p.categoria WHERE p.id = :id";
		return em.createQuery(jpql, Produto.class).setParameter("id", id).getSingleResult();
	}

}
