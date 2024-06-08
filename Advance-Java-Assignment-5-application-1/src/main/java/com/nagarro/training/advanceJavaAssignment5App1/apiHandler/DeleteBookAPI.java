package com.nagarro.training.advanceJavaAssignment5App1.apiHandler;

import static com.nagarro.training.advanceJavaAssignment5App1.apiHandler.API.*;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class DeleteBookAPI {
	
	private final RestTemplate restTemplate;

	public DeleteBookAPI(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}

	public void deleteBook(String code) {

		
		Map<String, String> params = new HashMap<String, String>();
		params.put("id", code);
		restTemplate.delete(DELETE_BOOK_API, params);
	}
}
