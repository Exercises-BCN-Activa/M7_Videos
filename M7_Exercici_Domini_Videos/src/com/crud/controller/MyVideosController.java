package com.crud.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.crud.domain.Video;

/**
 * Final class to prevent inheritance.
 * Empty constructor without visibility modifier only to be used within the package.
 * has two methods, one to list the user's videos and the other to return a list of these videos
 * @author faunoguazina
 *
 */
public final class MyVideosController {

	private static List<Video> myVideos = new ArrayList<>();

	MyVideosController() {}
	
	static void listOf(List<Video> videos) {
		if (!myVideos.isEmpty()) {myVideos.clear();} // clear the list if it contains any elements
		int userId = LoginController.logedUser().getId(); //identifies the user id logged in
		Iterator<Video> it = videos.iterator(); //interactor to scroll through the list of videos
		while (it.hasNext()) { //bucle to find out which videos have the same user id
			Video video = it.next(); 
			if (video.getUserId()==userId) { 
				myVideos.add(video); //if video is found add the list to be displayed
			}
		}
	}

	static List<Video> getMyVideos() {
		return myVideos;
	}

}
