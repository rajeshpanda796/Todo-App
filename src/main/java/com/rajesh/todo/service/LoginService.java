package com.rajesh.todo.service;

import org.springframework.stereotype.Service;

@Service
public class LoginService {
	public boolean validateUser(String userid, String password) {

		return userid.equalsIgnoreCase("rajesh") && password.equalsIgnoreCase("rajesh123");
	}
}
