package pt.ipp.isep.dei.esoft.project.repository;

import pt.ipp.isep.dei.esoft.project.domain.Land;
import pt.ipp.isep.dei.esoft.project.domain.Property;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * The type Property repository.
 */
public class PropertyRepository {
    private final List<Property> properties = new ArrayList<>();

    /**
     * Get property by location property.
     *
     * @param location the property location
     * @return the property
     */
    public Property getPropertyByLocation(String location){
        Property land = null;
        for (Property p : properties){
            if (p.getLocation().equalsIgnoreCase(location)){
                land = p;
            }
        }
        if(land == null){
            throw new IllegalArgumentException("Property not found");
        }
        return land;
    }

    /**
     * Add optional.
     *
     * @param land the property
     * @return the optional
     */
    public Optional<Property> add(Property property){

        Optional<Land> newProperty = Optional.empty();
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

    /**
     * Gets properties.
     *
     * @return the properties
     */
    public List<Property> getProperties() {
        return List.copyOf(properties);
    }
}


