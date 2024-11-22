import java.util.Random;

// The task is to create a class that generates random numbers within a range
public class RandomNumberClass {

    // This is the class that generates random numbers within a range
    public static class MinRandom {

        // The task demands the random object is inside MinRandom class
        private Random random;

        // Constructor for MinRandom
        public MinRandom() {
            this.random = new Random();
        }

        // Generate a random whole number between the lower and upper bound
        public int nesteHeltall(int nedre, int ovre) {
            if (nedre > ovre) {
                throw new IllegalArgumentException("nedre should be less than or equal to ovre");
            }
            // generate a random number between range size then add the lower bound
            return random.nextInt(ovre - nedre + 1) + nedre; 
        }

        // Generate a random decimal number between the lower and upper bound
        public double nesteDesimaltall(double nedre, double ovre) {
            if (nedre > ovre) {
                throw new IllegalArgumentException("nedre should be less than or equal to ovre");
            }
            // generates a number between 0 and 1 then multiply by the range size then add the lower bound
            return random.nextDouble() * (ovre - nedre) + nedre;
        }
    }

    // This is the main method
    public static void main(String[] args) {
        try {
            // Get the MinRandom object
            MinRandom random = new MinRandom();

            // Test the random whole number
            System.out.println("\nTest the heltall");
            for (int i = 0; i < 100; ++i) {
                System.out.println(String.format("%d -> %d : %d", 5, 10, random.nesteHeltall(5, 10)));
            }

            // Test the random decimal number
            System.out.println("\nTest the desimaltall");
            for (int i = 0; i < 100; ++i) {
                System.out.println(String.format("%d -> %d : %f", 5, 10, random.nesteDesimaltall(5, 10)));
            }

            // Test the random whole number
            System.out.println("\nTest the heltall");
            for (int i = 0; i < 100; ++i) {
                System.out.println(String.format("%d -> %d : %d", -4, 3, random.nesteHeltall(-4, 3)));
            }

            // Test the random decimal number
            System.out.println("\nTest the desimaltall");
            for (int i = 0; i < 100; ++i) {
                System.out.println(String.format("%d -> %d : %f", -4, 3, random.nesteDesimaltall(-4, 3)));
            }

        } catch (IllegalArgumentException e) {
            // Catch the exception and print the message
            System.out.println(e.getMessage());
        }
    }
}
