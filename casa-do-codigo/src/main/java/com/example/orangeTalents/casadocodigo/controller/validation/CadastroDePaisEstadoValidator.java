package com.example.orangeTalents.casadocodigo.controller.validation;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.example.orangeTalents.casadocodigo.controller.form.ClienteForm;
import com.example.orangeTalents.casadocodigo.model.Estado;
import com.example.orangeTalents.casadocodigo.model.Pais;
import com.example.orangeTalents.casadocodigo.repository.EstadoRepository;
import com.example.orangeTalents.casadocodigo.repository.PaisRepository;

@Component
public class CadastroDePaisEstadoValidator implements Validator {

	@Autowired
	private PaisRepository paisRepository;
	@Autowired
	private EstadoRepository estadoRepository;

	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return ClienteForm.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		if (errors.hasErrors()) {
			return;
		}
		ClienteForm request = (ClienteForm) target;

		Optional<Pais> pais = paisRepository.findById(request.getId_pais());
		Optional<Estado> estado = estadoRepository.findById(request.getId_estado());
		
		if(!pais.isPresent()) {
			errors.reject("id_pais", null, "Não existe pais com esse id");
			return;
		}
		
		if(!estado.isPresent()) {
			errors.reject("id_estado", null, "Não existe estado com esse id");
			return;
		}
		
		Pais pais2 = pais.get();
		Estado estado2 = estado.get();
	
		
		if(!pais2.getEstados().isEmpty() && !pais2.getEstados().contains(estado2)) {
			errors.reject("id_estado", null, "Não existe esse estado para esse país");
		}
		
	}

}
