package com.example.orangeTalents.casadocodigo.controller.form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.example.orangeTalents.casadocodigo.controller.annotations.UniqueValue;
import com.example.orangeTalents.casadocodigo.model.Categoria;

public class CategoriaForm {

	@NotNull
	@NotEmpty
	@UniqueValue(domainClass = Categoria.class, fieldName = "nome")
	private String nome;

	public String getNome() {
		return nome;
	}

	public Categoria converter() {

		return new Categoria(this.nome);
	}
}
