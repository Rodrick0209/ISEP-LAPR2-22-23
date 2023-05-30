package pt.ipp.isep.dei.esoft.project.application.controller;


import pt.ipp.isep.dei.esoft.project.domain.*;
import pt.ipp.isep.dei.esoft.project.repository.*;
import pt.ipp.isep.dei.esoft.project.ui.console.utils.Utils;
import pt.isep.lei.esoft.auth.domain.model.Email;

import java.util.List;

/**
 * The type Create request controller.
 */
public class CreateRequestController {

    private TypeBusinessRepository typeBusinessRepository;

    private PropertyRepository propertyRepository;

    private PropertyTypeRepository propertyTypeRepository;

    private AuthenticationRepository authenticationRepository;

    /**
     * Instantiates a new Create request controller.
     */
    public CreateRequestController(){
        getTypeBusinessRepository();
    }


    /**
     * Create request boolean.
     *
     * @param requestType      the request type
     * @param propertyType     the property type
     * @param area             the area
     * @param location         the location
     * @param distance         the distance
     * @param photos           the photos
     * @param n_bedrooms       the n bedrooms
     * @param n_bathrooms      the n bathrooms
     * @param n_parkingSpaces  the n parking spaces
     * @param avaiableEquip    the avaiable equip
     * @param price            the price
     * @param rentprice        the rentprice
     * @param contractduration the contractduration
     * @return the boolean
     */
    public boolean createRequest(String requestType, String propertyType, String area, String location, double distance, int photos, int n_bedrooms, int n_bathrooms, int n_parkingSpaces, String avaiableEquip, boolean price, boolean rentprice, String contractduration){
        return createRequest(requestType, propertyType,area, location,distance,photos,n_bedrooms, n_bathrooms, n_parkingSpaces, avaiableEquip, price, rentprice,contractduration);
    }

    /**
     * Add request.
     */
    public void addRequest() {

    }

    /**
     * Gets type business.
     *
     * @return the type business
     */
    public List<TypeBusiness> getTypeBusiness() {
        return getTypeBusinessRepository().getTypeBusiness();
    }

    /**
     * Gets type business repository.
     *
     * @return the type business repository
     */
    public TypeBusinessRepository getTypeBusinessRepository() {
        if(typeBusinessRepository == null){
            Repositories repositories = Repositories.getInstance();
            typeBusinessRepository = repositories.getTypeBusinessRepository();
        }
        return typeBusinessRepository;
    }

    /**
     * Gets property types.
     *
     * @return the property types
     */
    public List<PropertyType> getPropertyTypes() {
        return  getPropertyTypeRepository().getPropertyTypes();
    }

    private PropertyTypeRepository getPropertyTypeRepository() {
        if(propertyTypeRepository == null){
            Repositories repositories = Repositories.getInstance();
            propertyTypeRepository = repositories.getPropertyTypeRepository();
        }
        return  propertyTypeRepository;
    }

    /**
     * Gets sell land.
     *
     * @return the sell land
     */
    public Land getSellLand() {
        int area = Utils.readIntegerFromConsole("Area in squad meters");
        String street = Utils.readLineFromConsole("Street");
        String city = Utils.readLineFromConsole("City");
        String state = Utils.readLineFromConsole("State");
        int zipCode = Utils.readIntegerFromConsole("Zipcode");
        int distance = Utils.readIntegerFromConsole("Distance from the city center");
        Location location = new Location( street , city , state , zipCode);
        Owner owner = getOwnerFromSession();
        return new Land(new PropertyType("Land"), area, location, distance , owner);


    }

    /**
     * Gets rent land.
     *
     * @return the rent land
     */
    public Land getRentLand() {
        int area = Utils.readIntegerFromConsole("Area in squad meters");
        String street = Utils.readLineFromConsole("Street");
        String city = Utils.readLineFromConsole("City");
        String state = Utils.readLineFromConsole("State");
        int zipCode = Utils.readIntegerFromConsole("Zipcode");
        int distance = Utils.readIntegerFromConsole("Distance from the city center");
        Location location = new Location( street , city , state , zipCode);
        Owner owner = getOwnerFromSession();
        return new Land(new PropertyType("Land"), area, location, distance , owner );
    }


    /**
     * Gets sell apartment.
     *
     * @return the sell apartment
     */
    public Apartment getSellApartment() {
        int area = Utils.readIntegerFromConsole("Area in squad meters");
        String street = Utils.readLineFromConsole("Street");
        String city = Utils.readLineFromConsole("City");
        String state = Utils.readLineFromConsole("State");
        int zipCode = Utils.readIntegerFromConsole("Zipcode");
        int distance = Utils.readIntegerFromConsole("Distance from the city center");
        int n_bedrooms = Utils.readIntegerFromConsole("Number of bedrooms");
        int n_bathrooms = Utils.readIntegerFromConsole("Number of bathrooms");
        int n_parkingSpaces = Utils.readIntegerFromConsole("Number of parking spaces");
        String flag = Utils.readLineFromConsole("central heating ");
        boolean centralHeating;
        if( flag.equalsIgnoreCase("true")){
            centralHeating = true;
        }else {
            centralHeating = false;
        }
        String flag2 = Utils.readLineFromConsole("air conditioning ");
        boolean airConditioning;
        if( flag2.equalsIgnoreCase("true")){
            airConditioning = true;
        }else {
            airConditioning = false;
        }
        Location location = new Location( street , city , state , zipCode);
        Owner owner = getOwnerFromSession();
        return new Apartment( new PropertyType("Apartment"), area , location , distance,n_bedrooms, n_bathrooms, n_parkingSpaces, centralHeating , airConditioning , owner );
    }


    /**
     * Gets rent apartment.
     *
     * @return the rent apartment
     */
    public Apartment getRentApartment() {
        int area = Utils.readIntegerFromConsole("Area in squad meters");
        String street = Utils.readLineFromConsole("Street");
        String city = Utils.readLineFromConsole("City");
        String state = Utils.readLineFromConsole("State");
        int zipCode = Utils.readIntegerFromConsole("Zipcode");
        int distance = Utils.readIntegerFromConsole("Distance from the city center");
        int n_bedrooms = Utils.readIntegerFromConsole("Number of bedrooms");
        int n_bathrooms = Utils.readIntegerFromConsole("Number of bathrooms");
        int n_parkingSpaces = Utils.readIntegerFromConsole("Number of parking spaces");
        String flag = Utils.readLineFromConsole("central heating ");
        boolean centralHeating;
        if( flag.equalsIgnoreCase("true")){
            centralHeating = true;
        }else {
            centralHeating = false;
        }
        String flag2 = Utils.readLineFromConsole("air conditioning ");
        boolean airConditioning;
        if( flag2.equalsIgnoreCase("true")){
            airConditioning = true;
        }else {
            airConditioning = false;
        }
        Location location = new Location( street , city , state , zipCode);
        Owner owner = getOwnerFromSession();
        System.out.println();
        return new Apartment(new PropertyType("Apartment"), area , location  , distance , n_bedrooms, n_bathrooms, n_parkingSpaces, centralHeating , airConditioning , owner);

    }


    /**
     * Gets sell house.
     *
     * @return the sell house
     */
    public House getSellHouse() {
        int area = Utils.readIntegerFromConsole("Area in squad meters");
        String street = Utils.readLineFromConsole("Street");
        String city = Utils.readLineFromConsole("City");
        String state = Utils.readLineFromConsole("State");
        int zipCode = Utils.readIntegerFromConsole("Zipcode");
        int distance = Utils.readIntegerFromConsole("Distance from the city center");
        int n_bedrooms = Utils.readIntegerFromConsole("Number of bedrooms");
        int n_bathrooms = Utils.readIntegerFromConsole("Number of bathrooms");
        int n_parkingSpaces = Utils.readIntegerFromConsole("Number of parking spaces");
        String flag = Utils.readLineFromConsole("central heating ");
        boolean centralHeating;
        if( flag.equalsIgnoreCase("true")){
            centralHeating = true;
        }else {
            centralHeating = false;
        }
        String flag2 = Utils.readLineFromConsole("air conditioning ");
        boolean airConditioning;
        if( flag2.equalsIgnoreCase("true")){
            airConditioning = true;
        }else {
            airConditioning = false;
        }
        Location location = new Location( street , city , state , zipCode);
        boolean existBasement = Boolean.parseBoolean(Utils.readLineFromConsole("Has a basement?(true or false"));
        boolean inhabitableLoft = Boolean.parseBoolean(Utils.readLineFromConsole("Has a inhabitable loft?(true or false)"));
        String sunExposure = Utils.readLineFromConsole("Direction of the sun exposure( N,S , W or E)");
        Owner owner = getOwnerFromSession();
        return new House(new PropertyType("House"),area, location, distance , n_bedrooms, n_bathrooms, n_parkingSpaces, centralHeating, airConditioning, existBasement , inhabitableLoft, sunExposure , owner);

    }

    /**
     * Gets rent house.
     *
     * @return the rent house
     */
    public House getRentHouse() {
        int area = Utils.readIntegerFromConsole("Area in squad meters");
        String street = Utils.readLineFromConsole("Street");
        String city = Utils.readLineFromConsole("City");
        String state = Utils.readLineFromConsole("State");
        int zipCode = Utils.readIntegerFromConsole("Zipcode");
        int distance = Utils.readIntegerFromConsole("Distance from the city center");
        int n_bedrooms = Utils.readIntegerFromConsole("Number of bedrooms");
        int n_bathrooms = Utils.readIntegerFromConsole("Number of bathrooms");
        int n_parkingSpaces = Utils.readIntegerFromConsole("Number of parking spaces");
        String flag = Utils.readLineFromConsole("central heating ");
        boolean centralHeating;
        if( flag.equalsIgnoreCase("true")){
            centralHeating = true;
        }else {
            centralHeating = false;
        }
        String flag2 = Utils.readLineFromConsole("air conditioning ");
        boolean airConditioning;
        if( flag2.equalsIgnoreCase("true")){
            airConditioning = true;
        }else {
            airConditioning = false;
        }
        Location location = new Location( street , city , state , zipCode);
        boolean existBasement = Boolean.parseBoolean(Utils.readLineFromConsole("Has a basement?(true or false"));
        boolean inhabitableLoft = Boolean.parseBoolean(Utils.readLineFromConsole("Has a inhabitable loft?(true or false)"));
        String sunExposure = Utils.readLineFromConsole("Direction of the sun exposure( N,S , W or E)");
        Owner owner = getOwnerFromSession();
        return new House(new PropertyType("House"), area , location, distance, n_bedrooms, n_bathrooms, n_parkingSpaces, centralHeating, airConditioning, existBasement , inhabitableLoft, sunExposure , owner );
    }


    /**
     * Gets property type.
     *
     * @return the property type
     */
    public List<PropertyType> getPropertyType() {
        return getPropertyTypeRepository().getPropertyTypes();

    }

     private Owner getOwnerFromSession(){
        Email email = getAuthenticationRepository().getCurrentUserSession().getUserId();
        return new Owner(email.getEmail());
     }

    private AuthenticationRepository getAuthenticationRepository() {
        if(authenticationRepository == null){
            Repositories repositories = Repositories.getInstance();
            authenticationRepository = repositories.getAuthenticationRepository();
        }
        return authenticationRepository;
    }
}
