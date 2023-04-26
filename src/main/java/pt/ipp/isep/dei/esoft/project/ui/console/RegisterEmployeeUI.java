package pt.ipp.isep.dei.esoft.project.ui.console;

import pt.ipp.isep.dei.esoft.project.application.controller.RegisterEmployeeController;
import pt.ipp.isep.dei.esoft.project.domain.Agency;
import pt.ipp.isep.dei.esoft.project.domain.Employee;
import pt.ipp.isep.dei.esoft.project.domain.Role;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class RegisterEmployeeUI implements Runnable {
    private final Scanner sc = new Scanner(System.in);
    private final RegisterEmployeeController controller = new RegisterEmployeeController();
    private String employeeName;
    private String employeeEmail;
    private int employeeCCNumber;
    private int employeeTaxNumber;
    private String employeeAddress;
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
        Optional<Employee> employee = getController().createEmployee(employeeName, employeeEmail, employeeCCNumber, employeeTaxNumber, employeeAddress, employeeRoleName, employeeAgencyID);

        if (employee.isPresent()) {
            System.out.println("Employee successfully registered!");
        } else {
            System.out.println("Employee not registered!");
        }
    }

    private void submitOrNot() {
        showData();
        int answer;
        System.out.println("Submit Data?");
        System.out.println("1. Yes");
        System.out.println("2. No");
        System.out.println("Your answer: ");
        answer = sc.nextInt();
        switch(answer){
            case 1:
                submitData();
            case 2:
                run();
            default:
                System.out.println("Invalid Option. Please enter a valid option.");
                submitOrNot();
        }
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
    }

    /**
     *
     * @return input
     */
    private String requestEmployeeName() {
        String input;
        do{
            System.out.println("Employee Name: ");
            input = sc.nextLine().trim();
            if (input.isEmpty()) {
                System.out.println("Invalid input. Please try again.");
            }
        } while(input.isEmpty());
        return input;
    }

    /**
     *
     * @return input
     */
    private String requestEmployeeEmail() {
        String input;
        do{
            System.out.println("Employee Email: ");
            input = sc.nextLine().trim();
            if (!input.contains("@")) {
                System.out.println("Invalid input. Please try again.");
            }
        } while(!input.contains("@"));
        return input;
    }

    /**
     *
     * @return input
     */
    private int requestEmployeeCCNumber() {
        boolean valid = false;
        int input = 0;
        do{
            try{
                System.out.println("Employee Tax Number: ");
                input = sc.nextInt();
                valid = true;
            } catch (InputMismatchException e){
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
        boolean valid = false;
        int input = 0;
        do{
            try{
                System.out.println("Employee Tax Number: ");
                input = sc.nextInt();
                valid = true;
            } catch (InputMismatchException e){
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
            System.out.println("Employee Address: ");
            input = sc.nextLine().trim();
            if (input.isEmpty()) {
                System.out.println("Invalid input. Please try again.");
            }
        } while(input.isEmpty());
        return input;
    }

    /**
     *
     * @return role
     */
    private String displayAndSelectRole() {
        List<Role> roles = controller.getRoles();
        int answer = -1;

        while (answer < 1 || answer > roles.size()) {
            displayRoleOptions(roles);
            System.out.println("Select a Role: ");
            answer = sc.nextInt();
        }

        return roles.get(answer - 1).getName();
    }

    /**
     *
     * @param roles list of roles
     */
    private void displayRoleOptions(List<Role> roles) {
        int i = 1;
        for (Role role : roles) {
            System.out.println(i + ". " + role.getName());
            i++;
        }
    }

    /**
     *
     * @return agency ID
     */
    private int displayAndSelectAgency() {
        List<Agency> agencies = controller.getAgencies();
        int answer = -1;

        while (answer < 1 || answer > agencies.size()) {
            displayAgencyOptions(agencies);
            System.out.println("Select a Agency: ");
            answer = sc.nextInt();
        }
        return agencies.get(answer - 1).getID();
    }


    /**
     *
     * @param agencies list of agencies by designation and ID
     */
    private void displayAgencyOptions(List<Agency> agencies) {
        int i = 1;
        for (Agency agency : agencies) {
            System.out.println(i + ". " + agency.getDesignation() + " - " + agency.getID());
            i++;
        }
    }
}
