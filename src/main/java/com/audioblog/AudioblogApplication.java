package com.audioblog;

import java.sql.Date;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AudioblogApplication {

	public static void main(String[] args) {
		PostComponent post = new PostComponent("Azi ploua afara", "Status afara", new Date(12,11,13));
		PostComponent post2 = new PostComponent("Azi ploua afara", "Status afara", new Date(12,11,13));
		PostComponent post3 = new PostComponent("Azi ploua afara", "Status afara", new Date(12,11,13));
		PostComponent post4 = new PostComponent("Azi ploua afara", "Status afara", new Date(12,11,13));
		
		WallComponent wall = new WallComponent();
		wall.addPost(post);
		wall.addPost(post2);
		wall.addPost(post3);
		wall.addPost(post4);
		
		System.out.println(wall);
		SpringApplication.run(AudioblogApplication.class, args);
	}

}
