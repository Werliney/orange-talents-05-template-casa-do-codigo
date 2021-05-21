package com.example.orangeTalents.casadocodigo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;

@Entity
public class Estado {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotBlank
	private String nome;
	
	@ManyToOne
	private Pais pais;

	public Estado() {
		super();
	}
	

	public Estado(@NotBlank String nome, Pais pais) {
		super();
		this.nome = nome;
		this.pais = pais;
	}



	public Pais getPais() {
		return pais;
	}
	
	

}
