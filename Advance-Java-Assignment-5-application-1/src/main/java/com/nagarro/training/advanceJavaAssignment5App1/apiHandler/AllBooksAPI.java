package com.nagarro.training.advanceJavaAssignment5App1.apiHandler;
import static com.nagarro.training.advanceJavaAssignment5App1.apiHandler.API.*;

import java.util.stream.Collectors;

import org.springframework.web.client.RestTemplate;

import com.nagarro.training.advanceJavaAssignment5App1.model.*;

import java.util.List;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;

public class AllBooksAPI {

	final RestTemplate restTemplate;

	public AllBooksAPI(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}

	public AllBooksAPI() {
		this.restTemplate = new RestTemplate();
		// TODO Auto-generated constructor stub
	}

	public List<Book> getAllBooks() {
//		RestTemplate restTemplate = new RestTemplate();

		ResponseEntity<List<Book>> responseEntity = restTemplate.exchange(GET_ALL_BOOKS_API, HttpMethod.GET, null,
				new ParameterizedTypeReference<List<Book>>() {
				});

		List<Book> books = responseEntity.getBody();
		books.stream().map(Book::getCode).collect(Collectors.toList());

		return books;
	}

}
