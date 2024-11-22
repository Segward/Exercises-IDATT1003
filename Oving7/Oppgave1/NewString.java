package Oppgave1;

// The task was to make a new class that extends the String class and add two methods to it.
public class NewString {

    // This is a class for extending the String class
    public static class NyString {
        private String str;

        // Constructor
        public NyString(String str) {
            this.str = str;
        }

        // This method will abbreviate the string 
        // aka shorten it down to the first letter of each word
        public void abbreviate() {
            String[] words = str.split(" ");
            StringBuilder newStr = new StringBuilder();
            for (String word : words) {
                char firstChar = word.charAt(0);
                newStr.append(firstChar);
            }
            this.str = newStr.toString();
        }

        // This method will remove a character from the string at all places
        public void removeCharacter(char c) {
            StringBuilder newStr = new StringBuilder();
            for (int i = 0; i < str.length(); i++) {
                // If the character is not the one we want to remove, add it to the new string
                if (str.charAt(i) != c) {
                    newStr.append(str.charAt(i));
                }
            }
            this.str = newStr.toString();
        }

        // Returns the string object
        public String toString() {
            return this.str;
        }
        
    }

    // This is the main method
    public static void main(String[] args) {
        // Test sample 1
        NyString HelloWord = new NyString("Hello World");
        HelloWord.abbreviate();
        System.out.println(HelloWord.toString());

        // Test sample 2
        NyString GoodbyeWorld = new NyString("Goodbye World");
        GoodbyeWorld.removeCharacter('o');
        System.out.println(GoodbyeWorld.toString());
    }
}