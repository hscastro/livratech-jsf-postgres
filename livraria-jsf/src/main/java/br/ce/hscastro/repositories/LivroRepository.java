package br.ce.hscastro.repositories;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.ce.hscastro.domain.Livro;

public class LivroRepository implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	
	private EntityManager entityManager;
	
	@Inject
	public LivroRepository(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	
	public void salvar(Livro livro) {
		entityManager.persist(livro);
	} 
	
	public void excluir(Long id) {
		entityManager.getReference(Livro.class, id);
	}

	public Livro buscarPorId(Long id) {
		return entityManager.find(Livro.class, id);
	}
	
	public Livro editar(Livro livro) {
		return entityManager.merge(livro);
	} 
	
	public List<Livro> lista() {
		TypedQuery<Livro> query = entityManager.createQuery(
				"from Livro", Livro.class);
		return query.getResultList();
	}	
	
}
