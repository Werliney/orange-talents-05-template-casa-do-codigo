package com.example.orangeTalents.casadocodigo.controller.validation;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.example.orangeTalents.casadocodigo.controller.form.EstadoForm;
import com.example.orangeTalents.casadocodigo.model.Pais;
import com.example.orangeTalents.casadocodigo.repository.PaisRepository;

@Component
public class ProibeNomeDuploDeEstadoParaMesmoPais implements Validator {

	@Autowired
	private PaisRepository paisRepository;

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

		Optional<Pais> pais = paisRepository.findById(request.getId_pais());

		System.out.println("Pais " + pais.get() + "==================");
		if (!pais.isPresent()) {
			errors.rejectValue("id_pais", null, "Não existe país com esse id");
			return;
		}

		Pais pais2 = pais.get();

		System.out.println("O PAIS " + pais2 + "===========================");
		System.out.println("A LISTA DO PAIS " + pais2.getEstados() + "===========================");

		pais2.getEstados().stream().forEach(e -> {
			if (e.getNome().equals(request.getNome())) {
				errors.rejectValue("nome", null, "Já existe estado com o mesmo nome nesse país");
				return;
			}
		});
	}
}
