

// The task was to make a fraction class with basic operations
public class FractionCalculator {

    // This is the fraction class
    public static class Fraction {
        private int numerator;
        private int denominator;

        // This is the constructor for the Fraction class
        public Fraction(int numerator, int denominator) {
            // Check if the denominator is zero
            if (denominator == 0) {
                throw new IllegalArgumentException("Denominator cannot be zero");
            }
            
            // Set the numerator and denominator
            this.numerator = numerator;
            this.denominator = denominator;
        }

        public Fraction(int numerator) {
            this.numerator = numerator;
            this.denominator = 1;
        }

        // This is the method to add two fractions
        public void add(Fraction fraction) {
            // Convert the fractions to the same denominators
            int thisNumerator = this.numerator * fraction.denominator;
            int otherNumerator = fraction.numerator * this.denominator;
            int newDenominator = this.denominator * fraction.denominator;

            // Add the numerators to this class and set the new denominator
            this.numerator = thisNumerator + otherNumerator;
            this.denominator = newDenominator;
            this.simplify();
        }

        // This is the method to subtract two fractions
        public void subtract(Fraction fraction) {
            // Convert the fractions to the same denominators
            int thisNumerator = this.numerator * fraction.denominator;
            int otherNumerator = fraction.numerator * this.denominator;
            int newDenominator = this.denominator * fraction.denominator;
            
            // Subtract the numerators to this class and set the new denominator
            this.numerator = thisNumerator - otherNumerator;
            this.denominator = newDenominator;
            this.simplify();
        }

        // This is the method to multiply two fractions
        public void multiply(Fraction fraction) {
            // Multiply the numerators and denominators
            this.numerator = this.numerator * fraction.numerator;
            this.denominator = this.denominator * fraction.denominator;
            this.simplify();
        }

        // This is the method to divide two fractions
        public void divide(Fraction fraction) {
            // You can divide by multiplying the opposite fraction
            // Example: 5/2 divided by 3/4 is the same as 5/2 multiplied by 4/3
            this.numerator = this.numerator * fraction.denominator;
            this.denominator = this.denominator * fraction.numerator;
            this.simplify();
        }

        // This is the method to simplify the fraction
        private void simplify() {
            // First we find the greatest common divisor
            // Begin at the denominator and go down to 1
            int greatestCommonDivisor = 2;
            // We don't check for divisors above the smallest of the two numbers
            for (int i = 1; i <= this.numerator && i <= this.denominator; i++) {
                // Check if the divisor is a common divisor and sets it as the greatest common divisor
                if (this.numerator % i == 0 && this.denominator % i == 0) {
                    // We will get the greatest common divisor (highest)
                    greatestCommonDivisor = i;
                }
            }

            // Then we divide the numerator and denominator by the greatest common divisor
            this.numerator = this.numerator / greatestCommonDivisor;
            this.denominator = this.denominator / greatestCommonDivisor;
        }

        // This is the method to get the fraction
        public String toString() {
            return this.numerator + " / " + this.denominator;
        }
    }

    // This is the main method
    public static void main(String[] args) {
        try {
            // Test additon of two fractions
            Fraction fractionA = new Fraction(1, 2);
            Fraction fractionB = new Fraction(1, 4);
            fractionA.add(fractionB);
            System.out.println(fractionA.toString());

            // Test subtraction of two fractions
            Fraction fractionC = new Fraction(1, 2);
            Fraction fractionD = new Fraction(1, 4);
            fractionC.subtract(fractionD);
            System.out.println(fractionC.toString());

            // Test multiplication of two fractions
            Fraction fractionE = new Fraction(1, 2);
            Fraction fractionF = new Fraction(1, 4);
            fractionE.multiply(fractionF);
            System.out.println(fractionE.toString());

            // Test division of two fractions
            Fraction fractionG = new Fraction(1, 2);
            Fraction fractionH = new Fraction(1, 4);
            fractionG.divide(fractionH);
            System.out.println(fractionG.toString());

        // Catch the exception and print the message
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

} 