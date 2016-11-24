package com.appzone.assignment.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.appzone.assignment.dao.UserDao;
import com.appzone.assignment.entity.User;
import com.appzone.assignment.service.UserService;

@Service("UserService")
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;

	@Override
	public User findByUsername(String username) {
		return userDao.findByUsername(username);
	}
}
