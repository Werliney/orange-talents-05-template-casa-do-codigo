package com.example.orangeTalents.casadocodigo.controller.form;


import java.util.Optional;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.example.orangeTalents.casadocodigo.controller.annotations.CPFOrCNPJ;
import com.example.orangeTalents.casadocodigo.controller.annotations.UniqueValue;
import com.example.orangeTalents.casadocodigo.model.Cliente;
import com.example.orangeTalents.casadocodigo.model.Estado;
import com.example.orangeTalents.casadocodigo.model.Pais;
import com.example.orangeTalents.casadocodigo.repository.EstadoRepository;
import com.example.orangeTalents.casadocodigo.repository.PaisRepository;

public class ClienteForm {

	@NotBlank
	@Email
	@UniqueValue(domainClass = Cliente.class, fieldName = "email")
	private String email;
	@NotBlank
	private String nome;
	@NotBlank
	private String sobrenome;
	@NotBlank
	@CPFOrCNPJ
	@UniqueValue(domainClass = Cliente.class, fieldName = "documento")
	private String documento;
	@NotBlank
	private String endereco;
	@NotBlank
	private String complemento;
	@NotBlank
	private String cidade;
	@NotBlank
	private String telefone;
	@NotBlank
	private String cep;
	@NotNull
	private Long id_pais;
	private Long id_estado;

	public String getEmail() {
		return email;
	}

	public String getNome() {
		return nome;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public String getDocumento() {
		return documento;
	}

	public String getEndereco() {
		return endereco;
	}

	public String getComplemento() {
		return complemento;
	}

	public String getCidade() {
		return cidade;
	}

	public String getTelefone() {
		return telefone;
	}

	public String getCep() {
		return cep;
	}

	public Long getId_pais() {
		return id_pais;
	}

	public Long getId_estado() {
		return id_estado;
	}
	
	public Cliente converter(PaisRepository paisRepository, EstadoRepository estadoRepository) {
		Optional<Pais> pais = paisRepository.findById(this.id_pais);
		Optional<Estado> estado = estadoRepository.findById(this.id_estado);
		
		return new Cliente(email, nome, sobrenome, documento, endereco, complemento, cidade, telefone, cep, pais.get(), estado.get());
	}

}
