package br.com.pentagono.estoque.daos;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import br.com.pentagono.estoque.models.PerfilAcesso;

@Repository
public class PerfilAcessoDAO {

	@PersistenceContext
	private EntityManager manager;

	public void salvar(PerfilAcesso objeto) {
		manager.merge(objeto);
	}

	public PerfilAcesso buscarPorId(String nome) {
		return manager.find(PerfilAcesso.class, nome);
	}

	public List<PerfilAcesso> listarTodos() {
		return manager.createQuery("SELECT p FROM PerfilAcesso p").getResultList();
	}

	public void excluir(PerfilAcesso perfilAcessoEncontrado) {
		manager.remove(perfilAcessoEncontrado);
	}

}
