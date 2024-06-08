package com.nagarro.training.advanceJavaAssignment5App1.apiHandler;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpMethod;
import org.springframework.test.web.client.MockRestServiceServer;
import org.springframework.test.web.client.match.MockRestRequestMatchers;
import org.springframework.test.web.client.response.MockRestResponseCreators;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DeleteBookAPITest {

    private static final String DELETE_BOOK_API = "http://localhost:8082/library/books/{id}";

    private RestTemplate restTemplate;
    private MockRestServiceServer mockServer;

    @BeforeEach
    public void setUp() {
        restTemplate = new RestTemplate();
        mockServer = MockRestServiceServer.createServer(restTemplate);
    }

    @Test
    public void testDeleteBook() {
        // Arrange
        String bookId = "123";

        mockServer.expect(MockRestRequestMatchers.requestTo(DELETE_BOOK_API.replace("{id}", bookId)))
                .andExpect(MockRestRequestMatchers.method(HttpMethod.DELETE))
                .andRespond(MockRestResponseCreators.withNoContent());

        // Act
        DeleteBookAPI deleteBookAPI = new DeleteBookAPI(restTemplate);
        deleteBookAPI.deleteBook(bookId);

        // Verify
        mockServer.verify();
    }
}

