package com.audioblog.user;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
public class Post{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String content;
	private String title;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JsonIgnore // to prevent error from one getting the info from another
	private User user;
	
	
	public Post(){	
	}
	
	public Post(int id, String content, String title, User user, Date date) {
		super();
		this.id = id;
		this.content = content;
		this.title = title;
		this.user = user;
		this.date = date;
	}

	@Override
	public String toString() {
		return "Post [id=" + id + ", content=" + content + ", title=" + title + ", user=" + user + ", date=" + date
				+ "]";
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
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

	private Date date;
	
	
	
}