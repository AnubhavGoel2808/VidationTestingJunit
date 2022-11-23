package com.test.passwordgenerator;
import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.Test;

import com.project.passwordgenerator.Password;

class PasswordTest {
	private final Password passwordWeak = new Password("abc");
	private final Password passwordGood = new Password("Abc1CDed");
	private final Password passwordAverage = new Password("abA1");
	private final Password passwordExcellent = new Password("Ab#ca1hjsbc##421a");
	private final Password password = new Password();
	
	@Test
	void checkForWeakPassword() {
		assertTrue(passwordWeak.calculateScore().contains("Weak"));
	}
	@Test
	void checkForAveragePassword() {
		assertTrue(passwordAverage.calculateScore().contains("Average"));
	}
	@Test
	void checkForGoodPassword() {
		assertTrue(passwordGood.calculateScore().contains("Good"));
	}
	@Test
	void checkForExcellentPassword() {
		assertTrue(passwordExcellent.calculateScore().contains("Excellent"));
	}
	@Test
	void checkForNoInput() {
		assertTrue(password.checkPassword("na").contains("Weak"));
	}

}
