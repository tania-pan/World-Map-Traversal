package nz.ac.auckland.se281;

import java.util.*;

public class Country {

  private String name;
  private String continent;
  private int taxFee;
  private List<Country> neighbours = new ArrayList<>();

  /**
  * This is the constructor for the country object.
  
  * @param name      name of country
  * @param continent continent country is in
  * @param taxFee    tax fee of country
  */
  public Country(String name, String continent, int taxFee) {
    this.name = name;
    this.continent = continent;
    this.taxFee = taxFee;
  }

  /**
  * Overriding the hashcode method to compare countries by their names.
  
  * @return hashcode of the country
  */
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((name == null) ? 0 : name.hashCode());
    return result;
  }

  /**
  * Overriding the equals method to compare countries by their names.
  
  * @param obj country to compare
  * @return    true if the countries are equal, false otherwise
  */
  @Override
  public boolean equals(Object obj) {
    if (this.name == ((Country) obj).getName()) {
      return true;
    } else {
      return false;
    }
  }

  /**
  * This method is the getter for a country's name.
  
  * @return country name
  */
  public String getName() {
    return name;
  }

  /**
  * This method is the setter for a country's name.
  
  * @param name country's name
  */
  public void setName(String name) {
    this.name = name;
  }

  /**
  * This method is the getter for a country's continent.
  
  * @return continent that the country is in
  */
  public String getContinent() {
    return continent;
  }

  /**
  * This method is the setter for a country's continent.
  
  * @param continent continent that the country is in
  */
  public void setContinent(String continent) {
    this.continent = continent;
  }

  /**
  * This method is the getter for tax fee.
  
  * @return tax fee
  */
  public int getTaxFee() {
    return taxFee;
  }

  /**
  * This method is the setter for a country's tax fee.
  
  * @param taxFee tax fee
  */
  public void setTaxFee(int taxFee) {
    this.taxFee = taxFee;
  }

  /**
  * This method is the getter for a country's neighbours.
  
  * @return list of neighbours
  */
  public List<Country> getNeighbours() {
    return neighbours;
  }

  /**
  * This method is the setter for country's neighbours.

  * @param neighbour neighbouring country to add
  */
  public void addNeighbour(Country neighbour) {
    this.neighbours.add(neighbour);
  }
}
