package pt.ipp.isep.dei.esoft.project.ui.console;

import pt.ipp.isep.dei.esoft.project.application.controller.PublishAnnouncementController;
import pt.ipp.isep.dei.esoft.project.application.controller.RegisterEmployeeController;
import pt.ipp.isep.dei.esoft.project.domain.Agency;
import pt.ipp.isep.dei.esoft.project.domain.Announcement;
import pt.ipp.isep.dei.esoft.project.domain.Role;
import pt.ipp.isep.dei.esoft.project.ui.console.utils.Utils;

import java.util.List;
import java.util.Optional;

public class PublishAnnouncementUI implements Runnable {
    public PublishAnnouncementUI(){

    }

    private final PublishAnnouncementController controller = new PublishAnnouncementController();

    private String announcementPropertyLocation;
    private String announcementDescription;
    private RegisterEmployeeController getController() {
        return controller;
    }

    public void run() {
        System.out.println("Register Employee");

        requestData();

        employeeRoleName = displayAndSelectRole();
        employeeAgencyID = displayAndSelectAgency();

        submitOrNot();
    }

    private void submitData() {
        Optional<Announcement> announcement = getController().createEmployee();

        if (employee.isPresent()) {
            System.out.println("Employee successfully registered!");
        } else {
            System.out.println("Employee not registered!");
        }
    }

    private void submitOrNot() {
        showData();
        boolean answer = Utils.confirm("Submit Data?");
        if(answer){
            submitData();
        } else run();
    }

    private void showData(){
        System.out.println();
        System.out.println("Employee Name: " + employeeName);
        System.out.println("Employee Email: " + employeeEmail);
        System.out.println("Employee CC Number: " + employeeCCNumber);
        System.out.println("Employee Tax Number: " + employeeTaxNumber);
        System.out.println("Employee Address: " + employeeAddress);
        System.out.println("Employee Role: " + employeeRoleName);
        System.out.println("Employee Agency ID: " + employeeAgencyID);
        System.out.println();
    }
    private void requestData() {
        employeeName = requestEmployeeName();
        employeeEmail = requestEmployeeEmail();
        employeeCCNumber = requestEmployeeCCNumber();
        employeeTaxNumber = requestEmployeeTaxNumber();
        employeeAddress = requestEmployeeAddress();
        employeePhoneNumber = requestEmployeePhoneNumber();
    }

    /**
     *
     * @return input
     */
    private String requestEmployeeName() {
        String input;
        do{
            input = Utils.readLineFromConsole("Employee Name: ");
            if (input != null && input.isEmpty()) {
                System.out.println("Invalid input. Please try again.");
            }
        } while(input != null && input.isEmpty());
        return input;
    }

    /**
     *
     * @return input
     */
    private String requestEmployeeEmail() {
        String input;
        do{
            input = Utils.readLineFromConsole("Employee Email: ");
            if (input != null && !input.contains("@")) {
                System.out.println("Invalid input. Please try again.");
            }
        } while(input != null && !input.contains("@"));
        return input;
    }

    /**
     *
     * @return input
     */
    private int requestEmployeeCCNumber() {
        int input = 0;
        boolean valid = false;
        do{
            try {
                input = Utils.readIntegerFromConsole("Employee Tax Number: ");
                valid = true;
            } catch (NullPointerException e) {
                System.out.println("Invalid Number. Please enter a valid number.");
            }
        }while(!valid);
        return input;
    }

    /**
     *
     * @return input
     */
    private int requestEmployeeTaxNumber() {
        int input = 0;
        boolean valid = false;
        do{
            try{
                input = Utils.readIntegerFromConsole("Employee Tax Number: ");
                valid = true;
            } catch (NullPointerException e){
                System.out.println("Invalid Number. Please enter a valid number.");
            }
        }while(!valid);
        return input;
    }

    /**
     *
     * @return input
     */
    private String requestEmployeeAddress() {
        String input;
        do{
            input = Utils.readLineFromConsole("Employee Address: ");
            if (input != null && input.isEmpty()) {
                System.out.println("Invalid input. Please try again.");
            }
        } while(input!= null && input.isEmpty());
        return input;
    }

    private String requestEmployeePhoneNumber() {
        String input;
        do{
            input = Utils.readLineFromConsole("Employee Phone Number: ");
            if (input != null && !input.contains("(") && !input.contains(")") && !input.contains("-")) {
                System.out.println("Invalid input. Please try again.");
            }
        } while (input != null && !input.contains("(") && !input.contains(")") && !input.contains("-"));
        return input;
    }

    private String displayAndSelectRole() {
        List<Role> roles = controller.getRoles();
        int answer = Utils.showAndSelectIndex(roles, "Roles");
        return roles.get(answer).getName();
    }

    private int displayAndSelectAgency() {
        List<Agency> agencies = controller.getAgencies();
        int answer = Utils.showAndSelectIndex(agencies, "Agencies");
        return agencies.get(answer).getID();
    }

}
}
