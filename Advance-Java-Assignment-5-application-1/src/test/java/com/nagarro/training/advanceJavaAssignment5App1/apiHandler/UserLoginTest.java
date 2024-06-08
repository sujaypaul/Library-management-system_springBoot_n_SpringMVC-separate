package com.nagarro.training.advanceJavaAssignment5App1.apiHandler;

import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.nagarro.training.advanceJavaAssignment5App1.model.User;

import org.springframework.web.client.RestTemplate;
import org.springframework.http.HttpMethod;

import static org.junit.jupiter.api.Assertions.*;

public class UserLoginTest {

    private final String GET_USER_BY_ID_API = "http://localhost:8082/user/{id}";

    @Test
    public void testGetUser() {
        // Arrange
        String validUsername = "test"; 

        // Act
        User user = UserLogin.getUser(validUsername);

        // Assert
        assertNotNull(user, "User should not be null");
        assertEquals(validUsername, user.getUsername(), "Username should match");
    }

    @Test
    public void testCheckUsername() {
        // Arrange
        String validUsername = "test"; 

        // Act
        boolean result = UserLogin.checkUsername(validUsername);

        // Assert
        assertTrue(result, "Username should be valid");
    }

    @Test
    public void testCheckPassword() {
        // Arrange
        String validUsername = "test"; 
        String validPassword = "1234"; 

        // Act
        boolean result = UserLogin.checkPassword(validUsername, validPassword);

        // Assert
        assertTrue(result, "Password should be valid for the given username");
    }
}
