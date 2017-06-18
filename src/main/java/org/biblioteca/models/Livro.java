package org.biblioteca.models;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Livro {
	
	@Id
	@GeneratedValue
	private Integer id;
	
	@NotBlank(message = "Título é obrigatório")
	private String titulo;
		
	@Lob
	@NotBlank(message = "Descrição é obrigatório")
	@Size(max = 200, message = "A descrição não pode ter mais que 200 caracteres")
	private String descricao;
	
	@ManyToOne
	@NotNull(message = "Autor é obrigatório")
	private Autor autor;
	
	@Temporal(TemporalType.TIMESTAMP)
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@NotNull(message = "Data de lançamento é obrigatório")
	private Date dataLancamento;
	
	private String capa;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public Autor getAutor() {
		return autor;
	}
	
	public Integer getAutor1() {
		return autor.getId();
	}

	public void setAutor(Autor autor) {
		this.autor = autor;
	}
	
	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public Date getDataLancamento() {
		return dataLancamento;
	}

	public void setDataLancamento(Date dataLancamento) {
		this.dataLancamento = dataLancamento;
	}

	public String getCapa() {
		return capa;
	}

	public void setCapa(String capa) {
		this.capa = capa;
	}

	@Override
	public String toString() {
		return "Livro [id=" + id + ", titulo=" + titulo + ", capa=" + capa + ", descricao=" + descricao + ", autor="
				+ autor + ", dataLancamento=" + dataLancamento + "]";
	}

}
