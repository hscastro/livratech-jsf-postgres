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
	
	public void save(Livro livro) {
		System.out.println("testou "+livro.getAutor()); 
		entityManager.persist(livro);
	} 
	
	public void delete(Long id) {
		entityManager.getReference(Livro.class, id);
	}

	public Livro findById(Long id) {
		return entityManager.find(Livro.class, id);
	}
	
	public Livro edit(Livro livro) {
		return entityManager.merge(livro);
	} 
	
	public List<Livro> findAll() {
		TypedQuery<Livro> query = entityManager.createQuery(
				"from Livro", Livro.class);
		return query.getResultList();
	}	
	
}
