package br.com.iw.model;

import java.util.List;

import javax.enterprise.inject.Model;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import br.com.iw.entity.Fabricante;

@Model
public class FabricanteDAO implements DAO {

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public void salvar(Object object) {
		entityManager.persist((Fabricante) object);	
	}
	
	@Override
	public List<Fabricante> listar() {
		String query = "SELECT f FROM Fabricante f";
		TypedQuery<Fabricante> queryResult =  entityManager.createQuery(query,Fabricante.class);
		List<Fabricante> fabricantes = queryResult.getResultList();
		return fabricantes;
	}
	
	@Override
	public Object buscarPorID(Long id) {
		Fabricante fabricante = (Fabricante) entityManager.find(Fabricante.class, id);
		return fabricante;
	}
	
	@Override
	public void atualizar(Object object) {
		entityManager.merge((Fabricante) object);		
	}
	
	@Override
	public void deletar(Object object) {
		Fabricante fabricante = (Fabricante) object;
		entityManager.remove(entityManager.getReference(Fabricante.class, fabricante.getId()));
	}
}
