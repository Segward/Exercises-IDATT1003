
import java.util.Random;

// The task is to create a class that generates random numbers and count the appearances of each number
public class RandomNumberAppearances {

    // Random object to generate random numbers
    static private Random random = new Random();

    // Amount of loops to generate random numbers
    static private int scale = 100;

    // Number class to store the number and the appearances of the number
    public static class Number {
        private int number;
        private int appearances;

        // Constructor for number
        public Number(int number) {
            this.number = number;
            this.appearances = 0;
        }

        // Get the amount of stars to print based on the appearances of the number
        private String getStars() {
            int starsInteger = (int) Math.round( (double) this.appearances / scale * 100);
            StringBuilder stars = new StringBuilder();
            for (int i = 0; i < starsInteger; i++) {
                stars.append("*");
            }
            return stars.toString();
        }

        // Get method for number
        public int getNumber() {
            return number;
        }

        // Get method for appearances
        public int getAppearances() {
            return appearances;
        }

        // Increment appearances
        public void incrementAppearances() {
            this.appearances++;
        }

        // Get the number with appearances as a string
        public String getString() {
            return String.format("Number %d appearances: %d \t %s ", number, appearances, this.getStars());
        }
    }

    // This is the main method
    public static void main(String[] args) {

        // Create a array of Number objects
        Number[] numbers = new Number[10];

        // Assign number to numbers
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = new Number(i);
        }

        // Generate 100 random numbers and count the appearances of each number
        for (int i = 0; i < scale; ++i) {
            // Generate a random number between 0 and 9
            int randomNumber = random.nextInt(10);
            numbers[randomNumber].incrementAppearances();
        }

        // Print the appearances of each number
        for (Number number : numbers) {
            System.out.println(number.getString());
        }
    }
}