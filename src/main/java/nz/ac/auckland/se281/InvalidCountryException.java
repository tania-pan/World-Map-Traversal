package nz.ac.auckland.se281;

public class InvalidCountryException extends RuntimeException {

  /**
  * This constructor is invoked when the user inputs an invalid country.
  * 
  * @param input the invalid country input
  */
  public InvalidCountryException(String input) {
    MessageCli.INVALID_COUNTRY.printMessage(input);
  }
}
