package com.example.orangeTalents.casadocodigo.controller.dto;

import com.example.orangeTalents.casadocodigo.model.Cliente;

public class ClienteDto {

	private Long id;

	public ClienteDto(Cliente cliente) {
		this.id = cliente.getId();
	}

	public Long getId() {
		return id;
	}

}
