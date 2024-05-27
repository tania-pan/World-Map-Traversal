package nz.ac.auckland.se281;

import java.util.*;

public class MapEngine {

  private Set<Country> countryList = new HashSet<>();
  private WorldMap worldMap = new WorldMap();

  public MapEngine() {
    loadMap();
  }

  private void loadMap() {

    // adding the countries
    List<String> countries = Utils.readCountries();
    for (String country : countries) {
      String[] parts = country.split(",");
      Country c = new Country(parts[0], parts[1], Integer.parseInt(parts[2]));
      countryList.add(c);
    }

    // adding the neighbours of each country
    List<String> adjacencies = Utils.readAdjacencies();
    for (String adjacency : adjacencies) {
      String[] adjacents = adjacency.split(",");
      Country centreCountry = getCountryIfValid(adjacents[0]);

      for (int i = 1; i < adjacents.length; i++) {
        centreCountry.addNeighbour(getCountryIfValid(adjacents[i]));
      }
    }

    // mapping the neighbours of each country to the country
    for (Country country : countryList) {
      worldMap.addNeighbour(country);
    }
  }

  /** this method is invoked when the user run the command info-country. */
  public void showInfoCountry() {

    Country country;
    MessageCli.INSERT_COUNTRY.printMessage();
    country = getUserInput();

    MessageCli.COUNTRY_INFO.printMessage(
        country.getName(), country.getContinent(), String.valueOf(country.getTaxFee()));
  }

  /** this method is invoked when the user run the command route. */
  public void showRoute() {
    Country startCountry;
    Country endCountry;
    int taxFee = 0;

    MessageCli.INSERT_SOURCE.printMessage();
    startCountry = getUserInput();
    MessageCli.INSERT_DESTINATION.printMessage();
    endCountry = getUserInput();

    // check if the start and end countries are the same
    if (startCountry.equals(endCountry)) {
      MessageCli.NO_CROSSBORDER_TRAVEL.printMessage();
      return;
    }

    List<Country> route = worldMap.getRoute(startCountry, endCountry);

    // convert route to string and add up tax fee
    ArrayList<String> routeNames = new ArrayList<>();
    for (Country c : route) {
      routeNames.add(c.getName());
      taxFee += c.getTaxFee();
    }

    MessageCli.ROUTE_INFO.printMessage(routeNames.toString());
  }

  public Country getCountryIfValid(String countryName) {
    for (Country c : countryList) {
      if (c.getName().equals(countryName)) {
        return c;
      }
    }
    throw new InvalidCountryException(countryName);
  }

  public Country getUserInput() {

    Country country;

    // get user input until a valid country is entered
    while (true) {
      String userInput = Utils.scanner.nextLine();
      userInput = Utils.capitalizeFirstLetterOfEachWord(userInput);

      // check if the user inputted country exists
      try {
        country = getCountryIfValid(userInput);
      } catch (Exception InvalidCountryException) {
        continue;
      }

      // no errors so input is valid
      return country;
    }
  }
}
