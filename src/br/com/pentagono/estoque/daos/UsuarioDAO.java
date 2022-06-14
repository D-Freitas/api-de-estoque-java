package br.com.pentagono.estoque.daos;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;

import br.com.pentagono.estoque.models.Usuario;

@Repository
public class UsuarioDAO implements UserDetailsService {

	@PersistenceContext
	private EntityManager manager;
	
	public void salvar(Usuario usuarioQueSeraSalvo) {
		manager.merge(usuarioQueSeraSalvo);
	}
	
	public Usuario buscarPorId(String login) {
		return manager.find(Usuario.class, login);
	}
	
	public List<Usuario> listarTodos() {
		return manager.createQuery("SELECT u from Usuario u").getResultList();
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		Usuario usuarioEncontrado = manager.find(Usuario.class, username);
		if (usuarioEncontrado == null) {
			throw new UsernameNotFoundException("Usuário " + username + " não existe ou esta incorreto");
		}

		return usuarioEncontrado;
	}

	public void excluir(Usuario usuarioEncontrado) {
		manager.remove(usuarioEncontrado);		
	}

}
