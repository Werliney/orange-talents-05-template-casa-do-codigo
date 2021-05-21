package com.example.orangeTalents.casadocodigo.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.orangeTalents.casadocodigo.controller.form.PaisForm;
import com.example.orangeTalents.casadocodigo.model.Pais;
import com.example.orangeTalents.casadocodigo.repository.PaisRepository;

@RestController
@RequestMapping("/pais")
public class PaisController {
	
	@Autowired
	private PaisRepository paisRepository;
	
	@PostMapping
	public ResponseEntity<?> cadastraPais(@RequestBody @Valid PaisForm form) {
		Pais pais = form.converter();
		
		paisRepository.save(pais);
		
		return ResponseEntity.ok().build();
	}
}
