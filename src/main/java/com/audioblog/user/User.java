package com.audioblog.user;

import java.util.Date;

import org.springframework.data.annotation.Id;

public class User {
	
	@Id
	private int id;
	private String name;
	private Date birthDate;
	
	
}
