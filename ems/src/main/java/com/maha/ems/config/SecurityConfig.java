package com.maha.ems.config;

//@Configuration
//@EnableConfigurationProperties
public class SecurityConfig {
/*
	@Autowired
	LoginService loginService;
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
		.csrf().disable()
        .authorizeRequests()
        	.antMatchers(HttpMethod.POST,"/employees").permitAll()
        	.antMatchers(HttpMethod.GET,"/employees").permitAll()
        	.antMatchers(HttpMethod.PUT,"/employees").permitAll()
        	.antMatchers("/").permitAll()
            .anyRequest().authenticated()
            .and().cors()
            .and()
        .formLogin()
        	.loginProcessingUrl("/login")
            .permitAll()
            .and()
        .logout()
            .permitAll();
	}
	
	@Bean
    public CorsConfigurationSource corsConfigurationSource() {
		CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowedOrigins(Arrays.asList("http://localhost:4200"));
        configuration.setAllowedMethods(Arrays.asList("GET","POST","PUT","DELETE"));
        configuration.addAllowedHeader("*");
        configuration.setAllowCredentials(false);
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;

	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new PasswordEncoder() {
            @Override
            public String encode(CharSequence rawPassword) {
                return rawPassword.toString();
            }
            @Override
            public boolean matches(CharSequence rawPassword, String encodedPassword) {
                return rawPassword.toString().equals(encodedPassword);
            }
        };
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder authBuilder) throws Exception {
		authBuilder.userDetailsService(loginService);
	}
*/
}