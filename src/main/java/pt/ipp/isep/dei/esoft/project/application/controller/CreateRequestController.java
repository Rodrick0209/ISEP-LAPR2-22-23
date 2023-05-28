package pt.ipp.isep.dei.esoft.project.application.controller;


import pt.ipp.isep.dei.esoft.project.domain.*;
import pt.ipp.isep.dei.esoft.project.repository.PropertyRepository;
import pt.ipp.isep.dei.esoft.project.repository.PropertyTypeRepository;
import pt.ipp.isep.dei.esoft.project.repository.Repositories;
import pt.ipp.isep.dei.esoft.project.repository.TypeBusinessRepository;
import pt.ipp.isep.dei.esoft.project.ui.console.utils.Utils;

import java.util.List;

public class CreateRequestController {

    private TypeBusinessRepository typeBusinessRepository;

    private PropertyRepository propertyRepository;

    private PropertyTypeRepository propertyTypeRepository;
    public CreateRequestController(){
        getTypeBusinessRepository();
    }




    public boolean createRequest(String requestType, String propertyType, String area, String location, double distance, int photos, int n_bedrooms, int n_bathrooms, int n_parkingSpaces, String avaiableEquip, boolean price, boolean rentprice, String contractduration){
        return createRequest(requestType, propertyType,area, location,distance,photos,n_bedrooms, n_bathrooms, n_parkingSpaces, avaiableEquip, price, rentprice,contractduration);
    }

    public void addRequest() {

    }

    public List<TypeBusiness> getTypeBusiness() {
        return getTypeBusinessRepository().getTypeBusiness();
    }

    public TypeBusinessRepository getTypeBusinessRepository() {
        if(typeBusinessRepository == null){
            Repositories repositories = Repositories.getInstance();
            typeBusinessRepository = repositories.getTypeBusinessRepository();
        }
        return typeBusinessRepository;
    }

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

    public Land getSellLand() {
        int area = Utils.readIntegerFromConsole("Area in squad meters");
        String street = Utils.readLineFromConsole("Street");
        String city = Utils.readLineFromConsole("City");
        String state = Utils.readLineFromConsole("State");
        int zipCode = Utils.readIntegerFromConsole("Zipcode");
        int distance = Utils.readIntegerFromConsole("Distance from the city center");
        Location location = new Location( street , city , state , zipCode);

        return new Land(new PropertyType("Land"), area, location, distance );


    }

    public Land getRentLand() {
        int area = Utils.readIntegerFromConsole("Area in squad meters");
        String street = Utils.readLineFromConsole("Street");
        String city = Utils.readLineFromConsole("City");
        String state = Utils.readLineFromConsole("State");
        int zipCode = Utils.readIntegerFromConsole("Zipcode");
        int distance = Utils.readIntegerFromConsole("Distance from the city center");
        Location location = new Location( street , city , state , zipCode);

        return new Land(new PropertyType("Land"), area, location, distance );
    }


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
        return new Apartment( new PropertyType("Apartment"), area , location , distance, n_bedrooms, n_bathrooms, n_parkingSpaces, n_parkingSpaces, centralHeating , airConditioning );
    }


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
        return new Apartment(new PropertyType("Apartment"), area , location , distance, n_bedrooms, n_bathrooms, n_parkingSpaces, centralHeating , airConditioning );
    }


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
        return new House(new PropertyType("House"),area, location, distance, n_bedrooms, n_bathrooms, n_parkingSpaces, centralHeating, airConditioning, existBasement , inhabitableLoft, sunExposure );

    }

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
        return new House(new PropertyType("House"),area, location, distance, n_bedrooms, n_bathrooms, n_parkingSpaces, centralHeating, airConditioning, existBasement , inhabitableLoft, sunExposure );


    }


    public List<PropertyType> getPropertyType() {
        return getPropertyTypeRepository().getPropertyTypes();

    }
}
