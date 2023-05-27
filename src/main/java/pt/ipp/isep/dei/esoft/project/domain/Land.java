package pt.ipp.isep.dei.esoft.project.domain;

import java.util.List;

/**
 * The type Property.
 */
public class Land extends Property {



    public Land(double area, double distance, List<String> photos) {
        super(area, distance, photos);
    }

    public Land(PropertyType land, int area, Location location, int distance) {
        super(String.valueOf(location));
    }

    public Land(PropertyType type, double area, Location location, double distance, List<String> photos) {
        super(type, area, String.valueOf(location), distance, photos);
    }

    public Land(PropertyType type, double area, Location location, double distance) {
        super(type, area, String.valueOf(location), distance);
    }


}
