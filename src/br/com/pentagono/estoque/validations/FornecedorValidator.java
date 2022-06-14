package br.com.pentagono.estoque.validations;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import br.com.pentagono.estoque.models.Fornecedor;

public class FornecedorValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return Fornecedor.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "razaoSocial", "campo.obrigatorio");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "nomeFantasia", "campo.obrigatorio");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "cnpj", "campo.obrigatorio");

	}

}
