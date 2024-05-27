package nz.ac.auckland.se281;

import java.util.*;

public class WorldMap {

  private Map<Country, List<Country>> neighbourMap = new HashMap<>();

  public void addNeighbour(Country country) {
    neighbourMap.put(country, country.getNeighbours());
  }

  public List<Country> breadthFirstTraversal(Country startCountry, Country endCountry) {
    List<Country> visited = new ArrayList<>();
    Queue<Country> queue = new LinkedList<>();
    queue.add(startCountry);
    visited.add(startCountry);
    while (!queue.peek().equals(endCountry)) {
      Country currentCountry = queue.poll();
      for (Country neighbour : currentCountry.getNeighbours()) {
        if (!visited.contains(neighbour)) {
          visited.add(neighbour);
          queue.add(neighbour);
        }
      }
    }
    return visited;
  }

  public Map<Country, List<Country>> getNeighbourMap() {
    return neighbourMap;
  }

  public void setNeighbourMap(Map<Country, List<Country>> neighbourMap) {
    this.neighbourMap = neighbourMap;
  }
}
