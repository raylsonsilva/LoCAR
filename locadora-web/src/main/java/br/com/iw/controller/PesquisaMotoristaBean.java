package br.com.iw.controller;

import java.io.Serializable;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.iw.entity.Motorista;
import br.com.iw.service.BusinessException;
import br.com.iw.service.MotoristaService;
import br.com.iw.util.FacesMessages;

@Named
@ViewScoped
public class PesquisaMotoristaBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private MotoristaService motoristaService;
	
	private List<Motorista> motoristas;
	
	private Motorista motoristaSelecionado;
	
	@Inject
	private FacesMessages facesMessages;
	
	public List<Motorista> getMotoristas() {
		return motoristas;
	}
	
	public void deletar() throws BusinessException {
		try {
			motoristaService.deletar(motoristaSelecionado);
			facesMessages.info("Motorista " + motoristaSelecionado.getNome() + " excluído com sucesso.");
			this.motoristas.remove(motoristaSelecionado);
		} catch (BusinessException e) {
			facesMessages.error(e.getMessage());
		}
	}

	public Motorista getMotoristaSelecionado() {
		return motoristaSelecionado;
	}
	public void setMotoristaSelecionado(Motorista motoristaSelecionado) {
		this.motoristaSelecionado = motoristaSelecionado;
	}
	
	public void inicializar() {
		motoristas = motoristaService.listar();
	}
	
}
