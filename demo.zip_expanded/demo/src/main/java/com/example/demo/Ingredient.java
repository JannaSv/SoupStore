package com.example.demo;

import org.springframework.data.annotation.Id;
import org.springframework.data.domain.Persistable;
import org.springframework.data.relational.core.mapping.Table;

import lombok.AllArgsConstructor;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Data
@Table
@AllArgsConstructor
//@NoArgsConstructor(access=AccessLevel.PUBLIC, force=true)
@RequiredArgsConstructor 
public class Ingredient implements Persistable<String>{
	
	@Id private String id;
	private String name;
	private Type type;
	

	
	public enum Type {
		CEREAL, MEAT, VEGGIES, SAUCE, SPICE 
	}



	@Override
	public boolean isNew() {
		// TODO Auto-generated method stub
		return false;
	}

}
