package com.crud.domain;

import java.util.SortedSet;
import java.util.TreeSet;

public class Video {
	
	int id;
	String url, title;
	SortedSet<String> tags = new TreeSet<String>();
	int userId;
	
	private static int countIdVideo = 1;

	public Video(String url, String title, SortedSet<String> tags, int userId) {
		this.url = url;
		this.title = title;
		this.tags = tags;
		this.userId = userId;

		id = countIdVideo;
		countIdVideo++;
	}

	
	public int getId() {
		return id;
	}
	
	public int getUserId() {
		return userId;
	}
	
	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String títol) {
		this.title = títol;
	}

	public SortedSet<String> getTags() {
		return tags;
	}

	public void setTags(SortedSet<String> tags) {
		this.tags = tags;
	}
	
	public void addTag(String tag) {
		tags.add(tag);
	}

	public void addTags(SortedSet<String> tags) {
		this.tags.addAll(tags);
	}
}
