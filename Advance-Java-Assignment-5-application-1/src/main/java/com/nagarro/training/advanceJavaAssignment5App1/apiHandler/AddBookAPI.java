package com.nagarro.training.advanceJavaAssignment5App1.apiHandler;
import static com.nagarro.training.advanceJavaAssignment5App1.apiHandler.API.*;


import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.nagarro.training.advanceJavaAssignment5App1.model.Book;

public class AddBookAPI {
	
	public static void addBook(Book book) {
		
		RestTemplate restTemplate = new RestTemplate();
		
		restTemplate.postForEntity(ADD_BOOK_API, book, Book.class);
		
	}

}
