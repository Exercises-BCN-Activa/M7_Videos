package com.crud.controller;

import com.crud.persistence.UserRepository;
import com.crud.persistence.VideoRepository;
import com.crud.utilities.Inputs;

public class UserVideoController {
	
	private UserRepository repositUser = new UserRepository();
	private VideoRepository repositVideo = new VideoRepository();
	
	public UserVideoController() {}
	
	public void createUser() throws Exception {
		String name, surname, email, emailConfirm, password, passwordConfirm;
		
		name = Inputs.returnString("Introdueixi el nom", 0);
		
		if (!name.equalsIgnoreCase("NulL")) {
			surname = Inputs.returnString("Introdueixi els cognoms", 0);
			
			if (!surname.equalsIgnoreCase("NulL")) {
				email = Inputs.returnString("Introdueixi el correu electrònic", 2);
				
				if (!email.equalsIgnoreCase("NulL")) {					
					
					do {
						emailConfirm = Inputs.returnString("Confirma el correu electrònic", 2);
						
						if (!email.equals(emailConfirm) && !emailConfirm.equalsIgnoreCase("NulL")) {
							Inputs.showMessage("Els correus electrònics no són idèntics");
						}
					} while (!email.equals(emailConfirm) && !emailConfirm.equalsIgnoreCase("NulL"));
					
					if (!emailConfirm.equalsIgnoreCase("NulL")) {
						password = Inputs.returnString("Introdueixi la contrasenya", 3);
						
						if (!password.equalsIgnoreCase("NulL")) {
							
							do {
								passwordConfirm = Inputs.returnString("Confirma la contrasenya", 3);
								
								if (!password.equals(passwordConfirm) && !passwordConfirm.equalsIgnoreCase("NulL")) {
									Inputs.showMessage("Les contrasenyas no són idèntics");
								}
							} while (!password.equals(passwordConfirm) && !passwordConfirm.equalsIgnoreCase("NulL"));
							
							if (!passwordConfirm.equalsIgnoreCase("NulL")) {
								repositUser.addUser(UserVideoFactory.newUser(name, surname, email, password));
							}
						}	
					}					
				}
			}
		}	
	}

	
	public void createVideo() throws Exception {
		if (LoginController.logedUser()==null) {
			Inputs.showMessage("L'usuari no ha iniciat la sessió");
		}
		else {
			String url, title, tags;
			int userId;	
			
			title = Inputs.returnString("Introdueixi el títol del vídeo", 0);
			if (!title.equalsIgnoreCase("NulL")) {
				tags = Inputs.returnString("Introdueixi com a mínim una etiqueta", 1);
				if (!tags.equalsIgnoreCase("NulL")) {
					url = Inputs.returnUrl(title);
					userId = LoginController.logedUser().getId();
					repositVideo.addVideo(UserVideoFactory.newVideo(url, title, Inputs.stringToSortedSet(tags), userId));
					
				}
			}
		}
		
	}
	
	public void login() {
		if (repositUser.getAllUsers().isEmpty()) {
			System.out.println("No hi ha cap usuari registrat!");
		} else {			
			LoginController.loginUser(repositUser.getAllUsers());
		}
	}
	
	public void logout() {
		LoginController.logoutUser();
	}
	

}
