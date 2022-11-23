package com.test.passwordgenerator;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import com.project.passwordgenerator.Alphabet;
import com.project.passwordgenerator.Generator;
import com.project.passwordgenerator.Password;

class GeneratorTest {
	
	private final Password password= new Password("Secret");
	private final Alphabet firstAlphabet = new Alphabet(true,false,false,false);
	private final Alphabet secondAlphabet = new Alphabet(false,true,true,true);
	
	@Test
	void testOverrideString() {
		assertEquals("Secret", password.toString());
	}

	@Test
	void testPoolCreationLength() {
		assertEquals(firstAlphabet.getAlphabet().length(), 26);
	}

	@Test
	void testPoolCreation() {
		assertEquals(secondAlphabet.getAlphabet(), Alphabet.LOWERCASE_LETTERS + Alphabet.NUMBERS + Alphabet.SYMBOLS);
	}
	
	@Test
	void testRequestPassword() {
		Generator gen = new Generator("1 0 0 0 8");
		assertEquals(gen.requestPassword().length(),8);
	}
	
	@Test
	void testRequestPasswordUpperCase() {
		Generator gen = new Generator("0 1 0 0 8");
		String s = gen.requestPassword();
		System.out.println(s);
		for(char c : s.toCharArray()) {
			assertTrue((c) >= 'A' && (c) <= 'Z');
		}
	}
	@Test
	void testRequestPasswordLowerCase() {
		Generator gen = new Generator("1 0 0 0 8");
		String s = gen.requestPassword();
		for(char c : s.toCharArray()) {
			assertTrue(c >= 'a' && (c ) <= 'z');
		}
	}
	@Test
	void testRequestPasswordNumber() {
		Generator gen = new Generator("0 0 1 0 8");
		String s = gen.requestPassword();
		for(char c : s.toCharArray()) {
			assertTrue((c - '0') >= 0 && (c - '0') <= 9);
		}
	}
	@Test
	void testRequestPasswordSymbol() {
		Generator gen = new Generator("0 0 0 1 8");
		String s = gen.requestPassword();
		for(char c : s.toCharArray()) {
			assertTrue(!Character.isLetter(c));
		}
	}
	@Test
	void testRequestPasswordForNoSelectionAtFirst() {
		Generator gen = new Generator("0 0 0 0 1 1 1 1 8");
		assertEquals(gen.requestPassword().length(),8);
	}
	
	@Disabled
	void test4() {
		assertEquals(firstAlphabet.getAlphabet().length(), 27);
	}

}
