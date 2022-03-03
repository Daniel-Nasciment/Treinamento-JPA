package br.com.alura.loja.entity;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "categorias")
public class Categoria {

	// PARA REPRESENTAR UMA CHAVE COMPOSTA
	@EmbeddedId 
	private CategoriaId id;

	// CONSTRUTOR PADRÃO É NECESSÁRIO PARA USO DA JPA
	@Deprecated
	public Categoria() {

	}

	public Categoria (String nome, String tipo) {
		this.id = new CategoriaId(nome, tipo);
	}

	public String getNome() {
		return this.id.getNome();
	}

	
	
}
