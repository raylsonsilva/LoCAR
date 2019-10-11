package br.com.iw.controller;

import java.io.Serializable;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.iw.entity.Funcionario;
import br.com.iw.service.BusinessException;
import br.com.iw.service.FuncionarioService;
import br.com.iw.util.FacesMessages;

@Named
@ViewScoped
public class PesquisaFuncionarioBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private FuncionarioService funcionarioService;
	
	private List<Funcionario> funcionarios;
	
	private Funcionario funcionarioSelecionado;
	
	@Inject
	private FacesMessages facesMessages;
	
	public List<Funcionario> getFuncionarios() {
		return funcionarios;
	}
	
	public void deletar() throws BusinessException {
		try {
			funcionarioService.deletar(funcionarioSelecionado);
			facesMessages.info("Funcionário " + funcionarioSelecionado.getNome() + " excluído com sucesso.");
			this.funcionarios.remove(funcionarioSelecionado);
		} catch (BusinessException e) {
			facesMessages.error(e.getMessage());
		}
	}

	public Funcionario getFuncionarioSelecionado() {
		return funcionarioSelecionado;
	}
	public void setFuncionarioSelecionado(Funcionario funcionarioSelecionado) {
		this.funcionarioSelecionado = funcionarioSelecionado;
	}
	
	public void inicializar() {
		funcionarios = funcionarioService.listar();
	}
	
}
