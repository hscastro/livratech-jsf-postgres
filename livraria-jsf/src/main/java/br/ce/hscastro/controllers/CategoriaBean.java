package br.ce.hscastro.controllers;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import br.ce.hscastro.domain.Categoria;
import br.ce.hscastro.services.CategoriaService;

@Named
@RequestScoped
public class CategoriaBean {

	private String nome;
	
	@Inject
	private Categoria categoria;
	
	@Inject
	private CategoriaService service;

	public String cadastrar() {
		FacesContext context = FacesContext.getCurrentInstance();
		
	
		if((this.nome != null) && (this.nome != "")) {
			this.categoria.setNome(nome);
			//service.salvar(categoria);					
			
			System.out.println("Gol "+nome); 
			
			return "/listar?faces-redirect=true";
			
		}else {
			FacesMessage mensagem = new FacesMessage("Usuário/senha inválidos!");
			mensagem.setSeverity(FacesMessage.SEVERITY_ERROR);
			context.addMessage(null, mensagem);
		}
		
		return null;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	
		
}