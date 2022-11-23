package com.test.passwordgenerator;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import com.project.passwordgenerator.EmailValidation;

class EmailValidationTest {
	private final EmailValidation email  = new EmailValidation();
	
	@Test
	public void checkForEmailIdIsNull() {
		assertFalse(email.emailValidator(null));
	}
	@ParameterizedTest
	@ValueSource(strings = {"abc.xyz" , "abc@@gmail.com" , "abc@gmail" , "abc@.com"})
	public void checkForEmailIdIsWrong(String input) {
		assertFalse(email.emailValidator(input));
	}
	@Test
	public void checkForEmailIdIsRight() {
		assertTrue(email.emailValidator("dk69425@gmail.com"));
	}

}
