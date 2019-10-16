package br.com.iw.controller;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.iw.entity.Categoria;
import br.com.iw.entity.Fabricante;
import br.com.iw.entity.ModeloCarro;
import br.com.iw.service.BusinessException;
import br.com.iw.service.FabricanteService;
import br.com.iw.service.ModeloCarroService;
import br.com.iw.util.FacesMessages;

@Named
@ViewScoped
public class CadastroModeloCarroBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private ModeloCarro modeloCarro;

	@Inject
	private ModeloCarroService modeloCarroService;
	
	@Inject
	private FabricanteService fabricanteService;

	@Inject
	private FacesMessages facesMessages;
	
	private List<Fabricante> fabricantes;

	private List<Categoria> categorias;
	
	public void salvar() {
		try {
			this.modeloCarroService.salvar(modeloCarro);
			facesMessages.info("Modelo de Carro salvo com sucesso!");
			this.limpar();
		} catch (BusinessException e) {
			facesMessages.error(e.getMessage());
		}
	}

	public void inicializar() {
		if (this.modeloCarro == null) {
			this.limpar();
		}
		
		this.fabricantes = fabricanteService.listar();
		this.categorias = Arrays.asList(Categoria.values());
	}

	public ModeloCarro getModeloCarro() {
		return modeloCarro;
	}

	public void setModeloCarro(ModeloCarro modeloCarro) {
		this.modeloCarro = modeloCarro;
	}

	public List<Fabricante> getFabricantes() {
		return fabricantes;
	}

	public List<Categoria> getCategorias() {
		return categorias;
	}
	
	private void limpar() {
		this.modeloCarro = new ModeloCarro();
	}
	
}
