package generator;
import java.util.*;
import java.security.SecureRandom;


public class Generator {
    private static final String LOWERCASE_LETTERS = "abcdefghijklmnopqrstuvwxyz";
    private static final String UPPERCASE_LETTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String NUMBERS = "0123456789";
    private static final String SPECIAL_CHARACTERS = "!@#$%^&*()-_=+[]{}|;:'\",.<>?`~\\";

    private static final SecureRandom secureRandom = new SecureRandom();

    private String generatePassword(int length, boolean includeChars, boolean includeNumbers, boolean includeSpecialChars) {
        StringBuilder password = new StringBuilder();

        String characters = LOWERCASE_LETTERS + UPPERCASE_LETTERS;
        if (includeChars) characters += SPECIAL_CHARACTERS;
        if (includeNumbers) characters += NUMBERS;
        if (includeSpecialChars) characters += SPECIAL_CHARACTERS;

        for (int i = 0; i < length; i++) {
            int randomIndex = secureRandom.nextInt(characters.length());
            password.append(characters.charAt(randomIndex));
        }

        return password.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        Generator gc = new Generator();

        System.out.print("Enter the length of password that you want to generate: ");
        int length = scanner.nextInt();

        System.out.print("Include characters? (Y/N): ");
        boolean includeChars = scanner.next().equalsIgnoreCase("Y");

        System.out.print("Include numbers? (Y/N): ");
        boolean includeNumbers = scanner.next().equalsIgnoreCase("Y");

        System.out.print("Include special characters? (Y/N): ");
        boolean includeSpecialChars = scanner.next().equalsIgnoreCase("Y");

        String password = gc.generatePassword(length, includeChars, includeNumbers, includeSpecialChars);
        System.out.println("Generated password: " + password);

        scanner.close();
    }
}

