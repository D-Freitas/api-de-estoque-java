package br.com.pentagono.estoque.validations;

import java.time.LocalDate;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import br.com.pentagono.estoque.models.Produto;
import net.bytebuddy.asm.Advice.Local;

public class ProdutoValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {

		return Produto.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {

		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "descricao", "campo.obrigatorio");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "localizacao", "campo.obrigatorio");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "categoria", "campo.obrigatorio");

		Produto prod = (Produto) target;

		if (prod.getQuantidade() != null && prod.getQuantidade() < 0) {
			errors.rejectValue("quantidade", "numero.positivo");
		}

		Long resto = prod.getEstoqueMinimo() % 10;
		if (resto > 0) {
			errors.rejectValue("estoqueMinimo", "numero.mult");
		}

		if (prod.getValidade() == null) {
			errors.rejectValue("validade", "campo.obrigatorio");
		} else {
			LocalDate dataBase = LocalDate.now().plusYears(5);

			if (prod.getValidade().isBefore(dataBase)) {
				errors.rejectValue("validade", "fora.validade");
			}
		}
		
		if ( prod.getFornecedor() ==  null || prod.getFornecedor().getId() == 0L ) {
			errors.rejectValue("fornecedor", "campo.obrigatorio");
		}
		
		
		
	}
}
