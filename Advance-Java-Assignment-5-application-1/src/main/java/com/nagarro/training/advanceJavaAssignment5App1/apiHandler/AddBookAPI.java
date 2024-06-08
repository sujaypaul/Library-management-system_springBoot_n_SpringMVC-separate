package com.nagarro.training.advanceJavaAssignment5App1.apiHandler;
import static com.nagarro.training.advanceJavaAssignment5App1.apiHandler.API.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.nagarro.training.advanceJavaAssignment5App1.model.Book;

@Component
public class AddBookAPI {
	
	final RestTemplate restTemplate;

    
    public AddBookAPI(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

	public void addBook(Book book) {

		
		restTemplate.postForEntity(ADD_BOOK_API, book, Book.class);
		
	}

}
