package br.com.pentagono.estoque.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

	@RequestMapping(value = "/", name = "indexUrl")
	public String index() {
		return "redirect:/home";
	}

	@RequestMapping(value = "/login", name = "loginUrl")
	public String login() {
		return "login";
	}
	
	@RequestMapping(value = "/home", name = "homeUrl")
	public String home() {
		return "hello";
	}

}
