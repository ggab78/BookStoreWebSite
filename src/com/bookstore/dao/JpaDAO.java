package com.bookstore.dao;

import java.util.List;

import javax.persistence.EntityManager;

public class JpaDAO<E> {

	protected EntityManager entityManager;

	public JpaDAO(EntityManager entityManager) {
		super();
		this.entityManager = entityManager;
	}
	
	public E create(E entity) {
		entityManager.getTransaction().begin();
		
		entityManager.persist(entity);
		entityManager.flush();
		entityManager.refresh(entity);
	
		entityManager.getTransaction().commit();
		
		return entity;
	}
	
	public E update(E entity) {
		entityManager.getTransaction().begin();
		entityManager.merge(entity);
		entityManager.getTransaction().commit();
		return entity;
	}
	
	public E get (Object id) {
		
		return null;
	}
	
	public void delete(Object id) {
		
	}
	
	public List<E> listAll(){
		return null;
	}
	
	public long count() {
		return 0;
	}
	
}
