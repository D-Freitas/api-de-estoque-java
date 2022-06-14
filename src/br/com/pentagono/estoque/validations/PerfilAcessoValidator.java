package br.com.pentagono.estoque.validations;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import br.com.pentagono.estoque.models.PerfilAcesso;

public class PerfilAcessoValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return PerfilAcesso.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "authority", "campo.obrigatorio");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "descricao", "campo.obrigatorio");
	}

}
