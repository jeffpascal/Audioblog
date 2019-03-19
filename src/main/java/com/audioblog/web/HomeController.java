package com.audioblog.web;

import java.util.LinkedList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.audioblog.PostComponent;
import com.audioblog.WallComponent;

//Because HomeController is annotated with @Controller, 
//Spring’s component scanning automatically discovers it and creates an 
//instance of HomeController as a bean in the Spring application context.
@Controller
public class HomeController {
	
	//HTTP GET request is received for the root path /, then this method handles that request
	@GetMapping("/")
	public String home(Model model){
		
		LinkedList<PostComponent> postList = WallComponent.postList;
		System.out.println(postList);
		for(PostComponent post : postList){
			model.addAttribute(post.getTitle(), post.getText());
		}
		
		System.out.println(model.toString());
		
		return "home";
	}
	
	@PostMapping
	public String postPage(){
		
		return "post";
	}
	
}