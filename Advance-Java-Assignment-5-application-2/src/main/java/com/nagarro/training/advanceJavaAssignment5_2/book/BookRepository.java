package com.nagarro.training.advanceJavaAssignment5_2.book;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, String>{
	
	public List<Book> findByAuthorName(String authorName);

}
