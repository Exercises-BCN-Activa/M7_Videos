package com.crud.utilities;

/**
 * Final class to prevent inheritance.
 * Empty constructor without visibility modifier only to be used within the package.
 * Class containing regex standards and error messages.
 * @author Fauno Guazina
 */
final class Pattern {
	
	/**
	 * constructor accessible only from within the package
	 */
	Pattern() {}
	
	
	/**
	 * Only accepts words of accented or not accented alphabetic characters, 
	 * in addition to special characters (·) (.) (') (-), 
	 * words must be separated by spaces, commas are not allowed
	 * @return name and title validation regex
	 */
	static String regexNames() {
		final String NAMES = "^[A-zÀ-ÿ·.\\'\\-]+((\\s)[A-zÀ-ÿ·.\\'\\-]*)*$";
		return NAMES;
	}
	
	/**
	 * Only accepts words of accented or not accented alphabetic characters, 
	 * in addition to special characters (·) (') (-),
	 * tags must be separated by commas and space (, ), 
	 * spaces between words in one tag are not allowed.
	 * @return tags validation regex
	 */
	static String regexTags() {
		final String TAGS = "^[A-zÀ-ÿ·\\'\\-]+((, )[A-zÀ-ÿ·\\'\\-]*)*$";
		return TAGS;
	}

	/**
	 * Only accepts non-accented words and utf8 characters up to the point (.).
	 * Mandatory to have at least one sign (@) and a period (.) after the @.
	 * before the sign, the text must be at least 3 characters and up to 64 characters.
	 * after the sign the words must be at least 2 characters long.
	 * @return e-mail validation regex
	 */
	static String regexEmail() {
		String EMAIL = "^([\\w-\\.]+){3,64}@([\\w&&[^_]]+){2,255}.[a-z]{2,}$";		
		return EMAIL;
	}
	
	/**
	 * Minimum length of 8 characters, at least one uppercase, 
	 * one lowercase, a number and one of these special characters 
	 * (! @ # $% <>.?: = ~ ^ _ & * À-ÿ)
	 * @return password validation regex
	 */
	static String regexPassword() {
		final String PASSWORD = "(?=^.{8,}$)(?=.*\\d)(?=.*[!@#$%<>.?:=~^_&*À-ÿ]+)(?![.\\n])(?=.*[A-Z])(?=.*[a-z]).*$";
		return PASSWORD;
	}
	
	/**
	 * @return error message if the NAME regex is not met
	 */
	static String msgErrorNames() {
		String MSG_ERROR_NAMES = "\nNo hem pogut registrar el vostre nom. Introduïu un nom vàlid,\n" +
				"com a l'exemple: D\'Marcco Puig, Pew-Wes Chong, St. Peter Jonh";
		return MSG_ERROR_NAMES;
	}
	
	/**
	 * @return error message if the TAGS regex is not met
	 */
	static String msgErrorTags() {
		String MSG_ERROR_TAGS = "\nLes etiquetes no poden contenir cap espai i\n" + 
				"han d'estar separats per comes seguida d'un espai,\n" +
				"com a l'exemple: \"tag, tag, tag-tag, T'Tag\"";
		return MSG_ERROR_TAGS;
	}
	
	/**
	 * @return error message if the EMAIL regex is not met
	 */
	static String msgErrorEmail() {
		String MSG_ERROR_TAGS = "\nCal tenir-ne almenys un @ i un punt,\n" +
				"com a l'exemple: \"nom@proveidor.go\"";
		return MSG_ERROR_TAGS;
	}
	
	/**
	 * @return error message if the PASSWORD regex is not met
	 */
	static String msgErrorPassword() {
		String MSG_ERROR_PASSWORD = "\nLa longitud de la contrasenya ha de ser superior o igual a 8\n" + 
				"La contrasenya ha de contenir un o més caràcters en majúscules\n" + 
				"La contrasenya ha de contenir un o més caràcters en minúscula\n" + 
				"La contrasenya ha de contenir un o més valors numèrics\n" + 
				"La contrasenya ha de contenir un o més caràcters especials";
		return MSG_ERROR_PASSWORD;
	}

}
