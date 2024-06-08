package com.nagarro.training.advanceJavaAssignment5_2.book;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookController {
	
	
	private final BookService bookService;

	@Autowired
	public BookController(BookService bookService) {
		this.bookService = bookService;
	}

	@RequestMapping("library/books")
	public List<Book> getAllBooks() {
		return bookService.getAllBooks();
	}
	
	@RequestMapping("library/books/{id}")
	public Optional<Book> getBook(@PathVariable String id) {
		return bookService.getBook(id);
	}
	
	@RequestMapping(method=RequestMethod.POST, value="library/books/") 
	public void addBook(@RequestBody Book book) {
		bookService.addBook(book);
	}
	
	@RequestMapping(method=RequestMethod.PUT, value="library/books/{id}")
	public void updateBook(@RequestBody Book book) {
		bookService.updateBook(book);
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/library/books/{id}")
	public void deleteBook(@PathVariable String id) {
		 bookService.deleteBook(id);
	}

}
