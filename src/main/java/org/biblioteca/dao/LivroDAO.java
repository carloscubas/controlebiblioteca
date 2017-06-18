package org.biblioteca.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;

import org.biblioteca.models.Livro;
import org.springframework.stereotype.Repository;

@Repository
public class LivroDAO {
	
	@PersistenceContext(type = PersistenceContextType.EXTENDED)
	private EntityManager manager;
	
	public void save(Livro livro){
		manager.persist(livro);
	}
	
	public Livro get(Integer id){
		return manager.find(Livro.class, id);
	}
	
	public void update(Livro livro){
		manager.merge(livro);
	}
	
	public List<Livro> getAll(){
		return manager.createQuery("select l from Livro l", Livro.class).getResultList();
	}

}
