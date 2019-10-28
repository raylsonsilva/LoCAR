package br.com.iw.controller;

import java.io.Serializable;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.iw.entity.Acessorio;
import br.com.iw.entity.Carro;
import br.com.iw.entity.ModeloCarro;
import br.com.iw.service.AcessorioService;
import br.com.iw.service.BusinessException;
import br.com.iw.service.CarroService;
import br.com.iw.service.ModeloCarroService;
import br.com.iw.util.FacesMessages;

@Named
@ViewScoped
public class CadastroCarroBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private Carro carro;

	@Inject
	private CarroService carroService;
	
	@Inject
	private ModeloCarroService modeloCarroService;
	
	@Inject
	private AcessorioService acessorioService;

	@Inject
	private FacesMessages facesMessages;
	
	private List<ModeloCarro> modelosDeCarro;

	private List<Acessorio> acessorios;
	
	public void salvar() {
		try {
			this.carroService.salvar(carro);
			facesMessages.info("Carro salvo com sucesso!");
			this.limpar();
		} catch (BusinessException e) {
			facesMessages.error(e.getMessage());
		}
	}

	public void inicializar() {
		if (this.carro == null) {
			this.limpar();
		}
		
		this.modelosDeCarro = modeloCarroService.listar();
		this.acessorios = acessorioService.listar();
	}

	public Carro getCarro() {
		return carro;
	}

	public void setCarro(Carro carro) {
		this.carro = carro;
	}

	public List<ModeloCarro> getModelosDeCarro() {
		return modelosDeCarro;
	}

	public List<Acessorio> getAcessorios() {
		return acessorios;
	}
	
	private void limpar() {
		this.carro = new Carro();
	}
	
}
