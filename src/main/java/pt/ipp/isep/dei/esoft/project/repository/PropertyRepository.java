package pt.ipp.isep.dei.esoft.project.repository;

import pt.ipp.isep.dei.esoft.project.domain.Location;
import pt.ipp.isep.dei.esoft.project.domain.Property;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class PropertyRepository {
    private final List<Property> properties = new ArrayList<>();

    /**
     *
     * @param location the property location inputted
     * @return the property by his location
     */
    public Property getPropertyByLocation(Location location){
        Property newProperty = new Property(location);
        Property property = null;
        if(properties.contains(newProperty)){
            property = properties.get(properties.indexOf(newProperty));
        }
        if(property == null){
            throw new IllegalArgumentException("Property not found");
        }
        return property;
    }

    /**
     *
     * @param property the property registered/added
     * @return the list of property added
     */
    public Optional<Property> add(Property property){

        Optional<Property> newProperty = Optional.empty();
        boolean operationSuccess = false;

        if(validateProperty(property)){
            newProperty = Optional.of(property.clone());
            operationSuccess = properties.add(newProperty.get());
        }

        if(!operationSuccess){
            newProperty = Optional.empty();
        }
        return newProperty;
    }

    /**
     *
     * @param property the property registered/added
     * @return if the property is already contained on the property list
     */
    private boolean validateProperty(Property property){return !properties.contains(property);}

    /**
     *
     * @return a copy of the list of properties
     */
    public List<Property> getProperties() {
        return List.copyOf(properties);
    }
}
