package com.crud.domain;

import java.util.SortedSet;
import java.util.TreeSet;

public class Video {
	
	int id;
	String url, títol;
	SortedSet<String> tags = new TreeSet<String>();
	int usuariId;
	
	private static int countIdVideo = 1;

	public Video(String url, String títol, SortedSet<String> tags, Usuari usuari) {
		this.url = url;
		this.títol = títol;
		this.tags = tags;
		usuariId = usuari.getId();

		id = countIdVideo;
		countIdVideo++;
	}

	
	public int getId() {
		return id;
	}
	
	public int getUsuariId() {
		return usuariId;
	}
	
	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getTítol() {
		return títol;
	}

	public void setTítol(String títol) {
		this.títol = títol;
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
