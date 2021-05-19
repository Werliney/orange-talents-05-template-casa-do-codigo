package com.example.orangeTalents.casadocodigo.controller.form;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Optional;

import javax.persistence.Lob;
import javax.validation.constraints.Future;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.ISBN;

import com.example.orangeTalents.casadocodigo.controller.annotations.UniqueValue;
import com.example.orangeTalents.casadocodigo.model.Autor;
import com.example.orangeTalents.casadocodigo.model.Categoria;
import com.example.orangeTalents.casadocodigo.model.Livro;
import com.example.orangeTalents.casadocodigo.repository.AutorRepository;
import com.example.orangeTalents.casadocodigo.repository.CategoriaRepository;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;

public class LivroForm {

	@NotBlank
	@UniqueValue(domainClass = Livro.class, fieldName = "titulo")
	private String titulo;
	@Size(max = 500)
	@NotBlank
	private String resumo;

	@NotBlank
	private String sumario;
	@Min(value = 20)
	private BigDecimal preco_livro;
	@Min(value = 100)
	private int numero_paginas;
	@UniqueValue(domainClass = Livro.class, fieldName = "isbn")
	@NotBlank
	private String isbn;
	@Future
	@JsonFormat(pattern = "dd/MM/yyyy", shape = Shape.STRING)
	private LocalDate data_publicacao;
	@NotNull
	private Long id_categoria;
	@NotNull
	private Long id_autor;

	public LivroForm(@NotBlank String titulo, @Size(max = 500) @NotBlank String resumo, @NotBlank String sumario,
			@Min(20) BigDecimal preco_livro, @Min(100) int numero_paginas, @NotBlank String isbn,
			@NotNull Long id_categoria, @NotNull Long id_autor) {
		super();
		this.titulo = titulo;
		this.resumo = resumo;
		this.sumario = sumario;
		this.preco_livro = preco_livro;
		this.numero_paginas = numero_paginas;
		this.isbn = isbn;
		this.id_categoria = id_categoria;
		this.id_autor = id_autor;
	}

	public void setData_publicacao(LocalDate data_publicacao) {
		this.data_publicacao = data_publicacao;
	}

	public Livro converter(CategoriaRepository categoriaRepository, AutorRepository autorRepository) {
		Optional<Categoria> categoria = categoriaRepository.findById(id_categoria);
		Optional<Autor> autor = autorRepository.findById(id_autor);

		return new Livro(titulo, resumo, sumario, preco_livro, numero_paginas, isbn, data_publicacao, categoria.get(),
				autor.get());

	}

}
