package pt.ipp.isep.dei.esoft.project.repository;

import pt.ipp.isep.dei.esoft.project.domain.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * The type Property repository.
 */
public class PropertyRepository implements Serializable {
    private final List<Property> properties = new ArrayList<>();

    /**
     * Get property by location property.
     *
     * @param location the property location
     * @return the property
     */
    public Property getPropertyByLocation(Location location){
        Property property = null;
        for (Property p : properties){
            if (p.getLocation().equals(location)){
                property = p;
            }
        }
        if(property == null){
            throw new IllegalArgumentException("Property not found");
        }
        return property;
    }

    /**
     * Add optional.
     *
     * @param property the property
     * @return the optional
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

    public Optional<Property> createLand(PropertyType propertyType, double area, Location location, double distance, Owner owner){
        Optional<Property> optionalValue = Optional.empty();

        Land land = new Land(propertyType, area, location, distance , owner);

        if(addProperty(land)){
            optionalValue = Optional.of(land);
        }
        return optionalValue;
    }

    public Optional<Property> createApartment(PropertyType propertyType, double area, Location location, double distance , int numberOfBedrooms, int numberOfBathrooms, int numberOfParkingSpaces, boolean centralHeating, boolean airConditioning , Owner owner ){
        Optional<Property> optionalValue = Optional.empty();

        Apartment apartment = new Apartment(propertyType, area, location, distance ,numberOfBedrooms, numberOfBathrooms, numberOfParkingSpaces, centralHeating, airConditioning, owner);

        if(addProperty(apartment)){
            optionalValue = Optional.of(apartment);
        }
        return optionalValue;
    }

    public Optional<Property> createHouse(PropertyType propertyType, double area, Location location, double distance, int numberOfBedrooms, int numberOfBathrooms, int numberOfParkingSpaces, boolean centralHeating, boolean airConditioning, boolean existenceOfAnBasement, boolean inhabitableLoft, String sunExposure , Owner owner){
        Optional<Property> optionalValue = Optional.empty();

        House house = new House(propertyType, area, location, distance, numberOfBedrooms, numberOfBathrooms, numberOfParkingSpaces, centralHeating, airConditioning, existenceOfAnBasement, inhabitableLoft, sunExposure, owner);

        if(addProperty(house)){
            optionalValue = Optional.of(house);
        }
        return optionalValue;
    }

    public boolean addProperty(Property property){
        boolean success = false;
        if(validateProperty(property)){
            success = properties.add(property);
        }
        return success;
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


