package br.com.iw.controller;

import java.io.Serializable;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.iw.entity.Fabricante;
import br.com.iw.service.BusinessException;
import br.com.iw.service.FabricanteService;
import br.com.iw.util.FacesMessages;

@Named
@ViewScoped
public class CadastroFabricanteBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private FabricanteService fabricanteService;
		
	@Inject
	private Fabricante fabricante;
	
	@Inject
	private FacesMessages facesMessages;
	
	public void inicializar() {
		if (this.fabricante == null) {
			this.limpar();
		}
	}
		
	public void salvar() throws BusinessException {
		try {
			fabricanteService.salvar(fabricante);
			facesMessages.info("Fabricante salvo com sucesso!");
		} catch (BusinessException e) {
			facesMessages.error(e.getMessage());
		}
		this.limpar();
	}
	
	public Fabricante getFabricante() {
		return fabricante;
	}

	public void setFabricante(Fabricante fabricante) {
		this.fabricante = fabricante;
	}
		
	private void limpar() {
		this.fabricante = new Fabricante();
	}

}
