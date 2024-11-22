
// This is a program for manipulating strings
public class StringManipulation {
    
    // This is a class for manipulating strings
    public static class NyString {

        // Fields of the class
        private String originalString;
        private String str;

        // Constructor
        public NyString(String str) {
            this.str = str;
            this.originalString = str;
        }

        // Get the string
        public String toString() {
            return this.str;
        }

        // Get the original string
        public String toOriginal() {
            return this.originalString;
        }

        // Get the number of wrods
        public int getWordCount() {
            return this.str.split(" ").length;
        }

        // Get the average word length without counting special signs
        public int getAverageWordLength() {

            // the task doesnt want special signs to count so ...
            String[] specialSigns = {".", ",", "!", "-", "_", "?", ":", ";", 
            "(", ")", "[", "]", "{", "}", "<", ">", "/", "|", "\\", "@", 
            "#", "$", "%", "^", "&", "*", "+", "=", "~", "`"};

            // Remove special signs
            String newStr = this.str;
            for (String sign : specialSigns) {
                newStr = newStr.replace(sign, "");
            }

            // Split the string into words and get the average length by
            // dividing the total length by the number of words
            String[] words = newStr.split(" ");
            int totalLength = 0;
            for (String word : words) {
                totalLength += word.length();
            }

            // Return the average length
            return totalLength / words.length;
        }

        // Get the average number of words per sentence
        public int getAverageWordsPerSentence() {

            // Split the string into sentences
            String[] separators = {".", "!", "?", ":"};

            // Replace separators with a common separator
            String newStr = this.str;
            for (String separator : separators) {
                newStr = newStr.replace(separator, ".");
            }

            // Split the string into sentences and remove the separator
            String[] sentences = newStr.split("\\.");
            for (String sentence : sentences) {
                sentence = sentence.replace(".", "");
            }

            // Count the total number of words
            int totalWords = 0;
            for (String sentence : sentences) {
                String[] words = sentence.split(" ");
                totalWords += words.length;
            }

            // Return the average number of words per sentence
            return totalWords / sentences.length;
        }

        // Replace a word with another word
        public void replaceWord(String oldWord, String newWord) {
            this.str = this.str.replace(oldWord, newWord);
        }

        // Return the string in uppercase
        public String toUpperCase() {
            return this.str.toUpperCase();
        }

        // Return the string in lowercase
        public String toLowerCase() {
            return this.str.toLowerCase();
        }
    }

    // This is the main method
    public static void main(String[] args) {
        
        // Pad the console
        System.out.println("\n");

        // Create a sample string
        NyString sample = new NyString("Hello jeg heter Gustav. Jeg er 20 år gammel.????????? Jeg liker katter og hunder. Hello WÅÅÅÅRDL!");
        System.out.println(String.format("The string has %s words", sample.getWordCount()));
        System.out.println(String.format("The average word length is %s", sample.getAverageWordLength()));
        System.out.println(String.format("The average number of words per sentence is %s", sample.getAverageWordsPerSentence()));
        sample.replaceWord("katter", "elefanter");
        System.out.println(sample.toString());
        System.out.println(sample.toUpperCase());

        // Pad the console
        System.out.println("\n");

    }

}
