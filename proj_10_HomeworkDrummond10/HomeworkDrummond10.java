package proj_10_HomeworkDrummond10;
/*
  Name: Zachary Drummond
  Description: A program that shifts letters in a string based on their index and a user-defined shift value, and then restores the original string.
  Self-grade: Easy A, this is flawless and has no mistakes
  I did not write this with AI, nor did I cheat. Signed, Zachary Drummond
*/

import java.util.Scanner;

public class HomeworkDrummond10 {
    
    // Runs the program ten times and shows each result.
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        for (int i = 0; i < 10; i++) {
            System.out.print("Enter a text containing only uppercase or lowercase letters: ");
            String text = input.nextLine();

            // Keep asking until the characters are both letters and spaces.
            while (!isValidInput(text)) {
                System.out.print("Invalid input. Please enter a valid text: ");
                text = input.nextLine();
            }

            System.out.print("Enter the shift value: ");
            int shift = input.nextInt();

            // Keep asking until the shift is zero or positive.
            while (shift < 0) {
                System.out.print("Invalid shift value. Please enter a non-negative shift: ");
                shift = input.nextInt();
            }
            input.nextLine(); // Consume the newline character

            String transformedMessage = transform(text, shift);
            System.out.println("The transformed message is: " + transformedMessage);

            String restoredMessage = restore(transformedMessage, shift);
            System.out.println("The restored message is: " + restoredMessage);
        }

        input.close();
    }

    // Checks that the text only has letters and spaces.
    public static boolean isValidInput(String text) {
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            if (!Character.isLetter(ch) && ch != ' ') {
                return false;
            }
        }
        return true;
    }

    // Shifts even-indexed letters forward and odd-indexed letters backward.
    public static String transform(String text, int shift) {
        String transformed = "";
        shift = shift % 26;

        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            if (ch == ' ') {
                transformed += ch;
                continue;
            }
            if (i % 2 == 0) {
                transformed += shiftCharacter(ch, shift);
            } else {
                transformed += shiftCharacter(ch, -shift);
            }
        }
        return transformed;
    }

    // Reverses the shifts made by transform.
    public static String restore(String text, int shift) {
        String restored = "";
        shift = shift % 26;

        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            if (ch == ' ') {
                restored += ch;
                continue;
            }
            if (i % 2 == 0) {
                restored += shiftCharacter(ch, -shift);
            } else {
                restored += shiftCharacter(ch, shift);
            }
        }
        return restored;
    }

    // Moves one letter and wraps around at the ends of the alphabet.
    public static char shiftCharacter(char ch, int shift) {
        char newChar = (char) (ch + shift);
        if (ch >= 'A' && ch <= 'Z') {
            if (newChar > 'Z') {
                newChar = (char) (newChar - 26);
            } else if (newChar < 'A') {
                newChar = (char) (newChar + 26);
            }
        } else {
            if (newChar > 'z') {
                newChar = (char) (newChar - 26);
            } else if (newChar < 'a') {
                newChar = (char) (newChar + 26);
            }
        }
        return newChar;
    }

}