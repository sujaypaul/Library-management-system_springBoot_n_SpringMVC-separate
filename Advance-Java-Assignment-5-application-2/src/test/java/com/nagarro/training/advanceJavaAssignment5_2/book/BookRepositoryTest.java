package com.nagarro.training.advanceJavaAssignment5_2.book;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import com.nagarro.training.advanceJavaAssignment5_2.author.Author;
import com.nagarro.training.advanceJavaAssignment5_2.author.AuthorController;
import com.nagarro.training.advanceJavaAssignment5_2.author.AuthorRepository;

@SpringBootTest
class BookRepositoryTest {

    @InjectMocks
    private BookService bookService;

    @Mock
    private BookRepository bookRepository;

    @Test
    public void testGetAllBooks() {
        // Mock data
    	Book book1 = new Book("Code3", "Book3", new Author("Author3"), "2024-01-03");
        
        List<Book> mockBooks = Arrays.asList(book1);

        // Mocking the behavior of the authorRepository
        when(bookRepository.findAll()).thenReturn(mockBooks);

        // Call the method in your controller
        List<Book> result = bookService.getAllBooks();

        // Assertions
        assertEquals(1, result.size());
        assertEquals("Book3", result.get(0).getName());

    }
	@Test
	public void testGetBookById() {
	    // Mock data
	    String bookId = "Code3";
	    Book mockBook = new Book(bookId, "Book3", new Author("Author3"), "2024-01-03");
	
	    // Mocking the behavior of the bookRepository
	    when(bookRepository.findById(bookId)).thenReturn(Optional.of(mockBook));
	
	    // Call the method in your service
	    Optional<Book> result = bookService.getBook(bookId);
	
	    // Assertions
	    assertTrue(result.isPresent());
	    assertEquals("Book3", result.get().getName());
	}
	
	@Test
	public void testAddBook() {
	    // Mock data
	    Book newBook = new Book("Code4", "Book4", new Author("Author4"), "2024-01-03");

	    // Stubbing behavior
	    when(bookRepository.save(newBook)).thenReturn(newBook);

	    // Call the method in your service
	    bookService.addBook(newBook);

	    // Verify that the save method is called with the correct argument
	    verify(bookRepository).save(newBook);
	}

	
	@Test
	public void testUpdateBook() {
	    // Mock data
	    Book existingBook = new Book("Code3", "UpdatedBook", new Author("Author3"), "2024-01-03");

	    // Stubbing behavior
	    when(bookRepository.findById(existingBook.getCode())).thenReturn(Optional.of(existingBook));
	    when(bookRepository.save(existingBook)).thenReturn(existingBook);

	    // Call the method in your service
	    bookService.updateBook(existingBook);

	    // Verify that the save method is called with the correct argument
	    verify(bookRepository).save(existingBook);
	}

	
	@Test
	public void testDeleteBook() {
	    // Mock data
	    String bookId = "Code3";
	
	    // Stubbing behavior
	    doNothing().when(bookRepository).deleteById(bookId);
	
	    // Call the method in your service
	    bookService.deleteBook(bookId);
	
	    // Verify that the deleteById method is called with the correct argument
	    verify(bookRepository).deleteById(bookId);
	}
}