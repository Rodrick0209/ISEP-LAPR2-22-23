package pt.ipp.isep.dei.esoft.project.domain;

import java.util.Random;

public class PasswordGenerator {
    private static final int numberCapitalLetters = 3;
    private static final int numberDigits = 2;
    private static final int numberOtherAlphanumericLetters = 2;
    private static final String UPPER_CASE = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String DIGITS = "0123456789";

    private final Random random = new Random();

    public char generateRandomCharacter(String characterSet) {
        int index = random.nextInt(characterSet.length());
        return characterSet.charAt(index);
    }

    public String generatePassword() {
        StringBuilder password = new StringBuilder();

        for (int i = 0; i < numberCapitalLetters; i++) {
            password.append(generateRandomCharacter(UPPER_CASE));
        }

        for (int i = 0; i < numberDigits; i++) {
            password.append(generateRandomCharacter(DIGITS));
        }

        for (int i = 0; i < numberOtherAlphanumericLetters; i++) {
            password.append(generateRandomCharacter(UPPER_CASE.toLowerCase()));
        }

        return password.toString();
    }
}
