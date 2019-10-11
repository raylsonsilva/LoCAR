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
public class CadastroMotoristaBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private MotoristaService motoristaService;
		
	@Inject
	private Motorista motorista;
	
	@Inject
	private FacesMessages facesMessages;
	
	private List<Sexo> sexos;
	
	public void inicializar() {
		if (this.motorista == null) {
			this.limpar();
		}
		
		//Carregando a lista de sexos para escolha
		this.sexos = Arrays.asList(Sexo.values());
	}
		
	public void salvar() throws BusinessException {
		try {
			motoristaService.salvar(motorista);
			facesMessages.info("Motorista salvo com sucesso!");
		} catch (BusinessException e) {
			facesMessages.error(e.getMessage());
		}
		this.limpar();
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
