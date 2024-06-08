package com.nagarro.training.advanceJavaAssignment5_2.book;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {


	private final BookRepository bookRepository;

	@Autowired
	public BookService(BookRepository bookRepository) {
		this.bookRepository = bookRepository;
	}


	public List<Book> getAllBooks() {
		List<Book> books = new ArrayList<>();
		bookRepository.findAll()
		.forEach(books::add);
		return books;
	}

	public Optional<Book> getBook(String id) {
		return bookRepository.findById(id);
	}

	public void addBook(Book book) {
		bookRepository.save(book);
	}

	public void updateBook(Book book) {
		bookRepository.save(book);

	}

	public void deleteBook(String id) {
		bookRepository.deleteById(id);
	}
}
