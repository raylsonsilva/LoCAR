package br.com.iw.controller;

import java.io.Serializable;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.iw.entity.Carro;
import br.com.iw.service.BusinessException;
import br.com.iw.service.CarroService;
import br.com.iw.util.FacesMessages;

@Named
@ViewScoped
public class PesquisaCarroBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private List<Carro> carros;
	
	private Carro carroSelecionado;
	
	@Inject
	private CarroService carroService;
	
	@Inject
	private FacesMessages facesMessages;
	
	public List<Carro> getCarros() {
		return this.carros;
	}
	
	public void inicializar() {
		this.carros = this.carroService.listar();
	}
	
	public void deletar() {
		try {
			carroService.deletar(carroSelecionado);
			this.carros.remove(carroSelecionado);
			facesMessages.info("Carro " + carroSelecionado.getPlaca() + " excluído com sucesso!");
		} catch (BusinessException e) {
			facesMessages.error(e.getMessage());
		}
	}
	
	public Carro getCarroSelecionado() {
		return carroSelecionado;
	}
	public void setCarroSelecionado(Carro carroSelecionado) {
		this.carroSelecionado = carroSelecionado;
	}
	
	public Object buscarAcessoriosParaCarro(Long id) {
		return carroService.buscarAcessoriosPorId(id);
	}

}
