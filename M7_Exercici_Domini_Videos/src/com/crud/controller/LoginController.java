package com.crud.controller;

import java.util.Iterator;
import java.util.List;

import com.crud.utilities.Inputs;
import com.crud.domain.User;

public final class LoginController {
	
	private static User user = null;
	
	protected LoginController() {}
	
	
	static protected void loginUser(List<User> users) {
		String email, password;
		boolean finded = false;
		boolean verify = false;
		Iterator<User> it = users.iterator();	

		if (!users.isEmpty()) {
			email = Inputs.returnString("INICI DE SESSIÓ:\nIntrodueixi el correu electrònic", 2);
			if (!email.equalsIgnoreCase("NulL")) {
				while (it.hasNext() && !finded) {
					User use = it.next();
					if (use.getEmail().equalsIgnoreCase(email)) {
						finded = true;
						user = use;
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
	
	static protected void logoutUser() {
		user = null;
	}
	
	static protected User logedUser() {
		return user;
	}

}
