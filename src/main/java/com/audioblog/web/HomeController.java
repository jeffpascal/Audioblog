package com.audioblog.web;

import java.sql.Date;
import java.util.LinkedList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;


//Because HomeController is annotated with @Controller, 
//Spring’s component scanning automatically discovers it and creates an 
//instance of HomeController as a bean in the Spring application context.
@RestController
public class HomeController {
	
	//HTTP GET request is received for the root path /, then this method handles that request
	@GetMapping(path = "/")
	public com.audioblog.user.WallComponent home(){
		return null;
	}
	
	@PostMapping
	public String postPage(){
		
		return "post";
	}
	
}