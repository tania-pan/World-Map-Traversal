package nz.ac.auckland.se281;

public class InvalidCountryException extends RuntimeException {

  String input;

  public InvalidCountryException(String input) {
    MessageCli.INVALID_COUNTRY.printMessage(input);
  }
}
