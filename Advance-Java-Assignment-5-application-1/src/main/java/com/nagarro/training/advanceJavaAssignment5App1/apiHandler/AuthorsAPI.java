package com.nagarro.training.advanceJavaAssignment5App1.apiHandler;

import static com.nagarro.training.advanceJavaAssignment5App1.apiHandler.API.*;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.nagarro.training.advanceJavaAssignment5App1.model.Author;

public class AuthorsAPI {
	
	private static RestTemplate restTemplate = new RestTemplate();

	public static List<Author> getAuthors() {
		ResponseEntity<List<Author>> responseEntity 
										= restTemplate.exchange(
													GET_AUTHORS_API, 
													HttpMethod.GET, 
													null,
													new ParameterizedTypeReference<List<Author>>() {}
											);

		List<Author> authors = responseEntity.getBody();
			
		authors.stream().
			map(Author::getName)
			.collect(Collectors.toList());
		
		return authors;
	}

}
