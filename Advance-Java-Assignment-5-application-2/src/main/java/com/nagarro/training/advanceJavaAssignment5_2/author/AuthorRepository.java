package com.nagarro.training.advanceJavaAssignment5_2.author;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Component
@Repository
public interface AuthorRepository extends CrudRepository<Author, String>{
	
}
