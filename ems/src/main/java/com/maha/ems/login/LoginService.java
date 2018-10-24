package com.maha.ems.login;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.maha.ems.employee.Employee;
import com.maha.ems.employee.EmployeeRepository;

@Component
public class LoginService implements UserDetailsService{

	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		Employee employee=employeeRepository.findByEmail(email);
		if(employee==null) {
			throw new UsernameNotFoundException("User with this email id not found");
		}
		List<SimpleGrantedAuthority> authorities=Arrays.asList(new SimpleGrantedAuthority("user"));
		return new User(employee.getEmail(),employee.getPassword(),authorities);
	}
	
}
