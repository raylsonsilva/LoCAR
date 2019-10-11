package br.com.iw.model;

import java.util.List;

import javax.enterprise.inject.Model;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import br.com.iw.entity.Motorista;

@Model
public class MotoristaDAO implements DAO {

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public void salvar(Object object) {
		entityManager.persist((Motorista) object);	
	}
	
	@Override
	public List<Motorista> listar() {
		String query = "SELECT m FROM Motorista m";
		TypedQuery<Motorista> queryResult =  entityManager.createQuery(query,Motorista.class);
		List<Motorista> motoristas = queryResult.getResultList();
		return motoristas;
	}
	
	@Override
	public Object buscarPorID(Long id) {
		Motorista motorista = (Motorista) entityManager.find(Motorista.class, id);
		return motorista;
	}
	
	@Override
	public void atualizar(Object object) {
		entityManager.merge((Motorista) object);		
	}
	
	@Override
	public void deletar(Object object) {
		Motorista motorista = (Motorista) object;
		entityManager.remove(entityManager.getReference(Motorista.class, motorista.getId()));
	}
}
