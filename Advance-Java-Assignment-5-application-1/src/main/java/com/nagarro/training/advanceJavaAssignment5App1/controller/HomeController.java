package com.nagarro.training.advanceJavaAssignment5App1.controller;



import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.WebRequest;

import com.nagarro.training.advanceJavaAssignment5App1.apiHandler.AllBooksAPI;
import com.nagarro.training.advanceJavaAssignment5App1.model.Book;


@Controller
public class HomeController {

	
	@RequestMapping(value = "home", method = {RequestMethod.POST,RequestMethod.GET})
	public String home(Model model, WebRequest request) {

		if (request.getAttribute("usr", WebRequest.SCOPE_SESSION) == null) {
			return "redirect:loginpage";
		}
		
		List<Book> books = AllBooksAPI.getAllBooks();
		model.addAttribute("books", books);
		
		
		return "home";
			
	}
}
