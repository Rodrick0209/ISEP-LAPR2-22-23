package pt.ipp.isep.dei.esoft.project.domain;

import java.util.List;

/**
 * The type Property.
 */
public class Land extends Property {



    public Land(double area, double distance, List<String> photos) {
        super(area, distance, photos);
    }


    public Land(PropertyType propertytype, double area, Location location, double distance, Owner owner) {
        super(propertytype, area, location, distance , owner);
    }

    @Override
    public String toString() {
        return String.format("%s%n", super.toString());
    }
}
