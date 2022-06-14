package br.com.pentagono.estoque.daos;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Repository;

import br.com.pentagono.estoque.models.PerfilAcesso;
import br.com.pentagono.estoque.models.Usuario;

@Repository
@Transactional
public class UsuarioLoad {

	@Autowired
	private UsuarioDAO usuarioDAO;
	
	@Autowired
	private PerfilAcessoDAO perfiAcessoDAO;

	@Bean
	public void adicionaUsuarioAdmin() {
		
		PerfilAcesso perfiAdm = new PerfilAcesso("ROLE_ADMIN", "Administrador do Sistema");

		Usuario usuarioAdmin = new Usuario();
		usuarioAdmin.setUsername("admin");
		usuarioAdmin.setName("Usuario Administrador");
		usuarioAdmin.setPassword("1234");
		usuarioAdmin.getAuthorities().add(perfiAdm);

		if (usuarioDAO.buscarPorId(usuarioAdmin.getUsername()) == null) {
			perfiAcessoDAO.salvar(perfiAdm);
			usuarioDAO.salvar(usuarioAdmin);
		}
	}
}
