package com.nagarro.training.advanceJavaAssignment5App1.controller;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.ui.ExtendedModelMap;
import org.springframework.ui.Model;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.web.context.request.WebRequest;

import com.nagarro.training.advanceJavaAssignment5App1.apiHandler.DeleteBookAPI;
import com.nagarro.training.advanceJavaAssignment5App1.apiHandler.UserLogin;
import com.nagarro.training.advanceJavaAssignment5App1.model.User;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class LoginControllerTest {

	@Test
    public void test_login_with_empty_fields() {
        LoginController controller = new LoginController();
        Model model = new ExtendedModelMap();
        WebRequest request = Mockito.mock(WebRequest.class);
        User emptyUser = new User("", "");
    
        String view = controller.verify(emptyUser, new BeanPropertyBindingResult(emptyUser, "ver"), model, request);
    
        assertEquals("login", view);
        assertTrue(model.containsAttribute("msg"));
    }

}
