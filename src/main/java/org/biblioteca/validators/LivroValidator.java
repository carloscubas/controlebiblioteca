package org.biblioteca.validators;

import org.biblioteca.models.LivroForm;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class LivroValidator implements Validator {

	@Override
	public boolean supports(Class<?> clas) {
		return LivroForm.class.isAssignableFrom(clas);
	}

	@Override
	public void validate(Object target, Errors errors) {
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "titulo", "field.required");
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "autor", "field.required");
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "descricao", "field.required");
		
	}

}
