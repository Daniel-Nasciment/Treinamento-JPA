package br.com.alura.loja.testes;

import javax.persistence.EntityManager;

import br.com.alura.loja.dao.ProdutoDAO;
import br.com.alura.loja.entity.Produto;
import br.com.alura.loja.util.JPAutil;

public class TesteJoinFetch {

	public static void main(String[] args) {

		EntityManager em = JPAutil.getEntityManager();

		ProdutoDAO dao = new ProdutoDAO(em);


		Produto prod = dao.buscarPorIdCarregandoCliente(6L);

		em.close();

		System.out.println(prod.getCategoria().getNome());


	}
	
}
