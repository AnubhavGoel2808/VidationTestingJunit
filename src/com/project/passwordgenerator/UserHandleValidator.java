package com.project.passwordgenerator;

public class UserHandleValidator {
    final String regex = "^[a-zA-Z][a-zA-Z0-9_]{6,19}$";
    
    public boolean validateUserHandle(String s){
        if (s.matches(regex)) {
            return true;
        }
        return false;
    }
}

