package com.appzone.assignment.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.appzone.assignment.entity.User;
import com.appzone.assignment.entity.UserToken;
import com.appzone.assignment.service.UserService;

@RestController
@RequestMapping("/")
public class HomeController {

	@Autowired
	private UserService userService;

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ResponseEntity<UserToken> login(@RequestBody User user) {
		User account = userService.findByUsername(user.getUsername());
		Boolean status = account != null && user.getPassword().equals(account.getPassword());
		if (status)
			return new ResponseEntity<>(new UserToken(account.getId(), account.getUsername()), HttpStatus.OK);
		else
			return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
	}

}
