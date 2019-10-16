package br.com.iw.model;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import br.com.iw.entity.ModeloCarro;

public class ModeloCarroDAO implements DAO {

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public void salvar(Object object) {
		entityManager.persist((ModeloCarro) object);	
	}
	
	@Override
	public List<ModeloCarro> listar() {
		String query = "SELECT m FROM ModeloCarro m";
		TypedQuery<ModeloCarro> queryResult =  entityManager.createQuery(query,ModeloCarro.class);
		List<ModeloCarro> modelosDeCarro = queryResult.getResultList();
		return modelosDeCarro;
	}
	
	@Override
	public Object buscarPorID(Long id) {
		ModeloCarro modeloCarro = (ModeloCarro) entityManager.find(ModeloCarro.class, id);
		return modeloCarro;
	}
	
	@Override
	public void atualizar(Object object) {
		entityManager.merge((ModeloCarro) object);		
	}
	
	@Override
	public void deletar(Object object) {
		ModeloCarro modeloCarro = (ModeloCarro) object;
		entityManager.remove(entityManager.getReference(ModeloCarro.class, modeloCarro.getId()));
	}
	
	
	public Object buscarFabricantePorID(Long id) {
		Query queryResult = entityManager.createQuery("SELECT m FROM modelocarro m INNER JOIN m.fabricante WHERE f.id = :id");
		queryResult.setParameter("id", id);
		return queryResult.getSingleResult();
	}
	
}
