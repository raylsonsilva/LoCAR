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
public class EditarAcessorioBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private AcessorioService acessorioService;
		
	@Inject
	private Acessorio acessorio;
	
	@Inject
	private FacesMessages facesMessages;
			
	public void atualizar() throws BusinessException {
		acessorioService.atualizar(acessorio);
		facesMessages.info("Acessório editado com sucesso!");
		this.limpar();
	}
	
	public void editarAcessorio(Long id) {
		this.acessorio = (Acessorio) this.acessorioService.buscarAcessorioPorId(id);
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
