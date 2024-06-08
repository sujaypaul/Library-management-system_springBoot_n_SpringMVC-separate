package com.nagarro.training.advanceJavaAssignment5App1.apiHandler;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.nagarro.training.advanceJavaAssignment5App1.model.Author;
import com.nagarro.training.advanceJavaAssignment5App1.model.Book;

public class AddBookAPITest {

	@Test
    void addBook_shouldReturnSuccessStatusCode() {
        // Arrange
        RestTemplate restTemplate = Mockito.mock(RestTemplate.class);
        AddBookAPI addBookAPI = new AddBookAPI(restTemplate);

        Book mockBook = new Book("123", "Book 1", new Author("Author 1"), "2023-01-01");

        ResponseEntity<Book> mockResponseEntity = new ResponseEntity<>(mockBook, HttpStatus.CREATED);
        Mockito.when(restTemplate.postForEntity(Mockito.anyString(), Mockito.any(Book.class), Mockito.eq(Book.class)))
                .thenReturn(mockResponseEntity);

        // Act
        addBookAPI.addBook(mockBook);

        // Assert
        Mockito.verify(restTemplate).postForEntity(Mockito.anyString(), Mockito.any(Book.class), Mockito.eq(Book.class));
    }
	
}
