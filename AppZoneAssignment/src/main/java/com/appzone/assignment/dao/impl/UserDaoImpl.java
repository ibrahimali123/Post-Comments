package com.appzone.assignment.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.appzone.assignment.dao.UserDao;
import com.appzone.assignment.entity.User;

@Repository("UserDao")
public class UserDaoImpl implements UserDao {

	@PersistenceContext
	EntityManager em;

	@Override
	public User findByUsername(String username) {
		try {
			Query query = em.createNamedQuery("User.findByUsername");
			query.setParameter("username", username);
			return (User) query.getSingleResult();
		} catch (Exception e) {
			return null;
		}
	}

	 
}
