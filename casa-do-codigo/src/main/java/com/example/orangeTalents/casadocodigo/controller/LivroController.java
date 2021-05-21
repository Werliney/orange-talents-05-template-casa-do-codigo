package com.example.orangeTalents.casadocodigo.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.orangeTalents.casadocodigo.controller.dto.LivroDto;
import com.example.orangeTalents.casadocodigo.controller.form.LivroForm;
import com.example.orangeTalents.casadocodigo.model.Livro;
import com.example.orangeTalents.casadocodigo.repository.AutorRepository;
import com.example.orangeTalents.casadocodigo.repository.CategoriaRepository;
import com.example.orangeTalents.casadocodigo.repository.LivroRepository;

@RestController
@RequestMapping("/livros")
public class LivroController {
	
	@Autowired
	LivroRepository livroRepository;
	@Autowired
	AutorRepository autorRepository;
	@Autowired
	CategoriaRepository categoriaRepository;
	
	
	@PostMapping
	public ResponseEntity<?> cadastrarLivro(@RequestBody @Valid LivroForm form) {
		Livro livro = form.converter(categoriaRepository, autorRepository);
	    livroRepository.save(livro);
	    
	    return ResponseEntity.ok().build();
	}
	
	@GetMapping
	public List<LivroDto> listarLivros() {
		List<Livro> livros = livroRepository.findAll();
		
		return LivroDto.converter(livros);
	
	}
}
