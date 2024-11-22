import java.util.Scanner;

// This program exchanges currency
public class CurrencyExchanger {
    
    // Scanner object
    static Scanner scan = new Scanner(System.in);

    // Three currency objects
    static Currency[] currencies = {
        new Currency(10.49, "USD"),
        new Currency(11.72, "EUR"),
        new Currency(1.03, "SEK")
    };

    // This class represents a currency and it exchanges from and to nok
    public static class Currency {
        private double exchangeRateToNOK;
        private String currencyName;

        // Constructor for currency
        public Currency(double exchangeRateToNOK, String currencyName) {
            if (exchangeRateToNOK <= 0) {
                throw new IllegalArgumentException("Exchange rate must be greater than 0");
            }
            this.exchangeRateToNOK = exchangeRateToNOK;
            this.currencyName = currencyName;
        }

        // Exchange to NOK
        public double exchangeToNOK(double amount) {
            return amount * exchangeRateToNOK;
        }

        // Exchange from NOK
        public double exchangeFromNOK(double amount) {
            return amount / exchangeRateToNOK;
        }

        // Get the currency name
        public String getName() {
            return this.currencyName;
        }
    }

    // This is a "menu" class that handles the user input
    public static class Menu {
        // This method gets the currency the user wants to exchange with
        public static int getExchangeCurrency(Currency[] currencies) {
            System.out.println("\nWelcome to the currency exchanger!");

            // Print the currency options to the user
            for (int i = 0; i < currencies.length; i++) {
                System.out.println(i + 1 + ": " + currencies[i].currencyName);
            }

            // Print the exit option to the user
            System.out.println("0: Exit");
            System.out.print("Please select a currency you want to exchange with: ");
            int exchangeCurrency = scan.nextInt();

            // Exit the program if the user selects 0
            if (exchangeCurrency == 0) {
                System.out.println("Exiting program...");
                System.exit(0);
            }

            // Throw an exception if the user selects an invalid currency
            if (exchangeCurrency < 0 || exchangeCurrency > currencies.length) {
                throw new IllegalArgumentException("Invalid currency selection");
            }
            
            return exchangeCurrency;
        }

        // This method gets weather the user wants to exchange from or to nok
        public static int getExchangeType(Currency exchangeCurrency) {

            // Print the exchange options to the user
            System.out.println("\nWhat type of exchange do you want to do?");
            System.out.println(String.format("1: Exchange from %s to NOK", exchangeCurrency.getName()));
            System.out.println(String.format("2: Exchange from NOK to %s", exchangeCurrency.getName()));
            System.out.println("0: Exit");
            System.out.print("Please select an exchange type: ");
            int exchangeType = scan.nextInt();

            // Exit the program if the user selects 0
            if (exchangeType == 0) {
                System.out.println("Exiting program...");
                System.exit(0);
            }

            // Throw an exception if the user selects an invalid exchange type
            if (exchangeType < 0 || exchangeType > 2) {
                throw new IllegalArgumentException("Invalid exchange type");
            }

            return exchangeType;
        }

        // This method gets the amount the user wants to exchange
        public static double getAmountToExchange() {
            System.out.print("\nPlease enter the amount you want to exchange: ");
            return scan.nextDouble();
        }

        // This method processes the exchange and prints out the results
        public static void processExchange(Currency exchangeCurrency, int exchangeType, double amountToExchange) {
            System.out.println("\nProcessing exchange...");
            if (exchangeType == 1) {
                System.out.println(String.format("You will get %.2f NOK for %.2f %s\n", 
                exchangeCurrency.exchangeToNOK(amountToExchange), amountToExchange, exchangeCurrency.getName()));
            } else if (exchangeType == 2) {
                System.out.println(String.format("You will get %.2f %s for %.2f NOK\n", 
                exchangeCurrency.exchangeFromNOK(amountToExchange), exchangeCurrency.getName(), amountToExchange));
            }
        }
    }

    // This is the main method
    public static void main(String[] args) {
        while (true) {
            try {
                // Get the user input and process it
                Currency exchangeCurrency = currencies[Menu.getExchangeCurrency(currencies) - 1];
                int exchangeType = Menu.getExchangeType(exchangeCurrency);
                double amountToExchange = Menu.getAmountToExchange();
                Menu.processExchange(exchangeCurrency, exchangeType, amountToExchange);

            // Catch any exceptions and print the error message thrown in code
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                break;
            } 
        }
    }
    
}