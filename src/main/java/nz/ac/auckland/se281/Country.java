package nz.ac.auckland.se281;

import java.util.*;

public class Country {

  private String name;
  private String continent;
  private int taxFee;
  private List<Country> neighbours = new ArrayList<>();

  /**
   * Constructor for Country
   * 
   * @param name name of country
   * @param continent continent country is in
   * @param taxFee tax fee of country
   */
  public Country(String name, String continent, int taxFee) {
    this.name = name;
    this.continent = continent;
    this.taxFee = taxFee;
  }

  /**
   * Overriding the hashcode method to compare countries by their names
   * 
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
   * Overriding the equals method to compare countries by their names
   * 
   * @param obj country to compare
   * @return true if the countries are equal, false otherwise
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
   * Getter for country name
   * 
   * @return country name
   */
  public String getName() {
    return name;
  }

  /**
   * Setter for country name
   * 
   * @param name country name
   */
  public void setName(String name) {
    this.name = name;
  }

  /**
   * Getter for continent
   * 
   * @return continent
   */
  public String getContinent() {
    return continent;
  }

  /**
   * Setter for continent
   * 
   * @param continent continent
   */
  public void setContinent(String continent) {
    this.continent = continent;
  }

  /**
   * Getter for tax fee
   * 
   * @return tax fee
   */
  public int getTaxFee() {
    return taxFee;
  }

  /**
   * Setter for tax fee
   * 
   * @param taxFee tax fee
   */
  public void setTaxFee(int taxFee) {
    this.taxFee = taxFee;
  }

  /**
   * Getter for country's neighbours
   * 
   * @return list of neighbours
   */
  public List<Country> getNeighbours() {
    return neighbours;
  }

  /**
   * Setter for country's neighbours
   * 
   * @param neighbours list of neighbours
   */
  public void addNeighbour(Country neighbour) {
    this.neighbours.add(neighbour);
  }
}
