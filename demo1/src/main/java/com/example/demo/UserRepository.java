package com.example.demo;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;



public interface UserRepository extends CrudRepository<User, Long>{
	 UserDetails findByUsername(String username);
	
}
