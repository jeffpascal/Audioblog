package com.audioblog.user;

import java.sql.Date;
import java.util.LinkedList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.Id;

public class Post {
	
	@Id
	private Integer id;
	
	private String text;
	private String title;
	private Date date;
	
	@Autowired
	private LinkedList<Comment> comments;
	
	public Post(String text, String title, Date date, String id) {
		super();
		this.text = text;
		this.title = title;
		this.date = date;
	}
	
	public Post() {
		
	}
	
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public LinkedList<Comment> getComments() {
		return comments;
	}
	public void setComments(LinkedList<Comment> comments) {
		this.comments = comments;
	}
	@Override
	public String toString() {
		return "PostComponent [text=" + text + ", title=" + title + ", date=" + date + ", comments=" + comments + "]";
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
}
