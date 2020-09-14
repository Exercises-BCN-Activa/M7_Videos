package com.crud.persistence;
import com.crud.domain.User;

import java.util.ArrayList;
import java.util.List;


public final class UserRepository {
	
	private static List<User> users = new ArrayList<>();
	
	public UserRepository(){
		
	}
	
	public List<User> getAllUsers(){
		return users;
	}
	
	
	public void addUser(User user) throws Exception{
		if(user==null) throw new Exception();
		users.add(user);
	}

}
