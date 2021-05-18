package com.example.orangeTalents.casadocodigo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
public class Categoria {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotNull
	@NotEmpty
	private String nome;

	public Categoria() {
		super();
	}

	public Categoria(@NotNull @NotEmpty String nome) {
		super();
		this.nome = nome;
	}

}
