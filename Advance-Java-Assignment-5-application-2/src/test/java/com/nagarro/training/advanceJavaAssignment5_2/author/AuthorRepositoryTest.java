package com.nagarro.training.advanceJavaAssignment5_2.author;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class AuthorRepositoryTest {

    @InjectMocks
    private AuthorController authorController;

    @Mock
    private AuthorRepository authorRepository;

    @Test
    public void testGetAllAuthors() {
        // Mock data
        Author author1 = new Author("Author1");
        Author author2 = new Author("Author2");
        List<Author> mockAuthors = Arrays.asList(author1, author2);

        // Mocking the behavior of the authorRepository
        when(authorRepository.findAll()).thenReturn(mockAuthors);

        // Call the method in your controller
        List<Author> result = authorController.getAllAuthors();

        // Assertions
        assertEquals(2, result.size());
        assertEquals("Author1", result.get(0).getName());
        assertEquals("Author2", result.get(1).getName());
    }

    @Test
    public void testFindAuthorByName() {
        // Mock data
        String authorName = "Author1";
        Author mockAuthor = new Author(authorName);

        // Mocking the behavior of the authorRepository
        when(authorRepository.findById(authorName)).thenReturn(Optional.of(mockAuthor));

        // Call the method in your controller
        Optional<Author> result = authorRepository.findById(authorName);

        // Assertions
        assertEquals(mockAuthor, result.orElse(null));
    }
}
