package com.nagarro.training.advanceJavaAssignment5App1.apiHandler;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.nagarro.training.advanceJavaAssignment5App1.model.Book;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.test.web.client.MockRestServiceServer;
import org.springframework.test.web.client.match.MockRestRequestMatchers;
import org.springframework.test.web.client.response.MockRestResponseCreators;
import org.springframework.web.client.RestTemplate;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class BookByIdAPITest {

    private static final String GET_BOOK_BY_ID_API = "http://localhost:8082/library/books/{id}";

    private RestTemplate restTemplate;
    private MockRestServiceServer mockServer;

    @BeforeEach
    public void setUp() {
        restTemplate = new RestTemplate();
        mockServer = MockRestServiceServer.createServer(restTemplate);
    }

    @Test
    public void testGetBookById() throws Exception {
        // Arrange
        String bookId = "123";
        String expectedResponseBody = "{\"code\":\"123\",\"name\":\"TestBook\",\"author\":{\"id\":1,\"name\":\"TestAuthor\"},\"date\":\"2023-01-01\"}";

        mockServer.expect(MockRestRequestMatchers.requestTo(GET_BOOK_BY_ID_API.replace("{id}", bookId)))
                .andExpect(MockRestRequestMatchers.method(HttpMethod.GET))
                .andRespond(MockRestResponseCreators.withSuccess(expectedResponseBody, MediaType.APPLICATION_JSON));

        // Act
        BookByIdAPI bookByIdAPI = new BookByIdAPI(restTemplate);
        Book book = bookByIdAPI.getBook(bookId);

        // Assert
        assertEquals("123", book.getCode());
        assertEquals("TestBook", book.getName());
        assertEquals("TestAuthor", book.getAuthor().getName());
        assertEquals("2023-01-01", book.getDate());

        // Verify
        mockServer.verify();
    }
}
