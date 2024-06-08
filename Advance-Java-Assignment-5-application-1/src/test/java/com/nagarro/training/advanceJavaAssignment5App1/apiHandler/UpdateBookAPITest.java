package com.nagarro.training.advanceJavaAssignment5App1.apiHandler;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.test.web.client.MockRestServiceServer;
import org.springframework.test.web.client.match.MockRestRequestMatchers;
import org.springframework.test.web.client.response.MockRestResponseCreators;
import org.springframework.web.client.RestTemplate;

import com.nagarro.training.advanceJavaAssignment5App1.model.Author;
import com.nagarro.training.advanceJavaAssignment5App1.model.Book;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UpdateBookAPITest {

    private static final String UPDATE_BOOK_API = "http://localhost:8082/library/books/{id}";

    private RestTemplate restTemplate;
    private MockRestServiceServer mockServer;

    @BeforeEach
    public void setUp() {
        restTemplate = new RestTemplate();
        mockServer = MockRestServiceServer.createServer(restTemplate);
    }

    @Test
    public void testUpdateBook() {
        // Arrange
        Book updatedBook = new Book("123", "Updated Book", new Author("Author Name"), "2023-12-31");

        mockServer.expect(MockRestRequestMatchers.requestTo(UPDATE_BOOK_API.replace("{id}", updatedBook.getCode())))
                .andExpect(MockRestRequestMatchers.method(HttpMethod.PUT))
                .andExpect(MockRestRequestMatchers.content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockRestRequestMatchers.content().json("{\"code\":\"123\",\"name\":\"Updated Book\",\"author\":{\"name\":\"Author Name\"},\"date\":\"2023-12-31\"}"))
                .andRespond(MockRestResponseCreators.withNoContent());

        // Act
        UpdateBookAPI updateBookAPI = new UpdateBookAPI(restTemplate);
        updateBookAPI.updateBook(updatedBook);

        // Verify
        mockServer.verify();
    }
}

