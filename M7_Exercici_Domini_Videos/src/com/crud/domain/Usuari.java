package com.crud.domain;

import java.util.Calendar;

public class Usuari {
	
	int id;
	String nom, cognom, password;
	Calendar registre;
	private static int countIdUsuaris = 1;
	

	public Usuari(String nom, String cognom, String password) {
		this.nom = nom;
		this.cognom = cognom;
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
	

	public String getNom() {
		return nom;
	}


	public void setNom(String nom) {
		this.nom = nom;
	}


	public String getCognom() {
		return cognom;
	}


	public void setCognom(String cognom) {
		this.cognom = cognom;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}

	
}
