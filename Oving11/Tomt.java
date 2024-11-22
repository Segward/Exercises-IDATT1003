/** Represents a tomt */
public class Tomt {
  String kommuneNavn;
  String bruksNavn;
  String eierNavn;
  int kommuneNummer;
  int gårdsNummer;
  int bruksNummer;
  double areal;

  /**
   * Creates a new tomt.
   *
   * @param kommuneNavn String
   * @param bruksNavn String
   * @param eierNavn String
   * @param kommuneNummer int
   * @param gårdsNummer int
   * @param bruksNummer int
   * @param areal double
   */
  public Tomt(
      String kommuneNavn,
      String bruksNavn,
      String eierNavn,
      int kommuneNummer,
      int gårdsNummer,
      int bruksNummer,
      double areal) {
    this.kommuneNavn = kommuneNavn;
    this.eierNavn = eierNavn;
    this.bruksNavn = bruksNavn;
    this.kommuneNummer = kommuneNummer;
    this.gårdsNummer = gårdsNummer;
    this.bruksNummer = bruksNummer;
    this.areal = areal;
  }

  /**
   * Creates a new tomt from a string.
   *
   * @param tomtData The string to create the tomt from.
   */
  public Tomt(String tomtData) {
    String[] data = tomtData.split(",");
    kommuneNavn = data[0];
    eierNavn = data[1];
    bruksNavn = data[2];
    kommuneNummer = Integer.parseInt(data[3]);
    gårdsNummer = Integer.parseInt(data[4]);
    bruksNummer = Integer.parseInt(data[5]);
    areal = Double.parseDouble(data[6]);
  }

  /**
   * Gets the format string of the tomt.
   *
   * @return The format string kommmuneNummer-gårdsNummer/bruksNummer.
   */
  public String getFormatString() {
    return kommuneNummer + "-" + gårdsNummer + "/" + bruksNummer;
  }

  /**
   * Gets the full format string of the tomt.
   *
   * @return The full format string kommmuneNummer-gårdsNummer/bruksNummer kommuneNavn bruksNavn
   *     eierNavn areal.
   */
  public String getFullFormatString() {
    if (bruksNavn.equals("")) {
      return getFormatString() + " " + kommuneNavn + " " + eierNavn + " " + areal + "m²";
    }
    return getFormatString()
        + " "
        + kommuneNavn
        + " "
        + bruksNavn
        + " "
        + eierNavn
        + " "
        + areal
        + "m²";
  }

  /** Gets the string representation of the tomt with all fields and comma separator. */
  @Override
  public String toString() {
    return kommuneNavn
        + ","
        + eierNavn
        + ","
        + bruksNavn
        + ","
        + kommuneNummer
        + ","
        + gårdsNummer
        + ","
        + bruksNummer
        + ","
        + areal;
  }
}
