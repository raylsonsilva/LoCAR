package br.com.iw.controller;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.iw.entity.Motorista;
import br.com.iw.entity.Sexo;
import br.com.iw.service.BusinessException;
import br.com.iw.service.MotoristaService;
import br.com.iw.util.FacesMessages;

@Named
@ViewScoped
public class EditarMotoristaBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private MotoristaService motoristaService;
		
	@Inject
	private Motorista motorista;
	
	private List<Sexo> sexos;
	
	@Inject
	private FacesMessages facesMessages;
	
	public void inicializar() {
		this.sexos = Arrays.asList(Sexo.values());
	}
			
	public void atualizar() throws BusinessException {
		motoristaService.atualizar(motorista);
		facesMessages.info("Motorista editado com sucesso!");
		this.limpar();
	}
	
	public void editarMotorista(Long id) {
		this.motorista = (Motorista) this.motoristaService.buscarMotoristaPorId(id);
	}
	
	public Motorista getMotorista() {
		return motorista;
	}

	public void setMotorista(Motorista motorista) {
		this.motorista = motorista;
	}
		
	private void limpar() {
		this.motorista = new Motorista();
	}
	
	public List<Sexo> getSexos() {
		return sexos;
	}

}
