package com.audioblog;

import java.sql.Date;
import java.util.LinkedList;

public class PostComponent {
	private String text;
	private String title;
	private Date date;
	private LinkedList<CommentsComponent> comments;
}
