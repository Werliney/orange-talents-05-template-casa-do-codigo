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

import com.example.orangeTalents.casadocodigo.controller.form.EstadoForm;
import com.example.orangeTalents.casadocodigo.controller.validation.ProibeNomeDuploDeEstadoParaMesmoPais;
import com.example.orangeTalents.casadocodigo.model.Estado;
import com.example.orangeTalents.casadocodigo.repository.EstadoRepository;
import com.example.orangeTalents.casadocodigo.repository.PaisRepository;

@RestController
@RequestMapping("/estado")
public class EstadoController {

	@Autowired
	private EstadoRepository estadoRepository;

	@Autowired
	private PaisRepository paisRepository;

	@Autowired
	ProibeNomeDuploDeEstadoParaMesmoPais proibeNomeDuploDeEstadoParaMesmoPais;

	@InitBinder
	public void init(WebDataBinder binder) {
		binder.addValidators(proibeNomeDuploDeEstadoParaMesmoPais);
	}

	@PostMapping
	public ResponseEntity<?> cadastrarEstado(@RequestBody @Valid EstadoForm form) {
		Estado estado = form.converter(paisRepository);
		estadoRepository.save(estado);
		
		return ResponseEntity.ok().build();
	}
}
