package org.biblioteca.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.validator.constraints.NotBlank;

@Entity
public class Autor {
	
	@Id
	@GeneratedValue
	private Integer id;
	
	@NotBlank(message = "Nome é obrigatório")
	private String nome;
	
	@OneToMany(mappedBy="autor")
	private List<Livro> livros = new ArrayList<Livro>();

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public List<Livro> getLivros() {
		return livros;
	}

	public void setLivros(List<Livro> livros) {
		this.livros = livros;
	}

	@Override
	public String toString() {
		return "Autor [id=" + id + ", nome=" + nome + ", livros=" + livros + "]";
	}

}