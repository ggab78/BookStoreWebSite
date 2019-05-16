package com.bookstore.dao;

import javax.persistence.EntityManager;

import com.bookstore.entity.Users;

public class UserDAO extends JpaDAO<Users, Integer> implements GenericDAO<Users, Integer> {

	public UserDAO(EntityManager entityManager) {
		super(entityManager);
	}

}
