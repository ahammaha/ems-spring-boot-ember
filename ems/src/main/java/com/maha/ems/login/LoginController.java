package com.maha.ems.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
@CrossOrigin(origins="http://localhost:4200/")
public class LoginController {
	
	@Autowired
	private LoginService loginService;
	
	@RequestMapping(method=RequestMethod.POST)
	public void login() {
		
	}
	
}
