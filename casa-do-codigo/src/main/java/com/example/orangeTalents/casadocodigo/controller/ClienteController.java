package com.example.orangeTalents.casadocodigo.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.orangeTalents.casadocodigo.controller.dto.ClienteDto;
import com.example.orangeTalents.casadocodigo.controller.form.ClienteForm;
import com.example.orangeTalents.casadocodigo.controller.validation.CadastroDePaisEstadoValidator;
import com.example.orangeTalents.casadocodigo.model.Cliente;
import com.example.orangeTalents.casadocodigo.repository.ClienteRepository;
import com.example.orangeTalents.casadocodigo.repository.EstadoRepository;
import com.example.orangeTalents.casadocodigo.repository.PaisRepository;

@RestController
@RequestMapping("/clientes")
public class ClienteController {
	
	@Autowired
	private ClienteRepository clienteRepository;
	@Autowired
	private PaisRepository paisRepository;
	@Autowired
	private EstadoRepository estadoRepository;
	
	@Autowired
	private CadastroDePaisEstadoValidator cadastroDePaisEstadoValidator;
	
	@InitBinder
	public void init(WebDataBinder binder) {
		binder.addValidators(cadastroDePaisEstadoValidator);
	}
	
	@PostMapping
	public ResponseEntity<ClienteDto> cadastrarCliente(@RequestBody @Valid ClienteForm form) {
		Cliente cliente = form.converter(paisRepository, estadoRepository);
		clienteRepository.save(cliente);
		
		return ResponseEntity.ok(new ClienteDto(cliente));
	}
}
