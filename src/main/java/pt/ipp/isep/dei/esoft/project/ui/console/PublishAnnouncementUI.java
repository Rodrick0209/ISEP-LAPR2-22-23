package pt.ipp.isep.dei.esoft.project.ui.console;

import pt.ipp.isep.dei.esoft.project.application.controller.PublishAnnouncementController;
import pt.ipp.isep.dei.esoft.project.domain.*;
import pt.ipp.isep.dei.esoft.project.ui.console.menu.MenuItem;
import pt.ipp.isep.dei.esoft.project.ui.console.utils.Utils;

import java.util.ArrayList;
import java.util.Date;
import java.util.Optional;
import java.util.List;

public class PublishAnnouncementUI implements Runnable {
    private final PublishAnnouncementController controller = new PublishAnnouncementController();

    private String announcementPropertyLocation;
    private Date date;
    private Commission commission;
    private PublishAnnouncementController getController() {
        return controller;
    }

    public void run() {
        System.out.println("Select the requests\n");

        announcementPropertyLocation = displayAndSelectRequests();
        requestData();

        submitOrNot();
    }

    private void submitData() {
        Optional<Announcement> announcement = getController().createAnnouncement(announcementPropertyLocation, commission, date);

        if (announcement.isPresent()) {
            System.out.println("Announcement has been successfully published!");
        } else {
            System.out.println("Announcement not published!");
        }
    }

    private void submitOrNot() {
        showData();
        boolean answer = Utils.confirm("Confirm data? (type yes or no)");
        if(answer){
            submitData();
        } else run();
    }

    private void showData(){
        System.out.println();
        System.out.println("Property Location: " + announcementPropertyLocation);
        System.out.println("Commission Type: " + commission.getType());
        System.out.println("Commission Value: " + commission.getValue());
        System.out.println("Date of announcement: " + date);
        System.out.println();
    }

    private void requestData() {
        commission = requestCommission();
        date = requestDate();
    }

    /**
     *
     * @return input of the announcement description
     */
    private Date requestDate() {
        Date input;
        do{
            input = Utils.readDateFromConsole("Date of Request: ");
            if (input != null) {
                System.out.println("Invalid input. Please try again.");
            }
        } while(input != null);
        return input;
    }

    /**
     *
     * @return input of commission
     */
    private Commission requestCommission() {

        int input_value = 0;
        int input_type_value = 0;
        String input_type = "";
        boolean validCommissionType = false;
        boolean validCommissionValue = false;
        do{
            input_type_value = Utils.readIntegerFromConsole("Select your commission type: \n 1- Fixed Commission \n 2- Percentage Commission");
            if(input_type_value == 1){
                input_type = "Fixed Commission";
                validCommissionType = true;
            }
            else if(input_type_value == 2){
                input_type = "Percentage Commission";
                validCommissionType = true;
            }
            else {
                 System.out.println("Invalid Number. Please enter a valid number.");
            }
        }while(!validCommissionType);

        if (input_type_value == 1) {
            do {
                input_value = Utils.readIntegerFromConsole("Commission value: ");
                if (input_value > 0) {
                    validCommissionValue = true;
                }
                else{
                     System.out.println("Invalid Number. Please enter a valid number.");
                }
            } while (!validCommissionValue);
        }
        if (input_type_value == 2) {
            do {
                input_value = Utils.readIntegerFromConsole("Commission value: ");
                if (input_value > 0 && input_value <= 100) {
                    validCommissionValue = true;
                }
                else{
                    System.out.println("Invalid Number. Please enter a valid number.");
                }
            } while (!validCommissionValue);
        }
        return new Commission(input_type,input_value);
    }



    /**
     *
     * @return selected property from displayed property list
     */
    private String displayAndSelectRequests() {
        List<Request> requests = controller.getRequests();
        int answer = Utils.showAndSelectIndex(requests, "Requests:\n");
        return requests.get(answer).getProperty().getLocation();
    }

}
