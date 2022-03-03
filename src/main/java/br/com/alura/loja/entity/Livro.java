package br.com.alura.loja.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "livros")
public class Livro extends Produto implements Serializable {
	private static final long serialVersionUID = 1L;

	private String autor;
	private String titulo;

	@Deprecated
	public Livro() {
	}

	public Livro(String autor, String titulo) {
		this.autor = autor;
		this.titulo = titulo;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

}
