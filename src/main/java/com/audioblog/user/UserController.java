package com.audioblog.user;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

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
	
	@GetMapping(path="posts/{id}")
	public Optional<Post> getPost(@PathVariable int id) throws Exception {
		
		Optional<Post> post = postService.findById(id);
		if(!post.isPresent()) {
			throw new Exception("post not found");
		}
			
		return post;
	}
	
	@PostMapping("/posts/{id}/posts")
	public ResponseEntity<Object> createPost(@PathVariable int id ,@RequestBody Post post) throws Exception {
		Optional<User> user = userService.findById(id);
		
		if(!user.isPresent()) {
			throw new Exception("user not found");
		}
		post.setUser(user.get());
		postService.save(post);
		URI location = ServletUriComponentsBuilder
				.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(post.getId())
				.toUri();
		
		//<201 CREATED Created,[Location:"http://localhost:8080/users/4"]>
		return ResponseEntity.created(location).build();
	}
	
	@PostMapping("/users/")
	public ResponseEntity<Object> createUser(@RequestBody User user) throws Exception {
		
		userService.save(user);
		URI location = ServletUriComponentsBuilder
				//gets the current request uri /users/
				.fromCurrentRequest()
				//adds the path /{id} where id comes from 
				.path("/{id}") 
				//here you get the id
				.buildAndExpand(user.getId())
				//converts to uri
				.toUri();
		
		return ResponseEntity.created(location).build();
	}

	
}