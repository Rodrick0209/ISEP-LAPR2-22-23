package pt.ipp.isep.dei.esoft.project.domain;

import java.util.List;
import java.util.ArrayList;


public class PropertiesList {

    private final List<Property> properties = new ArrayList<>();

    public List<Property> getProperties() {
        return properties;
    }

    private void addProperty(Property property) {
        properties.add(property);
    }

    private void removeProperty(Property property) {
        properties.remove(property);
    }

}
