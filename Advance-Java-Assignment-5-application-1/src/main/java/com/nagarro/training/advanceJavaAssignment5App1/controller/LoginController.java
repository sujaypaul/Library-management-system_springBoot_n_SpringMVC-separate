package com.nagarro.training.advanceJavaAssignment5App1.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.context.request.WebRequest;

import com.nagarro.training.advanceJavaAssignment5App1.apiHandler.UserLogin;
import com.nagarro.training.advanceJavaAssignment5App1.model.User;


@Controller
@SessionAttributes("usr")
public class LoginController {
	
	@RequestMapping(value = "loginpage", method = RequestMethod.GET)
	public String show(Model model) {
		model.addAttribute("ver", new User());
		return "login";
	}
	

	@RequestMapping(value = "login", method = {RequestMethod.POST,RequestMethod.GET})
	public String verify(@ModelAttribute("ver") @Valid User login, BindingResult result, Model model, WebRequest request) {

		
		String username = login.getUsername();
		if ( UserLogin.checkUsername(username) ) {
			
			if( UserLogin.checkPassword(username, login.getPassword()) ) {
				model.addAttribute("usr", username); 
				System.out.println("login success....");
				return "redirect:home";
			}
			else {
				model.addAttribute("msg","Password is Incorrect");
				System.out.println("login failed....");

				return "login";
			}
			
			
		}
		else {
			model.addAttribute("msg","username not found");
			System.out.println("login failed....");

			return "login";
		}
	}

}

