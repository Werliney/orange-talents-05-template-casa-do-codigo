package com.example.orangeTalents.casadocodigo.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Future;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.ISBN;

import com.example.orangeTalents.casadocodigo.controller.annotations.UniqueValue;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;

@Entity
public class Livro {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotBlank
	private String titulo;
	@Size(max = 500)
	@NotBlank
	private String resumo;

	@Lob
	@NotBlank
	private String sumario;
	@Min(value = 20)
	private BigDecimal preco_livro;
	@Min(value = 100)
	private Integer numero_paginas;
	@NotBlank
	private String isbn;

	@Future
	@JsonFormat(pattern = "dd/MM/yyyy", shape = Shape.STRING)
	private LocalDate data_publicacao;

	@NotNull
	@ManyToOne
	private Categoria categoria;

	@NotNull
	@ManyToOne
	private Autor autor;

	public Livro() {
		super();
	}

	public Livro(@NotBlank String titulo, @Size(max = 500) @NotBlank String resumo, @NotBlank String sumario,
			@Min(20) BigDecimal preco_livro, @Min(100) Integer numero_paginas, @NotBlank String isbn,
			@Future LocalDate data_publicacao, @NotNull Categoria categoria, @NotNull Autor autor) {
		super();
		this.titulo = titulo;
		this.resumo = resumo;
		this.sumario = sumario;
		this.preco_livro = preco_livro;
		this.numero_paginas = numero_paginas;
		this.isbn = isbn;
		this.data_publicacao = data_publicacao;
		this.categoria = categoria;
		this.autor = autor;
	}

}
