package br.com.iw.model;

import java.util.List;

import javax.enterprise.inject.Model;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import br.com.iw.entity.Funcionario;


@Model
public class FuncionarioDAO implements DAO {

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public void salvar(Object object) {
		entityManager.persist((Funcionario) object);	
	}
	
	@Override
	public List<Funcionario> listar() {
		String query = "SELECT f FROM Funcionario f";
		TypedQuery<Funcionario> queryResult =  entityManager.createQuery(query,Funcionario.class);
		List<Funcionario> funcionarios = queryResult.getResultList();
		return funcionarios;
	}
	
	@Override
	public Object buscarPorID(Long id) {
		Funcionario funcionario = (Funcionario) entityManager.find(Funcionario.class, id);
		return funcionario;
	}
	
	@Override
	public void atualizar(Object object) {
		entityManager.merge((Funcionario) object);		
	}
	
	@Override
	public void deletar(Object object) {
		Funcionario funcionario = (Funcionario) object;
		entityManager.remove(entityManager.getReference(Funcionario.class, funcionario.getId()));
	}
}
