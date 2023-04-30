package pt.ipp.isep.dei.esoft.project.repository;

import pt.ipp.isep.dei.esoft.project.domain.Property;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class PropertyRepository {
    private final List<Property> properties = new ArrayList<>();

    public Property getPropertyByLocation(String propertyLocation){
        Property newProperty = new Property(propertyLocation);
        Property property = null;
        if(properties.contains(property)){
            property = properties.get(properties.indexOf(newProperty));
        }
        if(property == null){
            throw new IllegalArgumentException("Property not found");
        }
        return property;
    }

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

    private boolean validateProperty(Property property){return !properties.contains(property);}

    public List<Property> getProperties() {
        return List.copyOf(properties);
    }
}


