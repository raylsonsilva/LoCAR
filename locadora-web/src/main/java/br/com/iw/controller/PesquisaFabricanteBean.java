package br.com.iw.controller;

import java.io.Serializable;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.iw.entity.Fabricante;
import br.com.iw.service.BusinessException;
import br.com.iw.service.FabricanteService;
import br.com.iw.util.FacesMessages;

@Named
@ViewScoped
public class PesquisaFabricanteBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private FabricanteService fabricanteService;
	
	private List<Fabricante> fabricantes;
	
	private Fabricante fabricanteSelecionado;
	
	@Inject
	private FacesMessages facesMessages;
	
	public List<Fabricante> getFabricantes() {
		return fabricantes;
	}
	
	public void deletar() throws BusinessException {
		try {
			fabricanteService.deletar(fabricanteSelecionado);
			facesMessages.info("Fabricante " + fabricanteSelecionado.getNome() + " excluído com sucesso.");
			this.fabricantes.remove(fabricanteSelecionado);
		} catch (BusinessException e) {
			facesMessages.error(e.getMessage());
		}
		
	}

	public Fabricante getFabricanteSelecionado() {
		return fabricanteSelecionado;
	}
	public void setFabricanteSelecionado(Fabricante fabricanteSelecionado) {
		this.fabricanteSelecionado = fabricanteSelecionado;
	}
	
	public void inicializar() {
		fabricantes = fabricanteService.listar();
	}
	
}
