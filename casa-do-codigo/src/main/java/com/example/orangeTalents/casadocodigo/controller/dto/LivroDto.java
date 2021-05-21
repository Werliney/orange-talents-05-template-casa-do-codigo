package com.example.orangeTalents.casadocodigo.controller.dto;

import java.util.List;
import java.util.stream.Collectors;

import com.example.orangeTalents.casadocodigo.model.Livro;

public class LivroDto {

	private Long id;
	private String titulo;
	
	
	public LivroDto(Livro livro) {
		this.id = livro.getId();
		this.titulo = livro.getTitulo();
	}


	public Long getId() {
		return id;
	}

	public String getTitulo() {
		return titulo;
	}

	public static List<LivroDto> converter(List<Livro> livros) {
		return livros.stream().map(LivroDto::new).collect(Collectors.toList());
	}
}
