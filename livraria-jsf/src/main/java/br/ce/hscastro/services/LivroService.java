package br.ce.hscastro.services;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;

import br.ce.hscastro.domain.Livro;
import br.ce.hscastro.repositories.LivroRepository;

public class LivroService implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private LivroRepository livroRepository;
	
	public void salvar(Livro livro) {		
		livroRepository.save(livro);				
	}
	
	public void excluiar(Long id) {		
		livroRepository.delete(id);				
	}
	
	public Livro buscarPorId(Long id) {
		return livroRepository.findById(id);
	}
	
	public List<Livro> lista(){
		return livroRepository.findAll();
	}
	
}
