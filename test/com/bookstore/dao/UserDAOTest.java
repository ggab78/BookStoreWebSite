package com.bookstore.dao;

import static org.junit.Assert.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.bookstore.entity.Users;

public class UserDAOTest {

	private static EntityManagerFactory entityManagerFactory;
	private static EntityManager entityManager;
	private static UserDAO userDAO;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		entityManagerFactory = Persistence.createEntityManagerFactory("BookStoreWebSite");
		entityManager = entityManagerFactory.createEntityManager();
		userDAO = new UserDAO(entityManager);
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		entityManager.close();
		entityManagerFactory.close();
	}

	@Test
	public void testCreate() {
		Users user = new Users();
		user.setFullName("GabGam");
		user.setEmail("gg@gmail.com");
		user.setPassword("new pass");
		
		user = userDAO.create(user);
		assertTrue(user.getUserId()>0);
	}
	
	@Test(expected = PersistenceException.class)
	public void testCreateEmptyUser() {
		Users user = new Users();
		user = userDAO.create(user);
	}
	
	@Test
	public void testUpdate() {
		Users user = new Users();
		user.setUserId(1);
		user.setFullName("vvv");
		user.setEmail("gg@gmail.com");
		user.setPassword("new pass");
		userDAO.update(user);

		user = entityManager.find(Users.class, 1);
		assertEquals("vvv", user.getFullName());
		
	}
	
	
}
