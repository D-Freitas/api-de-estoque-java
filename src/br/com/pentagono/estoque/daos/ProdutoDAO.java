package br.com.pentagono.estoque.daos;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import br.com.pentagono.estoque.models.Produto;

@Repository
public class ProdutoDAO {

	@PersistenceContext
	private EntityManager manager;

	public void salvar(Produto objetoProduto) {
		if (objetoProduto.getId() == null) {
			manager.persist(objetoProduto);
		} else {
			manager.merge(objetoProduto);
		}
	}

	public List<Produto> listarTodos() {
		return manager.createQuery("SELECT p FROM Produto p").getResultList();
	}

	public Produto buscaPorId(Long id) {
		return manager.find(Produto.class, id);
	}

	public void excluir(Produto objetoProduto) {
		manager.remove(objetoProduto);
	}

}
