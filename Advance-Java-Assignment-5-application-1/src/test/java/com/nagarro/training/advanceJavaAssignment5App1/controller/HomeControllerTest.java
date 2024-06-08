package com.nagarro.training.advanceJavaAssignment5App1.controller;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;
import org.springframework.ui.Model;
import org.springframework.web.context.request.WebRequest;

import com.nagarro.training.advanceJavaAssignment5App1.apiHandler.AllBooksAPI;
import com.nagarro.training.advanceJavaAssignment5App1.model.Author;
import com.nagarro.training.advanceJavaAssignment5App1.model.Book;
import com.nagarro.training.advanceJavaAssignment5App1.model.User;

public class HomeControllerTest {

	@Test
    void home_shouldRedirectToLoginPageWhenUserNotLoggedIn() {
        // Arrange
        WebRequest request = Mockito.mock(WebRequest.class);
        Model model = Mockito.mock(Model.class);
        HomeController homeController = new HomeController();

        Mockito.when(request.getAttribute("usr", WebRequest.SCOPE_SESSION)).thenReturn(null);

        // Act
        String result = homeController.home(model, request);

        // Assert
        Assertions.assertEquals("redirect:loginpage", result);
    }

	@Test
    void home_shouldAddBooksToModelWhenUserLoggedIn() {
        // Arrange
        WebRequest request = Mockito.mock(WebRequest.class);
        Model model = Mockito.mock(Model.class);
        HomeController homeController = new HomeController();

        // Mocking AllBooksAPI
        AllBooksAPI allBooksAPI = Mockito.mock(AllBooksAPI.class);
        Book mockBook1 = new Book("B1", "Book 1", new Author("Author 1"), "2023-01-01");
        Book mockBook2 = new Book("B2", "Book 2", new Author("Author 2"), "2023-01-02");
        List<Book> mockBooks = Arrays.asList(mockBook1, mockBook2);

        Mockito.when(request.getAttribute("usr", WebRequest.SCOPE_SESSION)).thenReturn(new User()); // Assuming User is your session attribute
        Mockito.when(allBooksAPI.getAllBooks()).thenReturn(mockBooks);

        // ArgumentCaptor to capture the argument passed to model.addAttribute
        ArgumentCaptor<String> attributeNameCaptor = ArgumentCaptor.forClass(String.class);
        ArgumentCaptor<List<Book>> booksCaptor = ArgumentCaptor.forClass(List.class);

        // Act
        String result = homeController.home(model, request);

        // Assert
        Mockito.verify(model).addAttribute(attributeNameCaptor.capture(), booksCaptor.capture());

     // Check if the list of books matches content-wise
//        Assertions.assertEquals(new HashSet<>(mockBooks), new HashSet<>(booksCaptor.getValue()));


        Assertions.assertEquals("home", result);
    }
}
