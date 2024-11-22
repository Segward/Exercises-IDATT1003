public class Main {
  public static void main(String[] args) {
    TomtRegister tomtRegister = new TomtRegister();
    UserInterface userInterface = new UserInterface(tomtRegister);
    tomtRegister.load();
    userInterface.start();
    tomtRegister.save();
  }
}
