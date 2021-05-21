package com.example.orangeTalents.casadocodigo.controller.validation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.example.orangeTalents.casadocodigo.controller.form.EstadoForm;
import com.example.orangeTalents.casadocodigo.model.Estado;
import com.example.orangeTalents.casadocodigo.repository.EstadoRepository;

@Component
public class ProibeNomeDuploDeEstadoParaMesmoPais implements Validator {

	@Autowired
	private EstadoRepository estadoRepository;

	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return EstadoForm.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		if (errors.hasErrors()) {
			return;
		}

		EstadoForm request = (EstadoForm) target;

		List<Estado> estados = estadoRepository.findAll();
		estados.stream().forEach(e -> {
			if (e.getPais().getId() == request.getId_pais()) {
				errors.rejectValue("id_pais", null, "Já existe um estado com esse nome nesse país");
			}
		});
	}
}
