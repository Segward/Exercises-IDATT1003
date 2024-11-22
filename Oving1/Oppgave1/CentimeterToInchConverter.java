
// This program converts centimeters to inches and inches to centimeters
public class CentimeterToInchConverter {
    // This function prints centimeters to inches
    public static void printInches(double centimeters) {
        double inches = convertCentimetersToInches(centimeters);
        System.out.println(String.format("%f cm -> %f inches", centimeters, inches));
    }

    // This function prints inches to centimeters
    public static void printCentimeters(double inches) {
        double centimeters = convertInchesToCentimeters(inches);
        System.out.println(String.format("%f inches -> %f cm", inches, centimeters));
    }

    // This function converts centimeters to inches
    public static double convertCentimetersToInches(double centimeters) {
        return centimeters / 2.54;
    }

    // This function converts inches to centimeters
    public static double convertInchesToCentimeters(double inches) {
        return inches * 2.54;
    }

    // This is the main function
    public static void main(String[] args) {
        // These are test samples to see if the program works
        printInches(100);
        printInches(300);
        printInches(38.5);
        printCentimeters(19.3);
        printCentimeters(347.3);
    }
}