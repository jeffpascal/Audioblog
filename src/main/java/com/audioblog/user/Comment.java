package com.audioblog.user;

import org.springframework.data.annotation.Id;

public class Comment{
	@Id
	private Integer id;
	private User poster;
	private String name;
	
	public Comment() {
		
	}
	
	public Comment(int id, String name) {
		this.id = id;
		this.name = name;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	private String message;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
}
