package nz.ac.auckland.se281;

import java.util.*;

public class WorldMap {

  private Map<Country, List<Country>> neighbourMap = new HashMap<>();

  /** puts all the neighbouring countries of a country into a list */
  public void addNeighbour(Country country) {
    neighbourMap.put(country, country.getNeighbours());
  }

  /**
  * This method finds the route from one country to another using BFS algorithm.
  * 
  * @param startCountry starting country of the route
  * @param endCountry destination of the route
  * @return list of countries in the route
  */
  public List<Country> getRoute(Country startCountry, Country endCountry) {

    List<Country> visited = new ArrayList<>();
    Queue<Country> queue = new LinkedList<>();
    Map<Country, Country> parentMap = new HashMap<>();

    queue.add(startCountry);
    visited.add(startCountry);
    parentMap.put(startCountry, null);

    // BFS to find a path from start to destination
    while (!queue.peek().equals(endCountry)) {
      Country currentCountry = queue.poll();

      for (Country neighbour : currentCountry.getNeighbours()) {
        if (!visited.contains(neighbour)) {
          visited.add(neighbour);
          queue.add(neighbour);
          parentMap.put(neighbour, currentCountry); // mapping the parent country
        }
      }
    }

    // get route by tracing the parentMap from destination to source
    List<Country> route = new LinkedList<>();
    Country parent = endCountry;
    while (parent != null) {
      route.add(parent);
      parent = parentMap.get(parent);
    }

    Collections.reverse(route);

    return route;
  }

  /**
  * This method finds the shortest route from one country to another using BFS algorithm.
  * 
  * @param route
  * @return
  */
  public List<String> getContinentRoute(List<Country> route) {
    List<String> continentRoute = new LinkedList<>();
    for (Country country : route) {
      if (!continentRoute.contains(country.getContinent())) {
        continentRoute.add(country.getContinent());
      }
    }
    return continentRoute;
  }

  /**
  * This method returns the map of countries and their neighbours.
  * 
  * @return map of countries and their neighbours
  */
  public Map<Country, List<Country>> getNeighbourMap() {
    return neighbourMap;
  }

  /**
  * This method sets the map of countries and their neighbours.
  * 
  * @param neighbourMap map of countries and their neighbours
  */
  public void setNeighbourMap(Map<Country, List<Country>> neighbourMap) {
    this.neighbourMap = neighbourMap;
  }
}
