package com.mikko.vaestotieto.validators;

import java.util.regex.Pattern;




// ADDED JAVAX VALIDATOR TO POM
public class EmailValidator  {
	
  
    
    public static boolean patternMatches(String emailAddress, String regexPattern) {
        return Pattern.compile(regexPattern)
          .matcher(emailAddress)
          .matches();
    }
}
