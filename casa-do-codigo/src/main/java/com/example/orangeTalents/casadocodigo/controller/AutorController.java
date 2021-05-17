package com.example.orangeTalents.casadocodigo.controller;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.orangeTalents.casadocodigo.controller.form.AutorForm;
import com.example.orangeTalents.casadocodigo.model.Autor;
import com.example.orangeTalents.casadocodigo.repository.AutorRepository;

@RestController
@RequestMapping("/autores")
public class AutorController {
	
	@Autowired
	private AutorRepository autorRepository;
	
	@PostMapping
	public ResponseEntity<Autor> cadastrarAutor(@RequestBody @Valid AutorForm form) {
		
		Optional<Autor> autor2 = autorRepository.findByEmail(form.getEmail());
		
		if(autor2.isPresent()) {
			return ResponseEntity.badRequest().build();
		} 
		
		Autor autor = form.converter(form);
		autorRepository.save(autor);
		
		
		return ResponseEntity.ok(autor);
	}
}
