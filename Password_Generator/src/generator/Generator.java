package generator;
//import java.util.*;
//
//public class Generator {
//
//	
//	public static int random(int len) {
//		
//		int x = (int)(Math.random()*len);
//		
//		return x;
//	}
//	
//	
//		public static void pwd_generator(int len, boolean checkChar, boolean checkNum) {
//		    String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
//		    String special = "!@#$%^&*()-_=+[]{}|;:'\",.<>?`~\\";
//		    String numbers = "0123456789";
//		    String pwd = "";
//
//		    Random rand = new Random();
//
//		    for (int i = 0; i < len; i++) {
//		        if (checkChar && i % 3 == 0) { 
//		            
//		        	int y = random(special.length());
//		            char b = special.charAt(y);
//		            pwd += b; 
//		        } else if (checkNum && i % 2 == 0) { 
//		            int z = random(numbers.length());
//		            char c = numbers.charAt(z);
//		            pwd += c;
//		        } else {
//		        	int x = random(alphabet.length());
//		            char a = alphabet.charAt(x);
//		            pwd += a;
//		        }
//		    }
//		    System.out.println("Generated password is " + pwd);
//		}
//
//	
//	
//	
//	
//	public static void main(String[] args) {
//		
//		boolean Num = false;
//		boolean Char = false;
//		Scanner sc = new Scanner(System.in);
////		int x = random(26);
////		System.out.println(x);
//		
//		System.out.print("Enter the length of password that you want to generator:");
//		int len = sc.nextInt();
//		
//		System.out.print("Enter Y/N, if you want to include character:");
//		char checkChar = sc.next().charAt(0);
//		
//		System.out.print("ENter Y/N, if you want to include numbers:");
//		char checkNum = sc.next().charAt(0);
//		
//		if(checkChar =='Y') {
//			Char = true;
//		}
//		if(checkNum == 'Y') {
//			Num = true;
//		}
//
//		pwd_generator(len,Char,Num);
//		
//		
//		sc.close();
//	}
//
//}


import java.security.SecureRandom;
import java.util.Scanner;

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

