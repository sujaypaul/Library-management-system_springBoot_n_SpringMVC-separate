package com.nagarro.training.advanceJavaAssignment5App1.apiHandler;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.nagarro.training.advanceJavaAssignment5App1.model.Author;
import com.nagarro.training.advanceJavaAssignment5App1.model.Book;

public class AllBooksAPITest {

	@Test
    void getAllBooks_shouldReturnListOfBooks() {
        // Arrange
        RestTemplate restTemplate = Mockito.mock(RestTemplate.class);

        List<Book> mockBooks = Arrays.asList(
                new Book("B1", "Book 1", new Author("Author 1"), "2023-01-01"),
                new Book("B2", "Book 2", new Author("Author 2"), "2023-01-02")
        );

        ResponseEntity<List<Book>> mockResponseEntity = new ResponseEntity<>(mockBooks, HttpStatus.OK);
        Mockito.when(restTemplate.exchange(Mockito.anyString(), Mockito.eq(HttpMethod.GET), Mockito.isNull(),
                Mockito.<ParameterizedTypeReference<List<Book>>>any()))
                .thenReturn(mockResponseEntity);

        // Create AllBooksAPI with the RestTemplate
        AllBooksAPI allBooksAPI = new AllBooksAPI(restTemplate);

        // Act
        List<Book> books = allBooksAPI.getAllBooks();

        // Assert
        Mockito.verify(restTemplate).exchange(Mockito.anyString(), Mockito.eq(HttpMethod.GET), Mockito.isNull(),
                Mockito.<ParameterizedTypeReference<List<Book>>>any());

        assertEquals(2, books.size());
        assertEquals("B1", books.get(0).getCode());
        assertEquals("Book 1", books.get(0).getName());
        assertEquals("B2", books.get(1).getCode());
        assertEquals("Book 2", books.get(1).getName());
    }
	
}
