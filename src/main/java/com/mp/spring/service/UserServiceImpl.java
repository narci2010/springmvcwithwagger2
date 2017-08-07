package com.mp.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mp.spring.model.Customer;
import com.mp.spring.model.User;

@Service("userService")
public class UserServiceImpl implements UserService {
	@Autowired
	User user;
	@Autowired
	Customer customer;

	@Override
	public User get() {
		user.setAge(23);
		user.setFirstName("Jyoti Prakash");
		user.setId(11569);

		return user;
	}

	@Override
	public Customer login() {
		customer.setC_id(1);
		customer.setC_email("j@com");
		customer.setC_password("12345");

		return customer;
	}

}
