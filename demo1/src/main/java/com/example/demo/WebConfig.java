package com.example.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.example.demo.Ingredient.Type;

@Configuration
public class WebConfig implements WebMvcConfigurer {

		@Override
		public void addViewControllers(ViewControllerRegistry registry) {
			registry.addViewController("/").setViewName("home");
			registry.addViewController("/login");
		}
		
		@Bean
		public CommandLineRunner dataLoader(IngredientRepository repo) {
			
			return args -> {
				repo.save(new Ingredient("CH", "курица", Type.MEAT));
				repo.save(new Ingredient ("PR", "свинина", Type.MEAT));
				repo.save(new Ingredient ("PT", "картофель", Type.VEGGIES));
				repo.save (new Ingredient ("CB", "капуста", Type.VEGGIES));
				repo.save (new Ingredient ("CR", "морковь", Type.VEGGIES));
				repo.save (new Ingredient ("ND", "вермишель", Type.CEREAL));
				repo.save (new Ingredient ("RC", "рис", Type.CEREAL));
				repo.save (new Ingredient ("SC", "сметана", Type.SAUCE));
				repo.save (new Ingredient ("TM", "томатный соус", Type.SAUCE));
				repo.save (new Ingredient ("CL", "чили", Type.SPICE));	
			};
		}
		
}
