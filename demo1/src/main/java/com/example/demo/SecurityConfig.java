package com.example.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
@Configuration
public class SecurityConfig {
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		return http
				.authorizeHttpRequests()
				.requestMatchers("/orders")
				.hasRole("USER")
				.requestMatchers("/", "/**").permitAll()
				.and()
				.formLogin()
				.loginPage("/login")
				.defaultSuccessUrl("/design")
				.and()
				.logout()
				.and()
				.build();
	}
	/*
	@Bean
	 SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http)
	 throws Exception {
	 return http
	 .authorizeHttpRequests(authorizeRequests ->
	 authorizeRequests.anyRequest().authenticated()
	 )
	 .formLogin()
	 .and().build();
	 }*/
	 @Bean
	 UserDetailsService userDetailsService(UserRepository userRepo) {
	 return username -> userRepo.findByUsername(username);
	 }
	 @Bean
	 public PasswordEncoder passwordEncoder() {
	 return new BCryptPasswordEncoder();
	 }
	
		
	}


