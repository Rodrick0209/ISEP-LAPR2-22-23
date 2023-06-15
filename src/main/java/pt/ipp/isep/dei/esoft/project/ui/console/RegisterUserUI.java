package pt.ipp.isep.dei.esoft.project.ui.console;

import pt.ipp.isep.dei.esoft.project.application.controller.RegisterUserController;
import pt.ipp.isep.dei.esoft.project.application.controller.authorization.AuthenticationController;
import pt.ipp.isep.dei.esoft.project.domain.SendEmail;
import pt.ipp.isep.dei.esoft.project.ui.console.utils.Utils;

/**
 * The type Register user ui.
 */

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
        controller.createUser(userName, userEmail, userPassword, AuthenticationController.ROLE_CLIENT);
        controller.addUserWithRole(userName, userEmail, userPassword, AuthenticationController.ROLE_CLIENT);
        controller.writeFile(null, userPassword);
        controller.sendEmailToUser(userEmail);
        System.out.println("User successfully registered! A password for your login will be sent to your email address.");
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

    /**
     * Validate name boolean.
     * Name needs to be a string and has to have at least a letter (Capital or not )
     *
     * @param name the name
     * @return the boolean
     */
    public boolean validateName(String name) {
        if (name == null || name.trim().isEmpty()) {
            return false;
        }
        if (!name.matches("[a-zA-Z\\s]+")) {  //validating by checking if is only is a-z characters
            return false;
        }
        return true;
    }



    private String requestUserEmailAddress() {
        userEmail = inputAndValidateUserName();
        return userEmail;
    }

    /**
     * Input and validate user name string.
     *
     * @return the string
     */
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
     * Email validiation , email needs to have A-Z can or not contain a number a  @ and A-Z  letter can or not contain a number  ,
     *
     * @param email the email
     * @return the boolean
     */
    public static boolean validateEmail(String email) {

        String emailRegex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
        return email.matches(emailRegex);
    }

}
