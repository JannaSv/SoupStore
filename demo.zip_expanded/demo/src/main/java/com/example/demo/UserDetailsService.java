package com.example.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException; 

public interface UserDetailsService {
	
	@Bean
	public default UserDetailsService userDetailsService(UserRepository userRepo) {
		return username -> {
			User user = userRepo.findByUsername(username).orElse(null);
			if (user!=null) return user;
			
			throw new UsernameNotFoundException("User "+username+" not found");
		};
	}
		UserDetails loadUserByUsername(String username) throws UsernameNotFoundException;
}
