package com.bookstore.dao;

import static org.junit.Assert.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Persistence;


import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.bookstore.entity.Users;

public class UserDAOTest {

	private static EntityManagerFactory entityManagerFactory;
	private static EntityManager entityManager;
	private UserDAO userDAO;
	private Users user;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		entityManagerFactory = Persistence.createEntityManagerFactory("BookStoreWebSite");
		entityManager = entityManagerFactory.createEntityManager();

	}

	@Before
	public void setUpBeforeEachTest() throws Exception {
		userDAO = new UserDAO(entityManager);
		user = new Users();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		entityManager.close();
		entityManagerFactory.close();
	}

	@Test
	public void testCreate() {

		user.setFullName("GabGam");
		user.setEmail("gg@gmail.com");
		user.setPassword("new passssss");

		user = userDAO.create(user);
		assertTrue(user.getUserId() > 0);
	}

	@Test
	public void testFind() {

		user.setUserId(2);
		Users foundUser = userDAO.find(user.getClass(), user.getUserId());
		assertNotNull(foundUser);
		assertNotNull(foundUser.getEmail());
		assertTrue(foundUser.getUserId() == 2);
	}

	@Test
	public void testFindNotFound() {

		user.setUserId(10000001);
		Users foundUser = userDAO.find(user.getClass(), user.getUserId());
		assertNull(foundUser);
	}

//	@Test(expected = PersistenceException.class)
//	public void testCreateEmptyUser() {
//		try {
//			user = userDAO.create(user);
//		} catch (PersistenceException e) {
//			throw e;
//		}
//
//	}

	@Test
	public void testUpdate() {
		user.setUserId(1);
		user.setFullName("vvv_xxx");
		user.setEmail("gg@gmail.com");
		user.setPassword("new pass");
		Users updatedUser = userDAO.update(user);

		user = entityManager.find(user.getClass(), 1);
		assertEquals("vvv_xxx", updatedUser.getFullName());

	}

	@Test
	public void testDelete() {
		user.setUserId(1);
		userDAO.delete(user.getClass(), user.getUserId());
		user = userDAO.find(user.getClass(), user.getUserId());
		assertNull(user);
	}

	@Test(expected = Exception.class)
	public void testDeleteNotExistingUser() {
		user.setUserId(101);
		userDAO.delete(user.getClass(), user.getUserId());
	}

}
