package br.com.iw.controller;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.iw.entity.Funcionario;
import br.com.iw.entity.Sexo;
import br.com.iw.service.BusinessException;
import br.com.iw.service.FuncionarioService;
import br.com.iw.util.FacesMessages;

@Named
@ViewScoped
public class CadastroFuncionarioBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private FuncionarioService funcionarioService;
		
	@Inject
	private Funcionario funcionario;
	
	@Inject
	private FacesMessages facesMessages;
	
	private List<Sexo> sexos;
	
	public void inicializar() {
		if (this.funcionario == null) {
			this.limpar();
		}
		
		//Carregando a lista de sexos para escolha
		this.sexos = Arrays.asList(Sexo.values());
	}
		
	public void salvar() throws BusinessException {
		try {
			funcionarioService.salvar(funcionario);
			facesMessages.info("Funcionario salvo com sucesso!");
		} catch (BusinessException e) {
			facesMessages.error(e.getMessage());
		}
		this.limpar();
	}
	
	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}
		
	private void limpar() {
		this.funcionario = new Funcionario();
	}

	public List<Sexo> getSexos() {
		return sexos;
	}
	
}
