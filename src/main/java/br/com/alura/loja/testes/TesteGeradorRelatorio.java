package br.com.alura.loja.testes;

import java.util.List;

import br.com.alura.loja.dao.PedidoDAO;
import br.com.alura.loja.util.JPAutil;
import br.com.alura.loja.vo.RelatorioVendasVO;

public class TesteGeradorRelatorio {

	public static void main(String[] args) {

		
		PedidoDAO pedidoDao = new PedidoDAO(JPAutil.getEntityManager());
		
		List<RelatorioVendasVO> relatorio = pedidoDao.relatorioVendas();
		
		relatorio.forEach(r -> System.out.println(r));
		
	}

}
