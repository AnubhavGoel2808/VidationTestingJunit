package com.test.passwordgenerator;

import org.junit.jupiter.api.Test;

import com.project.passwordgenerator.Main;

class MainFlow {

	@Test
	void test() {
		String[] args = new String[2];
		args[0] = "null";
		args[1] = "0";
		Main.main(args);
	}

}
