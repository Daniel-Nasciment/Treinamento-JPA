package br.com.alura.loja.entity;

import javax.persistence.Embeddable;

@Embeddable // - ESSA CLASSE É EMBUTIVEL
public class DadosPessoais {

	private String nome;
	private String cpf;

	@Deprecated
	public DadosPessoais() {
	}

	public DadosPessoais(String nome, String cpf) {
		this.nome = nome;
		this.cpf = cpf;
	}

	public String getNome() {
		return nome;
	}

	public String getCpf() {
		return cpf;
	}

}
