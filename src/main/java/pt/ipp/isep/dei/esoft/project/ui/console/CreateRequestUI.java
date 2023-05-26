package pt.ipp.isep.dei.esoft.project.ui.console;

import pt.ipp.isep.dei.esoft.project.domain.*;

import pt.ipp.isep.dei.esoft.project.ui.console.utils.Utils;
import pt.ipp.isep.dei.esoft.project.application.controller.CreateRequestController;

import java.util.ArrayList;
import java.util.List;


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

    /*private int area;

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
    */
    private List<String> photos = new ArrayList<>();

    private int contractDuraction;

    private int price;
    private int rentprice;



    private String answer = "yes";

    public void  Run() {

    }
/*List<MenuItem> options = new ArrayList<MenuItem>();
        options.add(new MenuItem("Sell", (Runnable) new TypeBusinessRepository()));
        options.add(new MenuItem("Rent", (Runnable) new TypeBusinessRepository()));
        int option = 0;
        do {
            option = Utils.showAndSelectIndex(options, "\n\nType of Request:");

            if ((option >= 0) && (option < options.size())) {
                options.get(option).run();
            }
        } while (option != -1);

        if (("1".equals(options))) {
            Sell sell = new Sell();
        }
        if ("2".equals(option)) {
            Rent rent = new Rent();

        } else {
            System.out.println("Insert a valid number");
        }
        */


    /*
    CreateRequestController controller = new CreateRequestController();
    public void run() {
            // Property Type data verification:
            requestType = Utils.readLineFromConsole("Choose a type: sell or rent");
            switch(requestType) {

                case "sell":
                    price = Utils.readIntegerFromConsole("Price of the property");
                    do {
                        photos.add(Utils.readLineFromConsole("photo URL"));
                        answer = Utils.readLineFromConsole("Do you want more photos?");
                        n++;
                    } while (answer.equals("yes") & n <= 30);

                    propertyType = Utils.readLineFromConsole("Property Type(land, apartment or house):");
                    switch (propertyType) {
                        case "land":
                            area = Utils.readIntegerFromConsole("Area in squad meters");
                            street = Utils.readLineFromConsole("Street");
                            city = Utils.readLineFromConsole("City");
                            district = Utils.readLineFromConsole("District");
                            state = Utils.readLineFromConsole("State");
                            zipCode = Utils.readIntegerFromConsole("Zipcode");
                            distance = Utils.readIntegerFromConsole("Distance from the city center");
                            System.out.println("Request Type: " + requestType);
                            System.out.println("Property Type: " + propertyType);
                            System.out.println("Price: " + price + " $");
                            System.out.println("Area: " + area + "m2");
                            System.out.println("Location: " + street + "," + city + "," + district + "," + state + "," + zipCode);
                            System.out.println("Distance: " + distance + " km");
                            break;
                        case "apartment":
                            area = Utils.readIntegerFromConsole("Area in squad meters");
                            street = Utils.readLineFromConsole("Street");
                            city = Utils.readLineFromConsole("City");
                            district = Utils.readLineFromConsole("District");
                            state = Utils.readLineFromConsole("State");
                            zipCode = Utils.readIntegerFromConsole("Zipcode");
                            distance = Utils.readIntegerFromConsole("Distance from the city center");
                            n_bedrooms = Utils.readIntegerFromConsole("Number of bedrooms");
                            n_bathrooms = Utils.readIntegerFromConsole("Number of bathrooms");
                            n_parkingSpaces = Utils.readIntegerFromConsole("Number of parking spaces");
                            avaiableEquipment = Utils.readLineFromConsole("name of the equipment(central heating and/or air conditioning)");
                            System.out.println();
                            System.out.println("Request Type: " + requestType);
                            System.out.println("Property Type: " + propertyType);
                            System.out.println("Price: " + price + "$");
                            System.out.println("Area: " + area + "m2");
                            System.out.println("Location: " + street + "," + city + "," + district + "," + state + "," + zipCode);
                            System.out.println("Distance: " + distance + "km");
                            System.out.println("Number of bedrooms: " + n_bedrooms);
                            System.out.println("Number of bathrooms: " + n_bathrooms);
                            System.out.println("Number of parking spaces: " + n_parkingSpaces);
                            System.out.println("Avaiable equipment: " + avaiableEquipment);
                            break;

                        case "house":
                            area = Utils.readIntegerFromConsole("Area in squad meters");
                            street = Utils.readLineFromConsole("Street");
                            city = Utils.readLineFromConsole("City");
                            district = Utils.readLineFromConsole("District");
                            state = Utils.readLineFromConsole("State");
                            zipCode = Utils.readIntegerFromConsole("Zipcode");
                            distance = Utils.readIntegerFromConsole("Distance from the city center");
                            n_bedrooms = Utils.readIntegerFromConsole("Number of bedrooms");
                            n_bathrooms = Utils.readIntegerFromConsole("Number of bathrooms");
                            n_parkingSpaces = Utils.readIntegerFromConsole("Number of parking spaces");
                            avaiableEquipment = Utils.readLineFromConsole("Name of the equipment(central heating and/or air conditioning)");
                            existBasement = Boolean.parseBoolean(Utils.readLineFromConsole("Has a basement?(true or false)"));
                            inhabitableLoft = Boolean.parseBoolean(Utils.readLineFromConsole("Has a inhabitable loft?(true or false)"));
                            sunExposure = Utils.readLineFromConsole("Direction of the sun exposure(N , S , W or E ):");
                            System.out.println();
                            System.out.println("Request Type: " + requestType);
                            System.out.println("Property Type: " + propertyType);
                            System.out.println("Price: " + price + "$");
                            System.out.println("Area: " + area + "m2");
                            System.out.println("Location: " + street + "," + city + "," + district + "," + state + "," + zipCode);
                            System.out.println("Distance: " + distance + "km");
                            System.out.println("Number of bedrooms: " + n_bedrooms);
                            System.out.println("Number of bathrooms: " + n_bathrooms);
                            System.out.println("Number of parking spaces: " + n_parkingSpaces);
                            System.out.println("Avaiable equipment: " + avaiableEquipment);
                            System.out.println("Existence of a Basement: " + existBasement);
                            System.out.println("Existence of an inhabitable loft: " + inhabitableLoft);
                            System.out.println("Sun exposure: " + sunExposure);
                            System.out.println();
                            break;

                    }
                    break;

                case "rent":
                    contractDuraction = Utils.readIntegerFromConsole("Contract duraction in months:");
                    rentprice = Utils.readIntegerFromConsole("Rent price:");

                    do {
                        photos.add(Utils.readLineFromConsole("photo URL"));
                        answer = Utils.readLineFromConsole("Do you want more photos?");
                        n++;
                    }while (answer.equals("yes") & n<=30);

                    propertyType = Utils.readLineFromConsole("Property Type(land, apartment or house):");
                    switch (propertyType) {
                        case "land" :
                            area = Utils.readIntegerFromConsole("Area in squad meters");
                            street = Utils.readLineFromConsole("Street");
                            city = Utils.readLineFromConsole("City");
                            district = Utils.readLineFromConsole("District");
                            state = Utils.readLineFromConsole("State");
                            zipCode = Utils.readIntegerFromConsole("Zipcode");
                            distance = Utils.readIntegerFromConsole("Distance from the city center");
                            System.out.println("Request Type: " + requestType);
                            System.out.println("Property Type: " + propertyType);
                            System.out.println("Contract duration: " + contractDuraction + " months");
                            System.out.println("Rent price: " + rentprice + "$");
                            System.out.println("Area: " + area + "m2");
                            System.out.println("Location: " + street + "," + city + "," + district + "," + state + "," + zipCode);
                            System.out.println("Distance: " + distance + "km");
                            break;
                        case "apartment":
                            area = Utils.readIntegerFromConsole("Area in squad meters");
                            street = Utils.readLineFromConsole("Street");
                            city = Utils.readLineFromConsole("City");
                            district = Utils.readLineFromConsole("District");
                            state = Utils.readLineFromConsole("State");
                            zipCode = Utils.readIntegerFromConsole("Zipcode");
                            distance = Utils.readIntegerFromConsole("Distance from the city center");
                            n_bedrooms = Utils.readIntegerFromConsole("Number of bedrooms");
                            n_bathrooms = Utils.readIntegerFromConsole("Number of bathrooms");
                            n_parkingSpaces = Utils.readIntegerFromConsole("Number of parking spaces");
                            avaiableEquipment = Utils.readLineFromConsole("name of the equipment(central heating and/or air conditioning): ");
                            System.out.println();
                            System.out.println("Request Type: " + requestType);
                            System.out.println("Property Type: " + propertyType);
                            System.out.println("Contract duration: " + contractDuraction + " months");
                            System.out.println("Rent price: " + rentprice + " $");
                            System.out.println("Area: " + area + "m2");
                            System.out.println("Location: " + street + "," + city + "," + district + "," + state + "," + zipCode);
                            System.out.println("Distance: " + distance + "km");
                            System.out.println("Number of bedrooms: " + n_bedrooms);
                            System.out.println("Number of bathrooms: " + n_bathrooms);
                            System.out.println("Number of parking spaces: " + n_parkingSpaces);
                            System.out.println("Avaiable equipment: " + avaiableEquipment);
                            break;

                        case "house":  area = Utils.readIntegerFromConsole("Area in squad meters");
                            street = Utils.readLineFromConsole("Street");
                            city = Utils.readLineFromConsole("City");
                            district = Utils.readLineFromConsole("District");
                            state = Utils.readLineFromConsole("State");
                            zipCode =Utils.readIntegerFromConsole("Zipcode");
                            distance = Utils.readIntegerFromConsole("Distance from the city center");
                            n_bedrooms = Utils.readIntegerFromConsole("Number of bedrooms");
                            n_bathrooms = Utils.readIntegerFromConsole("Number of bathrooms");
                            n_parkingSpaces = Utils.readIntegerFromConsole("Number of parking spaces");
                            avaiableEquipment = Utils.readLineFromConsole("name of the equipment(central heating and/or air conditioning):");
                            existBasement = Boolean.parseBoolean(Utils.readLineFromConsole("Has a basement?(true or false"));
                            inhabitableLoft = Boolean.parseBoolean(Utils.readLineFromConsole("Has a inhabitable loft?(true or false)"));
                            sunExposure = Utils.readLineFromConsole("Direction of the sun exposure( N,S , W or E)");
                            System.out.println();
                            System.out.println("Request Type: " + requestType);
                            System.out.println("Property Type: " + propertyType);
                            System.out.println("Contract duration: " + contractDuraction);
                            System.out.println("Rent price: " + rentprice + " $");
                            System.out.println("Area: " + area + "m2");
                            System.out.println("Location: " + street + "," + city + "," + district + "," + state +"," + zipCode);
                            System.out.println("Distance: " + distance + " km");
                            System.out.println("Number of bedrooms: " + n_bedrooms);
                            System.out.println("Number of bathrooms: " + n_bathrooms);
                            System.out.println("Number of parking spaces: " + n_parkingSpaces);
                            System.out.println("Avaiable equipment: " + avaiableEquipment);
                            System.out.println("Existence of a Basement: " + existBasement);
                            System.out.println("Existence of an inhabitable loft: " + inhabitableLoft);
                            System.out.println("Sun exposure: " + sunExposure);
                            System.out.println();

                    }

            }
    }*/


    @Override
    public void run() {
        System.out.println("Create a request");
        requestType = displayAndSelectTypeBusiness();
        if (requestType == "1"){
            requestData1();
        }
        if (requestType == "2"){
            requestData2();
        }

    }



    private String displayAndSelectTypeBusiness() {
        List<TypeBusiness> typeBusiness = controller.getTypeBusiness();
        int answer = Utils.showAndSelectIndex(typeBusiness, "Type of business");
        return typeBusiness.get(answer).getName();
    }

    public void requestData1(){
        price = requestPrice();
        propertyType = requestPropertyType();

    }

    private void requestData2() {
        contractDuraction = requestContractDuraction();
        rentprice = requestRentPrice();
        propertyType = requestPropertyType();
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

