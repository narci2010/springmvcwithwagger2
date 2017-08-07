package com.mp.spring.service;

import com.mp.spring.model.Customer;
import com.mp.spring.model.User;

public interface UserService {
	
	public User get();
	public Customer login();
}
