package com.maha.ems.config;
/*
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import com.maha.ems.employee.EmployeeService;

public class WebSecurityConfig extends WebSecurityConfigurerAdapter{
	
	@Autowired
	private EmployeeService employeeService;
	
	@Override
	public void configure(HttpSecurity http) throws Exception{
		
		http.authorizeRequests().antMatchers("/*").permitAll();
		
		http.authorizeRequests().and().formLogin()
	        // Submit URL of login page.
	        .loginProcessingUrl("/j_spring_security_check") // Submit URL
	        .loginPage("/login")//
	        .defaultSuccessUrl("/api/employees")//
	        .failureUrl("/login?error=true")//
	        .usernameParameter("username")//
	        .passwordParameter("password")
	        // Config for Logout Page
	        .and().logout().logoutUrl("/logout").logoutSuccessUrl("/logoutSuccessful");
	     
	}
}
*/

public class WebSecurityConfig{
}