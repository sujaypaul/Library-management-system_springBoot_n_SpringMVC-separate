package com.nagarro.training.advanceJavaAssignment5App1.controller;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Arrays;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.ui.Model;
import org.springframework.web.context.request.WebRequest;

import com.nagarro.training.advanceJavaAssignment5App1.apiHandler.AddBookAPI;
import com.nagarro.training.advanceJavaAssignment5App1.apiHandler.AuthorsAPI;
import com.nagarro.training.advanceJavaAssignment5App1.apiHandler.BookByIdAPI;
import com.nagarro.training.advanceJavaAssignment5App1.model.Author;
import com.nagarro.training.advanceJavaAssignment5App1.model.User;

public class AddBookControllerTest {
	
	@Test
    void addBookPage_shouldRedirectToLoginPageWhenUserNotLoggedIn() {
        // Arrange
        WebRequest request = Mockito.mock(WebRequest.class);
        Model model = Mockito.mock(Model.class);
        
        AddBookAPI addBookAPI = mock(AddBookAPI.class);
        AuthorsAPI authorsAPI = mock(AuthorsAPI.class);
        BookByIdAPI bookByIdAPI = mock(BookByIdAPI.class);
        AddBookController addBookController = new AddBookController(addBookAPI, authorsAPI, bookByIdAPI);

        Mockito.when(request.getAttribute("usr", WebRequest.SCOPE_SESSION)).thenReturn(null);

        // Act
        String result = addBookController.addBookPage(model, request);

        // Assert
        Assertions.assertEquals("redirect:login", result);
    }

	@Test
	void addBookPage_shouldAddAuthorsToModelWhenUserLoggedIn() {
	    // Arrange
	    WebRequest request = Mockito.mock(WebRequest.class);
	    Model model = Mockito.mock(Model.class);
	    
	    AddBookAPI addBookAPI = mock(AddBookAPI.class);
        AuthorsAPI authorsAPI = mock(AuthorsAPI.class);
        BookByIdAPI bookByIdAPI = mock(BookByIdAPI.class);
        AddBookController addBookController = new AddBookController(addBookAPI, authorsAPI, bookByIdAPI);
	    Mockito.when(request.getAttribute("usr", WebRequest.SCOPE_SESSION)).thenReturn(new User()); 

	    // Mock the behavior of AuthorsAPI.getAuthors() to return a list of authors
	    AuthorsAPI authorAPI = Mockito.mock(AuthorsAPI.class);
	    Mockito.when(authorAPI.getAuthors()).thenReturn(Arrays.asList(new Author("Author 1"), new Author("Author 2")));

	    // Act
	    String result = addBookController.addBookPage(model, request);

	    // Assert
	    Mockito.verify(model).addAttribute(Mockito.eq("authors"), Mockito.anyList());

	    Assertions.assertEquals("addBook", result);
	}
	
	 @Test
	    public void test_redirects_to_loginpage_when_session_absent() {
	        WebRequest request = Mockito.mock(WebRequest.class);
	        when(request.getAttribute("usr", WebRequest.SCOPE_SESSION)).thenReturn(null);
	    
	        AddBookAPI addBookAPI = mock(AddBookAPI.class);
	        AuthorsAPI authorsAPI = mock(AuthorsAPI.class);
	        BookByIdAPI bookByIdAPI = mock(BookByIdAPI.class);
	        AddBookController controller = new AddBookController(addBookAPI, authorsAPI, bookByIdAPI);
	        String result = controller.cancel(request);
	    
	        assertEquals("redirect:loginpage", result);
	    }

}
