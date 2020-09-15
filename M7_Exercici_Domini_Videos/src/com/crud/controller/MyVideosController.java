package com.crud.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.crud.domain.Video;

public final class MyVideosController {

	private static List<Video> myVideos = new ArrayList<>();

	protected MyVideosController() {}
	
	static protected void listOf(List<Video> videos) {
		if (!myVideos.isEmpty()) {myVideos.clear();}
		int userId = LoginController.logedUser().getId();
		Iterator<Video> it = videos.iterator();
		while (it.hasNext()) {
			Video video = it.next();
			if (video.getUserId()==userId) {
				myVideos.add(video);
			}
		}
	}

	protected static List<Video> getMyVideos() {
		return myVideos;
	}

}
