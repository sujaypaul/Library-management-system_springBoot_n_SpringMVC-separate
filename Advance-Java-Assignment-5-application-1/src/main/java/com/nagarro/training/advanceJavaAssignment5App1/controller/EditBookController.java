package com.nagarro.training.advanceJavaAssignment5App1.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.WebRequest;

import com.nagarro.training.advanceJavaAssignment5App1.apiHandler.AuthorsAPI;
import com.nagarro.training.advanceJavaAssignment5App1.apiHandler.BookByIdAPI;
import com.nagarro.training.advanceJavaAssignment5App1.model.Author;

@Controller
public class EditBookController {
	
	@RequestMapping(value = "editBook", method = RequestMethod.GET)
	public String addBookPage(Model model, WebRequest request,@RequestParam("Id") String code) {

		if (request.getAttribute("usr", WebRequest.SCOPE_SESSION) == null) {
			return "redirect:login";
		} 
		
		List<Author> authors = AuthorsAPI.getAuthors();
		model.addAttribute("authors", authors);
		
		model.addAttribute("book", BookByIdAPI.getBook(code));
		return "editBook";
	}
	
	@PostMapping(value = "update")
	public String update(Model model) {

		return "redirect:home";
	}

}
