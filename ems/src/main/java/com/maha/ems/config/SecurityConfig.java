package com.maha.ems.config;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		// add our users for in memory authentication

		UserBuilder users = User.withDefaultPasswordEncoder();

		// By default spring security prefixes mentioned roles by ROLES_ ie.
		// ROLES_ADMIN, ROLES_MANAGER
		// we can give any role names and any number of roles
		auth.inMemoryAuthentication().withUser(users.username("user1").password("pwd").roles("EMPLOYEE", "ADMIN"))
				.withUser(users.username("user2").password("pwd").roles("EMPLOYEE", "MANAGER"))
				.withUser(users.username("user3").password("pwd").roles("EMPLOYEE"))
				.withUser(users.username("user4").password("pwd").roles("EMPLOYEE", "MANAGER"));
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
			.anyRequest().authenticated()
			.and()
			.formLogin().permitAll()
			.and()
			.logout().permitAll();
	}
}