package com.crud.domain;

import java.util.Calendar;

public class User {
	
	int id;
	String name, surname, password, email;
	Calendar registre;
	private static int countIdUsuaris = 1;
	

	public User(String name, String surname, String email, String password) {
		this.name = name;
		this.surname = surname;
		this.email = email;
		this.password = password;
		
		registre = Calendar.getInstance();
		
		id = countIdUsuaris;
		countIdUsuaris++;
		
	}


	public int getId() {
		return id;
	}


	public Calendar getRegistre() {
		return registre;
	}
	

	public String getName() {
		return name;
	}


	public void setName(String nom) {
		this.name = nom;
	}


	public String getSurname() {
		return surname;
	}


	public void setSurname(String cognom) {
		this.surname = cognom;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("User [id=");
		builder.append(id);
		builder.append(", name=");
		builder.append(name);
		builder.append(", surname=");
		builder.append(surname);
		builder.append(", password=");
		builder.append(password);
		builder.append(", email=");
		builder.append(email);
		builder.append(", registre=");
		builder.append(registre);
		builder.append("]");
		return builder.toString();
	}

	
}
