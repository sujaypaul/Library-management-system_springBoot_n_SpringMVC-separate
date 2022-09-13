package com.nagarro.training.advanceJavaAssignment5_2.user;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
	
	@Autowired
	private UserRepository userRepository;
	
	@RequestMapping("user/{id}")
	public Optional<User> getUser(@PathVariable String id) {
		return userRepository.findById(id);
	}
	
	@RequestMapping(method=RequestMethod.POST, value="user/") 
	public void addUser(@RequestBody User user) {
		userRepository.save(user);
	}
	
	@RequestMapping(method=RequestMethod.PUT, value="user/{id}")
	public void updateBook(@RequestBody User user) {
//		bookService.updateBook(book);
		userRepository.save(user);
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="user/{id}")
	public void deleteBook(@PathVariable String id) {
		userRepository.deleteById(id);
	}

}
