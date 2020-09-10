package com.crud.persistence;
import com.crud.domain.Usuari;

import java.util.ArrayList;
import java.util.List;


public final class UsuariRepository {
	
	private static List<Usuari> usuaris = new ArrayList<>();
	
	public UsuariRepository(){
		
	}
	
	public List<Usuari> getAllUsuaris(){
		return usuaris;
	}
	
	
	public void addUsuari(Usuari usuari) throws Exception{
		if(usuari==null) throw new Exception();
		usuaris.add(usuari);
	}

}
