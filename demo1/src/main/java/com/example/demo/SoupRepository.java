package com.example.demo;

import java.util.Optional;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.repository.CrudRepository;

public interface SoupRepository extends CrudRepository<Soup, Long> {

 //Soup findAll(PageRequest page);
	

}
