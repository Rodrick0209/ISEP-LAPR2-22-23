package pt.ipp.isep.dei.esoft.project.domain;

import java.util.List;

/**
 * The type Property.
 */
public class Land extends Property {



    public Land(double area, double distance, List<String> photos) {
        super(area, distance, photos);
    }

    public Land(PropertyType propertyType, int area, Location location, int distance) {
        super(propertyType, area, location, distance);
    }

    public Land(PropertyType propertytype, double area, Location location, double distance, List<String> photos, Owner owner) {
        super(propertytype, area, location, distance, photos, owner);
    }

    public Land(PropertyType type, double area, Location location, double distance, Owner owner) {
        super(type, area, location, distance, owner);
    }


}
