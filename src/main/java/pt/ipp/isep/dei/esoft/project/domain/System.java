/*
package pt.ipp.isep.dei.esoft.project.domain;


import java.util.List;
import java.util.ArrayList;
import java.util.logging.Filter;
import java.util.logging.LogRecord;

public class System {

    private PropertiesList propertiesList;

    public Filter createFilter() {
        return new Filter() {
            @Override
            public boolean isLoggable(LogRecord record) {
                return false;
            }
        };
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
*/