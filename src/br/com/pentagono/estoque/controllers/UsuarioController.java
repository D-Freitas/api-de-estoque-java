package br.com.pentagono.estoque.controllers;

import java.security.Principal;
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
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.pentagono.estoque.daos.PerfilAcessoDAO;
import br.com.pentagono.estoque.daos.UsuarioDAO;
import br.com.pentagono.estoque.models.Usuario;
import br.com.pentagono.estoque.utils.ArquivoUtils;
import br.com.pentagono.estoque.validations.UsuarioValidator;

@Controller
@Transactional
@RequestMapping("/usuarios")
public class UsuarioController {

	@Autowired
	private UsuarioDAO usuarioDAO;

	@Autowired
	private PerfilAcessoDAO perfilAcessoDAO;
	
	@Autowired
	private ArquivoUtils gravadorDeArquivos;

	@InitBinder
	protected void init(WebDataBinder binder) {

		UsuarioValidator validadorDeUsuario = new UsuarioValidator();
		binder.setValidator(validadorDeUsuario);
	}

	@RequestMapping(value = "/novo", name = "novoUsuarioUrl")
	public ModelAndView form(Usuario usuario) {
		ModelAndView mav = new ModelAndView("usuarios/form");
		mav.addObject("perfis", perfilAcessoDAO.listarTodos());

		System.out.println("carregando o formulario de usuarios");
		return mav;
	}

	@RequestMapping(method = RequestMethod.POST, name = "salvarUsuarioUrl")
	public ModelAndView salvarNoBanco(@Valid Usuario usuarioQueSeraSalvo, BindingResult resultadoValidacao,
			RedirectAttributes atributos) {

		if (resultadoValidacao.hasErrors()) {
			return form(usuarioQueSeraSalvo);
		}

		usuarioDAO.salvar(usuarioQueSeraSalvo);
		atributos.addFlashAttribute("status", "usuario salvo com sucesso");

		ModelAndView mav = new ModelAndView("redirect:/usuarios");
		return mav;
	}

	@RequestMapping(method = RequestMethod.GET, name = "listarUsuarioUrl")
	public ModelAndView listarUsuarios() {

		ModelAndView mav = new ModelAndView("usuarios/lista");
		List<Usuario> dados = usuarioDAO.listarTodos();
		mav.addObject("listaDeUsuarios", dados);

		return mav;
	}

	@RequestMapping(value = "{id}/edit", name = "alterarUsuarioUrl")
	public ModelAndView alterarUsuario(@PathVariable String id, Model model) {

		Usuario usuarioEncontrado = usuarioDAO.buscarPorId(id);
		usuarioEncontrado.getAuthorities();
		model.addAttribute(usuarioEncontrado);
		model.addAttribute("alteracao", true);
		return form(usuarioEncontrado);
	}

	@RequestMapping(value = "/{id}", name = "detalharUsuarioUrl")
	public ModelAndView detalharUsuario(@PathVariable String id) {

		Usuario usuarioVindoDoBanco = usuarioDAO.buscarPorId(id);
		ModelAndView mav = new ModelAndView("usuarios/detalhe");
		mav.addObject("usuario", usuarioVindoDoBanco);
		return mav;
	}

	@RequestMapping(value = "/{id}/delete", method = RequestMethod.POST, name = "excluirUsuarioUrl")
	public String excluirUsuario(@PathVariable String id) {

		Usuario usuarioEncontrado = usuarioDAO.buscarPorId(id);
		usuarioDAO.excluir(usuarioEncontrado);
		return "redirect:/usuarios";
	}

	@RequestMapping(value = "/perfil", method = RequestMethod.GET, name = "perfilUsuarioUrl")
	public ModelAndView perfil(Principal principal) {
		
		ModelAndView mav = new ModelAndView("usuarios/perfil");
		Usuario usuarioLogado = usuarioDAO.buscarPorId(principal.getName());
		mav.addObject("usuario", usuarioLogado);
		
		return mav;
	}

	@RequestMapping(value = "/perfil", method = RequestMethod.POST, name = "alterFotoPerfilUrl")
	public String alterarFotoPerfil(MultipartFile foto, Principal principal) {
		
		String caminhoDaFoto = gravadorDeArquivos.salvarEmDisco(foto);
		Usuario usuarioEncontrado = usuarioDAO.buscarPorId(principal.getName());
		
		usuarioEncontrado.setCaminhoFoto(caminhoDaFoto);
		usuarioDAO.salvar(usuarioEncontrado);
		
		
		
		return "redirect:/usuarios/perfil";
	}

}
