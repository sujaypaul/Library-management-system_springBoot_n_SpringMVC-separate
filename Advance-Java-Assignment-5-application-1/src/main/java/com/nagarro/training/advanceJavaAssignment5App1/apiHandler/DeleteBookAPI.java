package com.nagarro.training.advanceJavaAssignment5App1.apiHandler;
import static com.nagarro.training.advanceJavaAssignment5App1.apiHandler.API.*;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.client.RestTemplate;

public class DeleteBookAPI {

	private static RestTemplate restTemplate = new RestTemplate();

	public static void deleteBook(String code) {
//		Map<String, String> param = new HashMap<>();
//		param.put("id", code);
//		restTemplate.delete(DELETE_BOOK_API, param);
//		
	}
}
