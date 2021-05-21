package com.example.orangeTalents.casadocodigo.controller.form;

import javax.validation.constraints.NotBlank;

import com.example.orangeTalents.casadocodigo.controller.annotations.UniqueValue;
import com.example.orangeTalents.casadocodigo.model.Pais;

public class PaisForm {
	
	@UniqueValue(domainClass = Pais.class, fieldName = "nome")
	@NotBlank
	private String nome;

	public String getNome() {
		return nome;
	}

	public Pais converter() {
		return new Pais(this.nome);
	}
}
