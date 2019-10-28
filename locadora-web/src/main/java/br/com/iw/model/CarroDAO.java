package br.com.iw.model;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import br.com.iw.entity.Carro;

public class CarroDAO implements DAO {

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public void salvar(Object object) {
		entityManager.persist((Carro) object);	
	}
	
	@Override
	public List<Carro> listar() {
		String query = "SELECT c FROM Carro c";
		TypedQuery<Carro> queryResult =  entityManager.createQuery(query,Carro.class);
		List<Carro> carros = queryResult.getResultList();
		return carros;
	}
	
	@Override
	public Object buscarPorID(Long id) {
		Carro carro = (Carro) entityManager.find(Carro.class, id);
		return carro;
	}
	
	@Override
	public void atualizar(Object object) {
		entityManager.merge((Carro) object);		
	}
	
	@Override
	public void deletar(Object object) {
		Carro carro = (Carro) object;
		entityManager.remove(entityManager.getReference(Carro.class, carro.getId()));
	}
	
	
	public Object buscarModeloPorID(Long id) {
		Query queryResult = entityManager.createQuery("SELECT c FROM Carro c INNER JOIN c.modelocarro WHERE c.id = :id");
		queryResult.setParameter("id", id);
		return queryResult.getSingleResult();
	}
	
	public Object buscarAcessorioPorID(Long id) {
		Query queryResult = entityManager.createQuery("SELECT c FROM Carro c INNER JOIN c.acessorio WHERE c.id = :id");
		queryResult.setParameter("id", id);
		return queryResult.getSingleResult();
	}
	
}
