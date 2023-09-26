package com.mikko.vaestotieto.validators;

import java.util.regex.Pattern;

// SIMPLE UTILITY CLASS THAT PROVIDES A METHOD CALLED "PATTERNMATCHES"
// RETURNS TRUE IF EMAIL ADDRESS MATCHES THE PATTERN
public class EmailValidator {

	public static boolean patternMatches(String emailAddress, String regexPattern) {
		return Pattern.compile(regexPattern).matcher(emailAddress).matches();
	}
}
