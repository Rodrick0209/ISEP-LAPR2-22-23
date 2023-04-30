package pt.ipp.isep.dei.esoft.project.ui.console;

import pt.ipp.isep.dei.esoft.project.ui.console.utils.Utils;

import java.util.ArrayList;
import java.util.List;

public class CreateRequestUI implements Runnable {

    private String requestType;

    private String propertyType;

    private int area;

    private int distance;

    private int n_bedrooms;

    private int n_bathrooms;

    private int n_parkingSpaces;

    private String avaiableEquipment;

    private String existBasement;

    private String inhabitableLoft;

    private String sunExposure;

    private String street;
    private String city;
    private String district;
    private String state;
    private int zipCode;

    private List<String> photos = new ArrayList<>();

    private int contractDuraction;

    private float price;
    private float rentprice;


    private String answer;
    public void run() {
            // Property Type data verification:
            requestType = Utils.readLineFromConsole("Choose a type: sell or rent");
            switch(requestType) {

                case "sell":
                    price = Utils.readIntegerFromConsole("Price of the property");
                    do {
                        photos.add(Utils.readLineFromConsole("photo URL"));
                        answer = Utils.readLineFromConsole("Do you want more photos?");
                    }while (answer == "yes");

                    propertyType = Utils.readLineFromConsole("Property Type(land, apartment or house:");
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
                            avaiableEquipment = Utils.readLineFromConsole("name of the equipment");
                            System.out.println();
                            System.out.println("Request Type: " + requestType);
                            System.out.println("Property Type: " + propertyType);
                            System.out.println("Price: " + price +"$");
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
                            avaiableEquipment = Utils.readLineFromConsole("name of the equipment");
                            existBasement = Utils.readLineFromConsole("Has a basement?");
                            inhabitableLoft = Utils.readLineFromConsole("Has a inhabitable loft?");
                            sunExposure = Utils.readLineFromConsole("Direction of the sun exposure");
                            System.out.println();
                            System.out.println("Request Type: " + requestType);
                            System.out.println("Property Type: " + propertyType);
                            System.out.println("Price: " + price + "$");
                            System.out.println("Area: " + area+ "m2");
                            System.out.println("Location: " + street + "," + city + "," + district + "," + state +"," + zipCode);
                            System.out.println("Distance: " + distance + "km");
                            System.out.println("Number of bedrooms: " + n_bedrooms);
                            System.out.println("Number of bathrooms: " + n_bathrooms);
                            System.out.println("Number of parking spaces: " + n_parkingSpaces);
                            System.out.println("Avaiable equipment: " + avaiableEquipment);
                            System.out.println("Existence of a Basement: " + existBasement);
                            System.out.println("Existence of an inhabitable loft: " + inhabitableLoft);
                            System.out.println("Sun exposure: " + sunExposure);
                            System.out.println();

                    }
                    break;

                case "rent":
                    contractDuraction = Utils.readIntegerFromConsole("Contract duraction in months:");
                    rentprice = Utils.readIntegerFromConsole("Rent price:");

            }
                do {
                        photos.add(Utils.readLineFromConsole("photo URL"));
                        answer = Utils.readLineFromConsole("Do you want more photos?");
                    }while (answer == "yes");

                propertyType = Utils.readLineFromConsole("Property Type(land, apartment or house:");
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
                            avaiableEquipment = Utils.readLineFromConsole("name of the equipment");
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
                            avaiableEquipment = Utils.readLineFromConsole("name of the equipment");
                            existBasement = Utils.readLineFromConsole("Has a basement?");
                            inhabitableLoft = Utils.readLineFromConsole("Has a inhabitable loft?");
                            sunExposure = Utils.readLineFromConsole("Direction of the sun exposure");
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

}

