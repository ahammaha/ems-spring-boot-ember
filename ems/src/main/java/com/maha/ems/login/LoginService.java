package com.maha.ems.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.maha.ems.employee.EmployeeRepository;

@Component
public class LoginService/* implements UserDetailsService*/{

	@Autowired
	private EmployeeRepository employeeRepository;
/*
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		Employee employee=employeeRepository.findByEmail(email);
		if(employee==null) {
			throw new UsernameNotFoundException("User with this email id not found");
		}
		List<SimpleGrantedAuthority> authorities=Arrays.asList(new SimpleGrantedAuthority("user"));
		return new User(employee.getEmail(),employee.getPassword(),authorities);
	}
	*/
}
