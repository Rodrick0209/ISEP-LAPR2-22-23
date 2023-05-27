package pt.ipp.isep.dei.esoft.project.ui.console;

import pt.ipp.isep.dei.esoft.project.application.controller.PublishAnnouncementController;
import pt.ipp.isep.dei.esoft.project.domain.*;

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

    private String avaiableEquipment;

    private boolean existBasement;

    private boolean inhabitableLoft;

    private String sunExposure;



    private String street;
    private String city;
    private String district;
    private String state;
    private int zipCode;

    private List<String> photos = new ArrayList<>();

    private int contractDuraction;

    private int price;
    private int rentprice;


    private CreateRequestController getController() {
        return controller;
    }
    private String answer = "yes";



    /*public CreateRequestUI() {

    }*/

    @Override
    public void run() {
        //agent = displayAndSelectAgent();
        requestType = displayAndSelectTypeBusiness();
        propertyType = displayAndSelectTypeProperty();
        if ( propertyType == "Land" && requestType=="Sell"){
            requestData1();
            Land land = controller.getSellLand();
            System.out.println("Price :" + price + "$");
        }
        if ( propertyType == "Land" && requestType=="Rent"){
            requestData2();
            requestData3();
            Land land = controller.getRentLand();
            System.out.println("Rent price :" + rentprice + "$");
            System.out.println("Contract duration :" + contractDuraction + "months");
        }
        if ( propertyType == "Apartment" && requestType == "Sell"){
            requestData1();
            Apartment apartment = controller.getSellApartment();
            System.out.println("Price :" + price + "$");
        }
        if ( propertyType == "Apartment" && requestType == "Rent"){
            requestData2();
            requestData3();
            Apartment apartment = controller.getRentApartment();
            System.out.println("Rent price :" + rentprice + "$");
            System.out.println("Contract duration :" + contractDuraction + "months");
        }
        if ( propertyType == "House" && requestType =="Sell"){
            requestData1();
            House house = controller.getSellHouse();
            System.out.println("Price :" + price + "$");
        }
        if ( propertyType == "House" && requestType =="Rent"){
            requestData1();
            House house = controller.getRentHouse();
            System.out.println("Rent price :" + rentprice + "$");
            System.out.println("Contract duration :" + contractDuraction + "months");
        }

 }

    /*private void submitOrNot() {
        boolean answer = Utils.confirm("Submit Data? (type yes or no)");
        if(answer){
            submitData();
        } else run();
        */



    private void submitData() {
        List<Property> properties = (List<Property>) getController().createProperty();

        }





    /*private String displayAndSelectAgent() {
        List<Employee> employees = controller.getAgents();
        int answer = Utils.showAndSelectIndex(employees, "Agent:");
        return employees.get(answer).getRole().getName();
    }*/



    private String displayAndSelectTypeProperty() {
        List<PropertyType> propertyTypes = controller.getPropertyType();
        int answer = Utils.showAndSelectIndex(propertyTypes, "Type of property:");
        return propertyTypes.get(answer).getName();
    }


    private String displayAndSelectTypeBusiness() {
        List<TypeBusiness> typeBusiness = controller.getTypeBusiness();
        int answer = Utils.showAndSelectIndex(typeBusiness, "Type of business:");
        return typeBusiness.get(answer).getName();
    }

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
            List<PropertyType> options = controller.getPropertyType();
        int answer = Utils.showAndSelectIndex(options, "Type of business");
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

