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

import com.example.orangeTalents.casadocodigo.controller.form.CategoriaForm;
import com.example.orangeTalents.casadocodigo.controller.validation.ProibeNomeDuplicadoDeCategoriaValidator;
import com.example.orangeTalents.casadocodigo.model.Categoria;
import com.example.orangeTalents.casadocodigo.repository.CategoriaRepository;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {
	
	@Autowired
	CategoriaRepository categoriaRepository;
	@Autowired
	private ProibeNomeDuplicadoDeCategoriaValidator proibeNomeDuplicadoDeCategoriaValidator;
	
	@InitBinder
	public void init(WebDataBinder binder) {
		binder.addValidators(proibeNomeDuplicadoDeCategoriaValidator);
	}
	
	@PostMapping
	public ResponseEntity<Categoria> cadastrarCategoria(@RequestBody @Valid CategoriaForm form) {
		Categoria categoria = form.converter();
		categoriaRepository.save(categoria);
		
		return ResponseEntity.ok().build();
	}
}
