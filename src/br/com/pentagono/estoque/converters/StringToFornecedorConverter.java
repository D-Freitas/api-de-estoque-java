package br.com.pentagono.estoque.converters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import br.com.pentagono.estoque.daos.FornecedorDAO;
import br.com.pentagono.estoque.models.Fornecedor;

@Component
public class StringToFornecedorConverter implements Converter<String, Fornecedor> {

	@Autowired
	private FornecedorDAO fornecedorDAO;

	@Override
	public Fornecedor convert(String source) {
		Long id = Long.parseLong(source);

		try {
			return fornecedorDAO.buscarPorId(id);
		} catch (Exception e) {
			return new Fornecedor();
		}
	}
}
