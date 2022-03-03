package br.com.alura.loja.testes;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;

import br.com.alura.loja.dao.CategoriaDAO;
import br.com.alura.loja.dao.ProdutoDAO;
import br.com.alura.loja.entity.Categoria;
import br.com.alura.loja.entity.Produto;
import br.com.alura.loja.util.JPAutil;

public class TestaCadastroProduto {

	public static void main(String[] args) {

		EntityManager em = JPAutil.getEntityManager();
		
		ProdutoDAO prodDao = new ProdutoDAO(em);
		
		//Produto produto = prodDao.buscaPorId(3l);
		
		//List<Produto> produtos = prodDao.buscaTodos();
		
		//List<Produto> produtos = prodDao.buscaPorNomeCategoria("CELULARES");
		
		List<Produto> produtos = prodDao.buscaPorNome("iPhone XS");
		
		BigDecimal preco = prodDao.buscaPrecoPeloNome("iPhone XS");
		
		System.out.println(preco);
		
		produtos.forEach(p -> System.out.println(p));
		

	}

	public void cadastraProduto(EntityManager em) {
		Categoria videoGame = new Categoria("Video Games", "GAMES");
		Produto ps5 = new Produto("ps5", "1TB", new BigDecimal("5000"), videoGame);

		ProdutoDAO prodDao = new ProdutoDAO(em);
		CategoriaDAO catDao = new CategoriaDAO(em);
		em.getTransaction().begin();

		catDao.salvar(videoGame);
		prodDao.salvar(ps5);

		// EXISTE O MÉTODO FLUSH QUE SINCRONIZA A ENTIDADE COM A BASE DE DADOS SEM
		// COMMITAR A TRANSAÇÃO
		em.getTransaction().commit();
		em.close();
	}

}
