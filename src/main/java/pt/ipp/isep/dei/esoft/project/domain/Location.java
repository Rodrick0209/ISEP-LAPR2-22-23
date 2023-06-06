
package pt.ipp.isep.dei.esoft.project.domain;

import java.util.Objects;


/**
 * The type Location.
 */
public class Location {
    private String street;
    private String city;
    private String state;
    private int zipCode;


    /**
     * Instantiates a new Location.
     *
     * @param street  the street
     * @param city    the city
     * @param state   the state
     * @param zipCode the zip code
     */
    public Location(String street, String city, String state, int zipCode){
        this.street = street;
        this.city = city;
        this.state = state;
        if(zipCode < 10000 || zipCode > 99999){
            throw new IllegalArgumentException("Invalid zip code");
        }else{
            this.zipCode = zipCode;
        }

    }


    /**
     * Sets street.
     *
     * @param street the street
     */
    public void setStreet(String street) {
        this.street = street;
    }


    /**
     * Sets city.
     *
     * @param city the city
     */
    public void setCity(String city) {
        this.city = city;
    }


    /**
     * Sets state.
     *
     * @param state the state
     */
    public void setState(String state) {
        this.state = state;
    }


    /**
     * Sets zip code.
     *
     * @param zipCode the zip code
     */
    public void setZipCode(int zipCode) {
        this.zipCode = zipCode;
    }


    /**
     * Gets street.
     *
     * @return the street
     */
    public String getStreet() {
        return street;
    }


    /**
     * Gets city.
     *
     * @return the city
     */
    public String getCity() {
        return city;
    }


    /**
     * Gets state.
     *
     * @return the state
     */
    public String getState() {
        return state;
    }


    /**
     * Gets zip code.
     *
     * @return the zip code
     */
    public int getZipCode() {
        return zipCode;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Location adress = (Location) o;
        return zipCode == adress.zipCode && street.equals(adress.street) && city.equals(adress.city) && state.equals(adress.state);
    }

    @Override
    public int hashCode() {
        return Objects.hash(street, city, state, zipCode);
    }

    @Override
    public String toString() {
        return String.format (
                "Street: %s%n" + "City: %s%n" + "State: %s%n"+ "ZipCode:%s",street,city, state,zipCode);

    }

}

