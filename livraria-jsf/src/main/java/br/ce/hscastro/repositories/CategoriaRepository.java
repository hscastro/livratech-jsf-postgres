package br.ce.hscastro.repositories;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.ce.hscastro.domain.Categoria;

public class CategoriaRepository implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	
	private EntityManager entityManager;
	
	@Inject
	public CategoriaRepository(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	
	public void save(Categoria categoria) {
		entityManager.persist(categoria);
	} 
	
	public void delete(Long id) {
		entityManager.getReference(Categoria.class, id);
	}

	public Categoria findById(Long id) {
		return entityManager.find(Categoria.class, id);
	}
	
	public Categoria edit(Categoria categoria) {
		return entityManager.merge(categoria);
	} 
	
	public List<Categoria> findAll() {
		TypedQuery<Categoria> query = entityManager.createQuery(
				"from Categoria", Categoria.class);
		return query.getResultList();
	}	
	
}
