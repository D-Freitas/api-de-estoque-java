package br.com.pentagono.estoque.controllers;

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

import br.com.pentagono.estoque.daos.PerfilAcessoDAO;
import br.com.pentagono.estoque.models.PerfilAcesso;
import br.com.pentagono.estoque.validations.PerfilAcessoValidator;

@Controller
@Transactional
@RequestMapping("/perfis")
public class PerfilAcessoController {

	@Autowired
	private PerfilAcessoDAO perfilAcessoDAO;

	@InitBinder
	protected void init(WebDataBinder binder) {
		binder.setValidator(new PerfilAcessoValidator());
	}

	@RequestMapping(value = "/novo", name = "novoPerfilAcessoUrl")
	public String form(PerfilAcesso PerfilAcesso) {
		return "perfis/form";
	}
	
	@RequestMapping(method = RequestMethod.POST, name = "salvarPerfilAcessoUrl")
	public String salvarNoBanco(@Valid PerfilAcesso perfilAcessoQueSeraSalvo, BindingResult resultadoValidacao,
			RedirectAttributes atributos) {

		if (resultadoValidacao.hasErrors()) {
			return form(perfilAcessoQueSeraSalvo);
		}

		perfilAcessoDAO.salvar(perfilAcessoQueSeraSalvo);
		return "redirect:/perfis";
	}

	@RequestMapping(method = RequestMethod.GET, name = "listarPerfilAcessoUrl")
	public ModelAndView listar() {

		ModelAndView mav = new ModelAndView("perfis/lista");
		List<PerfilAcesso> dados = perfilAcessoDAO.listarTodos();
		mav.addObject("listaDePerfis", dados);

		return mav;
	}

	@RequestMapping(value = "{id}/edit", name = "alterarPerfilAcessoUrl")
	public String alterar(@PathVariable String id, Model model) {

		PerfilAcesso perfilAcessoEncontrado = perfilAcessoDAO.buscarPorId(id);
		model.addAttribute(perfilAcessoEncontrado);
		return form(perfilAcessoEncontrado);
	}

	@RequestMapping(value = "/{id}", name = "detalharPerfilAcessoUrl")
	public ModelAndView detalhar(@PathVariable String id) {

		PerfilAcesso perfilAcessoVindoDoBanco = perfilAcessoDAO.buscarPorId(id);
		ModelAndView mav = new ModelAndView("perfis/detalhe");
		mav.addObject("perfilAcesso", perfilAcessoVindoDoBanco);
		return mav;
	}

	@RequestMapping(value = "/{id}/delete", method = RequestMethod.POST, name = "excluirPerfilAcessoUrl")
	public String excluir(@PathVariable String id) {

		PerfilAcesso perfilAcessoEncontrado = perfilAcessoDAO.buscarPorId(id);
		perfilAcessoDAO.excluir(perfilAcessoEncontrado);
		return "redirect:/perfis";
	}

}
