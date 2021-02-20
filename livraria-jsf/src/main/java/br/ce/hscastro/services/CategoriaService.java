package br.ce.hscastro.services;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;

import br.ce.hscastro.domain.Categoria;
import br.ce.hscastro.repositories.CategoriaRepository;

public class CategoriaService implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private CategoriaRepository categoriaRepository;
	
	public void salvar(Categoria categoria) {		
		categoriaRepository.save(categoria);				
	}
	
	public void excluiar(Long id) {		
		categoriaRepository.delete(id);				
	}
	
	public Categoria buscarPorId(Long id) {
		return categoriaRepository.findById(id);
	}
	
	public List<Categoria> lista(){
		return categoriaRepository.findAll();
	}
	
}
