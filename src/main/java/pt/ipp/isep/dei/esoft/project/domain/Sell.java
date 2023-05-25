package pt.ipp.isep.dei.esoft.project.domain;

import pt.ipp.isep.dei.esoft.project.ui.console.DevTeamUI;
import pt.ipp.isep.dei.esoft.project.ui.console.ShowTextUI;
import pt.ipp.isep.dei.esoft.project.ui.console.authorization.AuthenticationUI;
import pt.ipp.isep.dei.esoft.project.ui.console.menu.MenuItem;
import pt.ipp.isep.dei.esoft.project.ui.console.utils.Utils;

import java.util.ArrayList;
import java.util.List;



public class Sell  implements Runnable{
    public void run() {
        List<MenuItem> options = new ArrayList<MenuItem>();
        options.add(new MenuItem("Property.java", new AuthenticationUI()));
        options.add(new MenuItem("Apartment", new DevTeamUI()));
        options.add(new MenuItem("House", new ShowTextUI()));
        int option = 0;
        do {
            option = Utils.showAndSelectIndex(options, "\n\nMain Menu");

            if ((option >= 0) && (option < options.size())) {
                options.get(option).run();
            }
        } while (option != -1);

        if ("1".equals(option)){
            Land();
        }if ("2".equals(option)) {
            Apartment();
        }if ("3".equals(option)) {
            House();
        }else {
            System.out.println("Insert a valid number");
        }

        }


    public void Land() {
        int area = Utils.readIntegerFromConsole("Area in squad meters");
        String street = Utils.readLineFromConsole("Street");
        String city = Utils.readLineFromConsole("City");
        String district = Utils.readLineFromConsole("District");
        String state = Utils.readLineFromConsole("State");
        int zipCode = Utils.readIntegerFromConsole("Zipcode");
        double distance = Utils.readIntegerFromConsole("Distance from the city center");
        int price = Utils.readIntegerFromConsole("Price ");
        System.out.println("Request Type: Sell " );
        System.out.println("Property Type: Property.java " );
        System.out.println("Price: " + price + " $");
        System.out.println("Area: " + area + "m2");
        System.out.println("Location: " + street + "," + city + "," + district + "," + state + "," + zipCode);
        System.out.println("Distance: " + distance + " km");
    }

    public void Apartment(){

        int price = Utils.readIntegerFromConsole("Price");
        int area = Utils.readIntegerFromConsole("Area in squad meters");
        String street = Utils.readLineFromConsole("Street");
        String city = Utils.readLineFromConsole("City");
        String district = Utils.readLineFromConsole("District");
        String  state = Utils.readLineFromConsole("State");
        int zipCode = Utils.readIntegerFromConsole("Zipcode");
        int distance = Utils.readIntegerFromConsole("Distance from the city center");
        int n_bedrooms = Utils.readIntegerFromConsole("Number of bedrooms");
        int n_bathrooms = Utils.readIntegerFromConsole("Number of bathrooms");
        int n_parkingSpaces = Utils.readIntegerFromConsole("Number of parking spaces");
        List<MenuItem> options = new ArrayList<MenuItem>();
        options.add(new MenuItem("Central heating", new AuthenticationUI()));
        options.add(new MenuItem("Air conditioning", new DevTeamUI()));
        options.add(new MenuItem("Both", new ShowTextUI()));
        options.add(new MenuItem("None", new ShowTextUI()));
        int option = 0;
        do {
            option = Utils.showAndSelectIndex(options, "\n\nAvaiable Equipment");

            if ((option >= 0) && (option < options.size())) {
                options.get(option).run();
            }
        } while (option != -1);
        System.out.println();
        System.out.println("Request Type: Sell " );
        System.out.println("Property Type: Apartment " );
        System.out.println("Price: " + price + "$");
        System.out.println("Area: " + area + "m2");
        System.out.println("Location: " + street + "," + city + "," + district + "," + state + "," + zipCode);
        System.out.println("Distance: " + distance + "km");
        System.out.println("Number of bedrooms: " + n_bedrooms);
        System.out.println("Number of bathrooms: " + n_bathrooms);
        System.out.println("Number of parking spaces: " + n_parkingSpaces);
        System.out.println("Avaiable equipment: " + options);

}

public void House() {
    int price = Utils.readIntegerFromConsole("Price");
    int area = Utils.readIntegerFromConsole("Area in squad meters");
    String street = Utils.readLineFromConsole("Street");
    String city = Utils.readLineFromConsole("City");
    String district = Utils.readLineFromConsole("District");
    String  state = Utils.readLineFromConsole("State");
    int zipCode = Utils.readIntegerFromConsole("Zipcode");
    int distance = Utils.readIntegerFromConsole("Distance from the city center");
    int n_bedrooms = Utils.readIntegerFromConsole("Number of bedrooms");
    int n_bathrooms = Utils.readIntegerFromConsole("Number of bathrooms");
    int n_parkingSpaces = Utils.readIntegerFromConsole("Number of parking spaces");
    List<MenuItem> options = new ArrayList<MenuItem>();
    options.add(new MenuItem("Central heating", new AuthenticationUI()));
    options.add(new MenuItem("Air conditioning", new DevTeamUI()));
    options.add(new MenuItem("Both", new ShowTextUI()));
    options.add(new MenuItem("None", new ShowTextUI()));
    int option = 0;
    do {
        option = Utils.showAndSelectIndex(options, "\n\nAvaiable Equipment");

        if ((option >= 0) && (option < options.size())) {
            options.get(option).run();
        }
    } while (option != -1);
    List<MenuItem> opt = new ArrayList<MenuItem>();
    opt.add(new MenuItem("True", new AuthenticationUI()));
    opt.add(new MenuItem("False", new DevTeamUI()));
    int opti = 0;
    do {
        opti = Utils.showAndSelectIndex(opt, "\n\nInhabitable Loft");

        if ((opti >= 0) && (opti < opt.size())) {
            opt.get(opti).run();
        }
    } while (opti != -1);
    List<MenuItem> optio = new ArrayList<MenuItem>();
    optio.add(new MenuItem("True", new AuthenticationUI()));
    optio.add(new MenuItem("False", new DevTeamUI()));
    int Optio = 0;
    do {
        Optio = Utils.showAndSelectIndex(opt, "\n\nExistence of Basement");

        if ((Optio >= 0) && (Optio < opt.size())) {
            opt.get(Optio).run();
        }
    } while (Optio != -1);
    List<MenuItem> Options = new ArrayList<MenuItem>();
    Options.add(new MenuItem("N", new AuthenticationUI()));
    Options.add(new MenuItem("S", new DevTeamUI()));
    Options.add(new MenuItem("W", new ShowTextUI()));
    Options.add(new MenuItem("E", new ShowTextUI()));
    int OptionS = 0;
    do {
        OptionS = Utils.showAndSelectIndex(opt, "\n\nSun Exposure");

        if ((OptionS >= 0) && (OptionS < Options.size())) {
            opt.get(OptionS).run();
        }
    } while (OptionS != -1);
    System.out.println();
    System.out.println("Request Type: Sell " );
    System.out.println("Property Type: Apartment " );
    System.out.println("Price: " + price + "$");
    System.out.println("Area: " + area + "m2");
    System.out.println("Location: " + street + "," + city + "," + district + "," + state + "," + zipCode);
    System.out.println("Distance: " + distance + "km");
    System.out.println("Number of bedrooms: " + n_bedrooms);
    System.out.println("Number of bathrooms: " + n_bathrooms);
    System.out.println("Number of parking spaces: " + n_parkingSpaces);
    System.out.println("Avaiable equipment: " + options);
    System.out.println("Existence of a Basement: " + optio);
    System.out.println("Existence of an inhabitable loft: " + opt);
    System.out.println("Sun exposure: " + Options);


}
}
