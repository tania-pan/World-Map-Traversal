package nz.ac.auckland.se281;

import java.util.*;

public class WorldMap {

  private Map<Country, List<Country>> neighbourMap = new HashMap<>();

  public void addNeighbour(Country country) {
    neighbourMap.put(country, country.getNeighbours());
  }

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

  public Map<Country, List<Country>> getNeighbourMap() {
    return neighbourMap;
  }

  public void setNeighbourMap(Map<Country, List<Country>> neighbourMap) {
    this.neighbourMap = neighbourMap;
  }
}
