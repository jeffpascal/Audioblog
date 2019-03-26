package com.audioblog.user;


import java.util.LinkedList;

import org.springframework.beans.factory.annotation.Autowired;

public class WallComponent {
	
	public WallComponent(LinkedList<Post> postList) {
		super();
		this.postList = postList;
	}
	
	@Autowired
	public LinkedList<Post> postList;
	
	
	public LinkedList<Post> getPostList() {
		return postList;
	}

	public void setPostList(LinkedList<Post> postList) {
		this.postList = postList;
	}
	
	public void addPost(Post post){
		postList.add(post);
	}
	@Override
	public String toString() {
		return "WallComponent [postList=" + postList + "]";
	}
	
}
