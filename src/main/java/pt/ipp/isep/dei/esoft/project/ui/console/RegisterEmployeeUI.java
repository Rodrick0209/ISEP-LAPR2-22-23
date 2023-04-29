package pt.ipp.isep.dei.esoft.project.ui.console;

import pt.ipp.isep.dei.esoft.project.application.controller.RegisterEmployeeController;
import pt.ipp.isep.dei.esoft.project.domain.Agency;
import pt.ipp.isep.dei.esoft.project.domain.Employee;
import pt.ipp.isep.dei.esoft.project.domain.Role;
import pt.ipp.isep.dei.esoft.project.ui.console.utils.Utils;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class RegisterEmployeeUI implements Runnable {

    public RegisterEmployeeUI(){

    }
    private final RegisterEmployeeController controller = new RegisterEmployeeController();
    private String employeeName;
    private String employeeEmail;
    private int employeeCCNumber;
    private int employeeTaxNumber;
    private String employeeAddress;
    private String employeePhoneNumber;
    private String employeeRoleName;
    private int employeeAgencyID;

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
        Optional<Employee> employee = getController().createEmployee(employeeName, employeeEmail, employeeCCNumber, employeeTaxNumber, employeeAddress, employeePhoneNumber, employeeRoleName, employeeAgencyID);

        if (employee.isPresent()) {
            System.out.println("Employee successfully registered!");
        } else {
            System.out.println("Employee not registered!");
        }
    }

    private void submitOrNot() {
        showData();
        boolean answer = Utils.confirm("Submit Data? (type yes or no)");
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
     * @return input of employee name
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
     * @return input of employee email
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
     * @return input of employee cc number
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
     * @return input of employee tax number
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
     * @return input of employee address
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

    /**
     *
     * @return input of employee phone number
     */
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

    /**
     *
     * @return selected role from displayed role list
     */
    private String displayAndSelectRole() {
        List<Role> roles = controller.getRoles();
        int answer = Utils.showAndSelectIndex(roles, "Roles");
        return roles.get(answer).getName();
    }

    /**
     *
     * @return selected agency from displayed agency list
     */
    private int displayAndSelectAgency() {
        List<Agency> agencies = controller.getAgencies();
        int answer = Utils.showAndSelectIndex(agencies, "Agencies");
        return agencies.get(answer).getID();
    }

}
