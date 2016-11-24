package com.appzone.assignment.dao;

import com.appzone.assignment.entity.User;

public interface UserDao {

	public User findByUsername(String username);
}
