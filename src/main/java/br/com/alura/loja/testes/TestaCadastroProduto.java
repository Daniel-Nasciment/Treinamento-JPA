package br.com.alura.loja.testes;

import java.math.BigDecimal;

import javax.persistence.EntityManager;

import br.com.alura.loja.dao.ProdutoDAO;
import br.com.alura.loja.entity.Produto;
import br.com.alura.loja.enums.Categoria;
import br.com.alura.loja.util.JPAutil;

public class TestaCadastroProduto {

	public static void main(String[] args) {

		Produto iPhone = new Produto("iPhone XS", "64GB preto", new BigDecimal("1300"), Categoria.CELULARES);

		EntityManager em = JPAutil.getEntityManager();

		ProdutoDAO dao = new ProdutoDAO(em);
		em.getTransaction().begin();

		dao.salvar(iPhone);

		em.getTransaction().commit();
		em.close();

	}

}
