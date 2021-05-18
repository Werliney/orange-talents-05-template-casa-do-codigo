package com.example.orangeTalents.casadocodigo.controller.form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.example.orangeTalents.casadocodigo.model.Categoria;

public class CategoriaForm {

	@NotNull
	@NotEmpty
	private String nome;

	public String getNome() {
		return nome;
	}

	public Categoria converter() {

		return new Categoria(this.nome);
	}
}
