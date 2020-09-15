package com.crud.view;

import com.crud.controller.UserVideoController;

public class MainApp {

	public static void main(String[] args) throws Exception {
		
		UserVideoController controller = new UserVideoController();
		
		controller.testeDataBase(); //simple data to test
		controller.login(); //to test when user does not log in
		controller.listMyVideos(); //to test when user does not log in
		controller.login(); //EMAIL: jose@marin.jm | PASS: 123qweA@
		controller.listMyVideos(); //jose's video listing
		controller.logout(); // logout user Jose
		controller.createUser(); //create new user
		controller.createVideo(); //create new video without being logged in
		controller.login(); //login new user
		controller.createVideo();  //create new video logged with new user
		controller.listMyVideos(); //new user's video listing
		controller.logout(); // logout user New User

	}

}
