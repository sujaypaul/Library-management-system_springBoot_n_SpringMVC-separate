package com.nagarro.training.advanceJavaAssignment5App1.controller;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.ui.Model;

import com.nagarro.training.advanceJavaAssignment5App1.apiHandler.DeleteBookAPI;

import static org.mockito.Mockito.verify;

class DeleteBookControllerTest {

    @Test
    void delete_shouldCallDeleteBookAPIAndRedirectToHomePage() {
        // Arrange
        String bookCode = "B1";
        DeleteBookAPI deleteBookAPI = Mockito.mock(DeleteBookAPI.class);
        Model model = Mockito.mock(Model.class);
        DeleteBookController deleteBookController = new DeleteBookController(deleteBookAPI);

        // Act
        String result = deleteBookController.delete(bookCode);

        // Assert
        verify(deleteBookAPI).deleteBook(bookCode);
        Assertions.assertEquals("redirect:home", result);
    }
}