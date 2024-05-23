package nz.ac.auckland.se281;

import java.util.*;

/** This class is the main entry point. */
public class MapEngine {

  private Set<Country> countryList = new HashSet<>();

  public MapEngine() {
    loadMap(); // keep this mehtod invocation
  }

  /** invoked one time only when constracting the MapEngine class. */
  private void loadMap() {

    List<String> countries = Utils.readCountries();
    for (String country : countries) {
      String[] parts = country.split(",");
      Country c = new Country(parts[0], parts[1], Integer.parseInt(parts[2]));
      countryList.add(c);
    }

    List<String> adjacencies = Utils.readAdjacencies();
    for (String adjacency : adjacencies) {
      String[] adjacents = adjacency.split(",");
      Country centreCountry = getCountry(adjacents[0]);

      for (int i = 1; i < adjacents.length; i++) {
        centreCountry.addNeighbour(getCountry(adjacents[i]));
      }
    }
  }

  /** this method is invoked when the user run the command info-country. */
  public void showInfoCountry() {
    MessageCli.INSERT_COUNTRY.printMessage();

    while (true) {
      String userInput = Utils.scanner.nextLine();
      userInput = Utils.capitalizeFirstLetterOfEachWord(userInput);
      String[] parsedInput = userInput.split(" ");

      // catch invalid country entered by the user
      for (String input : parsedInput) {
        try {
          getCountry(input);
        } catch (Exception InvalidCountryException) {
          MessageCli.INVALID_COUNTRY.printMessage(input);
          continue;
        }
        MessageCli.COUNTRY_INFO.printMessage(
            getCountry(input).getName(),
            getCountry(input).getContinent(),
            String.valueOf(getCountry(input).getTaxFee()));
        return;
      }
    }
  }

  /** this method is invoked when the user run the command route. */
  public void showRoute() {}

  public Country getCountry(String countryName) {
    for (Country c : countryList) {
      if (c.getName().equals(countryName)) {
        return c;
      }
    }
    throw new InvalidCountryException();
  }
}
