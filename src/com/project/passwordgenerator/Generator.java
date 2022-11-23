package com.project.passwordgenerator;
import java.util.Scanner;

public class Generator {
    public Alphabet alphabet;
    public static Scanner keyboard;

    public Generator(String sc) {
    	if(sc == null)
    		keyboard = new Scanner(System.in);
    	else
    		keyboard = new Scanner(sc);
    }

    public void createPool(boolean IncludeUpper, boolean IncludeLower, boolean IncludeNum, boolean IncludeSym) {
        alphabet = new Alphabet(IncludeUpper, IncludeLower, IncludeNum, IncludeSym);
    }

 

    private Password GeneratePassword(int length) {
        final StringBuilder pass = new StringBuilder("");

        final int alphabetLength = alphabet.getAlphabet().length();

        int max = alphabetLength - 1;
        int min = 0;
        int range = max - min + 1;

        for (int i = 0; i < length; i++) {
            int index = (int) (Math.random() * range) + min;
            pass.append(alphabet.getAlphabet().charAt(index));
        }

        return new Password(pass.toString());
    }

    public String requestPassword() {
        boolean IncludeUpper = false;
        boolean IncludeLower = false;
        boolean IncludeNum = false;
        boolean IncludeSym = false;

        boolean correctParams = false;

        System.out.println();
        System.out.println("Hello, welcome to the Password Generator :) answer"
                + " the following questions by Yes(1) or No(0) \n");

        do {
            System.out.println("Do you want Lowercase letters \"abcd...\" to be used? ");
            int input = keyboard.nextInt();

            if (input == 1) IncludeLower = true;

            System.out.println("Do you want Uppercase letters \"ABCD...\" to be used? ");
            input = keyboard.nextInt();

            if (input == 1) IncludeUpper = true;

            System.out.println("Do you want Numbers \"1234...\" to be used? ");
            input = keyboard.nextInt();

            if (input == 1) IncludeNum = true;

            System.out.println("Do you want Symbols \"!@#$...\" to be used? ");
            input = keyboard.nextInt();

            if (input == 1) IncludeSym = true;

            //No Pool Selected
            if (!IncludeUpper && !IncludeLower && !IncludeNum && !IncludeSym) {
                System.out.println("You have selected no characters to generate your " +
                        "password at least one of your answers should be Yes");
                correctParams = true;
            }else {
            	correctParams = false;
            }

           
        } while (correctParams);
        System.out.println("Great! Now enter the length of the password");
        int length = keyboard.nextInt();

        createPool(IncludeUpper, IncludeLower, IncludeNum, IncludeSym);
        final Password password = GeneratePassword(length);
        return password.toString();
    }

}
