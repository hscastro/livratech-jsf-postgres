package br.ce.hscastro.controllers;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import br.ce.hscastro.domain.Livro;
import br.ce.hscastro.services.LivroService;

@Named
@RequestScoped
public class LivroBean {

	private String titulo;
	private String isbn;
	private String autor;
	
	@Inject
	private Livro livro;
	
	@Inject
	private LivroService service;

	public String cadastrar() {
		FacesContext context = FacesContext.getCurrentInstance();
		
	
		if((this.titulo != null) && (this.isbn != null) && (autor != null)) {
			this.livro.setTitulo(this.titulo);
			this.livro.setIsnb(this.isbn);
			this.livro.setAutor(this.autor);
			service.salvar(livro);					
			
			System.out.println("Gol "+autor); 
			
			return "/listar?faces-redirect=true";
			
		}else {
			FacesMessage mensagem = new FacesMessage("Usuário/senha inválidos!");
			mensagem.setSeverity(FacesMessage.SEVERITY_ERROR);
			context.addMessage(null, mensagem);
		}
		
		return null;
	}


	public String getTitulo() {
		return titulo;
	}


	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}


	public String getIsbn() {
		return isbn;
	}


	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}


	public String getAutor() {
		return autor;
	}


	public void setAutor(String autor) {
		this.autor = autor;
	}


	public Livro getLivro() {
		return livro;
	}


	public void setLivro(Livro livro) {
		this.livro = livro;
	}
	
	
		
}