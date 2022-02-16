package br.com.alura.loja.testes;

import java.math.BigDecimal;

import javax.persistence.EntityManager;

import br.com.alura.loja.dao.ProdutoDAO;
import br.com.alura.loja.entity.Produto;
import br.com.alura.loja.util.JPAutil;

public class TestaCadastroProduto {

	public static void main(String[] args) {

		Produto iPhone = new Produto();

		iPhone.setNome("iPhone XR");
		iPhone.setDescricao("64GB preto");
		iPhone.setPreco(new BigDecimal("1300"));

		EntityManager em = JPAutil.getEntityManager();

		ProdutoDAO dao = new ProdutoDAO(em);
		em.getTransaction().begin();

		dao.salvar(iPhone);

		em.getTransaction().commit();
		em.close();

	}

}
