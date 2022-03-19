package com.alzohar.relationship.webservice.config;

import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
@EnableWebSecurity
  public class WebSecurityConfig extends WebSecurityConfigurerAdapter  {
	protected void configure(HttpSecurity http) throws Exception {
		
		http.authorizeRequests()
		.antMatchers("/api/proudct/**").permitAll()
		.antMatchers("/api/ordes/**").hasRole("ADMIN")
		.antMatchers("/api/customer/**").hasRole("USER")
		.antMatchers("/api/employee/").hasRole("VENDOR")
//		.antMatchers("/api/employee/**").hasRole("ADMIN")
		.anyRequest().authenticated();
		http.csrf().disable();
		http.formLogin();
		http.httpBasic();
	}

  @Override
  protected void configure(AuthenticationManagerBuilder auth)throws Exception {
	auth.inMemoryAuthentication()
	.withUser("Haris")
	.password("Haris@123")
	.roles("USER")
	.and()
	.withUser("Najim")
	.password("najim@123")
	.roles("VENDOR")
	.and()
	.withUser("Tauheed")
	.password("Tauheed@123")
	.roles("ADMIN");
	
}
  @Bean
  protected PasswordEncoder getPasswordEncoder() {
	return NoOpPasswordEncoder.getInstance();
}
}
