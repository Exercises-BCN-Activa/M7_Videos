package com.crud.controller;

import java.util.SortedSet;

import com.crud.domain.User;
import com.crud.domain.Video;

/**
 * Final class to prevent inheritance.
 * Empty constructor without visibility modifier only to be used within the package.
 * has two methods of building Users and Videos
 * @author faunoguazina
 *
 */
final public class UserVideoFactory {
	
	UserVideoFactory() {}
	
	static User newUser(String name, String surname, String email, String password) {
		User user = new User(name, surname, email, password);
		return user;
	}
	
	static Video newVideo(String url, String title, SortedSet<String> tags, int userId) {
		Video video = new Video(url, title, tags, userId);
		return video;
	}
	
	
	

}
