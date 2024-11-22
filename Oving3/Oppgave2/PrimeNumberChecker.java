import java.util.Scanner;
import java.lang.Math;

// This program checks if a number is a primenumber
public class PrimeNumberChecker {
   // This is the scanner used for getting user input
   static Scanner scan = new Scanner(System.in);

   // This function gets the user input
   public static int getUserInput() {
      System.out.print("\nEnter a number to check if it is a primenumber: ");
      int userInput = scan.nextInt();
      return userInput;
   }

   // This is a function to check if a number is a primenumber
   public static boolean isPrimeNumber(int number) {
      if (number < 2)
         return false;

      // Checks if the number is divisible by any number between 2 and the square root of the number
      // If the number is divisible it will return false (not a primenumber)
      for (int i = 2; i <= Math.sqrt(number); ++i) {
         if (number % i == 0) 
            return false;
      }
      return true;
   }

   // This function prints if the number is a primenumber or not
   public static void printPrimeNumberResult(int number, boolean primeNumber) {
      if (primeNumber) {
         System.out.println(String.format("%s is a primenumber", number));
         return;
      }
      System.out.println(String.format("%s is NOT a primenumber", number));
   }

   // This function gets the user input and checks if it is a primenumber
   public static boolean getNewPrimeNumber() {
      try {
         // Get the user input which is a number and check if it is a primenumber
         int number = getUserInput();
         boolean primeNumber = isPrimeNumber(number);
         
         // Print if the number is a primenumber or not so the user can see the result
         printPrimeNumberResult(number, primeNumber);
         return true;
      }
      
      // Catch the exception if the user input is not a number
      catch (Exception e) {
         System.out.println("invalid number");
         return false;
      }
   }

   // This is the main function
   public static void main(String[] args) {
      do {
         // This part does absolutely nothing
      } while (getNewPrimeNumber());
      scan.close();
   }
}
