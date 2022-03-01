package br.com.alura.loja.vo;

import java.time.LocalDate;

// VO -> VALUE OBJETCT
public class RelatorioVendasVO {

	private String nomeProduto;

	// A FUNÇÃO MAX RETORNA UM LONG
	private Long quantidadeVendida;

	private LocalDate ultimaVenda;

	public RelatorioVendasVO(String nomeProduto, Long quantidadeVendida, LocalDate ultimaVenda) {
		this.nomeProduto = nomeProduto;
		this.quantidadeVendida = quantidadeVendida;
		this.ultimaVenda = ultimaVenda;
	}

	@Override
	public String toString() {
		return "RelatorioVendasVO [nomeProduto=" + nomeProduto + ", quantidadeVendida=" + quantidadeVendida
				+ ", ultimaVenda=" + ultimaVenda + "]";
	}

	public String getNomeProduto() {
		return nomeProduto;
	}

	public Long getQuantidadeVendida() {
		return quantidadeVendida;
	}

	public LocalDate getUltimaVenda() {
		return ultimaVenda;
	}

}
