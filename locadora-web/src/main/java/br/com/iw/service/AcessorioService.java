package br.com.iw.service;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import org.apache.commons.lang3.StringUtils;

import br.com.iw.entity.Acessorio;
import br.com.iw.model.AcessorioDAO;


public class AcessorioService implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Inject
	private AcessorioDAO acessorioDAO;
	
	@Transactional
	public void salvar(Acessorio acessorio) throws BusinessException {
		if (StringUtils.isEmpty(acessorio.getDescricao())) { 
			throw new BusinessException("A descrição do acessório é obrigatória!");
		}
		this.acessorioDAO.salvar(acessorio);
	}
	
	public List<Acessorio> listar() {		
		return this.acessorioDAO.listar();
	}

	public Object buscarAcessorioPorId(Long id) {
		return this.acessorioDAO.buscarPorID(id);
		
	}

	@Transactional
	public void atualizar(Acessorio acessorio) {
		this.acessorioDAO.atualizar(acessorio);		
	}
	
	@Transactional
	public void deletar(Acessorio acessorio) throws BusinessException {
		this.acessorioDAO.deletar(acessorio);		
	}

}
