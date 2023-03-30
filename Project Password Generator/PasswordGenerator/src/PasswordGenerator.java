//Java Program to Generate Random Password and Check its Strength//

import java.security.SecureRandom;
import java.util.Scanner;

public class PasswordGenerator {

    private static final String UPPER = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String LOWER = "abcdefghijklmnopqrstuvwxyz";
    private static final String NUMBERS = "0123456789";
    private static final String SYMBOLS = "!@#$%^&*_=+-/";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the length of the password (between 8 and 16 characters): ");
        int length = scanner.nextInt();
        scanner.close();

        if (length < 8 || length > 16) {
            System.out.println("Invalid length!");
            return;
        }

        SecureRandom random = new SecureRandom();

        StringBuilder password = new StringBuilder(length);
        String passwordAlphabet = UPPER + LOWER + NUMBERS + SYMBOLS;

        for (int i = 0; i < length; i++) {
            int index = random.nextInt(passwordAlphabet.length());
            password.append(passwordAlphabet.charAt(index));
        }

        String generatedPassword = password.toString();
        System.out.println("Generated Password: " +generatedPassword);
        System.out.println("Length of Password: " + generatedPassword.length());

        System.out.println("Password Strength: " +getPasswordStrength(generatedPassword));
    }

    private static String getPasswordStrength(String password) {
        boolean hasUpper = false, hasLower = false, hasNumber = false, hasSymbol = false;

        for (char c : password.toCharArray()) {
            if (UPPER.contains(Character.toString(c))) 
            {
                hasUpper = true;
            } 
            else if (LOWER.contains(Character.toString(c))) 
            {
                hasLower = true;
            } 
            else if (NUMBERS.contains(Character.toString(c))) 
            {
                hasNumber = true;
            } 
            else if (SYMBOLS.contains(Character.toString(c))) 
            {
                hasSymbol = true;
            }
        }

        int passwordLength = password.length();
        
        int strengthPoints = 0;

        if (passwordLength < 8) 
        {
            return "Very Weak";
        } 
        
        else if (passwordLength >= 8 && passwordLength <= 11) {
            strengthPoints++;
        } 
        
        else if (passwordLength >= 12 && passwordLength <= 15) 
        {
            strengthPoints += 2;
        } 
        
        else {
            strengthPoints += 3;
        }

        if (hasUpper && hasLower) 
        {
            strengthPoints++;
        }
        if (hasNumber) 
        {
            strengthPoints++;
        }
        if (hasSymbol) 
        {
            strengthPoints++;
        }

        if (strengthPoints == 0) 
        {
            return "Very Weak";
        } 
        else if (strengthPoints == 1) 
        {
            return "Weak";
        } 
        else if (strengthPoints == 2) 
        {
            return "Medium";
        } 
        else if (strengthPoints == 3) 
        {
            return "Strong";
        } 
        else {
            return "Very Strong";
        }
    }
}
