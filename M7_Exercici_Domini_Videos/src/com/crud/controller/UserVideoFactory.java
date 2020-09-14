package com.crud.controller;

import java.util.SortedSet;

import com.crud.domain.User;
import com.crud.domain.Video;

final public class UserVideoFactory {
	
	protected UserVideoFactory() {}
	
	static protected User newUser(String name, String surname, String email, String password) {
		User user = new User(name, surname, email, password);
		return user;
	}
	
	static protected Video newVideo(String url, String title, SortedSet<String> tags, int userId) {
		Video video = new Video(url, title, tags, userId);
		return video;
	}
	
	
	

}
