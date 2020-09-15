package com.crud.controller;

import java.util.Iterator;
import java.util.List;

import com.crud.utilities.Inputs;
import com.crud.domain.User;

/**
 * Final class to prevent inheritance.
 * Empty constructor without visibility modifier only to be used within the package.
 * three methods, one for logging in, another for logging out and a simple get
 * @author faunoguazina
 *
 */
public final class LoginController {
	
	private static User userLogged = null;
	
	LoginController() {}
	
	
	/**
	 * @param users list of database users
	 */
	static void loginUser(List<User> users) {
		String email, password;
		boolean finded = false;
		boolean verify = false;
		User userMethod = null;
		Iterator<User> it = users.iterator();	

		if (!users.isEmpty()) { //if the list is not empty it searches for user
			email = Inputs.returnString("INICI DE SESSIÓ:\nIntrodueixi el correu electrònic", 2);
			if (!email.equalsIgnoreCase("NulL")) { //if user does not cancel input, scroll through the list
				while (it.hasNext() && !finded) {
					User userBuckle = it.next();
					if (userBuckle.getEmail().equalsIgnoreCase(email)) {
						finded = true;
						userMethod = userBuckle;
					}
				}
				
				if (finded) { //if it finds the user asks for the password
					password = Inputs.returnString("INICI DE SESSIÓ:\nIntrodueixi la contrasenya", 3);
					if (!password.equalsIgnoreCase("NulL")) { //if user does not cancel input, validates the password									
						if (userMethod.getPassword().equals(password)) { //validate the password
							verify = true;		
						}
						if (!verify) { //if the password is incorrect, notify user and log out
							userLogged = userMethod;
						} else { //if the password is incorrect, notify user and log out
							logoutUser();
							Inputs.showMessage("ERROR D'INICIACIÓ:\ncontrasenya incorrecta");
						}
					}
					
					
				} else {
					Inputs.showMessage("ERROR D'INICIACIÓ:\ncorreu electrònic no registrat");
				}
			}	
		}	
	}
	
	static void logoutUser() { //logout method
		userLogged = null;
	}
	
	static User logedUser() { // get user logged
		return userLogged;
	}

}
