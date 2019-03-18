package com.audioblog.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

//Because HomeController is annotated with @Controller, 
//Spring’s component scanning automatically discovers it and creates an 
//instance of HomeController as a bean in the Spring application context.
@Controller
public class HomeController {
	
	//HTTP GET request is received for the root path /, then this method handles that request
	@GetMapping("/")
	public String home(){
		return "home";
	}
	
}