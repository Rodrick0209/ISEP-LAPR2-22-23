package pt.ipp.isep.dei.esoft.project.ui.console;

import pt.ipp.isep.dei.esoft.project.application.controller.RegisterAgencyController;
import pt.ipp.isep.dei.esoft.project.domain.Agency;
import pt.ipp.isep.dei.esoft.project.ui.console.utils.Utils;

import java.util.Optional;

public class RegisterAgencyUI implements Runnable {
    private final RegisterAgencyController controller = new RegisterAgencyController();
    private int agencyID;
    private String agencyDesignation;
    private String agencyLocation;
    private String agencyEmailAddress;
    private String agencyPhoneNumber;

    private RegisterAgencyController getController(){ return controller;}

    public void run(){
        System.out.println("Register Agency");

        requestData();

        submitOrNot();
    }

    private void submitData() {
        Optional<Agency> agency = getController().createAgency(agencyID, agencyDesignation, agencyLocation, agencyEmailAddress, agencyPhoneNumber);

        if (agency.isPresent()) {
            System.out.println("Agency successfully registered!");
        } else {
            System.out.println("Agency not registered!");
        }
    }

    private void submitOrNot() {
        showData();
        boolean answer = Utils.confirm("Confirm Data? (type yes or no)");
        if(answer){
            submitData();
        } else run();
    }

    private void showData(){
        System.out.println();
        System.out.println("Agency ID: " + agencyID);
        System.out.println("Agency Designation: " + agencyDesignation);
        System.out.println("Agency Location: " + agencyLocation);
        System.out.println("Agency Email Address: " + agencyEmailAddress);
        System.out.println("Agency Phone Number: " + agencyPhoneNumber);
        System.out.println();
    }
    private void requestData() {
        agencyID = requestAgencyID();
        agencyDesignation = requestAgencyDesignation();
        agencyLocation = requestAgencyLocation();
        agencyEmailAddress = requestAgencyEmailAddress();
        agencyPhoneNumber = requestAgencyPhoneNumber();
    }

    /**
     *
     * @return input of agency designation
     */
    private String requestAgencyDesignation() {
        String input;
        do{
            input = Utils.readLineFromConsole("Agency Designation: ");
            if (input != null && input.isEmpty()) {
                System.out.println("Invalid input. Please try again.");
            }
        } while(input != null && input.isEmpty());
        return input;
    }

    /**
     *
     * @return input of agency email address
     */
    private String requestAgencyEmailAddress() {
        String input;
        int count = 0;
        do {
            input = Utils.readLineFromConsole("Employee Email Address: ");
            if (input != null) {
                for (char c : input.toCharArray()) {
                    if (c == '@') {
                        count++;
                    }
                }
                if (input.isEmpty() || count != 1) {
                    System.out.println("Invalid input. Please try again.");
                }
            }
        } while ((input != null && input.isEmpty()) || count != 1);
        return input;
    }

    /**
     *
     * @return input of agency id
     */
    private int requestAgencyID() {
        int input = 0;
        boolean valid = false;
        do{
            try {
                input = Utils.readIntegerFromConsole("Agency ID: ");
                valid = true;
            } catch (NullPointerException e) {
                System.out.println("Invalid Number. Please enter a valid number.");
            }
        }while(!valid);
        return input;
    }

    /**
     *
     * @return input of agency location
     */
    private String requestAgencyLocation() {
        String input;
        do{
            input = Utils.readLineFromConsole("Agency Location: ");
            if (input != null && input.isEmpty()) {
                System.out.println("Invalid input. Please try again.");
            }
        } while(input!= null && input.isEmpty());
        return input;
    }

    /**
     *
     * @return input of agency phone number
     */
    private String requestAgencyPhoneNumber() {
        String input;
        do{
            input = Utils.readLineFromConsole("Agency Phone Number: ");
            if (input != null && input.isEmpty()) {
                System.out.println("Invalid input. Please try again.");
            }
        } while(input!= null && input.isEmpty());
        return input;
    }
}
