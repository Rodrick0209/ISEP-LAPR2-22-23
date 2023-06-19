package pt.ipp.isep.dei.esoft.project.domain;

import java.io.Serializable;
import java.util.Objects;
import java.util.List;

/**
 * The type Property.
 */
public class Property implements Serializable {

    private PropertyType type;
    private double area;
    private String location;

    private double distance;

    //private List<String> photos;

    private Owner owner;

    private static final String initialString = "n/a";


    /**
     * Instantiates a new Property.
     *
     * @param area     the area
     * @param distance the distance
     * @param photos   the photos
     */
    public Property(double area,double distance, List<String> photos) {
        if (area <= 0) {
            throw new IllegalArgumentException("Area must be greater than 0.");
        }
        if (distance <= 0) {
            throw new IllegalArgumentException("Distance from the city center must be greater than 0.");
        }
        if (photos == null) {
            throw new IllegalArgumentException("Is necessary more than 0 photos");
        }
    }

    /**
     * Instantiates a new Property.
     *
     * @param area     the area
     * @param distance the distance
     */
    public Property(int area, int distance) {
        this.area = area;
        this.distance = distance;
    }

    /**
     * Instantiates a new Property.
     *
     * @param area the area
     */
    public Property(double area) {
        this.area = area;
    }


    /**
     * Gets area.
     *
     * @return the area
     */
    public double getArea() {
        return area;
    }

    /**
     * Sets area.
     *
     * @param area the area
     */
    public void setArea(int area) {
        this.area = area;
    }

    /**
     * Sets distance.
     *
     * @param distance the distance
     */
    public void setDistance(int distance) {
        this.distance = distance;
    }

    /**
     * Gets distance.
     *
     * @return the distance
     */
    public double getDistance() {
        return distance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Property property = (Property) o;
        return area == property.area && distance == property.distance && Objects.equals(location, property.location);
    }

    @Override
    public int hashCode() {
        return Objects.hash(area, location, distance);
    }

    /**
     * Instantiates a new Property.
     *
     * @param type     the type
     * @param area     the area
     * @param location the location
     * @param distance the distance
     * @param owner    the owner
     */
    public Property(PropertyType type, double area, String location, double distance, Owner owner) {
        this.type = type;
        this.area = area;
        this.location = location;
        this.distance = distance;
        this.owner = owner;
    }


    public Property clone() {
        return new Property(this.type, this.area, this.location, this.distance, owner);
    }

    /**
     * Gets location.
     *
     * @return the location
     */
    public String getLocation() {
        return location;
    }

    /*public void setPhotos(Object o) {
    }*/

    @Override
    public String toString() {
        return "\nType: " + type  +
                "\nArea: " + area + " m2"+
                "\nLocation: " + location +
                "\nDistance of city centre: " + distance + " miles";
    }
}
