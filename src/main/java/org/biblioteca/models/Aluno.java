package org.biblioteca.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.validator.constraints.NotBlank;

@Entity
public class Aluno {
	
	@Id
	@GeneratedValue
	private Integer id;
	
	@NotBlank(message = "Nome é obrigatório")
	private String Nome;
	
	@NotBlank(message = "RA é obrigatório")
	private String registroAcademico;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return Nome;
	}

	public void setNome(String nome) {
		Nome = nome;
	}
	
	public String getRegistroAcademico() {
		return registroAcademico;
	}

	public void setRegistroAcademico(String registroAcademico) {
		this.registroAcademico = registroAcademico;
	}

	@Override
	public String toString() {
		return "Aluno [id=" + id + ", Nome=" + Nome + ", registroAcademico=" + registroAcademico + "]";
	}	
}
