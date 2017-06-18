package org.biblioteca.models;

import java.util.Date;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

public class LivroForm {
	
	private Integer id;
	
	@NotBlank(message = "Título é obrigatório")
	private String titulo;
	
	@NotNull(message = "Autor é obrigatório")
	private String autor;
	
	@NotBlank(message = "Descrição é obrigatório")
	@Size(max = 200, message = "A descriçnao não pode ter mais que 200 caracteres")
	private String descricao;
	
	@DateTimeFormat(iso=ISO.DATE)
	@NotNull(message = "Data de lançamento é obrigatório")
	private Date dataLancamento;
	
	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}
	
	public Date getDataLancamento() {
		return dataLancamento;
	}

	public void setDataLancamento(Date dataLancamento) {
		this.dataLancamento = dataLancamento;
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "LivroForm [titulo=" + titulo + ", autor=" + autor + ", descricao=" + descricao + ", dataLancamento="
				+ dataLancamento + "]";
	}

}
