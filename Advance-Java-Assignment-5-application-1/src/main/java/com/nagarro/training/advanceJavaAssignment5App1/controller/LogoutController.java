package com.nagarro.training.advanceJavaAssignment5App1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.context.request.WebRequest;

@Controller
public class LogoutController {
	
	@RequestMapping(value = "logout", method = RequestMethod.POST)
	public String logout(Model model, WebRequest request, SessionStatus status) {

		status.setComplete();
		request.removeAttribute("usr", WebRequest.SCOPE_SESSION);
		return "redirect:loginpage";
	}

}
