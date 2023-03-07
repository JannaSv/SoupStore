package com.example.demo;

import java.util.Optional;
import com.example.demo.Ingredient;

import org.springframework.data.repository.CrudRepository;


public interface IngredientRepository extends CrudRepository<Ingredient, String> {
	
}
