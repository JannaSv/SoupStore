package com.example.demo;

import java.util.Date;
import java.util.List;
import java.util.ArrayList;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@Table
public class Soup {
	
	@Id private Long id;
	private Date createdAt = new Date();
	
	@NotNull
	@Size(min=1, message="Название должно содержать хотя бы один символ")
	private String name;
	
	@NotNull
	@Size(min=1, message="Выберите хотя бы один ингредиент")
	private List <IngredientRef> ingredients;

}
