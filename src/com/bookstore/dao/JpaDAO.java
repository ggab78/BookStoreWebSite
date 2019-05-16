package com.bookstore.dao;

import java.util.List;

import javax.management.RuntimeErrorException;
import javax.persistence.EntityManager;

import org.w3c.dom.ranges.RangeException;

public class JpaDAO<E, Id> {

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

	public E find(Class<? extends E> e, Id id) {
		E entity = entityManager.find(e, id);
		if (entity != null) {
			entityManager.refresh(entity);
		}

		return entity;
	}

	public void delete(Class<? extends E> e, Id id){
		entityManager.getTransaction().begin();
		try {
			E entity = entityManager.getReference(e, id);
			entityManager.remove(entity);
			entityManager.flush();
		} catch (Exception e2) {
			e2.getMessage();
			e2.printStackTrace();
		}finally {
			entityManager.getTransaction().commit();
		}
	}

	public List<E> listAll() {
		return null;
	}

	public long count() {
		return 0;
	}

}
