package br.com.alura.loja.testes;

import javax.persistence.EntityManager;

import br.com.alura.loja.dao.CategoriaDAO;
import br.com.alura.loja.entity.Categoria;
import br.com.alura.loja.util.JPAutil;

public class TestaCategoria {

	public static void main(String[] args) {


		EntityManager em = JPAutil.getEntityManager();

		CategoriaDAO dao = new CategoriaDAO(em);


		Categoria chaveComposta = dao.buscaComChaveComposta("Celulares", "Aparelhos");
		
		System.out.println(chaveComposta.getNome());
		
	}

}
