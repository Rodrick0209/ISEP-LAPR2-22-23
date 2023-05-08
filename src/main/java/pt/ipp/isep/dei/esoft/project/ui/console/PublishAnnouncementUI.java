package pt.ipp.isep.dei.esoft.project.ui.console;

import pt.ipp.isep.dei.esoft.project.application.controller.PublishAnnouncementController;
import pt.ipp.isep.dei.esoft.project.domain.Announcement;
import pt.ipp.isep.dei.esoft.project.domain.Location;
import pt.ipp.isep.dei.esoft.project.domain.Property;
import pt.ipp.isep.dei.esoft.project.ui.console.utils.Utils;

import java.util.Optional;
import java.util.List;

public class PublishAnnouncementUI implements Runnable {
    private final PublishAnnouncementController controller = new PublishAnnouncementController();

    private Location announcementPropertyLocation;
    private String announcementDescription;
    private int commission;
    private PublishAnnouncementController getController() {
        return controller;
    }

    public void run() {
        System.out.println("\nSelect the properties\n");

        announcementPropertyLocation = displayAndSelectProperty();
        requestData();

        submitOrNot();
    }

    private void submitData() {
        Optional<Announcement> announcement = getController().createAnnouncement(announcementPropertyLocation, announcementDescription, commission);

        if (announcement.isPresent()) {
            System.out.println("Announcement successfully published!");
        } else {
            System.out.println("Announcement not published!");
        }
    }

    private void submitOrNot() {
        showData();
        boolean answer = Utils.confirm("Submit and Publish data? (type yes or no)");
        if(answer){
            submitData();
        } else run();
    }

    private void showData(){
        System.out.println();
        System.out.println("Property Location: " + announcementPropertyLocation);
        System.out.println("Announcement Description: " + announcementDescription);
        System.out.println("Commission: " + commission);
        System.out.println();
    }

    private void requestData() {
        announcementDescription = requestAnnouncementDescription();
        commission = requestCommission();
    }

    /**
     *
     * @return input of the announcement description
     */
    private String requestAnnouncementDescription() {
        String input;
        do{
            input = Utils.readLineFromConsole("Announcement description: ");
            if (input != null && input.isEmpty()) {
                System.out.println("Invalid input. Please try again.");
            }
        } while(input != null && input.isEmpty());
        return input;
    }

    /**
     *
     * @return input of commission
     */
    private int requestCommission() {
        int input = 0;
        boolean valid = false;
        do{
            try {
                input = Utils.readIntegerFromConsole("Commission: ");
                valid = true;
            } catch (NullPointerException e) {
                System.out.println("Invalid Number. Please enter a valid number.");
            }
        }while(!valid);
        return input;
    }


    /**
     *
     * @return selected property from displayed property list
     */
    private Location displayAndSelectProperty() {
        List<Property> properties = controller.getProperties();
        int answer = Utils.showAndSelectIndex(properties, "Properties");
        return properties.get(answer).getLocation();
    }

}
