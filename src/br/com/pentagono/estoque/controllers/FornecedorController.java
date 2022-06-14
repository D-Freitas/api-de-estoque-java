package br.com.pentagono.estoque.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.pentagono.estoque.daos.FornecedorDAO;
import br.com.pentagono.estoque.models.Fornecedor;
import br.com.pentagono.estoque.models.Produto;
import br.com.pentagono.estoque.validations.FornecedorValidator;

@Controller
@Transactional
@RequestMapping("/fornecedores")
public class FornecedorController {

	@Autowired
	private FornecedorDAO fornecedorDAO;

	@InitBinder
	protected void init(WebDataBinder binder) {
		binder.setValidator(new FornecedorValidator());
	}

	@RequestMapping(value = "/novo", name = "novoFornecedorUrl")
	public String form(Fornecedor fornecedor) {
		return "fornecedores/form";
	}

	@RequestMapping(value = "/novoJs", name = "novoFornecedorJsUrl")
	public String formJs(Fornecedor fornecedor) {
		return "fornecedores/formJs";
	}

	@RequestMapping(method = RequestMethod.POST, name = "salvarFornecedorUrl")
	public String salvarNoBanco(@Valid Fornecedor fornecedorQueSeraSalvo,  BindingResult resultadoValidacao,
			RedirectAttributes atributos) {

		if (resultadoValidacao.hasErrors()) {
			return form(fornecedorQueSeraSalvo);
		}

		fornecedorDAO.salvar(fornecedorQueSeraSalvo);
		return "redirect:/fornecedores";
	}

	@RequestMapping(value = "/js", method = RequestMethod.POST, name = "salvarFornecedorJsUrl")
	public String SalvarNoBancoJs(@Valid Fornecedor fornecedorComJs, BindingResult resultadoValidacao) {

		if (resultadoValidacao.hasErrors()) {
			return formJs(fornecedorComJs);
		}

		for (Produto prod : fornecedorComJs.getProdutos()) {
			prod.setFornecedor(fornecedorComJs);
		}
		fornecedorDAO.salvar(fornecedorComJs);

		return "redirect:/fornecedores";
	}

	@RequestMapping(method = RequestMethod.GET, name = "listarFornecedorUrl")
	public ModelAndView listar() {

		ModelAndView mav = new ModelAndView("fornecedores/lista");
		List<Fornecedor> dados = fornecedorDAO.listarTodos();
		mav.addObject("listaDeFornecedores", dados);

		return mav;
	}

	@RequestMapping(value = "{id}/edit", name = "alterarFornecedorUrl")
	public String alterar(@PathVariable Long id, Model model) {

		Fornecedor fornecedorEncontrado = fornecedorDAO.buscarPorId(id);
		model.addAttribute(fornecedorEncontrado);
		return form(fornecedorEncontrado);
	}

	@RequestMapping(value = "/{id}", name = "detalharFornecedorUrl")
	public ModelAndView detalhar(@PathVariable Long id) {

		Fornecedor fornecedorVindoDoBanco = fornecedorDAO.buscarPorId(id);
		ModelAndView mav = new ModelAndView("fornecedores/detalhe");
		mav.addObject("fornecedor", fornecedorVindoDoBanco);
		return mav;
	}

	@RequestMapping(value = "/{id}/delete", method = RequestMethod.POST, name = "excluirFornecedorUrl")
	public String excluir(@PathVariable Long id) {

		Fornecedor fornecedorEncontrado = fornecedorDAO.buscarPorId(id);
		fornecedorDAO.excluir(fornecedorEncontrado);
		return "redirect:/fornecedores";
	}
}
