package com.example.orangeTalents.casadocodigo.controller.form;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import com.example.orangeTalents.casadocodigo.model.Autor;

public class AutorForm {

	@NotNull
	@NotEmpty
	private String nome;
	@NotNull
	@NotEmpty
	@Email
	private String email;
	@NotNull
	@NotEmpty
	@Length(max = 400)
	private String descricao;

	public String getNome() {
		return nome;
	}

	public String getEmail() {
		return email;
	}

	public String getDescricao() {
		return descricao;
	}
	
	public Autor converter(AutorForm form) {
		
		return new Autor(nome, email, descricao);
	}

}
