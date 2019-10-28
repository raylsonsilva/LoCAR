package br.com.iw.controller;

import java.io.Serializable;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.iw.entity.Acessorio;
import br.com.iw.service.AcessorioService;
import br.com.iw.service.BusinessException;
import br.com.iw.util.FacesMessages;

@Named
@ViewScoped
public class CadastroAcessorioBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private AcessorioService acessorioService;
		
	@Inject
	private Acessorio acessorio;
	
	@Inject
	private FacesMessages facesMessages;
	
	public void inicializar() {
		if (this.acessorio == null) {
			this.limpar();
		}
	}
		
	public void salvar() throws BusinessException {
		try {
			acessorioService.salvar(acessorio);
			facesMessages.info("Acessório salvo com sucesso!");
		} catch (BusinessException e) {
			facesMessages.error(e.getMessage());
		}
		this.limpar();
	}
	
	public Acessorio getAcessorio() {
		return acessorio;
	}

	public void setAcessorio(Acessorio acessorio) {
		this.acessorio = acessorio;
	}
		
	private void limpar() {
		this.acessorio = new Acessorio();
	}

}
