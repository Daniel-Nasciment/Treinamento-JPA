package br.com.alura.loja.testes;

import java.math.BigDecimal;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.alura.loja.entity.Produto;

public class TestaCadastroProduto {

	public static void main(String[] args) {

		Produto iPhone = new Produto();

		iPhone.setNome("iPhone 12 PRO MAX");
		iPhone.setDescricao("Muito legal");
		iPhone.setPreco(new BigDecimal("10.000"));

		// "loja" É O NAME DO PERSISTENCE-UNI NO XML
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("loja");

		EntityManager em = factory.createEntityManager();
		
		// COMO O TRANSACTION TIPE É RESOURCE_LOCAL EU PRECISO CONTROLAR AS TRANSAÇÕES, ABRINDO, COMMITANDO E FECHANDO.
		em.getTransaction().begin();
		em.persist(iPhone);
		em.getTransaction().commit();
		em.close();

	}

}
