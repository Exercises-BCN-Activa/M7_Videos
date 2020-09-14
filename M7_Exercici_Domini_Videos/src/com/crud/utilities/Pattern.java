package com.crud.utilities;

final class Pattern {
	
	protected Pattern() {}
	
	
	static protected String regexNames() {
		final String NAMES = "^[A-zÀ-ÿ·.\\'\\-]+((\\s)[A-zÀ-ÿ·.\\'\\-]*)*$";
		return NAMES;
	}
	
	static protected String regexTags() {
		final String TAGS = "^[A-zÀ-ÿ·\\'\\-]+((, )[A-zÀ-ÿ·\\'\\-]*)*$";
		return TAGS;
	}

	static protected String regexEmail() {
		String EMAIL = "^([\\w-\\.]+){1,64}@([\\w&&[^_]]+){2,255}.[a-z]{2,}$";		
		return EMAIL;
	}
	
	static protected String regexPassword() {
		final String PASSWORD = "(?=^.{8,}$)(?=.*\\d)(?=.*[!@#$%<>.?:=~^_&*À-ÿ]+)(?![.\\n])(?=.*[A-Z])(?=.*[a-z]).*$";
		return PASSWORD;
	}
	
	static protected String msgErrorNames() {
		String MSG_ERROR_NAMES = "\nNo hem pogut registrar el vostre nom. Introduïu un nom vàlid,\n" +
				"com a l'exemple: D\'Marcco Puig, Pew-Wes Chong, St. Peter Jonh";
		return MSG_ERROR_NAMES;
	}
	
	static protected String msgErrorTags() {
		String MSG_ERROR_TAGS = "\nLes etiquetes no poden contenir cap espai i\n" + 
				"han d'estar separats per comes seguida d'un espai,\n" +
				"com a l'exemple: \"tag, tag, tag-tag, T'Tag\"";
		return MSG_ERROR_TAGS;
	}
	
	static protected String msgErrorEmail() {
		String MSG_ERROR_TAGS = "\nCal tenir-ne almenys un @ i un punt,\n" +
				"com a l'exemple: \"nom@proveidor.go\"";
		return MSG_ERROR_TAGS;
	}
	
	static protected String msgErrorPassword() {
		String MSG_ERROR_PASSWORD = "\nLa longitud de la contrasenya ha de ser superior o igual a 8\n" + 
				"La contrasenya ha de contenir un o més caràcters en majúscules\n" + 
				"La contrasenya ha de contenir un o més caràcters en minúscula\n" + 
				"La contrasenya ha de contenir un o més valors numèrics\n" + 
				"La contrasenya ha de contenir un o més caràcters especials";
		return MSG_ERROR_PASSWORD;
	}

}
