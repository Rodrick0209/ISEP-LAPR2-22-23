package pt.ipp.isep.dei.esoft.project.ui.console;

import pt.ipp.isep.dei.esoft.project.application.controller.RegisterUserController;
import pt.ipp.isep.dei.esoft.project.application.controller.authorization.AuthenticationController;
import pt.ipp.isep.dei.esoft.project.ui.console.utils.Utils;

public class RegisterUserUI implements Runnable {

    private final RegisterUserController controller = new RegisterUserController();

    private String userName;
    private String userEmail;

    private String userPassword;

    public void run(){
        System.out.println("Sign up\n");

        requestData();
        submitOrNot();
    }

    private void requestData(){
        userName = requestUserName();
        userEmail = requestUserEmailAddress();

    }

    private void submitData() {
        userPassword = controller.generatePassword();
        if(controller.addUserWithRole(userName, userEmail, userPassword, AuthenticationController.ROLE_USER)){
            controller.writeFile(userEmail, userPassword);
            System.out.println("User successfully registered! A password for you login in the application will be sent to your email address.");
        } else System.out.println("User not registered!");
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
        System.out.println("Name: " + userName);
        System.out.println("Email Address: " + userEmail);
        System.out.println();
    }
    private String requestUserName(){
        userName = inputAndValidateUserName(userName);
        return  userName;

    }



    private String inputAndValidateUserName(String userName) {
        do{
            userName = Utils.readLineFromConsole("Your Name: ");
            if (userName != null && !validateName(userName)) {
                System.out.println("Invalid name. Please try again.");
            }
        } while(userName != null && !validateName(userName));
        return userName;
    }

    public boolean validateName(String name) {
        if (name == null || name.trim().isEmpty()) {
            return false;
        }
        if (!name.matches("[a-zA-Z\\s]+")) {
            return false;
        }
        return true;
    }


    private String requestUserEmailAddress() {
        userEmail = inputAndValidateUserName();
        return userEmail;
    }
    public String inputAndValidateUserName() {
        do {
            userEmail = Utils.readLineFromConsole("Your Email Address: ");
            if (userEmail != null && !validateEmail(userEmail)){
                System.out.println("Invalid Email please try again");
            }
        } while (userEmail != null && !validateEmail(userEmail));
        return userEmail;
    }

    /**
     * Email validiation , email need to have A-Z can or not contain a number a  @ and A-Z  letter can or not contain a number  ,
     */
    public static boolean validateEmail(String email) {

        String emailRegex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
        return email.matches(emailRegex);
    }
}
