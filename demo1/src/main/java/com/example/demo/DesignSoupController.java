package com.example.demo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.example.demo.Ingredient.Type;
import com.example.demo.Ingredient;
import com.example.demo.Soup;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/design")
@SessionAttributes("soupOrder")
public class DesignSoupController {
	
	private final IngredientRepository ingredientRepo;
	
	@Autowired
	public DesignSoupController(IngredientRepository ingredientRepo) {
		this.ingredientRepo=ingredientRepo;
	}
	
	@ModelAttribute
	public void addIngredientsToModel(Model model) {
		Iterable <Ingredient> ingredients = ingredientRepo.findAll();
		
		Type[] types = Ingredient.Type.values();
		for (Type type: types) {
			model.addAttribute(type.toString().toLowerCase(), filterByType(ingredients, type));
			
		}
	}
	
	@ModelAttribute(name = "soupOrder")
	public SoupOrder order() {
		return new SoupOrder();
	}
	
	@ModelAttribute(name = "soup")
	public Soup soup() {
		return new Soup();
	}
	
	@GetMapping
	public String showDesignForm() {
		return "design";
	}
	
	private Iterable <Ingredient> filterByType(Iterable<Ingredient> ingredients, Type type) {
		
		List <Ingredient> list = new ArrayList<>();
		for (Ingredient ing : ingredients) {
			if (ing.getType().equals(type)) list.add(ing);
		}
		
		return list;
			
	}

	
	@PostMapping
	public String processSoup(@Valid Soup soup, Errors errors, @ModelAttribute SoupOrder soupOrder) {
		
		if (errors.hasErrors()) {
			return "design";
		}
		soupOrder.addSoup(soup);
		log.info("Processing soup: {}", soup);
		
		return "redirect:/orders/current";
		
	}

}

