package br.com.alura.loja.testes;

import javax.persistence.EntityManager;

import br.com.alura.loja.dao.ClienteDAO;
import br.com.alura.loja.dao.PedidoDAO;
import br.com.alura.loja.dao.ProdutoDAO;
import br.com.alura.loja.entity.Cliente;
import br.com.alura.loja.entity.ItemPedido;
import br.com.alura.loja.entity.Pedido;
import br.com.alura.loja.entity.Produto;
import br.com.alura.loja.util.JPAutil;

public class TestaPedido {

	public static void main(String[] args) {
		
		EntityManager em = JPAutil.getEntityManager();
		
		ProdutoDAO prodDao = new ProdutoDAO(em);
		ClienteDAO cliDao = new ClienteDAO(em);
		PedidoDAO pedDao = new PedidoDAO(em);
		
		
		Produto produto = prodDao.buscaPorId(6L);
		Cliente cliente = new Cliente("Nicolas", "345678");
		Pedido pedido = new Pedido(cliente);
		ItemPedido item = new ItemPedido(1, pedido, produto);
		
		pedido.adicionaItem(item);
		
		em.getTransaction().begin();
		
		cliDao.salvar(cliente);
		pedDao.salvar(pedido);
		
		em.getTransaction().commit();
		
	}
	
}
