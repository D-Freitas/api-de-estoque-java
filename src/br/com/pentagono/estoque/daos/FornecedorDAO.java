package br.com.pentagono.estoque.daos;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import br.com.pentagono.estoque.models.Fornecedor;
import br.com.pentagono.estoque.models.Produto;

@Repository
public class FornecedorDAO {

	@PersistenceContext
	private EntityManager manager;

	public List<Fornecedor> listarTodos() {
		return manager.createQuery("select f from Fornecedor f order by id").getResultList();
	}

	public Fornecedor buscarPorId(Long id) {
		return manager.find(Fornecedor.class, id);
	}

	public void salvar(Fornecedor fornecedor) {
		if (fornecedor.getId() == null) {
			manager.persist(fornecedor);
		} else {
			manager.merge(fornecedor);
		}
	}

	public void excluir(Fornecedor fornecedor) {
		manager.remove(fornecedor);
	}

}
