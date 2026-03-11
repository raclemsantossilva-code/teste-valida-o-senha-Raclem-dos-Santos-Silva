package br.com.validacaosenha;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PasswordValidatorTest {

    @Test
    void shouldReturnTrueForValidPassword() {
        assertTrue(PasswordValidator.isValid("Ab@1CdEfG"));
    }

    @Test
    void shouldFailWhenPasswordIsTooShort() {
        assertFalse(PasswordValidator.isValid("Ab@1CdE"));
    }

    @Test
    void shouldFailWhenMissingDigit() {
        assertFalse(PasswordValidator.isValid("Ab@CdEfGh"));
    }

    @Test
    void shouldFailWhenMissingLowerCase() {
        assertFalse(PasswordValidator.isValid("AB@1CDEFG"));
    }

    @Test
    void shouldFailWhenMissingUpperCase() {
        assertFalse(PasswordValidator.isValid("ab@1cdefg"));
    }

    @Test
    void shouldFailWhenMissingSpecialCharacter() {
        assertFalse(PasswordValidator.isValid("Abc1DefGh"));
    }

    @Test
    void shouldFailWhenContainsRepeatedCharacters() {
        assertFalse(PasswordValidator.isValid("Ab@1CdEfA"));
    }

    @Test
    void shouldFailWhenContainsInvalidSpecialCharacter() {
        assertFalse(PasswordValidator.isValid("Ab!1CdEfG"));
    }

    @Test
    void shouldAcceptMinimumSizeValidPassword() {
        assertTrue(PasswordValidator.isValid("A1b@CdefG"));
    }

}
