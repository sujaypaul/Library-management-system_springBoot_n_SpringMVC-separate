package com.nagarro.training.advanceJavaAssignment5App1.apiHandler;
import static com.nagarro.training.advanceJavaAssignment5App1.apiHandler.API.*;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.client.RestTemplate;

import com.nagarro.training.advanceJavaAssignment5App1.model.Book;

public class UpdateBookAPI {
	
	
	public void updateBook(Book book) {
		
		RestTemplate restTemplate = new RestTemplate();
		Map<String, String> param = new HashMap<>();
		param.put("id", book.getCode());
		restTemplate.put(UPDATE_BOOK_API, book, param);
	}


}
