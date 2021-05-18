package com.example.orangeTalents.casadocodigo.controller.validation;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.example.orangeTalents.casadocodigo.controller.form.CategoriaForm;
import com.example.orangeTalents.casadocodigo.model.Categoria;
import com.example.orangeTalents.casadocodigo.repository.CategoriaRepository;

@Component
public class ProibeNomeDuplicadoDeCategoriaValidator implements Validator {

	@Autowired
	private CategoriaRepository categoriaRepository;

	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return CategoriaForm.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		if (errors.hasErrors()) {
			return;
		}

		CategoriaForm request = (CategoriaForm) target;
		Optional<Categoria> categoria = categoriaRepository.findByNome(request.getNome());

		if (categoria.isPresent()) {
			errors.rejectValue("nome", null, "Já existe uma categoria com o mesmo nome " + request.getNome());
		}

	}

}
