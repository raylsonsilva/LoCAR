package br.com.iw.service;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import org.apache.commons.lang3.StringUtils;
import br.com.iw.entity.Motorista;
import br.com.iw.model.MotoristaDAO;


public class MotoristaService implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Inject
	private MotoristaDAO motoristaDAO;
	
	@Transactional
	public void salvar(Motorista motorista) throws BusinessException {
		if (StringUtils.isEmpty(motorista.getNome())) { 
			throw new BusinessException("O nome do motorista é obrigatório");
		}
		this.motoristaDAO.salvar(motorista);
	}
	
	public List<Motorista> listar() {		
		return this.motoristaDAO.listar();
	}

	public Object buscarMotoristaPorId(Long id) {
		return this.motoristaDAO.buscarPorID(id);
		
	}

	@Transactional
	public void atualizar(Motorista motorista) {
		this.motoristaDAO.atualizar(motorista);		
	}
	
	@Transactional
	public void deletar(Motorista motorista) throws BusinessException {
		this.motoristaDAO.deletar(motorista);		
	}

}
