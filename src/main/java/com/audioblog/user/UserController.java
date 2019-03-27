package com.audioblog.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

//Because HomeController is annotated with @Controller, 
//Spring’s component scanning automatically discovers it and creates an 
//instance of HomeController as a bean in the Spring application context.
@RestController
public class UserController {
	
	@Autowired
	private UserRepository userService;
	
	@Autowired
	private PostRepository postService;
	
	//HTTP GET request is received for the root path /, then this method handles that request
	@GetMapping(path = "/users")
	public List<User> getAllUsers() {
		return userService.findAll();
	}
	
	
	@GetMapping(path="/posts")
	public List<Post> getAllPosts(){
		return postService.findAll();
	}
	
	@PostMapping
	public String postPage(){
		
		return "post";
	}
	
}