
import java.util.Vector;
import java.util.Scanner;

// This program analyzes a text and the characters in it.
public class TextAnalysis {

    // Scanner object for reading input
    private static Scanner scan = new Scanner(System.in);

    public static class Analysis {
        // Fields
        private int characterAppearence[] = new int[30];
        private String text;

        // Constants for the Norwegian characters
        private final int NORWEGIAN_AE = 248;
        private final int NORWEGIAN_OE = 229;
        private final int NORWEGIAN_AA = 230; 
        private final int NORWEGIAN_AE_INDEX = 26; 
        private final int NORWEGIAN_OE_INDEX = 27;
        private final int NORWEGIAN_AA_INDEX = 28;

        // The constructor takes a string as input and counts the appearance of each character
        public Analysis(String text) {
            this.text = text.toLowerCase();
            analyzeText();
        }

        // Analyzes the text and counts the appearance of each character
        private void analyzeText() {
            for (int i = 0; i < text.length(); i++) {
                int character = (int) text.charAt(i);
                updateCharacterAppearance(character);
            }
        }

        // Updates the character appearance array
        private void updateCharacterAppearance(int character) {
            if (character >= 97 && character <= 122) {
                characterAppearence[character - 97]++;
            } else {
                switch (character) {
                    case NORWEGIAN_AE:
                        characterAppearence[NORWEGIAN_AE_INDEX]++;
                        break;
                    case NORWEGIAN_OE:
                        characterAppearence[NORWEGIAN_OE_INDEX]++;
                        break;
                    case NORWEGIAN_AA:
                        characterAppearence[NORWEGIAN_AA_INDEX]++;
                        break;
                    default:
                        characterAppearence[29]++;
                        break;
                }
            }
        }

        // Returns the different types of characters in the text
        public int getDifferentCharacters() {
            int differentCharacters = 0;
            for (int i = 0; i < 29; i++) {
                if (characterAppearence[i] > 0) {
                    differentCharacters++;
                }
            }
            return differentCharacters;
        }

        // Returns the total number of characters in the text
        public int getTotalLetters() {
            int totalCharacters = 0;
            for (int i = 0; i < 29; i++) {
                totalCharacters += characterAppearence[i];
            }
            return totalCharacters;
        }

        // Returns the percentage of special characters in the text
        public double getSpecialCharactersPercentage() {
            return (double) characterAppearence[29] / text.length() * 100;
        }

        // Returns the appearance of a specific letter
        public int getLetterAppearance(char letter) {
            int character = (int) letter;
            if (character >= 97 && character <= 122) {
                return characterAppearence[character - 97];
            } else {
                switch (character) {
                    case NORWEGIAN_AE_INDEX:
                        return characterAppearence[NORWEGIAN_AE_INDEX];
                    case NORWEGIAN_OE_INDEX:
                        return characterAppearence[NORWEGIAN_OE_INDEX];
                    case NORWEGIAN_AA_INDEX:
                        return characterAppearence[NORWEGIAN_AA_INDEX];
                    default:
                        return characterAppearence[29];
                }
            }
        }

        // Return a integer as a character
        public char getCharacter(int character) {
            if (character >= 0 && character <= 25) {
                return (char) (character + 97);
            } else {
                switch (character) {
                    case NORWEGIAN_AE_INDEX:
                        return (char) NORWEGIAN_AE;
                    case NORWEGIAN_OE_INDEX:
                        return (char) NORWEGIAN_OE;
                    case NORWEGIAN_AA_INDEX:
                        return (char) NORWEGIAN_AA;
                    default:
                        return (char) 0;
                }
            }
        }

        // Returns the letter(s) that appears the most in the text
        public Vector<Character> getMostAppearingLetter() {
            // Find the highest appearance
            int maxAppearance = 1;
            for (int i = 0; i < 29; i++) {
                if (characterAppearence[i] > maxAppearance) {
                    maxAppearance = characterAppearence[i];
                }
            }

            // Find the character(s) with the highest appearance
            Vector<Character> mostAppearing = new Vector<Character>();
            for (int i = 0; i < 29; i++) {
                if (characterAppearence[i] == maxAppearance) {
                    mostAppearing.addElement(getCharacter(i));
                }
            }
            
            return mostAppearing;
        }

        // Full analysis of the text
        public void fullAnalysis() {
            System.out.println("Different characters: " + getDifferentCharacters());
            System.out.println("Total characters: " + getTotalLetters());
            System.out.println("Special characters percentage: " + getSpecialCharactersPercentage() + "%");
            System.out.println("Most appearing letter(s): " + getMostAppearingLetter());
        }
    }
    
    // This is the main method that demonstrates the functionality of the Analysis class
    public static void main(String[] args) {

        // Run the program in an infinite loop
        while (true) {

            // Read the text from the user
            System.out.print("\nEnter the text you want to analyze: ");
            String text = scan.nextLine();

            // Create an Analysis object
            Analysis analysis = new Analysis(text);

            // Perform a full analysis of the text
            analysis.fullAnalysis();

        }
    }

}
