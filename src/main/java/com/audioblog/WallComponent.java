package com.audioblog;


import java.util.LinkedList;

public class WallComponent {
	public WallComponent(LinkedList<PostComponent> postList) {
		super();
		this.postList = postList;
	}
	

	static public LinkedList<PostComponent> postList;
	
	
	public LinkedList<PostComponent> getPostList() {
		return postList;
	}

	public void setPostList(LinkedList<PostComponent> postList) {
		this.postList = postList;
	}
	
	public void addPost(PostComponent post){
		postList.add(post);
	}
	@Override
	public String toString() {
		return "WallComponent [postList=" + postList + "]";
	}
	
}
