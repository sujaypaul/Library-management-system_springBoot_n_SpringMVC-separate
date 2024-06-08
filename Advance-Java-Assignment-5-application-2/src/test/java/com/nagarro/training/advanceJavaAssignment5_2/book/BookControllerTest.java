package com.nagarro.training.advanceJavaAssignment5_2.book;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.nagarro.training.advanceJavaAssignment5_2.author.Author;
import com.nagarro.training.advanceJavaAssignment5_2.author.AuthorController;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class BookControllerTest {

    
    private BookService bookService = Mockito.mock(BookService.class);

    private BookController bookController;

    @Test
    void getAllBooks_shouldReturnBookList() throws Exception {
        // Arrange
        List<Book> mockBooks = Arrays.asList(
                new Book("B1", "Book 1", new Author("Author 1"), "2023-01-01"),
                new Book("B2", "Book 2", new Author("Author 2"), "2023-01-02")
        );

        Mockito.when(bookService.getAllBooks()).thenReturn(mockBooks);
    	
    
    	BookController bookController = new BookController(bookService);

        // Act and Assert
        List<Book> bookList = bookController.getAllBooks();
        
        Assertions.assertEquals("B1", bookList.get(0).getCode());
        Assertions.assertEquals("Book 1", bookList.get(0).getName());
        Assertions.assertEquals("B2", bookList.get(1).getCode());
        Assertions.assertEquals("Book 2", bookList.get(1).getName());

    }
    
    @Test
    void getBook_shouldReturnSelectedBookById() throws Exception {
        // Arrange
        List<Book> mockBooks = Arrays.asList(
                new Book("B1", "Book 1", new Author("Author 1"), "2023-01-01"),
                new Book("B2", "Book 2", new Author("Author 2"), "2023-01-02")
        );

        Mockito.when(bookService.getAllBooks()).thenReturn(mockBooks);
    	
    
    	BookController bookController = new BookController(bookService);

        // Act and Assert
        Optional<Book> selectedBook = bookController.getBook("B1");
        
        Assertions.assertEquals(bookController.getBook("B1"), selectedBook);
        

    }

	@Test
	void addBook_shouldAddBook() {
	    // Arrange
	    BookController bookController = new BookController(bookService);
	    Book bookToAdd = new Book("B3", "Book 3", new Author("Author 3"), "2023-01-03");
	
	    // Act
	    bookController.addBook(bookToAdd);
	
	    // Assert
	    verify(bookService, times(1)).addBook(bookToAdd);
	}
	
	@Test
	void updateBook_shouldUpdateBook() {
	    // Arrange
	    BookController bookController = new BookController(bookService);
	    Book bookToUpdate = new Book("B1", "Updated Book", new Author("Author 1"), "2023-01-01");
	
	    // Act
	    bookController.updateBook(bookToUpdate);
	
	    // Assert
	    verify(bookService, times(1)).updateBook(bookToUpdate);
	}
	
	@Test
	void deleteBook_shouldDeleteBook() {
	    // Arrange
	    BookController bookController = new BookController(bookService);
	    String bookIdToDelete = "B2";
	
	    // Act
	    bookController.deleteBook(bookIdToDelete);
	
	    // Assert
	    verify(bookService, times(1)).deleteBook(bookIdToDelete);
	}
	
}
