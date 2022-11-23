package com.project.passwordgenerator;

import java.util.Scanner;

public class Password {
    String Value;
    int Length;

    public Password(String s) {
        Value = s;
        Length = s.length();
    }

    public Password() {
		// TODO Auto-generated constructor stub
	}

	public int CharType(char C) {
        int val;

        // Char is Uppercase Letter
        if ((int) C >= 65 && (int) C <= 90)
            val = 1;

        // Char is Lowercase Letter
        else if ((int) C >= 97 && (int) C <= 122) {
            val = 2;
        }

        // Char is Digit
        else if ((C - '0') >= 0 && (C - '0' <= 9) ) {
            val = 3;
        }

        // Char is Symbol
        else {
            val = 4;
        }

        return val;
    }

    public int PasswordStrength() {
        String s = this.Value;
        boolean UsedUpper = false;
        boolean UsedLower = false;
        boolean UsedNum = false;
        boolean UsedSym = false;
        int type;
        int Score = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            type = CharType(c);

            if (type == 1) UsedUpper = true;
            if (type == 2) UsedLower = true;
            if (type == 3) UsedNum = true;
            if (type == 4) UsedSym = true;
        }
        
        if (UsedUpper) Score += 1;
        if (UsedLower) Score += 1;
        if (UsedNum) Score += 1;
        if (UsedSym) Score += 1;
      //  System.out.println(Score);
        if (s.length() >= 8) Score += 1;
        if (s.length() >= 16) Score += 1;

        return Score;
    }

    public String calculateScore() {
        int Score = this.PasswordStrength();
      //  System.out.println(Score);
        if (Score == 6) {
            return "Excellent password";
        } else if (Score >= 4) {
            return "Good password";
        } else if (Score >= 3) {
            return "Average password";
        } else {
            return "Weak Password";
        }
    }
    
    @SuppressWarnings("resource")
	public String checkPassword(String sc) {
        String input;
        Scanner in;
        if(sc == null)
        	 in = new Scanner(System.in);
        else
        	 in = new Scanner(sc);

        System.out.print("\nEnter your password:");
        this.Value = in.nextLine();
        this.Length = Value.length();
        return calculateScore();

    }
    
    @Override
    public String toString() {
        return Value;
    }
}
