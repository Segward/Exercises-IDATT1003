import java.util.ArrayList;
import java.util.Scanner;

/** UserInterface class for handling user input and output */
public class UserInterface {

  private Scanner scanner = new Scanner(System.in);
  private TomtRegister tomtRegister;
  private String options =
      "\n1. Register tomt\n"
          + "2. Delete tomt\n"
          + "3. Search for gårdsnummer\n"
          + "4. Search for tomt\n"
          + "5. List tomts\n"
          + "6. Get average area\n"
          + "7. Exit";

  /**
   * Constructor for UserInterface
   *
   * @param tomtRegister TomtRegister object used to store and manage Tomt objects
   */
  public UserInterface(TomtRegister tomtRegister) {
    this.tomtRegister = tomtRegister;
  }

  /**
   * Get user choice from options
   *
   * @param options which is a string of options
   * @return user choice as string
   */
  private String getStringChoice(String options) {
    System.out.println(options);
    System.out.print("Enter choice: ");
    return scanner.nextLine();
  }

  /**
   * Get user choice from options
   *
   * @param options which is a string of options
   * @return user choice as integer
   */
  private int getIntChoice(String options) {
    System.out.println(options);
    System.out.print("Enter choice: ");
    while (!scanner.hasNextInt()) {
      System.out.println("Invalid input. Please enter a valid number.");
      scanner.next();
      System.out.print("Enter choice: ");
    }
    int choice = scanner.nextInt();
    scanner.nextLine();
    return choice;
  }

  /**
   * Get user choice from options
   *
   * @param options which is a string of options
   * @return user choice as double
   */
  private double getDoubleChoice(String options) {
    System.out.println(options);
    System.out.print("Enter choice: ");
    while (true) {
      try {
        return Double.parseDouble(scanner.nextLine());
      } catch (NumberFormatException e) {
        System.out.println("Invalid input. Please enter a valid number.");
        System.out.print("Enter choice: ");
      }
    }
  }

  /** Register a tomt */
  private void registerTomt() {
    String kommuneNavn = getStringChoice("Enter kommune name: ");
    String bruksNavn = getStringChoice("Enter bruks name: ");
    String eierNavn = getStringChoice("Enter eier name: ");
    int kommuneNummer = getIntChoice("Enter kommune number: ");
    int gårdsNummer = getIntChoice("Enter gårds number: ");
    int bruksNummer = getIntChoice("Enter bruks number: ");
    double areal = getDoubleChoice("Enter areal: ");
    tomtRegister.registerTomt(
        new Tomt(kommuneNavn, bruksNavn, eierNavn, kommuneNummer, gårdsNummer, bruksNummer, areal));
  }

  /** Delete a tomt */
  private void deleteTomt() {
    int kommuneNummer = getIntChoice("Enter kommune number: ");
    int gårdsNummer = getIntChoice("Enter gårds number: ");
    int bruksNummer = getIntChoice("Enter bruks number: ");
    tomtRegister.deleteTomt(kommuneNummer, gårdsNummer, bruksNummer);
  }

  /** Search for tomts with a specific gårdsnummer */
  private void searchGårdsnummer() {
    int gårdsNummer = getIntChoice("Enter gårds number: ");
    ArrayList<Tomt> tomtsWithGårdsnummer = tomtRegister.getTomtsWithGårdsnummer(gårdsNummer);
    if (tomtsWithGårdsnummer.size() > 0) {
      for (Tomt tomt : tomtsWithGårdsnummer) {
        System.out.println(tomt.getFullFormatString());
      }
    } else {
      System.out.println("No tomts found with gårdsnummer " + gårdsNummer);
    }
  }

  /** List all tomts */
  private void listTomts() {
    tomtRegister.listTomts();
  }

  /** Search for a tomt */
  private void searchTomt() {
    int kommuneNummer = getIntChoice("Enter kommune number: ");
    int gårdsNummer = getIntChoice("Enter gårds number: ");
    int bruksNummer = getIntChoice("Enter bruks number: ");
    Tomt tomt = tomtRegister.searchTomt(kommuneNummer, gårdsNummer, bruksNummer);
    if (tomt != null) {
      System.out.println(tomt.getFullFormatString());
    } else {
      System.out.println("Tomt not found");
    }
  }

  /** Get average area of all tomts */
  private void averageArea() {
    System.out.println("Average area: " + tomtRegister.averageArea() + "m²");
  }

  /** Start the user interface */
  public void start() {
    while (true) {
      int choice = getIntChoice(options);
      System.out.println();
      switch (choice) {
        case 1:
          registerTomt();
          break;
        case 2:
          deleteTomt();
          break;
        case 3:
          searchGårdsnummer();
          break;
        case 4:
          searchTomt();
          break;
        case 5:
          listTomts();
          break;
        case 6:
          averageArea();
          break;
        case 7:
          System.out.println("Exiting...");
          scanner.close();
          return;
        default:
          System.out.println("Invalid choice");
      }
    }
  }
}
