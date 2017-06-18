package org.biblioteca.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;

import org.biblioteca.models.Aluno;
import org.springframework.stereotype.Repository;

@Repository
public class AlunoDAO {
	
	@PersistenceContext(type = PersistenceContextType.EXTENDED)
	private EntityManager manager;
	
	public void save(Aluno aluno){
		manager.persist(aluno);
	}
	
	public void update(Aluno aluno){
		manager.merge(aluno);
	}
	
	public Aluno get(Integer id){
		return manager.find(Aluno.class, id);
	}
	
	public List<Aluno> getAll(){
		return manager.createQuery("select a from Aluno a", Aluno.class).getResultList();
	}

}
