package com.example.demo;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path="/api/soups", produces="application/json")
@CrossOrigin(origins="http://soupstore:8080")
public class SoupController {
	
	private SoupRepository soupRepo;
	
	public SoupController(SoupRepository soupRepo) {
		this.soupRepo=soupRepo;
	}
	
	/*@GetMapping(params="recent")
	public Iterable<Soup> recentSoups() {
		PageRequest page = PageRequest.of(0,12, Sort.by("createdAt").descending());
		return soupRepo(page).getContent();
	}*/
	
	@PostMapping(consumes="application/json")
	@ResponseStatus(HttpStatus.CREATED)
	public Soup postSoup(@RequestBody Soup soup) {
		return soupRepo.save(soup);
	}

}
