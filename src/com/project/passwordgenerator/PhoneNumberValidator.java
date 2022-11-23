package com.project.passwordgenerator;

import java.util.regex.Pattern;

public class PhoneNumberValidator {
	String patterns = 
			"^(\\+\\d{1,3}( )?)?((\\(\\d{3}\\))|\\d{3})[- .]?\\d{3}[- .]?\\d{4}$" 
		    + "|^(\\+\\d{1,3}( )?)?(\\d{3}[ ]?){2}\\d{3}$" 
		    + "|^(\\+\\d{1,3}( )?)?(\\d{3}[ ]?)(\\d{2}[ ]?){2}\\d{2}$";
	
	public boolean validatePhoneNumber(String phoneNumber) {
		Pattern pattern = Pattern.compile(patterns);
		
		if(phoneNumber == null)
			return false;
		//System.out.print(pattern.matcher(phoneNumber).matches());
		return pattern.matcher(phoneNumber).matches();
	}
}
