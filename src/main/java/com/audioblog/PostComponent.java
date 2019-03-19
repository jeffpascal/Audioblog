package com.audioblog;

import java.sql.Date;
import java.util.LinkedList;

public class PostComponent {
	public PostComponent(String text, String title, Date date) {
		super();
		this.text = text;
		this.title = title;
		this.date = date;
	}
	private String text;
	private String title;
	private Date date;
	private LinkedList<CommentsComponent> comments;
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
	public LinkedList<CommentsComponent> getComments() {
		return comments;
	}
	public void setComments(LinkedList<CommentsComponent> comments) {
		this.comments = comments;
	}
}
