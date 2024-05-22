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
      for (int i = 1; i < adjacents.length; i++) {
        for (Country c : countryList) {
          if (c.getName().equalsIgnoreCase(adjacents[0])) {
            for (Country n : countryList) {
              if (n.getName().equalsIgnoreCase(adjacents[i])) {
                c.addNeighbour(n);
              }
            }
          }
        }
      }
    }
  }

  /** this method is invoked when the user run the command info-country. */
  public void showInfoCountry() {
    MessageCli.INSERT_COUNTRY.printMessage();
    String country = Utils.scanner.nextLine();

    // i reckon change this to something about hash codes tho maybe
    for (Country c : countryList) {
      if (c.getName().equalsIgnoreCase(country)) {
        MessageCli.COUNTRY_INFO.printMessage(
            c.getName(), c.getContinent(), String.valueOf(c.getTaxFee()));
        return;
      }
    }
  }

  /** this method is invoked when the user run the command route. */
  public void showRoute() {}
}
