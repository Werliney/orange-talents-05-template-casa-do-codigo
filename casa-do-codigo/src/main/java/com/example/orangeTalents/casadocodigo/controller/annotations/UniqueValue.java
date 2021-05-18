package com.example.orangeTalents.casadocodigo.controller.annotations;

import java.lang.annotation.Target;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.validation.Constraint;
import javax.validation.Payload;


@Documented
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = { UniqueValueValidator.class })
public @interface UniqueValue {
	
	String message() default "{Já existe uma categoria com esse nome}";
	
	Class<?>[] groups() default {};
	
	Class<? extends Payload>[] payload() default { };
	
	String fieldName();
	
	Class<?> domainClass();
}
