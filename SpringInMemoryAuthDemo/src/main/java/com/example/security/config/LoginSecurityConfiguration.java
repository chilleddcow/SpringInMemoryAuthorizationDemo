package com.example.security.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
@Configuration
public class LoginSecurityConfiguration extends WebSecurityConfigurerAdapter{

	private static final String ADMIN_ROLE = "ADMIN";
	private static final String USER_ROLE = "USER";
	
	@Override
	public void configure(AuthenticationManagerBuilder builder) throws Exception {
		
		PasswordEncoder passwordEncoder = getPasswordEncoder();
		builder.inMemoryAuthentication().passwordEncoder(passwordEncoder)
		.withUser("manoj").password(passwordEncoder.encode("test")).roles(ADMIN_ROLE)
		.and().withUser("abc").password(passwordEncoder.encode("test123")).roles(USER_ROLE);
	}
	
	@Override
	public void configure(HttpSecurity http) throws Exception {
		http
		.antMatcher("/login/**").authorizeRequests()
		.anyRequest().hasRole(ADMIN_ROLE)
		.and().httpBasic();
	}
	
	private PasswordEncoder getPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}
}
