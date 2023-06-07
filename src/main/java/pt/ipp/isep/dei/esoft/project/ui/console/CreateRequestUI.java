package pt.ipp.isep.dei.esoft.project.ui.console;

import pt.ipp.isep.dei.esoft.project.application.controller.PublishAnnouncementController;
import pt.ipp.isep.dei.esoft.project.application.controller.authorization.AuthenticationController;
import pt.ipp.isep.dei.esoft.project.domain.*;

import pt.ipp.isep.dei.esoft.project.repository.Repositories;
import pt.ipp.isep.dei.esoft.project.ui.console.utils.Utils;
import pt.ipp.isep.dei.esoft.project.application.controller.CreateRequestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


/**
 * The type Create request ui.
 */
public class CreateRequestUI implements Runnable {

    /**
     * The Request controller.
     */
    CreateRequestController controller = new CreateRequestController();
    private String requestType;

    private String propertyType;

    private String agent;

    private int area;

    private int distance;

    private int n_bedrooms;

    private int n_bathrooms;

    private int n_parkingSpaces;

    private  boolean centralHeating;
    private boolean airConditioning;

    private String sunExposure;
    private boolean existBasement;
    private boolean existinhabitableLoft;






    private String street;
    private String city;
    private String district;
    private String state;
    private int zipCode;

    private List<String> photos = new ArrayList<>();

    private int contractDuraction;

    private int price;
    private int rentprice;
    private Repositories repositories;


    private CreateRequestController getController() {
        return controller;
    }
    private String answer = "yes";

    @Override
    public void run() {
        //agent = displayAndSelectAgent();
        propertyType = displayAndSelectTypeProperty();
        if ( propertyType.equalsIgnoreCase("Land")){
            requestLandData();
            Location location = new Location(street, city, state, zipCode);
            Optional<Property> land = controller.createLand(propertyType, area, location, distance);
            if(land.isPresent()){
                System.out.println("Property created... Redirecting to create request." );
                requestPropertyRequests();
            }else {
                System.out.println("Property not created.");
            }

        }
        if ( propertyType.equalsIgnoreCase("Apartment")){
            requestApartmentData();
            Location location = new Location(street, city, state, zipCode);
            Optional<Property> apartment = controller.createApartment(propertyType, area, location, distance);
            if(apartment.isPresent()){
                System.out.println("Property created... Redirecting to create request." );
                requestPropertyRequests();
            }else {
                System.out.println("Property not created.");
            }
        }
        if ( propertyType.equalsIgnoreCase("House")) {
            requestHouseData();
            Location location = new Location(street, city, state, zipCode);
            Optional<Property> house = controller.createHouse(propertyType, area, location, distance);
            if(house.isPresent()){
                System.out.println("Property created... Redirecting to create request." );
                requestPropertyRequests();
            }else {
                System.out.println("Property not created.");
            }
        }
        submitOrNot();
    }

    private void submitProperty() {
        Location location = new Location(street, city, state, zipCode);
        if (propertyType.equalsIgnoreCase("Land")) {
            Optional<Property> land = controller.createLand(propertyType, area, location, distance);
            if (land.isPresent()) {
                System.out.println("Property created... Redirecting to create request.");
                requestPropertyRequests();
            } else {
                System.out.println("Property not created.");
            }
        } else if (propertyType.equalsIgnoreCase("Apartment")) {
            Optional<Property> apartment = controller.createApartment(propertyType, area, location, distance);
            if (apartment.isPresent()) {
                System.out.println("Property created... Redirecting to create request.");
                requestPropertyRequests();
            } else {
                System.out.println("Property not created.");
            }
        } else if (propertyType.equalsIgnoreCase("House")) {
            Optional<Property> house = controller.createHouse(propertyType, area, location, distance);
            if (house.isPresent()) {
                System.out.println("Property created... Redirecting to create request.");
                requestPropertyRequests();
            } else {
                System.out.println("Property not created.");
            }
        }
    }

    private void submitOrNot() {
             if(propertyType.equalsIgnoreCase("Land")){
                 showLandData();
             }
             if(propertyType.equalsIgnoreCase("Apartment")){
                 showApartmentData();
             }
             if(propertyType.equalsIgnoreCase("House")){
                 showHouseData();
             }
             boolean answer = Utils.confirm("Confirm Data? (type yes or no)");
        if(answer){
            submitData();
        } else run();
    }

    private void showHouseData() {
        System.out.println();
        System.out.println("Type of request: " + requestType);
        System.out.println("Type of property: " + propertyType);
        System.out.println("Area: " + area);
        System.out.println("LOCATION:" + street +","+ city+"," + state+"," + zipCode);
        System.out.println("Distance from the city centre: " + distance);
        System.out.println("Number of bedrooms: "+ n_bedrooms);
        System.out.println("Number of bathrooms: "+ n_bathrooms);
        System.out.println("Number of parking spaces: "+ n_parkingSpaces);
        System.out.println("Existence of central heating: "+ centralHeating);
        System.out.println("Existence of air conditioning: "+ airConditioning);
        System.out.println("Existence of basement: " + existBasement);
        System.out.println("Existence of inhabitable loft: "+ existinhabitableLoft);
        System.out.println("Sun exposure: "+ sunExposure);
    }

    private void showApartmentData() {
        System.out.println();
        System.out.println("Type of request: " + requestType);
        System.out.println("Type of property: " + propertyType);
        System.out.println("Area: " + area);
        System.out.println("LOCATION:" + street +","+ city+"," + state+"," + zipCode);
        System.out.println("Distance from the city centre: " + distance);
        System.out.println("Number of bedrooms: "+ n_bedrooms);
        System.out.println("Number of bathrooms: "+ n_bathrooms);
        System.out.println("Number of parking spaces: "+ n_parkingSpaces);
        System.out.println("Existence of central heating: "+ centralHeating);
        System.out.println("Existence of air conditioning: "+ airConditioning);
    }

    private void submitData() {
        if(requestType.equalsIgnoreCase("Rent")){
            Optional<Request> rentRequest = controller.createRentRequest("Rent", new Location(street,city,state,zipCode),rentprice,contractDuraction);
        if(rentRequest.isPresent()){
            System.out.println("Request was created");
        }
        else{
            System.out.println("Request not created");
        }
        }
    }

    private void showLandData() {
        System.out.println();
        System.out.println("Type of request: " + requestType);
        System.out.println("Type of property: " + propertyType);
        System.out.println("Area: " + area);
        System.out.println("LOCATION:" + street +","+ city+"," + state+"," + zipCode);
        System.out.println("Distance from the city centre: " + distance);
    }


    private void requestPropertyRequests(){
        requestType = displayAndSelectTypeBusiness();
        if(requestType.equalsIgnoreCase("Sell")){
            requestData1();
        }else if(requestType.equalsIgnoreCase("Rent")){
            requestData2();
            requestData3();
        }
    }

    private String displayAndSelectTypeProperty() {
        List<PropertyType> propertyTypes = controller.getPropertyType();
        int answer = Utils.showAndSelectIndex(propertyTypes, "Type of property:");
        return propertyTypes.get(answer).getName();
    }


    private  String displayAndSelectTypeBusiness() {
        List<TypeBusiness> typeBusiness = controller.getTypeBusiness();
        int answer = Utils.showAndSelectIndex(typeBusiness, "Type of business:");


        return typeBusiness.get(answer).getName();
    }

    /**
     * Request data 1 int.
     *
     * @return the int
     */
    public int requestData1(){
        price = requestPrice();
        return price;
    }

    private int requestData2() {
        contractDuraction = requestContractDuraction();
        return contractDuraction;
    }

    private int requestData3() {
        rentprice = requestRentPrice();
        return rentprice;
    }

    private void requestLandData(){
        area = Utils.readIntegerFromConsole("Area in squad meters");
        street = Utils.readLineFromConsole("Street");
        city = Utils.readLineFromConsole("City");
        state = Utils.readLineFromConsole("State");
        zipCode = Utils.readIntegerFromConsole("Zipcode");
        distance = Utils.readIntegerFromConsole("Distance from the city center");
        }

    private void requestApartmentData() {
        area = Utils.readIntegerFromConsole("Area in squad meters");
        street = Utils.readLineFromConsole("Street");
        city = Utils.readLineFromConsole("City");
        state = Utils.readLineFromConsole("State");
        zipCode = Utils.readIntegerFromConsole("Zipcode");
        distance = Utils.readIntegerFromConsole("Distance from the city center");
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
    }

    private void requestHouseData() {
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
        boolean existBasement = Boolean.parseBoolean(Utils.readLineFromConsole("Has a basement?(true or false"));
        boolean inhabitableLoft = Boolean.parseBoolean(Utils.readLineFromConsole("Has a inhabitable loft?(true or false)"));
        String sunExposure = Utils.readLineFromConsole("Direction of the sun exposure( N,S , W or E)");
    }


    private int requestRentPrice() {
        int input=0;
        boolean valid = false;
        do {
            try{
                input = Utils.readIntegerFromConsole("Rent price of property: ");
                valid = true;
            }catch (NullPointerException e){
                System.out.println("Invalid rent price. Please enter a valid rent price.");
            }
        }while (!valid);
        return input;
    }


    private int requestContractDuraction() {
        int input=0;
        boolean valid = false;
        do {
            try{
                input = Utils.readIntegerFromConsole("Contract duration: ");
                valid = true;
            }catch (NullPointerException e){
                System.out.println("Invalid contract duration. Please enter a valid contract duration.");
            }
        }while (!valid);
        return input;
    }

    private String requestPropertyType() {
        String input=null;
            List<PropertyType> options = controller.getPropertyTypes();
        int answer = Utils.showAndSelectIndex(options, "Property Type: ");
        return options.get(answer).getName();

    }

    private int requestPrice(){
        int input=0;
        boolean valid = false;
        do {
            try{
                input = Utils.readIntegerFromConsole("Price of property: ");
                valid = true;
            }catch (NullPointerException e){
                System.out.println("Invalid price. Please enter a valid price.");
            }
        }while (!valid);
        return input;
    }




}

