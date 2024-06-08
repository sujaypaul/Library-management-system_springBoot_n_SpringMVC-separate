package com.nagarro.training.advanceJavaAssignment5App1.apiHandler;

import static com.nagarro.training.advanceJavaAssignment5App1.apiHandler.API.*;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.client.RestTemplate;

public class DeleteBookAPI {

	public void deleteBook(String code) {

		RestTemplate restTemplate = new RestTemplate();
		Map<String, String> params = new HashMap<String, String>();
		params.put("id", code);
		restTemplate.delete(DELETE_BOOK_API, params);
	}
}
