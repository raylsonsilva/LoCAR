package br.com.iw.service;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import org.apache.commons.lang3.StringUtils;

import br.com.iw.entity.Carro;
import br.com.iw.model.CarroDAO;


public class CarroService implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Inject
	private CarroDAO carroDAO;
	
	@Transactional
	public void salvar(Carro carro) throws BusinessException {
		this.validar(carro);
		this.carroDAO.salvar(carro);
	}
	
	public List<Carro> listar() {		
		return this.carroDAO.listar();
	}

	public Object buscarCarroPorId(Long id) {
		return this.carroDAO.buscarPorID(id);
	}
	
	public Object buscarModeloPorId(Long id) {
		return this.carroDAO.buscarModeloPorID(id);
	}
	
	public Object buscarAcessoriosPorId(Long id) {
		return this.carroDAO.buscarAcessorioPorID(id);
	}

	@Transactional
	public void atualizar(Carro carro) {
		this.carroDAO.atualizar(carro);		
	}
	
	@Transactional
	public void deletar(Carro carro) throws BusinessException {
		this.carroDAO.deletar(carro);		
	}
	
	private void validar(Carro carro) throws BusinessException {
		if (StringUtils.isBlank(carro.getPlaca())) {
			throw new BusinessException("A placa do carro é obrigatória.");
		}
		
		if (StringUtils.isBlank(carro.getChassi())) {
			throw new BusinessException("O Chassi do carro é obrigatório.");
		}
		
		if (carro.getModelo() == null) {
			throw new BusinessException("O modelo do carro é obrigatório");
		}
	}


}
