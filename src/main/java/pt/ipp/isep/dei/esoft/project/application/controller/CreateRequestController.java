package pt.ipp.isep.dei.esoft.project.application.controller;


import pt.ipp.isep.dei.esoft.project.domain.*;
import pt.ipp.isep.dei.esoft.project.repository.*;
import pt.ipp.isep.dei.esoft.project.ui.console.utils.Utils;
import pt.isep.lei.esoft.auth.domain.model.Email;

import java.util.List;
import java.util.Optional;

/**
 * The type Create request controller.
 */
public class CreateRequestController {

    private TypeBusinessRepository typeBusinessRepository;

    private PropertyRepository propertyRepository;

    private PropertyTypeRepository propertyTypeRepository;

    private AuthenticationRepository authenticationRepository;

    private RequestRepository requestRepository;


    /**
     * Instantiates a new Create request controller.
     */
    public CreateRequestController(){
        getTypeBusinessRepository();
    }

    private PropertyRepository getPropertyRepository(){
        if(propertyRepository == null){
            Repositories repositories = Repositories.getInstance();
            propertyRepository = repositories.getPropertyRepository();
        }
        return propertyRepository;
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
    private TypeBusinessRepository getTypeBusinessRepository() {
        if(typeBusinessRepository == null){
            Repositories repositories = Repositories.getInstance();
            typeBusinessRepository = repositories.getTypeBusinessRepository();
        }
        return typeBusinessRepository;
    }

    private RequestRepository getRequestRepository(){
        if(requestRepository == null){
            Repositories repositories = Repositories.getInstance();
            requestRepository = repositories.getInstance().getRequestRepository();
        }
        return requestRepository;
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
     * Create land optional.
     *
     * @param propertyTypeName the property type name
     * @param area             the area
     * @param location         the location
     * @param distance         the distance
     * @return the optional
     */
    public Optional<Property> createLand(String propertyTypeName, int area, Location location, int distance){
        PropertyType propertyType = getPropertyTypeByName(propertyTypeName);
        Owner owner = getOwnerFromSession();
        Optional<Property> newProperty = Optional.empty();

        if(getPropertyRepository() != null){
            newProperty = getPropertyRepository().createLand(propertyType, area, location, distance, owner );
        }
        return newProperty;
    }

    /**
     * Create apartment optional.
     *
     * @param propertyTypeName the property type name
     * @param area             the area
     * @param location         the location
     * @param distance         the distance
     * @return the optional
     */
    public Optional<Property> createApartment(String propertyTypeName, int area, Location location, int distance){
        PropertyType propertyType = getPropertyTypeByName(propertyTypeName);
        Owner owner = getOwnerFromSession();
        Optional<Property> newProperty = Optional.empty();

        if(getPropertyRepository() != null){
            newProperty = getPropertyRepository().createLand(propertyType, area, location, distance, owner );
        }
        return newProperty;
    }

    /**
     * Create house optional.
     *
     * @param propertyTypeName the property type name
     * @param area             the area
     * @param location         the location
     * @param distance         the distance
     * @return the optional
     */
    public Optional<Property> createHouse(String propertyTypeName, int area, Location location, int distance){
        PropertyType propertyType = getPropertyTypeByName(propertyTypeName);
        Owner owner = getOwnerFromSession();
        Optional<Property> newProperty = Optional.empty();

        if(getPropertyRepository() != null){
            newProperty = getPropertyRepository().createLand(propertyType, area, location, distance, owner );
        }
        return newProperty;
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

    /**
     * Get owner from session owner.
     *
     * @return the owner
     */
    public Owner getOwnerFromSession(){
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


    /**
     * Add request.
     */
    public void addRequest() {

    }


    /**
     * Create rent request optional.
     *
     * @param requestType      the request type
     * @param propertyLocation the property location
     * @param rentPrice        the rent price
     * @param contractDuration the contract duration
     * @return the optional
     */
    public Optional<Request> createRentRequest(String requestType, Location propertyLocation, int rentPrice, int contractDuration){
        TypeBusiness typeBusiness = getTypeBusinessByName(requestType);
        Property property = getPropertyByLocation(propertyLocation);
        Owner owner = getOwnerFromSession();
        Optional<Request> newRentRequest = Optional.empty();

        if(getRequestRepository() != null){
            newRentRequest = getRequestRepository().createRentRequest(property, typeBusiness, rentPrice, contractDuration, owner);
        }
        return newRentRequest;
    }


    private Property getPropertyByLocation(Location location){
        return getPropertyRepository().getPropertyByLocation(location);
    }

    /**
     * Create sell request optional.
     *
     * @param requestType      the request type
     * @param propertyLocation the property location
     * @param price            the price
     * @return the optional
     */
    public Optional<Request> createSellRequest(String requestType  , Location propertyLocation , int  price) {
        TypeBusiness typeBusiness = getTypeBusinessByName(requestType);
        Property property = getPropertyByLocation(propertyLocation);
        Owner owner = getOwnerFromSession();
        Optional<Request> newSaleRequest = Optional.empty();

        if(getRequestRepository() != null){
            newSaleRequest = getRequestRepository().createSaleRequest(property, typeBusiness, price, owner);
        }
        return newSaleRequest;
    }


    /**
     * Get properties list.
     *
     * @return the list
     */
    public List<Property> getProperties(){
        return getPropertyRepository().getProperties();
    }

    private TypeBusiness getTypeBusinessByName(String typeBusinessName){
        return getTypeBusinessRepository().getTypeBusinessbyName(typeBusinessName);
    }

    private PropertyType getPropertyTypeByName(String propertyTypeName){
        return getPropertyTypeRepository().getPropertyTypeByName(propertyTypeName);
    }


}
