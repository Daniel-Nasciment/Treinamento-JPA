package br.com.alura.loja.testes;

import java.math.BigDecimal;

import br.com.alura.loja.dao.PedidoDAO;
import br.com.alura.loja.util.JPAutil;

public class TestaConsultaFuncaoAgregacao {

	public static void main(String[] args) {

		PedidoDAO pedidoDao = new PedidoDAO(JPAutil.getEntityManager());
		
		BigDecimal totalVendido = pedidoDao.somaTotalVendido();
		
		
		System.out.println("VALOR TOTAL: " + totalVendido);
		
	}

}
