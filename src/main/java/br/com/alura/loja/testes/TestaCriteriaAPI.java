package br.com.alura.loja.testes;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.alura.loja.dao.ProdutoDAO;
import br.com.alura.loja.entity.Produto;
import br.com.alura.loja.util.JPAutil;

public class TestaCriteriaAPI {

	public static void main(String[] args) {

		EntityManager em = JPAutil.getEntityManager();
		
		
		ProdutoDAO dao = new ProdutoDAO(em);
		
		List<Produto> produtos = dao.buscaPorParametrosComCriteria("iPhone XS", null, null);
		
		produtos.forEach(p -> System.out.println(p));
		
	}

}
