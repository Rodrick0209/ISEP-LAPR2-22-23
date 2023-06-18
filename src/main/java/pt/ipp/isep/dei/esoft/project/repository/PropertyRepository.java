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
    public Property getPropertyByLocation(String location){
        Property property = null;
        for (Property p : properties){
            if (p.getLocation().equalsIgnoreCase(location)){
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

    /**
     * Create land optional.
     *
     * @param propertyType the property type
     * @param area         the area
     * @param location     the location
     * @param distance     the distance
     * @param owner        the owner
     * @return the optional
     */
    public Optional<Property> createLand(PropertyType propertyType, double area, String location, double distance, Owner owner){
        Optional<Property> optionalValue = Optional.empty();

        Land land = new Land(propertyType, area, location, distance , owner);

        if(addProperty(land)){
            optionalValue = Optional.of(land);
        }
        return optionalValue;
    }

    /**
     * Create apartment optional.
     *
     * @param propertyType          the property type
     * @param area                  the area
     * @param location              the location
     * @param distance              the distance
     * @param numberOfBedrooms      the number of bedrooms
     * @param numberOfBathrooms     the number of bathrooms
     * @param numberOfParkingSpaces the number of parking spaces
     * @param centralHeating        the central heating
     * @param airConditioning       the air conditioning
     * @param owner                 the owner
     * @return the optional
     */
    public Optional<Property> createApartment(PropertyType propertyType, double area, String location, double distance , int numberOfBedrooms, int numberOfBathrooms, int numberOfParkingSpaces, boolean centralHeating, boolean airConditioning , Owner owner ){
        Optional<Property> optionalValue = Optional.empty();

        Apartment apartment = new Apartment(propertyType, area, location, distance ,numberOfBedrooms, numberOfBathrooms, numberOfParkingSpaces, centralHeating, airConditioning, owner);

        if(addProperty(apartment)){
            optionalValue = Optional.of(apartment);
        }
        return optionalValue;
    }

    /**
     * Create house optional.
     *
     * @param propertyType          the property type
     * @param area                  the area
     * @param location              the location
     * @param distance              the distance
     * @param numberOfBedrooms      the number of bedrooms
     * @param numberOfBathrooms     the number of bathrooms
     * @param numberOfParkingSpaces the number of parking spaces
     * @param centralHeating        the central heating
     * @param airConditioning       the air conditioning
     * @param existenceOfAnBasement the existence of an basement
     * @param inhabitableLoft       the inhabitable loft
     * @param sunExposure           the sun exposure
     * @param owner                 the owner
     * @return the optional
     */
    public Optional<Property> createHouse(PropertyType propertyType, double area, String location, double distance, int numberOfBedrooms, int numberOfBathrooms, int numberOfParkingSpaces, boolean centralHeating, boolean airConditioning, boolean existenceOfAnBasement, boolean inhabitableLoft, String sunExposure , Owner owner){
        Optional<Property> optionalValue = Optional.empty();

        House house = new House(propertyType, area, location, distance, numberOfBedrooms, numberOfBathrooms, numberOfParkingSpaces, centralHeating, airConditioning, existenceOfAnBasement, inhabitableLoft, sunExposure, owner);

        if(addProperty(house)){
            optionalValue = Optional.of(house);
        }
        return optionalValue;
    }

    /**
     * Add property boolean.
     *
     * @param property the property
     * @return the boolean
     */
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

    public boolean removeProperty(Property property){
        return properties.remove(property);
    }

    public void clear(){properties.clear();}
}


