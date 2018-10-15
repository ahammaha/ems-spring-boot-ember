package com.maha.ems.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.maha.ems.employee.Employee;

@Service
public class LoginService {

	@Autowired
	private LoginRepository loginRepository;
	
	// pending to write a custom event
	public Employee getUser(String emailId) {
		return null;//loginRepository.findById(emailId).get();
	}
	
}
