package nz.ac.auckland.se281;

import java.util.*;

public class Country {

  private String name;
  private String continent;
  private int taxFee;
  private List<Country> neighbours = new ArrayList<>();

  public Country(String name, String continent, int taxFee) {
    this.name = name;
    this.continent = continent;
    this.taxFee = taxFee;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((name == null) ? 0 : name.hashCode());
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this.name == ((Country) obj).getName()) {
      return true;
    } else {
      return false;
    }
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getContinent() {
    return continent;
  }

  public void setContinent(String continent) {
    this.continent = continent;
  }

  public int getTaxFee() {
    return taxFee;
  }

  public void setTaxFee(int taxFee) {
    this.taxFee = taxFee;
  }

  public List<Country> getNeighbours() {
    return neighbours;
  }

  public void addNeighbour(Country neighbour) {
    this.neighbours.add(neighbour);
  }
}
