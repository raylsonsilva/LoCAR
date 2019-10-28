package br.com.iw.controller;

import java.io.Serializable;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.iw.entity.Acessorio;
import br.com.iw.service.AcessorioService;
import br.com.iw.service.BusinessException;
import br.com.iw.util.FacesMessages;

@Named
@ViewScoped
public class PesquisaAcessorioBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private AcessorioService acessorioService;
	
	private List<Acessorio> acessorios;
	
	private Acessorio acessorioSelecionado;
	
	@Inject
	private FacesMessages facesMessages;
	
	public List<Acessorio> getAcessorios() {
		return acessorios;
	}
	
	public void deletar() throws BusinessException {
		try {
			acessorioService.deletar(acessorioSelecionado);
			facesMessages.info("Acessório " + acessorioSelecionado.getDescricao() + " excluído com sucesso.");
			this.acessorios.remove(acessorioSelecionado);
		} catch (BusinessException e) {
			facesMessages.error(e.getMessage());
		}
		
	}

	public Acessorio getAcessorioSelecionado() {
		return acessorioSelecionado;
	}
	
	public void setAcessorioSelecionado(Acessorio acessorioSelecionado) {
		this.acessorioSelecionado = acessorioSelecionado;
	}
	
	public void inicializar() {
		acessorios = acessorioService.listar();
	}
	
}
