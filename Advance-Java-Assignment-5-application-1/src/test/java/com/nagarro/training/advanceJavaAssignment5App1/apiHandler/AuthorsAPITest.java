package com.nagarro.training.advanceJavaAssignment5App1.apiHandler;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.nagarro.training.advanceJavaAssignment5App1.model.Author;

public class AuthorsAPITest {

	@Test
    void getAuthors_shouldReturnListOfAuthors() {
        // Arrange
        RestTemplate restTemplate = Mockito.mock(RestTemplate.class);
        AuthorsAPI authorsAPI = new AuthorsAPI(restTemplate);

        // Mock response data
        List<Author> expectedAuthors = Arrays.asList(
                new Author("Author1"),
                new Author("Author2"),
                new Author("Author3")
        );
        ResponseEntity<List<Author>> mockResponseEntity = ResponseEntity.ok(expectedAuthors);
        System.out.println(expectedAuthors);
        // Mock RestTemplate behavior
        Mockito.when(restTemplate.exchange(
                ArgumentMatchers.eq(API.GET_AUTHORS_API),
                ArgumentMatchers.eq(HttpMethod.GET),
                ArgumentMatchers.isNull(),
                ArgumentMatchers.<ParameterizedTypeReference<List<Author>>>any()
        )).thenReturn(mockResponseEntity);

        // Act
        List<Author> result = authorsAPI.getAuthors();
        System.out.println(result);

        // Assert
        Assertions.assertEquals(expectedAuthors.size(), result.size());
        for (Author expectedAuthor : expectedAuthors) {
            Assertions.assertTrue(result.contains(expectedAuthor));
        }

        // Verify that restTemplate.exchange was called with the expected arguments
        Mockito.verify(restTemplate, Mockito.times(1)).exchange(
                ArgumentMatchers.eq(API.GET_AUTHORS_API),
                ArgumentMatchers.eq(HttpMethod.GET),
                ArgumentMatchers.isNull(),
                ArgumentMatchers.<ParameterizedTypeReference<List<Author>>>any()
        );
    }
	
}
