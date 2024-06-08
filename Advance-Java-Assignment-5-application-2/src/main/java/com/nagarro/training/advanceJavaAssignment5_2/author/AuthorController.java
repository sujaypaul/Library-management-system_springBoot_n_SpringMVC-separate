package com.nagarro.training.advanceJavaAssignment5_2.author;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@Component
@RestController
public class AuthorController {
	
	
	private final AuthorRepository authorRepository;
	
	@Autowired
	public AuthorController(AuthorRepository authorRepository) {
		this.authorRepository = authorRepository;
	}
	
	@RequestMapping("/library/authors")
	public List<Author> getAllAuthors() {
		
		List<Author> authors = new ArrayList<>();
		
		authorRepository.findAll()
		.forEach(authors::add);
		
		return authors;
	}

}
