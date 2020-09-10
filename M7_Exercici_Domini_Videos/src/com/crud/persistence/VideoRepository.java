package com.crud.persistence;
import com.crud.domain.Video;

import java.util.ArrayList;
import java.util.List;


public class VideoRepository {
	
private static List<Video> videos=new ArrayList<>();
	
	public VideoRepository(){
		
	}
	
	public List<Video> getAllVideos(){
		return videos;
	}
	
	
	public void addMember(Video video) throws Exception{
		if(video==null) throw new Exception();
		videos.add(video);
	}

}
