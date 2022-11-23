package com.test.passwordgenerator;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import com.project.passwordgenerator.PhoneNumberValidator;

class PhoneNumberValidatorTest {

	final PhoneNumberValidator phoneNumberValidator = new PhoneNumberValidator();
	
	@Test 
	void checkLength() {
		assertFalse(phoneNumberValidator.validatePhoneNumber("76506789"));

		assertTrue(phoneNumberValidator.validatePhoneNumber("989943421"));

		assertTrue(phoneNumberValidator.validatePhoneNumber("6316783487"));

		assertFalse(phoneNumberValidator.validatePhoneNumber("85375614697"));
	}
	
	@Test
	void checkCountryCode() {
		assertTrue(phoneNumberValidator.validatePhoneNumber("+2 6316783487"));

		assertTrue(phoneNumberValidator.validatePhoneNumber("+91 989943421"));

		assertTrue(phoneNumberValidator.validatePhoneNumber("+111 9316783487"));

		assertFalse(phoneNumberValidator.validatePhoneNumber("+1234 7163445487"));
	}

	@ParameterizedTest
	@ValueSource(strings = {"+111 (202) 555 0125" , "63685 67 89" , "+91 786 555 0125"})
	void checkSpaces(String input) {
		assertTrue(phoneNumberValidator.validatePhoneNumber(input));

	//	assertTrue(phoneNumberValidator.validatePhoneNumber());

//		

	//	assertTrue(phoneNumberValidator.validatePhoneNumber());
	}
	
	@Test
	void checkSpacesFailTest() {
		assertFalse(phoneNumberValidator.validatePhoneNumber("202 555 01 25"));
	}
	
	@Test
	void checkForNull() {
		assertFalse(phoneNumberValidator.validatePhoneNumber(null));
	}
}