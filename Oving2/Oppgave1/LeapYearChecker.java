import java.util.Scanner;

// This program checks if a year is a leapyear
public class LeapYearChecker {
    // This is the scanner used for getting user input
    static Scanner scan = new Scanner(System.in);

    // This function gets the user input
    public static int getYear() {
        System.out.print("Enter year: ");
        int year = scan.nextInt();
        return year;
    }

    // This is a function to check if a year is a leapyear
    public static boolean isLeapYear(int year) {
        // Returns true if the year is dividable by 4 and isnt a century
        // Returns true if the year is dividable by 400 and is a century
        if ((year % 4 == 0 && year % 100 != 0) || (year % 100 == 0 && year % 400 == 0)) {
            return true;
        }
        return false;
    }

    // This function prints if the year is a leapyear or not
    public static void printLeapYearResult(int year, boolean leapyear) {
        if (leapyear) {
            System.out.println(String.format("%s is a leapyear", year));
            return;
        }
        System.out.println(String.format("%s is NOT a leapyear", year));
    }

    // This is the main function
    public static void main(String[] args) {
        try {
            // Get the user input which is a year and check if it is a leapyear
            int year = getYear();
            boolean leapyear = isLeapYear(year);
            
            // Print if the year is a leapyear or not so the user can see the result
            printLeapYearResult(year, leapyear);
        }
        
        // Catch the exception if the user input is not a number
        catch (Exception e) {
            System.out.println("year must be a number");
            return;
        }
        scan.close();
    }
}





