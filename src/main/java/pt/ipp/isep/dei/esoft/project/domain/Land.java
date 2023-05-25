package pt.ipp.isep.dei.esoft.project.domain;

import java.util.Objects;
import java.util.List;

/**
 * The type Property.
 */
public class Land extends Property {


    public Land(double area, double distance, List<String> photos) {
        super(area, distance, photos);
    }

    public Land(int area, int distance) {
        super(area, distance);
    }

    public Land(String location) {
        super(location);
    }

    public Land(String type, double area, String location, double distance, List<String> photos, Owner owner) {
        super(type, area, location, distance, photos, owner);
    }

    public Land(String type, double area, String location, double distance, Owner owner) {
        super(type, area, location, distance, owner);
    }


}
