package br.com.validacaosenha;

import java.util.HashSet;
import java.util.Set;

public class PasswordValidator {

    private static final String SPECIAL_CHARACTERS = "@#$%^&*()-+";

    public static boolean isValid(String password) {

        if (password == null || password.length() < 9) {
            return false;
        }

        boolean hasDigit = false;
        boolean hasLower = false;
        boolean hasUpper = false;
        boolean hasSpecial = false;

        Set<Character> uniqueChars = new HashSet<>();

        for (char c : password.toCharArray()) {

            if (uniqueChars.contains(c)) {
                return false;
            }

            uniqueChars.add(c);

            if (Character.isDigit(c)) {
                hasDigit = true;
            }

            else if (Character.isLowerCase(c)) {
                hasLower = true;
            }

            else if (Character.isUpperCase(c)) {
                hasUpper = true;
            }

            else if (SPECIAL_CHARACTERS.indexOf(c) >= 0) {
                hasSpecial = true;
            }

            else {
                return false;
            }
        }

        return hasDigit && hasLower && hasUpper && hasSpecial;
    }
}
