package com.mikko.vaestotieto.validators;

import java.util.regex.Pattern;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;


// ADDED JAVAX VALIDATOR TO POM
public class EmailValidator implements ConstraintValidator<ValidEmail, String> {
	private static final String EMAIL_REGEX = "^[A-Za-z0-9+_.-]+@(.+)$";
    private static final Pattern pattern = Pattern.compile(EMAIL_REGEX);


    @Override
    public void initialize(ValidEmail constraintAnnotation) {
    }

    @Override
    public boolean isValid(String email, ConstraintValidatorContext context) {
    	if (email == null || email.trim().isEmpty()) {
            return true; 
        }

        return pattern.matcher(email).matches();
    }
}
