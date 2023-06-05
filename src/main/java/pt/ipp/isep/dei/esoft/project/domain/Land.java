package pt.ipp.isep.dei.esoft.project.domain;

import java.util.List;

/**
 * The type Property.
 */
public class Land extends Property {


    /**
     * Instantiates a new Land.
     *
     * @param area     the area
     * @param distance the distance
     * @param photos   the photos
     */
    /*public Land(double area, double distance, List<String> photos) {

        super(area, distance, photos);
    }
*/

    /**
     * Instantiates a new Land.
     *
     * @param propertytype the propertytype
     * @param area         the area
     * @param location     the location
     * @param distance     the distance
     * @param owner        the owner
     */
    public Land(PropertyType propertytype, double area, Location location, double distance, Owner owner) {
        super(propertytype, area, location, distance , owner);
    }

    @Override
    public String toString() {
        return String.format("%s%n", super.toString());
    }

}
