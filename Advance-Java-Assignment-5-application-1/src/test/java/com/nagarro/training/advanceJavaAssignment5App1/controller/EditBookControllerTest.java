package com.nagarro.training.advanceJavaAssignment5App1.controller;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.ui.Model;
import org.springframework.web.context.request.WebRequest;

import com.nagarro.training.advanceJavaAssignment5App1.apiHandler.BookByIdAPI;
import com.nagarro.training.advanceJavaAssignment5App1.apiHandler.DeleteBookAPI;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class EditBookControllerTest {

	 @Test
	    public void redirect_to_login_if_no_session() {
	        WebRequest request = mock(WebRequest.class);
	        when(request.getAttribute("usr", WebRequest.SCOPE_SESSION)).thenReturn(null);
	        Model model = mock(Model.class);
	    
	        EditBookController controller = new EditBookController();
	        String view = controller.addBookPage(model, request, "123");
	    
	        assertEquals("redirect:login", view);
	    }
	 
	 @Test
	    public void handle_null_response_for_invalid_book_id() {
	        WebRequest request = mock(WebRequest.class);
	        when(request.getAttribute("usr", WebRequest.SCOPE_SESSION)).thenReturn(new Object());
	        Model model = mock(Model.class);
	        BookByIdAPI bookByIdAPI = mock(BookByIdAPI.class);
	        when(bookByIdAPI.getBook("invalidCode")).thenReturn(null);
	    
	        EditBookController controller = new EditBookController();
	    
	        String view = controller.addBookPage(model, request, "invalidCode");
	    
	        verify(model).addAttribute(eq("book"), isNull());
	        assertEquals("editBook", view);
	    }
}
