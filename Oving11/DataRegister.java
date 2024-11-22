import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/** Data register that accesses TomtData.csv */
public class DataRegister {
  final String filePath;

  /**
   * Constructor
   *
   * @param filePath Path to file that will be used to store data
   */
  public DataRegister(String filePath) {
    this.filePath = filePath;
  }

  /**
   * Save data to file with BufferedWriter and FileWriter
   *
   * @param data ArrayList of strings
   */
  public void save(ArrayList<String> data) {
    try (BufferedWriter bw = new BufferedWriter(new FileWriter(filePath))) {
      clear();
      for (String line : data) {
        bw.write(line);
        bw.newLine();
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  /**
   * Load data from file with BufferedReader and FileReader
   *
   * @return ArrayList of strings
   */
  public ArrayList<String> load() {
    ArrayList<String> data = new ArrayList<>();
    try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
      String line;
      while ((line = br.readLine()) != null) {
        data.add(line);
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
    return data;
  }

  /** Clears the data by setting data to nothing */
  private void clear() {
    try (BufferedWriter bw = new BufferedWriter(new FileWriter(filePath))) {
      bw.write("");
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
