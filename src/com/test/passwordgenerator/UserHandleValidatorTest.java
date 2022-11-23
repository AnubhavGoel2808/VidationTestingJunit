package com.test.passwordgenerator;

import org.junit.jupiter.api.Test;

import com.project.passwordgenerator.UserHandleValidator;

import static org.junit.jupiter.api.Assertions.*;

class UserHandleValidatorTest {
    final UserHandleValidator userHandleValidator = new UserHandleValidator();
    @Test
    void checkLengthGreaterThanEqualToSeven(){
        assertFalse(userHandleValidator.validateUserHandle("sam"));
    }
    @Test
    void checkLengthLessThanEqualTwoTwenty(){
        assertFalse(userHandleValidator.validateUserHandle("abcdefghijABCDEFGH12345678"));
    }
    @Test
    void checkForDollarCharacter(){
        assertFalse(userHandleValidator.validateUserHandle("sam$sam"));
    }

    @Test
    void checkForPoundCharacter(){
        assertFalse(userHandleValidator.validateUserHandle("sam#sam"));
    }
    @Test
    void checkForUnderscoreCharacter(){
        assertTrue(userHandleValidator.validateUserHandle("sam_1999"));
    }
    @Test
    void checkForFirstCharacterIsAlphabetic(){
        assertFalse(userHandleValidator.validateUserHandle("1999_sam"));
    }
    @Test
    void checkForNormalPassword(){
        assertTrue(userHandleValidator.validateUserHandle("moksh_1999"));
    }
}