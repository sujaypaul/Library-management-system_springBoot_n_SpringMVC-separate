package com.nagarro.training.advanceJavaAssignment5_2.user;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.nagarro.training.advanceJavaAssignment5_2.author.Author;
import com.nagarro.training.advanceJavaAssignment5_2.author.AuthorController;
import com.nagarro.training.advanceJavaAssignment5_2.author.AuthorRepository;

@SpringBootTest
class UserRepositoryTest {

    @InjectMocks
    private UserController userController;

    @Mock
    private UserRepository userRepository;

    @Test
    public void testUser() {
        // Mock data
        Optional<User> mockUser = Optional.of(new User("testuser", "testpassword"));

        // Mocking the behavior of the authorRepository
        when(userRepository.findById("testuser")).thenReturn(mockUser);

        // Call the method in your controller

        Optional<User> resultUser = userController.getUser("testuser");

        assertEquals(mockUser, resultUser);
   
    }

}
