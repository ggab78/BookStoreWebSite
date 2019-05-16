package com.bookstore.dao;

import java.util.List;

public interface GenericDAO<E, Id> {

	public E create(E e);
	
	public E update(E e);
	
	public E find (Class<? extends E> e, Id id);
	
	public void delete(Class<? extends E> e, Id id);
	
	public List<E> listAll();
	
	public long count();

}
