package com.project.passwordgenerator;

import java.util.Scanner;

public class Main {

    public static Scanner keyboard = new Scanner(System.in);

    public static void main(String[] args) {
    	if(args.length > 1)
    		keyboard = new Scanner(args[1]);
    	printMenu();
    	mainLoop();
        keyboard.close();
    }
    
    private static void printMenu() {
        System.out.println();
        System.out.println("Enter 1 - Password Generator");
        System.out.println("Enter 2 - Password Strength Check");
        System.out.println("Enter 3 - Email Validator");
        System.out.println("Enter 4 - UserName Validator");
        System.out.println("Enter 5 - Phone number Validator");
        System.out.println("Enter 0 - Quit");
        System.out.print("Choice:");
    }

    public static void mainLoop() {
        String userOption = "-1";

        while (!userOption.equals("0")) {

            userOption = keyboard.next();

            switch (userOption) {
                case "1" -> {
                	Generator generator = new Generator(null);
                	String s = generator.requestPassword();
                	System.out.println("Generated Password -> " + s);
                    printMenu();
                }
                case "2" -> {
                    Password password = new Password();
                    String s = password.checkPassword(null);
                    System.out.println("Result : " + s);
                    printMenu();
                }
                case "3" -> {
                	System.out.println("Enter email id to Validate : ");
                	keyboard.nextLine();
                	String s = keyboard.nextLine();
                	EmailValidation emailValidation = new EmailValidation();
                	Boolean ans = emailValidation.emailValidator(s);
                	System.out.println("Email is " + ((ans == true) ?"Valid":"Invalid"));
                    printMenu();
                }
                case "4" -> {
                	System.out.println("Enter userhandle to Validate : ");
                	keyboard.nextLine();
                	String s = keyboard.nextLine();
                	UserHandleValidator user = new UserHandleValidator();
                	Boolean ans = user.validateUserHandle(s);
                	System.out.println("UserHandle is " + ((ans == true) ?"Valid":"Invalid"));
                    printMenu();
                }
                case "5" -> {
                	System.out.println("Enter phoneNumber to Validate : ");
                	keyboard.nextLine();
                	String s = keyboard.nextLine();
                	PhoneNumberValidator phone = new PhoneNumberValidator();
                	Boolean ans = phone.validatePhoneNumber(s);
                	System.out.println("PhoneNumber is " + ((ans == true) ?"Valid":"Invalid"));
                    printMenu();
                }
                case "0" -> {
                	System.out.println("Exit");
                }
                default -> {
                    System.out.println();
                    System.out.println("Kindly select one of the available commands");
                    printMenu();
                }
            }
        }
    }
}
