package com.crud.utilities;

import java.util.SortedSet;
import java.util.TreeSet;
import javax.swing.JOptionPane;

public class Inputs { 
	
	/**
	 * Method that invokes JOptionPane Class to jump a window 
	 * asking the user to enter information and return a string.
	 * This method does not allow the user to enter an empty input.
	 *  
	 * @param msg Message that tells the user what to insert
	 * @param option Options that define which regex will be used 
	 * to check user input (0 = NAMES | 1 = TAGS | 2 = EMAIL | 3 = PASSWORD)
	 * @return if a name in title case, if a tag in lower case, 
	 * if a password is identical to the input
	 */
	public static String returnString(String msg, int option) {
		String userInput, msgError, regexCase;
		
		switch (option) {
			case 0:
				regexCase = Pattern.regexNames();
				msgError = Pattern.msgErrorNames();
				break;
			case 1:
				regexCase = Pattern.regexTags();
				msgError = Pattern.msgErrorTags();
				break;
			case 2:
				regexCase = Pattern.regexEmail();
				msgError = Pattern.msgErrorEmail();
				break;
			case 3:
				regexCase = Pattern.regexPassword();
				msgError = Pattern.msgErrorPassword();
				break;
			default:
				regexCase = Pattern.regexPassword();
				msgError = Pattern.msgErrorPassword();
		}
		
		try {
			userInput = JOptionPane.showInputDialog(msg).trim();
			
			while (!userInput.matches(regexCase)) { 
				userInput = JOptionPane.showInputDialog(msg+msgError).trim();
			}
			
			if (regexCase.equalsIgnoreCase(Pattern.regexNames())) {
				userInput = toTitleCase(userInput);
				
			} else if (regexCase.equalsIgnoreCase(Pattern.regexTags())) {
				userInput = userInput.toLowerCase();
			}
			
		} catch (Exception e) {
			System.out.println("Inputing canceled by user");
			userInput = "NulL";
		}
		
		return userInput; 
	}
	
	
	/**
	 * Method that invokes JOptionPane Class 
	 * to jump a window that shows users a message 
	 * @param msg string you want the user to be notified of
	 */
	public static void showMessage(String msg) {
		JOptionPane.showMessageDialog(null, msg);
	}
	
	
	/**
	 * method that converts a string to TitleCase, 
	 * that is, each of the words in the string 
	 * will have the first capital letter 
	 * and all other lower case letters.
	 * @param input string you want to convert
	 * @return this same string capitalized only the first letters of each word
	 */
	public static String toTitleCase(String input) {
	    StringBuilder titleCase = new StringBuilder(input.length());
	    
	    boolean nextTitleCase = true;
	    
	    for (Character c : input.toCharArray()) {
    		if (c.equals(' ') || c.equals('-') || c.equals('\'')) {
    			nextTitleCase = true;
    		} else if (nextTitleCase) {
    			c = Character.toUpperCase(c);
    			nextTitleCase = false;
    		} else {
    			c = Character.toLowerCase(c);
    		}
    		
    		titleCase.append(c);
    	}
	    

	    return titleCase.toString();
	}
	
	public static SortedSet<String> stringToSortedSet(String input) {
		SortedSet<String> list = new TreeSet<String>();
		if (input.indexOf(", ")!=-1) {
			String [] itensInput = input.split(", ");
			for (String item : itensInput) {
				list.add(item.toLowerCase());			
			}
		}
		else {
			list.add(input.toLowerCase());
		}

		return list;		
	}
	
	public static String returnUrl(String input) {
		String url;
		
		url = input.replaceAll("·", "0");
		url = url.replaceAll("\\.", "1");
		url = url.replaceAll("\\'", "2");
		url = url.replaceAll("\\-", "3");
		url = url.replaceAll(" ", "_");
		url = url.replaceAll("[aAÀÁÂÃÄÅàáâãå]", "4");
		
		return url;
		
	}

}
