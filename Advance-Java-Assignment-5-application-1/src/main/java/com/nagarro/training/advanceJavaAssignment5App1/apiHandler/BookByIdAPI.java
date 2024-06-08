package com.nagarro.training.advanceJavaAssignment5App1.apiHandler;

import static com.nagarro.training.advanceJavaAssignment5App1.apiHandler.API.*;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.nagarro.training.advanceJavaAssignment5App1.model.Book;

@Component
public class BookByIdAPI {

	private final RestTemplate restTemplate;

	public BookByIdAPI(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}

	public BookByIdAPI() {
		this.restTemplate = new RestTemplate();
		// TODO Auto-generated constructor stub
	}

	public Book getBook(String code) {
		
		try {
			

			Map<String, String> param = new HashMap<>();
			param.put("id", code);

			restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
			Book book = restTemplate.getForObject(GET_BOOK_BY_ID_API, Book.class, param);

			return book;
		} catch (Exception e) {
			return null;
		}

	}

}
