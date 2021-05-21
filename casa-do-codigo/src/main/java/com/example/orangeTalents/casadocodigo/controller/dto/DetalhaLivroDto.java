package com.example.orangeTalents.casadocodigo.controller.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

import com.example.orangeTalents.casadocodigo.model.Autor;
import com.example.orangeTalents.casadocodigo.model.Categoria;
import com.example.orangeTalents.casadocodigo.model.Livro;

public class DetalhaLivroDto {
	
	private String titulo;
	private String resumo;
	private String sumario;
	private BigDecimal preco_livro;
	private Integer numero_paginas;
	private String isbn;
	private LocalDate data_publicacao;
	private Autor autor;
	private Categoria categoria;
	
	public DetalhaLivroDto(Livro livro) {
		this.titulo = livro.getTitulo();
		this.resumo = livro.getResumo();
		this.sumario = livro.getSumario();
		this.preco_livro = livro.getPreco_livro();
		this.numero_paginas = livro.getNumero_paginas();
		this.isbn = livro.getIsbn();
		this.data_publicacao = livro.getData_publicacao();
		this.autor = livro.getAutor();
		this.categoria = livro.getCategoria();
	}

	public String getTitulo() {
		return titulo;
	}

	public String getResumo() {
		return resumo;
	}

	public String getSumario() {
		return sumario;
	}

	public BigDecimal getPreco_livro() {
		return preco_livro;
	}

	public Integer getNumero_paginas() {
		return numero_paginas;
	}

	public String getIsbn() {
		return isbn;
	}

	public LocalDate getData_publicacao() {
		return data_publicacao;
	}

	public Autor getAutor() {
		return autor;
	}

	public Categoria getCategoria() {
		return categoria;
	}
	
	
}
