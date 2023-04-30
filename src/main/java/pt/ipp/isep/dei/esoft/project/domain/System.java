package pt.ipp.isep.dei.esoft.project.domain;

import java.util.List;
import java.util.ArrayList;

public class System {

    private PropertiesList propertiesList;

    public Filter createFilter() {
        return new Filter();
    }

    public List<Property> searchPropertiesByFilter(Filter filter) {
        List<Property> properties = propertiesList.getProperties();
        List<Property> filteredProperties = new ArrayList<Property>();

        for (Property property : properties) {
            if (filter.matches(property)) {
                filteredProperties.add(property);
            }
        }

        return filteredProperties;
    }
}
