package com.nagarro.training.advanceJavaAssignment5App1.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.WebRequest;

import com.nagarro.training.advanceJavaAssignment5App1.apiHandler.AddBookAPI;
import com.nagarro.training.advanceJavaAssignment5App1.apiHandler.AllBooksAPI;
import com.nagarro.training.advanceJavaAssignment5App1.apiHandler.AuthorsAPI;
import com.nagarro.training.advanceJavaAssignment5App1.model.Author;
import com.nagarro.training.advanceJavaAssignment5App1.model.Book;
import com.nagarro.training.advanceJavaAssignment5App1.model.User;

@Controller
public class AddBookController {

	@RequestMapping(value = "addBook", method = RequestMethod.POST)
	public String addBookPage(Model model, WebRequest request) {

		if (request.getAttribute("usr", WebRequest.SCOPE_SESSION) == null) {
			return "redirect:login";
		}

		List<Author> authors = AuthorsAPI.getAuthors();
		model.addAttribute("authors", authors);

		return "addBook";
	}

	@RequestMapping(value = "cancel", method = RequestMethod.POST)
	public String cancel(WebRequest request) {
		if (request.getAttribute("usr", WebRequest.SCOPE_SESSION) == null) {
			return "redirect:loginpage";
		}
		return "redirect:home";
	}

	@PostMapping(value = "add")
	public String update(Model model,@ModelAttribute("book") @Valid Book book) {
		
		AddBookAPI.addBook(book);

		return "redirect:home";
	}
}
