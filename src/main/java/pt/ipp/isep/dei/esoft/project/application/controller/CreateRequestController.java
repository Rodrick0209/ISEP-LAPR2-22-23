package pt.ipp.isep.dei.esoft.project.application.controller;


import pt.ipp.isep.dei.esoft.project.domain.*;
import pt.ipp.isep.dei.esoft.project.repository.*;
import pt.ipp.isep.dei.esoft.project.ui.console.utils.Utils;

import java.util.List;

public class CreateRequestController {

    private TypeBusinessRepository typeBusinessRepository;

    private PropertyRepository propertyRepository;

    private PropertyTypeRepository propertyTypeRepository;

    private EmployeeRepository employeeRepository;

    public CreateRequestController() {
        getTypeBusinessRepository();
        //employeeRepository=Repositories.getInstance().getEmployeeRepository();
    }

    private String name;
    private int ccNumber;
    private String taxNumber;
    private String emailAddress;
    private String phoneNumber;


    public boolean createRequest(int requestType, String propertyType, String area, Location location, double distance, int photos, int n_bedrooms, int n_bathrooms, int n_parkingSpaces, String avaiableEquip, boolean price, boolean rentprice, String contractduration) {
        return createRequest(requestType, propertyType, area, location, distance, photos, n_bedrooms, n_bathrooms, n_parkingSpaces, avaiableEquip, price, rentprice, contractduration);
    }


    public List<TypeBusiness> getTypeBusiness() {
        return getTypeBusinessRepository().getTypeBusiness();
    }

    public TypeBusinessRepository getTypeBusinessRepository() {
        if (typeBusinessRepository == null) {
            Repositories repositories = Repositories.getInstance();
            typeBusinessRepository = repositories.getTypeBusinessRepository();
        }
        return typeBusinessRepository;
    }

    public List<PropertyType> getPropertyType() {
        return getPropertyTypeRepository().getPropertyType();
    }

    private PropertyTypeRepository getPropertyTypeRepository() {
        if (propertyTypeRepository == null) {
            Repositories repositories = Repositories.getInstance();
            propertyTypeRepository = repositories.getPropertyTypeRepository();
        }
        return propertyTypeRepository;
    }

    public Land getLand() {

        int area = Utils.readIntegerFromConsole("Area in squad meters");
        String street = Utils.readLineFromConsole("Street");
        String city = Utils.readLineFromConsole("City");
        String district = Utils.readLineFromConsole("District");
        String state = Utils.readLineFromConsole("State");
        int zipCode = Utils.readIntegerFromConsole("Zipcode");
        int distance = Utils.readIntegerFromConsole("Distance from the city center");
        Location location = new Location(street, city, district, state, zipCode);

        return new Land(new PropertyType("Land"), area, location, distance);
    }

    public Apartment getSellApartment() {
        int area = Utils.readIntegerFromConsole("Area in squad meters");
        String street = Utils.readLineFromConsole("Street");
        String city = Utils.readLineFromConsole("City");
        String district = Utils.readLineFromConsole("District");
        String state = Utils.readLineFromConsole("State");
        int zipCode = Utils.readIntegerFromConsole("Zipcode");
        int distance = Utils.readIntegerFromConsole("Distance from the city center");
        int n_bedrooms = Utils.readIntegerFromConsole("Number of bedrooms");
        int n_bathrooms = Utils.readIntegerFromConsole("Number of bathrooms");
        int n_parkingSpaces = Utils.readIntegerFromConsole("Number of parking spaces");
        String flag = Utils.readLineFromConsole("central heating ");
        boolean centralHeating;
        if (flag.equalsIgnoreCase("true")) {
            centralHeating = true;
        } else {
            centralHeating = false;
        }
        String flag2 = Utils.readLineFromConsole("air conditioning ");
        boolean airConditioning;
        if (flag2.equalsIgnoreCase("true")) {
            airConditioning = true;
        } else {
            airConditioning = false;
        }
        Location location = new Location(street, city, district, state, zipCode);
        System.out.println("Request Type : sell");
        System.out.println("Property type : Apartment");
        System.out.println("Area: " + area + "m2");
        System.out.println("Location: " + street + "," + city + "," + district + "," + state + "," + zipCode);
        System.out.println("Distance: " + distance + "km");
        System.out.println("Number of bedrooms: " + n_bedrooms);
        System.out.println("Number of bathrooms: " + n_bathrooms);
        System.out.println("Number of parking spaces: " + n_parkingSpaces);
        System.out.println("Central heating: " + centralHeating);
        System.out.println("Air conditioning : " + airConditioning);
        return new Apartment(new PropertyType("Apartment"), area, location, distance, area, n_bedrooms, n_bathrooms, n_parkingSpaces, centralHeating, airConditioning);/* new Owner (name, ccNumber,  taxNumber,  emailAddress,  phoneNumber), n_bedrooms, n_bathrooms, n_parkingSpaces, centralHeating , airConditioning*/
    }

    public House getHouse() {
        int area = Utils.readIntegerFromConsole("Area in squad meters");
        String street = Utils.readLineFromConsole("Street");
        String city = Utils.readLineFromConsole("City");
        String district = Utils.readLineFromConsole("District");
        String state = Utils.readLineFromConsole("State");
        int zipCode = Utils.readIntegerFromConsole("Zipcode");
        int distance = Utils.readIntegerFromConsole("Distance from the city center");
        int n_bedrooms = Utils.readIntegerFromConsole("Number of bedrooms");
        int n_bathrooms = Utils.readIntegerFromConsole("Number of bathrooms");
        int n_parkingSpaces = Utils.readIntegerFromConsole("Number of parking spaces");
        String flag = Utils.readLineFromConsole("central heating ");
        boolean centralHeating;
        if (flag.equalsIgnoreCase("true")) {
            centralHeating = true;
        } else {
            centralHeating = false;
        }
        String flag2 = Utils.readLineFromConsole("air conditioning ");
        boolean airConditioning;
        if (flag2.equalsIgnoreCase("true")) {
            airConditioning = true;
        } else {
            airConditioning = false;
        }
        Location location = new Location(street, city, district, state, zipCode);
        boolean existBasement = Boolean.parseBoolean(Utils.readLineFromConsole("Has a basement?(true or false"));
        boolean inhabitableLoft = Boolean.parseBoolean(Utils.readLineFromConsole("Has a inhabitable loft?(true or false)"));
        String sunExposure = Utils.readLineFromConsole("Direction of the sun exposure( N,S , W or E)");
        return new House("House", area, location, distance, area, n_bedrooms, n_bathrooms, n_parkingSpaces, centralHeating, airConditioning, existBasement, inhabitableLoft, sunExposure);/*, new Owner(name, ccNumber,  taxNumber,  emailAddress,  phoneNumber), n_bedrooms, n_bathrooms, n_parkingSpaces, centralHeating, airConditioning );*/
    }


    public Land getSellLand() {
        int area = Utils.readIntegerFromConsole("Area in squad meters");
        String street = Utils.readLineFromConsole("Street");
        String city = Utils.readLineFromConsole("City");
        String district = Utils.readLineFromConsole("District");
        String state = Utils.readLineFromConsole("State");
        int zipCode = Utils.readIntegerFromConsole("Zipcode");
        int distance = Utils.readIntegerFromConsole("Distance from the city center");
        Location location = new Location(street, city, district, state, zipCode);
        System.out.println("Request Type : sell");
        System.out.println("Property type : Land");
        System.out.println("Area: " + area + "m2");
        System.out.println("Location: " + street + "," + city + "," + district + "," + state + "," + zipCode);
        System.out.println("Distance: " + distance + "km");


        return new Land(new PropertyType("Land"), area, location, distance);
    }

    public Land getRentLand() {
        int area = Utils.readIntegerFromConsole("Area in squad meters");
        String street = Utils.readLineFromConsole("Street");
        String city = Utils.readLineFromConsole("City");
        String district = Utils.readLineFromConsole("District");
        String state = Utils.readLineFromConsole("State");
        int zipCode = Utils.readIntegerFromConsole("Zipcode");
        int distance = Utils.readIntegerFromConsole("Distance from the city center");
        Location location = new Location(street, city, district, state, zipCode);
        System.out.println("Request Type : rent");
        System.out.println("Property type : Land");
        System.out.println("Area: " + area + "m2");
        System.out.println("Location: " + street + "," + city + "," + district + "," + state + "," + zipCode);
        System.out.println("Distance: " + distance + "km");


        return new Land(new PropertyType("Land"), area, location, distance);

    }

    public Apartment getRentApartment() {
        int area = Utils.readIntegerFromConsole("Area in squad meters");
        String street = Utils.readLineFromConsole("Street");
        String city = Utils.readLineFromConsole("City");
        String district = Utils.readLineFromConsole("District");
        String state = Utils.readLineFromConsole("State");
        int zipCode = Utils.readIntegerFromConsole("Zipcode");
        int distance = Utils.readIntegerFromConsole("Distance from the city center");
        int n_bedrooms = Utils.readIntegerFromConsole("Number of bedrooms");
        int n_bathrooms = Utils.readIntegerFromConsole("Number of bathrooms");
        int n_parkingSpaces = Utils.readIntegerFromConsole("Number of parking spaces");
        String flag = Utils.readLineFromConsole("Central heating(true or false) ");
        boolean centralHeating;
        if (flag.equalsIgnoreCase("true")) {
            centralHeating = true;
        } else {
            centralHeating = false;
        }
        String flag2 = Utils.readLineFromConsole("Air conditioning(true or false) ");
        boolean airConditioning;
        if (flag2.equalsIgnoreCase("true")) {
            airConditioning = true;
        } else {
            airConditioning = false;
        }
        Location location = new Location(street, city, district, state, zipCode);
        System.out.println("Request Type : rent");
        System.out.println("Property type : Apartment");
        System.out.println("Area: " + area + "m2");
        System.out.println("Location: " + street + "," + city + "," + district + "," + state + "," + zipCode);
        System.out.println("Distance: " + distance + "km");
        System.out.println("Number of bedrooms: " + n_bedrooms);
        System.out.println("Number of bathrooms: " + n_bathrooms);
        System.out.println("Number of parking spaces: " + n_parkingSpaces);
        System.out.println("Central heating: " + centralHeating);
        System.out.println("Air conditioning : " + airConditioning);
        return new Apartment(new PropertyType("Apartment"), area, location, distance, area, n_bedrooms, n_bathrooms, n_parkingSpaces, centralHeating, airConditioning);/* new Owner (name, ccNumber,  taxNumber,  emailAddress,  phoneNumber), n_bedrooms, n_bathrooms, n_parkingSpaces, centralHeating , airConditioning*/

    }

    public House getSellHouse() {
        int area = Utils.readIntegerFromConsole("Area in squad meters");
        String street = Utils.readLineFromConsole("Street");
        String city = Utils.readLineFromConsole("City");
        String district = Utils.readLineFromConsole("District");
        String state = Utils.readLineFromConsole("State");
        int zipCode = Utils.readIntegerFromConsole("Zipcode");
        int distance = Utils.readIntegerFromConsole("Distance from the city center");
        int n_bedrooms = Utils.readIntegerFromConsole("Number of bedrooms");
        int n_bathrooms = Utils.readIntegerFromConsole("Number of bathrooms");
        int n_parkingSpaces = Utils.readIntegerFromConsole("Number of parking spaces");
        String flag = Utils.readLineFromConsole("Central heating (true or false) ");
        boolean centralHeating;
        if (flag.equalsIgnoreCase("true")) {
            centralHeating = true;
        } else {
            centralHeating = false;
        }
        String flag2 = Utils.readLineFromConsole("Air conditioning (true or false) ");
        boolean airConditioning;
        if (flag2.equalsIgnoreCase("true")) {
            airConditioning = true;
        } else {
            airConditioning = false;
        }
        Location location = new Location(street, city, district, state, zipCode);
        boolean existBasement = Boolean.parseBoolean(Utils.readLineFromConsole("Has a basement?(true or false"));
        boolean inhabitableLoft = Boolean.parseBoolean(Utils.readLineFromConsole("Has a inhabitable loft?(true or false)"));
        String sunExposure = Utils.readLineFromConsole("Direction of the sun exposure( N,S , W or E)");
        System.out.println("Request Type : sell");
        System.out.println("Property type : House");
        System.out.println("Area: " + area + "m2");
        System.out.println("Location: " + street + "," + city + "," + district + "," + state + "," + zipCode);
        System.out.println("Distance: " + distance + "km");
        System.out.println("Number of bedrooms: " + n_bedrooms);
        System.out.println("Number of bathrooms: " + n_bathrooms);
        System.out.println("Number of parking spaces: " + n_parkingSpaces);
        System.out.println("Central heating: " + centralHeating);
        System.out.println("Air conditioning : " + airConditioning);
        System.out.println("Existence of basement : " + existBasement);
        System.out.println("Existence of inhabitable loft : " + inhabitableLoft);
        System.out.println("Sun exposure: " + sunExposure);
        return new House("House", area, location, distance, area, n_bedrooms, n_bathrooms, n_parkingSpaces, centralHeating, airConditioning, existBasement, inhabitableLoft, sunExposure);/*, new Owner(name, ccNumber,  taxNumber,  emailAddress,  phoneNumber), n_bedrooms, n_bathrooms, n_parkingSpaces, centralHeating, airConditioning );*/
    }

    public House getRentHouse() {
        int area = Utils.readIntegerFromConsole("Area in squad meters");
        String street = Utils.readLineFromConsole("Street");
        String city = Utils.readLineFromConsole("City");
        String district = Utils.readLineFromConsole("District");
        String state = Utils.readLineFromConsole("State");
        int zipCode = Utils.readIntegerFromConsole("Zipcode");
        int distance = Utils.readIntegerFromConsole("Distance from the city center");
        int n_bedrooms = Utils.readIntegerFromConsole("Number of bedrooms");
        int n_bathrooms = Utils.readIntegerFromConsole("Number of bathrooms");
        int n_parkingSpaces = Utils.readIntegerFromConsole("Number of parking spaces");
        String flag = Utils.readLineFromConsole("Central heating(true or false) ");
        boolean centralHeating;
        if (flag.equalsIgnoreCase("true")) {
            centralHeating = true;
        } else {
            centralHeating = false;
        }
        String flag2 = Utils.readLineFromConsole("Air conditioning (true or false)");
        boolean airConditioning;
        if (flag2.equalsIgnoreCase("true")) {
            airConditioning = true;
        } else {
            airConditioning = false;
        }
        Location location = new Location(street, city, district, state, zipCode);
        boolean existBasement = Boolean.parseBoolean(Utils.readLineFromConsole("Has a basement?(true or false"));
        boolean inhabitableLoft = Boolean.parseBoolean(Utils.readLineFromConsole("Has a inhabitable loft?(true or false)"));
        String sunExposure = Utils.readLineFromConsole("Direction of the sun exposure( N,S , W or E)");
        System.out.println("Request Type : rent");
        System.out.println("Property type : House");
        System.out.println("Area: " + area + "m2");
        System.out.println("Location: " + street + "," + city + "," + district + "," + state + "," + zipCode);
        System.out.println("Distance: " + distance + "km");
        System.out.println("Number of bedrooms: " + n_bedrooms);
        System.out.println("Number of bathrooms: " + n_bathrooms);
        System.out.println("Number of parking spaces: " + n_parkingSpaces);
        System.out.println("Central heating: " + centralHeating);
        System.out.println("Air conditioning : " + airConditioning);
        System.out.println("Existence of basement : " + existBasement);
        System.out.println("Existence of inhabitable loft : " + inhabitableLoft);
        System.out.println("Sun exposure: " + sunExposure);
        return new House("House", area, location, distance, area, n_bedrooms, n_bathrooms, n_parkingSpaces, centralHeating, airConditioning, existBasement, inhabitableLoft, sunExposure);
    }

    public PropertyRepository createProperty() {
        return getPropertyRepository();
    }

    private PropertyRepository getPropertyRepository() {
        if (propertyRepository == null) {
            Repositories repositories = Repositories.getInstance();
            propertyRepository = repositories.getPropertyRepository();
        }
        return propertyRepository;
    }
}