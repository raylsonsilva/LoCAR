package br.com.iw.model;

import java.util.List;

import javax.enterprise.inject.Model;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import br.com.iw.entity.Acessorio;

@Model
public class AcessorioDAO implements DAO {

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public void salvar(Object object) {
		entityManager.persist((Acessorio) object);	
	}
	
	@Override
	public List<Acessorio> listar() {
		String query = "SELECT a FROM Acessorio a";
		TypedQuery<Acessorio> queryResult =  entityManager.createQuery(query,Acessorio.class);
		List<Acessorio> acessorios = queryResult.getResultList();
		return acessorios;
	}
	
	@Override
	public Object buscarPorID(Long id) {
		Acessorio acessorio = (Acessorio) entityManager.find(Acessorio.class, id);
		return acessorio;
	}
	
	@Override
	public void atualizar(Object object) {
		entityManager.merge((Acessorio) object);		
	}
	
	@Override
	public void deletar(Object object) {
		Acessorio acessorio = (Acessorio) object;
		entityManager.remove(entityManager.getReference(Acessorio.class, acessorio.getId()));
	}
}
