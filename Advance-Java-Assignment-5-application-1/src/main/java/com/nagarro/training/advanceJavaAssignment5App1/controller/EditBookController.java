package com.nagarro.training.advanceJavaAssignment5App1.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.WebRequest;

import com.nagarro.training.advanceJavaAssignment5App1.apiHandler.AuthorsAPI;
import com.nagarro.training.advanceJavaAssignment5App1.apiHandler.BookByIdAPI;
import com.nagarro.training.advanceJavaAssignment5App1.apiHandler.UpdateBookAPI;
import com.nagarro.training.advanceJavaAssignment5App1.model.Author;
import com.nagarro.training.advanceJavaAssignment5App1.model.Book;

@Controller
public class EditBookController {
	
	@RequestMapping(value = "editBook", method = RequestMethod.GET)
	public String addBookPage(Model model, WebRequest request,@RequestParam("Id") String code) {

		if (request.getAttribute("usr", WebRequest.SCOPE_SESSION) == null) {
			return "redirect:login";
		} 
		
		AuthorsAPI authorAPI = new AuthorsAPI();
		List<Author> authors = authorAPI.getAuthors();
		model.addAttribute("authors", authors);
		
		BookByIdAPI bookByIdAPI = new BookByIdAPI();
		
		model.addAttribute("book", bookByIdAPI.getBook(code));
		return "editBook";
	}
	
	@PostMapping(value = "update")
	public String update(Model model,@ModelAttribute("book") @Valid Book book) {

		UpdateBookAPI updateBookAPI = new UpdateBookAPI();
		updateBookAPI.updateBook(book);
		System.out.println("book with code "+book.getCode()+" was updated.");


		return "redirect:home";
	}

}
