package br.com.alura.loja.testes;

import javax.persistence.EntityManager;

import br.com.alura.loja.dao.ClienteDAO;
import br.com.alura.loja.entity.Cliente;
import br.com.alura.loja.util.JPAutil;

public class TesteClientes {

	public static void main(String[] args) {

		EntityManager em = JPAutil.getEntityManager();
		
		ClienteDAO dao = new ClienteDAO(em);
		
		Cliente cliente = dao.buscarPorId(1L);
		
		System.out.println(cliente.getNome());
		
	}

}
