package com.example.demo;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

public interface OrderRepository extends CrudRepository<SoupOrder, Long> {
	

}
