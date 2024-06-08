package com.nagarro.training.advanceJavaAssignment5_2.user;

import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class UserControllerTest {


    @Test
    void getUser_shouldReturnSelectedUserById() {
        // Arrange
        UserRepository userRepository = Mockito.mock(UserRepository.class);
        UserController userController = new UserController(userRepository);

        User mockUser = new User("John Doe", "password");
        Mockito.when(userRepository.findById("John Doe")).thenReturn(Optional.of(mockUser));

        // Act
        Optional<User> result = userController.getUser("John Doe");

        // Assert
        Assertions.assertEquals(Optional.of(mockUser), result);
    }
    
	
}
