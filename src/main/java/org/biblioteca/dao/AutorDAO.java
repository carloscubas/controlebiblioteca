package org.biblioteca.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;

import org.biblioteca.models.Autor;
import org.springframework.stereotype.Repository;

@Repository
public class AutorDAO {
	
	@PersistenceContext(type = PersistenceContextType.EXTENDED)
	private EntityManager manager;
	
	public void save(Autor autor){
		manager.persist(autor);
	}
	
	public void update(Autor autor){
		manager.merge(autor);
	}
	
	public Autor get(Integer id){
		return manager.find(Autor.class, id);
	}
	
	public List<Autor> getAll(){
		return manager.createQuery("select a from Autor a", Autor.class).getResultList();
	}

}
