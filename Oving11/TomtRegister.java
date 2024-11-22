import java.util.ArrayList;

/** Tomt register that handles tomts, accesses data on load and save */
public class TomtRegister {

  DataRegister dataRegister = new DataRegister("TomtData.csv");
  ArrayList<Tomt> tomtList = new ArrayList<>();

  /**
   * Registers a tomt.
   *
   * @param tomt The tomt to register.
   */
  public void registerTomt(Tomt tomt) {
    tomtList.add(tomt);
  }

  /**
   * Deletes a tomt.
   *
   * @param kommuneNummer int
   * @param gårdsNummer int
   * @param bruksNummer int
   */
  public void deleteTomt(int kommuneNummer, int gårdsNummer, int bruksNummer) {
    Tomt tomt = searchTomt(kommuneNummer, gårdsNummer, bruksNummer);
    if (tomt != null) {
      tomtList.remove(tomt);
    }
  }

  /**
   * 3 Gets all tomts with a given kommune number.
   *
   * @param kommuneNummer The kommune number to search for.
   * @return A list of tomts with the given kommune number.
   */
  public ArrayList<Tomt> getTomtsWithGårdsnummer(int gårdsnummer) {
    ArrayList<Tomt> tomtsWithGårdsnummer = new ArrayList<>();
    for (Tomt tomt : tomtList) {
      if (tomt.gårdsNummer == gårdsnummer) {
        tomtsWithGårdsnummer.add(tomt);
      }
    }
    return tomtsWithGårdsnummer;
  }

  /** Saves the tomt data to a file. */
  public void save() {
    ArrayList<String> data = new ArrayList<>();
    for (Tomt tomt : tomtList) {
      data.add(tomt.toString());
    }
    dataRegister.save(data);
  }

  /** Loads the tomt data from a file. */
  public void load() {
    ArrayList<String> data = dataRegister.load();
    for (String tomtData : data) {
      tomtList.add(new Tomt(tomtData));
    }
  }

  /** Lists the tomts stored in tomtList */
  public void listTomts() {
    for (Tomt tomt : tomtList) {
      System.out.println(tomt.getFullFormatString());
    }
  }

  /**
   * Gets the list of tomts stored in tomtList.
   *
   * @return The list of tomts stored in tomtList
   */
  public ArrayList<Tomt> getTomtList() {
    return tomtList;
  }

  /**
   * Searches for a tomt.
   *
   * @param kommuneNummer int
   * @param gårdsNummer int
   * @param bruksNummer int
   * @return The tomt if found, otherwise null.
   */
  public Tomt searchTomt(int kommuneNummer, int gårdsNummer, int bruksNummer) {
    for (Tomt tomt : tomtList) {
      if (tomt.kommuneNummer == kommuneNummer
          && tomt.gårdsNummer == gårdsNummer
          && tomt.bruksNummer == bruksNummer) {
        return tomt;
      }
    }
    return null;
  }

  /**
   * Calculates the average area
   *
   * @return Double average area of the tomts stored in tomtList
   */
  public double averageArea() {
    double totalArea = 0;
    for (Tomt tomt : tomtList) {
      totalArea += tomt.areal;
    }
    return totalArea / tomtList.size();
  }
}
