
import java.util.Scanner;

public class Arbeidstaker {

    private static Scanner scan = new Scanner(System.in);

    public static class ManagerMenu {
        private Worker worker;
        private final int CHANGE_FIRST_NAME = 1;
        private final int CHANGE_LAST_NAME = 2;
        private final int CHANGE_BIRTH_YEAR = 3;
        private final int CHANGE_YEAR_OF_HIRE = 4;
        private final int CHANGE_MONTHLY_SALARY = 5;
        private final int CHANGE_TAX_PERCENTAGE = 6;
        private final int PRINT_INFO = 7;
        private final int HAS_BEEN_HIRED_FOR_MORE_THAN = 8;
        private final int QUIT = 9;

        public ManagerMenu(Worker worker) {
            this.worker = worker;
        }

        public void OpenMenu() {

            System.out.println("\n1. Change first name");
            System.out.println("2. Change last name");
            System.out.println("3. Change birth year");
            System.out.println("4. Change year of hire");
            System.out.println("5. Change monthly salary");
            System.out.println("6. Change tax percentage");
            System.out.println("7. Print info");
            System.err.println("8. Has been hired for more than ... years");
            System.out.println("9. Quit");
            System.out.print("Enter choice: ");
            int choice = scan.nextInt();
            
            switch (choice) {

                case CHANGE_FIRST_NAME:
                    System.out.print("Enter new first name: ");
                    String newFirstName = scan.next();
                    worker.setFirstName(newFirstName);
                    break;

                case CHANGE_LAST_NAME:
                    System.out.print("Enter new last name: ");
                    String newLastName = scan.next();
                    worker.setLastName(newLastName);
                    break;
                
                case CHANGE_BIRTH_YEAR:
                    System.out.print("Enter new birth year: ");
                    int newBirthYear = scan.nextInt();
                    worker.setBirthYear(newBirthYear);
                    break;
                
                case CHANGE_YEAR_OF_HIRE:
                    System.out.print("Enter new year of hire: ");
                    int newYearOfHire = scan.nextInt();
                    worker.setYearOfHire(newYearOfHire);
                    break;

                case CHANGE_MONTHLY_SALARY:
                    System.out.print("Enter new monthly salary: ");
                    double newMonthlySalary = scan.nextDouble();
                    worker.setMonthlySalary(newMonthlySalary);
                    break;
                
                case CHANGE_TAX_PERCENTAGE:
                    System.out.print("Enter new tax percentage: ");
                    double newTaxPercentage = scan.nextDouble();
                    worker.setTaxPercentage(newTaxPercentage);
                    break;
                
                case PRINT_INFO:
                    break;

                case HAS_BEEN_HIRED_FOR_MORE_THAN:
                    System.out.print("Enter number of years: ");
                    int years = scan.nextInt();
                    System.out.println(worker.hasBeenHiredForMoreThanYears(years));
                    break;

                case QUIT:
                    System.exit(0);
                    break;
            }

        }

        public void printInfo() {
            System.out.println(worker.toString());
        }

    }

    public static void main(String[] args) {
        Person ola = new Person("Ola Haverstad", "Skyberg", 2006);
        Worker worker = new Worker(2022, 5000, 30, ola);
        ManagerMenu menu = new ManagerMenu(worker);

        // sjekk at det fungerer ved å kalle alle metodene i Worker-klassen
        menu.printInfo();

        while (true) {
            try {
                menu.OpenMenu();
                menu.printInfo();
            } catch (Exception IllegalArgumentException) {
                System.out.println(IllegalArgumentException);
            }
        }
    }
}