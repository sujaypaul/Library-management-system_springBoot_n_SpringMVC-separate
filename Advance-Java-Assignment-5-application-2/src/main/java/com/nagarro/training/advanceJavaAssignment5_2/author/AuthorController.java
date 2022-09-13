package com.nagarro.training.advanceJavaAssignment5_2.author;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthorController {
	
	@Autowired
	private AuthorRepository authorRepository;
	
	@RequestMapping("/library/authors")
	public List<Author> getAllAuthors() {
		
		List<Author> authors = new ArrayList<>();
		
		authorRepository.findAll()
		.forEach(authors::add);
		
		return authors;
	}

}
