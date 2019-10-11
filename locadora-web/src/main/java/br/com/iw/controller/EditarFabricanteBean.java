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
public class EditarFabricanteBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private FabricanteService fabricanteService;
		
	@Inject
	private Fabricante fabricante;
	
	@Inject
	private FacesMessages facesMessages;
			
	public void atualizar() throws BusinessException {
		fabricanteService.atualizar(fabricante);
		facesMessages.info("Fabricante editado com sucesso!");
		this.limpar();
	}
	
	public void editarFabricante(Long id) {
		this.fabricante = (Fabricante) this.fabricanteService.buscarFabricantePorId(id);
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
