package pt.ipp.isep.dei.esoft.project.domain;

import java.util.List;
import java.util.Objects;

/**
 * The type Apartment.
 */
public class Apartment extends Property {

    private Owner owner ;
    private String type;
    private double area;
    private Location location;

    private double distance;

    private List<String> photos;

    private int n_bedrooms;
    private int n_bathrooms;
    private int n_parkingSpaces;
    private String avaiableEquip;

    private final boolean centralHeating;
    private final boolean airConditioning;


    /**
     * Instantiates a new Apartment.
     *
     * @param area            the area
     * @param location        the location
     * @param distance        the distance
     * @param n_bedrooms      the n bedrooms
     * @param n_bathrooms     the n bathrooms
     * @param n_parkingSpaces
     */



    public Apartment(PropertyType typeName, double area, Location location, double distance , int n_bedrooms, int n_bathrooms, int n_parkingSpaces, boolean centralHeating, boolean airConditioning , Owner owner) {
        super(typeName, area, location, distance, owner);
        this.n_bedrooms = n_bedrooms;
        this.n_bathrooms = n_bathrooms;
        this.n_parkingSpaces = n_parkingSpaces;
        this.centralHeating = centralHeating;
        this.airConditioning = airConditioning;
    }

    public Apartment(int area, int distance, boolean centralHeating, boolean airConditioning) {
        super(area, distance);
        this.centralHeating = centralHeating;
        this.airConditioning = airConditioning;
    }

    /**
     * Gets n bedrooms.
     *
     * @return the n bedrooms
     */
    public int getN_bedrooms() {
        return n_bedrooms;
    }

    /**
     * Sets n bedrooms.
     *
     * @param n_bedrooms the n bedrooms
     */
    public void setN_bedrooms(int n_bedrooms) {
        this.n_bedrooms = n_bedrooms;
    }

    /**
     * Gets n bathrooms.
     *
     * @return the n bathrooms
     */
    public int getN_bathrooms() {
        return n_bathrooms;
    }

    /**
     * Sets n bathrooms.
     *
     * @param n_bathrooms the n bathrooms
     */
    public void setN_bathrooms(int n_bathrooms) {
        this.n_bathrooms = n_bathrooms;
    }

    /**
     * Gets n parking spaces.
     *
     * @return the n parking spaces
     */
    public int getN_parkingSpaces() {
        return n_parkingSpaces;
    }

    /**
     * Sets n parking spaces.
     *
     * @param n_parkingSpaces the n parking spaces
     */
    public void setN_parkingSpaces(int n_parkingSpaces) {
        this.n_parkingSpaces = n_parkingSpaces;
    }

    /**
     * Gets avaiable equip.
     *
     * @return the avaiable equip
     */
    public String getAvaiableEquip() {
        return avaiableEquip;
    }

    /**
     * Sets avaiable equip.
     *
     * @param avaiableEquip the avaiable equip
     */
    public void setAvaiableEquip(String avaiableEquip) {
        this.avaiableEquip = avaiableEquip;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Apartment apartment = (Apartment) o;
        return n_bedrooms == apartment.n_bedrooms && n_bathrooms == apartment.n_bathrooms && n_parkingSpaces == apartment.n_parkingSpaces && avaiableEquip.equals(apartment.avaiableEquip);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), n_bedrooms, n_bathrooms, n_parkingSpaces, avaiableEquip);
    }

    public boolean getCentralHeating() {
        return centralHeating;
    }

    public boolean getAirConditioning() {
        return airConditioning;
    }
}

