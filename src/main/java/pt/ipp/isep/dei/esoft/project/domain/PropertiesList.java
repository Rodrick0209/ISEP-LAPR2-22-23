package pt.ipp.isep.dei.esoft.project.domain;

import java.util.List;
import java.util.ArrayList;


/**
 * The type Properties list.
 */
public class PropertiesList {

    private final List<Land> properties = new ArrayList<>();

    /**
     * Gets properties.
     *
     * @return the properties
     */
    public List<Land> getProperties() {
        return properties;
    }

    private void addProperty(Land land) {
        properties.add(land);
    }

    private void removeProperty(Land land) {
        properties.remove(land);
    }

}
