package com.nagarro.training.advanceJavaAssignment5_2.book;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import com.nagarro.training.advanceJavaAssignment5_2.author.Author;

public class BookServiceTest {
	
	@Test
    void getAllBooks_shouldReturnBookList() {
        // Arrange
        BookRepository bookRepository = Mockito.mock(BookRepository.class);
        BookService bookService = new BookService(bookRepository);

        List<Book> mockBooks = Arrays.asList(
                new Book("B1", "Book 1", new Author("Author 1"), "2023-01-01"),
                new Book("B2", "Book 2", new Author("Author 2"), "2023-01-02")
        );

        Mockito.when(bookRepository.findAll()).thenReturn(mockBooks);

        // Act
        List<Book> result = bookService.getAllBooks();

        // Assert
        Assertions.assertEquals(mockBooks, result);
    }

    @Test
    void getBook_shouldReturnSelectedBookById() {
        // Arrange
        BookRepository bookRepository = Mockito.mock(BookRepository.class);
        BookService bookService = new BookService(bookRepository);

        Book mockBook = new Book("B1", "Book 1", new Author("Author 1"), "2023-01-01");
        Mockito.when(bookRepository.findById("B1")).thenReturn(Optional.of(mockBook));

        // Act
        Optional<Book> result = bookService.getBook("B1");

        // Assert
        Assertions.assertEquals(Optional.of(mockBook), result);
    }

    @Test
    void addBook_shouldAddBook() {
        // Arrange
        BookRepository bookRepository = Mockito.mock(BookRepository.class);
        BookService bookService = new BookService(bookRepository);

        Book bookToAdd = new Book("B3", "Book 3", new Author("Author 3"), "2023-01-03");

        // Act
        bookService.addBook(bookToAdd);

        // Assert
        verify(bookRepository, times(1)).save(bookToAdd);
    }

    @Test
    void updateBook_shouldUpdateBook() {
        // Arrange
        BookRepository bookRepository = Mockito.mock(BookRepository.class);
        BookService bookService = new BookService(bookRepository);

        Book bookToUpdate = new Book("B1", "Updated Book", new Author("Author 1"), "2023-01-01");

        // Act
        bookService.updateBook(bookToUpdate);

        // Assert
        verify(bookRepository, times(1)).save(bookToUpdate);
    }

    @Test
    void deleteBook_shouldDeleteBook() {
        // Arrange
        BookRepository bookRepository = Mockito.mock(BookRepository.class);
        BookService bookService = new BookService(bookRepository);

        String bookIdToDelete = "B2";

        // Act
        bookService.deleteBook(bookIdToDelete);

        // Assert
        verify(bookRepository, times(1)).deleteById(bookIdToDelete);
    }

}
