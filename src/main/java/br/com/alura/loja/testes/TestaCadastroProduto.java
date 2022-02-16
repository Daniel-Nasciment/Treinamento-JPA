package br.com.alura.loja.testes;

import java.math.BigDecimal;

import javax.persistence.EntityManager;

import br.com.alura.loja.dao.CategoriaDAO;
import br.com.alura.loja.dao.ProdutoDAO;
import br.com.alura.loja.entity.Categoria;
import br.com.alura.loja.entity.Produto;
import br.com.alura.loja.util.JPAutil;

public class TestaCadastroProduto {

	public static void main(String[] args) {

		// ESTADOS DA ENTIDADE
		// NEW -> TRANSIENT - AINDA NÃO FOI PERSISTIDO E A JPA DESCONHECE ESSA ENTIDADE
		// PERSIST -> MANAGED - A JPA ESTÁ OBSERVANDO AQUELA ENTIDADE
		// CLOSE -> DETACHED - JPA IGONORA
		// PARA RETORNAR DO DETACHED É NECESSÁRIO USAR O EntityManager.merge() PORÉM ELE RETORNA UMA REFERENCIA QUE NO CASO VAI ESTAR NO MANAGED
		
		Categoria celulares = new Categoria("Celulares");
		Produto iPhone = new Produto("iPhone XS", "64GB preto", new BigDecimal("1400"), celulares);


		EntityManager em = JPAutil.getEntityManager();

		ProdutoDAO prodDao = new ProdutoDAO(em);
		CategoriaDAO catDao = new CategoriaDAO(em);
		em.getTransaction().begin();

		catDao.salvar(celulares);
		prodDao.salvar(iPhone);

		// EXISTE O MÉTODO FLUSH QUE SINCRONIZA A ENTIDADE COM A BASE DE DADOS SEM COMMITAR A TRANSAÇÃO
		em.getTransaction().commit();
		em.close();

	}

}
