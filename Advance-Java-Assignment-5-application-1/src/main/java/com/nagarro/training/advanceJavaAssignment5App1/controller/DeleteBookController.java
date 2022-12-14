package com.nagarro.training.advanceJavaAssignment5App1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.nagarro.training.advanceJavaAssignment5App1.apiHandler.DeleteBookAPI;

@Controller
public class DeleteBookController {
	
	@RequestMapping(value = "delete")
	public String delete(@RequestParam("Id") String code) {
		
		DeleteBookAPI deleteBookAPI = new DeleteBookAPI();
		deleteBookAPI.deleteBook(code);
		
		System.out.println("Book with code: "+ code+" was deleted");

		return "redirect:home";
	}
}
