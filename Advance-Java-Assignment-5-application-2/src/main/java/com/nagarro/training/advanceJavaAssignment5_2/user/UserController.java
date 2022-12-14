package com.nagarro.training.advanceJavaAssignment5_2.user;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

	@Autowired
	private UserRepository userRepository;

	@RequestMapping("user/{id}")
	public Optional<User> getUser(@PathVariable String id) {
		return userRepository.findById(id);
	}

}
