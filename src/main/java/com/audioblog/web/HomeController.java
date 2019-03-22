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
		
		com.audioblog.user.PostComponent post = new com.audioblog.user.PostComponent("Azi", "Status", new Date(12,11,13), null);
		com.audioblog.user.PostComponent post2 = new com.audioblog.user.PostComponent("Azi ploua afara", "Status afara", new Date(12,11,13), null);
		com.audioblog.user.PostComponent post3 = new com.audioblog.user.PostComponent("Azi ploua afara", "Status afara", new Date(12,11,13), null);
		com.audioblog.user.PostComponent post4 = new com.audioblog.user.PostComponent("Azi ploua afara", "Status afara", new Date(12,11,13), null);
		
		com.audioblog.user.WallComponent wall = new com.audioblog.user.WallComponent(new LinkedList<>());
		wall.addPost(post);
		wall.addPost(post2);
		wall.addPost(post3);
		wall.addPost(post4);
		
		
		
		return wall;
	}
	
	@PostMapping
	public String postPage(){
		
		return "post";
	}
	
}