package com.audioblog;

import java.awt.List;
import java.util.LinkedList;

public class WallComponent {
	LinkedList<PostComponent> postList;
	
	public LinkedList<PostComponent> getPostList() {
		return postList;
	}

	public void setPostList(LinkedList<PostComponent> postList) {
		this.postList = postList;
	}
	
}
