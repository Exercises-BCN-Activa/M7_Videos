package com.crud.view;

import com.crud.controller.UserVideoController;

public class MainApp {

	public static void main(String[] args) throws Exception {
		
		UserVideoController controller = new UserVideoController();
		
		controller.login();
		controller.createUser();
		controller.createVideo();
		controller.login();
		controller.createVideo();
		controller.logout();

	}

}
