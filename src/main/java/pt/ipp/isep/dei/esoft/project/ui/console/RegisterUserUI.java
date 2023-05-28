package pt.ipp.isep.dei.esoft.project.ui.console;

import pt.ipp.isep.dei.esoft.project.application.controller.RegisterUserController;
import pt.ipp.isep.dei.esoft.project.application.controller.authorization.AuthenticationController;
import pt.ipp.isep.dei.esoft.project.domain.Agency;
import pt.ipp.isep.dei.esoft.project.ui.console.utils.Utils;

import java.util.Optional;

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
        String input;
        do{
            input = Utils.readLineFromConsole("Your Name: ");
            if (input != null && input.isEmpty()) {
                System.out.println("Invalid input. Please try again.");
            }
        } while(input != null && input.isEmpty());
        return input;
    }

    private String requestUserEmailAddress() {
        String input;
        int count = 0;
        do {
            input = Utils.readLineFromConsole("Your Email Address: ");
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
}
