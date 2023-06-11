package pt.ipp.isep.dei.esoft.project.application.controller;


import pt.ipp.isep.dei.esoft.project.domain.*;
import pt.ipp.isep.dei.esoft.project.repository.*;
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
     * Create land optional.
     *
     * @param propertyTypeName the property type name
     * @param area             the area
     * @param location         the location
     * @param distance         the distance
     * @return the optional
     */
    public Optional<Property> createLand(String propertyTypeName, int area, String location, int distance){
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
    public Optional<Property> createApartment(String propertyTypeName, int area, String location, int distance){
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
    public Optional<Property> createHouse(String propertyTypeName, int area, String location, int distance){
        PropertyType propertyType = getPropertyTypeByName(propertyTypeName);
        Owner owner = getOwnerFromSession();
        Optional<Property> newProperty = Optional.empty();

        if(getPropertyRepository() != null){
            newProperty = getPropertyRepository().createLand(propertyType, area, location, distance, owner );
        }
        return newProperty;
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
    public Optional<Request> createRentRequest(String requestType, String propertyLocation, int rentPrice, int contractDuration){
        TypeBusiness typeBusiness = getTypeBusinessByName(requestType);
        Property property = getPropertyByLocation(propertyLocation);
        Owner owner = getOwnerFromSession();
        Optional<Request> newRentRequest = Optional.empty();

        if(getRequestRepository() != null){
            newRentRequest = getRequestRepository().createRentRequest(property, typeBusiness, rentPrice, contractDuration, owner);
        }
        return newRentRequest;
    }


    private Property getPropertyByLocation(String location){
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
    public Optional<Request> createSaleRequest(String requestType  , String propertyLocation , int  price) {
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
