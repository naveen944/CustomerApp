package com.talentsprint.businesstier.manager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.talentsprint.persistencetier.UserService;

@Component
public class UserManager {
	@Autowired
	UserService service;
	public Boolean getUser(String username, String password) {
		//UserService service=new UserService();
		
		return service.getUser(username, password);
	}
}
