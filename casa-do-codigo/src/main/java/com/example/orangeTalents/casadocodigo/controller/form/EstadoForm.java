package com.example.orangeTalents.casadocodigo.controller.form;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.example.orangeTalents.casadocodigo.model.Estado;
import com.example.orangeTalents.casadocodigo.model.Pais;
import com.example.orangeTalents.casadocodigo.repository.PaisRepository;

public class EstadoForm {

	@NotBlank
	private String nome;
	@NotNull
	private Long id_pais;

	public String getNome() {
		return nome;
	}

	public Long getId_pais() {
		return id_pais;
	}

	public Estado converter(PaisRepository paisRepository) {
		Pais pais = paisRepository.findById(id_pais).get();
		
		return new Estado(nome, pais);
	}

}
