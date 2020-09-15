package com.crud.controller;

import com.crud.persistence.UserRepository;
import com.crud.persistence.VideoRepository;
import com.crud.utilities.Inputs;

/**
 * Responsible for public control of the entire program
 * class that controls the database repositories and contains their instances.
 * has all the public methods that use internal methods to perform tasks.
 * @author faunoguazina
 *
 */
public class UserVideoController {
	
	private final UserRepository repositUser = new UserRepository(); //user repository instance
	private final VideoRepository repositVideo = new VideoRepository(); //video repository instance
	
	public UserVideoController() {} //constructor
	
	/**
	 * new user registration method.
	 * 
	 * @throws Exception if user is empty or null prevents adding to the repository
	 */
	public void createUser() throws Exception {
		String name, surname, email, emailConfirm, password, passwordConfirm;
		
		name = Inputs.returnString("Introdueixi el nom", 0);
		
		if (!name.equalsIgnoreCase("NulL")) { //if user does not cancel input, questions the next item
			surname = Inputs.returnString("Introdueixi els cognoms", 0);
			
			if (!surname.equalsIgnoreCase("NulL")) { //if user does not cancel input, questions the next item
				email = Inputs.returnString("Introdueixi el correu electrònic", 2);
				
				if (!email.equalsIgnoreCase("NulL")) { //if user does not cancel input, questions the next item			
					
					do { //loop email confirmation
						emailConfirm = Inputs.returnString("Confirma el correu electrònic", 2);
						
						if (!email.equals(emailConfirm) && !emailConfirm.equalsIgnoreCase("NulL")) { //if user does not cancel and is not identical, 
							Inputs.showMessage("Els correus electrònics no són idèntics"); // warns that e-mail and its confirmation are not identical
						}
					} while (!email.equals(emailConfirm) && !emailConfirm.equalsIgnoreCase("NulL"));
					
					if (!emailConfirm.equalsIgnoreCase("NulL")) { //if user does not cancel input, questions the next item
						password = Inputs.returnString("Introdueixi la contrasenya", 3);
						
						if (!password.equalsIgnoreCase("NulL")) { //if user does not cancel input, questions the next item
							
							do { //loop password confirmation
								passwordConfirm = Inputs.returnString("Confirma la contrasenya", 3);
								
								if (!password.equals(passwordConfirm) && !passwordConfirm.equalsIgnoreCase("NulL")) { //if user does not cancel and is not identical,
									Inputs.showMessage("Les contrasenyas no són idèntics"); // warns that password and its confirmation are not identical
								}
							} while (!password.equals(passwordConfirm) && !passwordConfirm.equalsIgnoreCase("NulL"));
							
							if (!passwordConfirm.equalsIgnoreCase("NulL")) {//if user does not cancel input, questions the next item
								// invokes method of adding user from the manufacture of new user
								repositUser.addUser(UserVideoFactory.newUser(name, surname, email, password));
							}
						}	
					}					
				}
			}
		}	
	}

	

	/**
	 * login method
	 */
	public void login() {
		if (repositUser.getAllUsers().isEmpty()) { //checks if database is empty
			System.out.println("No hi ha cap usuari registrat!");
		} else { //invokes method that logs in by sending the user list
			LoginController.loginUser(repositUser.getAllUsers());
		}
	}
	
	/**
	 * logout method
	 */
	public void logout() {
		LoginController.logoutUser();
	}
	
	
	
	/**
	 * new video registration method.
	 * @throws Exception if video is empty or null prevents adding to the repository
	 */
	public void createVideo() throws Exception {
		if (LoginController.logedUser()==null) { //checks if user is logged in
			Inputs.showMessage("L'usuari no ha iniciat la sessió");
		}
		else {
			String url, title, tags;
			int userId;	
			
			title = Inputs.returnString("Introdueixi el títol del vídeo", 0);
			if (!title.equalsIgnoreCase("NulL")) { //if user does not cancel input, questions the next item
				tags = Inputs.returnString("Introdueixi com a mínim una etiqueta", 1);
				if (!tags.equalsIgnoreCase("NulL")) { //if user does not cancel input, proceed to the next item
					url = Inputs.returnUrl(title); //from the title creates url prefix
					userId = LoginController.logedUser().getId(); //fetch user id
					repositVideo.addVideo(UserVideoFactory.newVideo(url, title, Inputs.stringToSortedSet(tags), userId));
					
				}
			}
		}
		
	}
	
	
	
	public void listMyVideos() { ////checks if user is logged in
		if (LoginController.logedUser()==null) {
			Inputs.showMessage("L'usuari no ha iniciat la sessió");
		}
		else { //send list of videos to the method that processes the user id
			MyVideosController.listOf(repositVideo.getAllVideos());
			
			if (!MyVideosController.getMyVideos().isEmpty()) {
				
				System.out.println(MyVideosController.getMyVideos()); //prints the list if there is a video
			}
			
		}
	}
	
	
	//DATABASE TEST
	public void testeDataBase() throws Exception {		
		repositUser.addUser(UserVideoFactory.newUser("Fauno", "Guazina", "fauno@guazina.fg", "123qweA@"));
		repositUser.addUser(UserVideoFactory.newUser("Jose", "Marin", "jose@marin.jm", "123qweA@"));
		repositVideo.addVideo(UserVideoFactory.newVideo("Teste_1", "Teste 1", Inputs.stringToSortedSet("Teste, Texte"), 2));
		repositVideo.addVideo(UserVideoFactory.newVideo("Teste_2", "Teste 2", Inputs.stringToSortedSet("Teste, Texte"), 2));
		repositVideo.addVideo(UserVideoFactory.newVideo("Teste_3", "Teste 3", Inputs.stringToSortedSet("Teste, Texte"), 2));
		
	}
}
