package com.crud.controller;

import com.crud.utilities.Inputs;

import java.util.Iterator;
import java.util.List;

import com.crud.domain.User;

public final class LoginController {
	
	private static User user = null;
	
	protected LoginController() {}
	
	
	static public void loginUser(List<User> users) {
		String email, password;
		boolean finded = false;
		boolean verify = false;
		Iterator<User> it = users.iterator();	

		if (!users.isEmpty()) {
			email = Inputs.returnString("INICI DE SESSIÓ:\nIntrodueixi el correu electrònic", 2);
			if (!email.equalsIgnoreCase("NulL")) {
				while (it.hasNext() && !finded) {
					if (it.next().getEmail().equalsIgnoreCase(email)) {
						finded = true;
						user = it.next();
					}
				}
				
				if (finded) {
					password = Inputs.returnString("INICI DE SESSIÓ:\nIntrodueixi la contrasenya", 3);
					if (!password.equalsIgnoreCase("NulL")) {												
						if (user.getPassword().equals(password)) {
							verify = true;		
						}
						if (verify) {
							
						}else {
							Inputs.showMessage("ERROR D'INICIACIÓ:\ncontrasenya incorrecta");
						}
					}
					
					
				} else {
					Inputs.showMessage("ERROR D'INICIACIÓ:\ncorreu electrònic no registrat");
				}
			}	
		}	
	}
	
	static public void logoutUser() {
		user = null;
	}
	
	static public User logedUser() {
		return user;
	}

}
