package br.com.pentagono.estoque.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.pentagono.estoque.daos.FornecedorDAO;
import br.com.pentagono.estoque.models.Fornecedor;

@RestController
@RequestMapping("/api/fornecedores")
public class FornecedorApiController {
	
	@Autowired
	private FornecedorDAO fornecedorDAO;
	
	@GetMapping
	public List<Fornecedor> listar() {
		return fornecedorDAO.listarTodos();		
	}

}
