package pt.ipp.isep.dei.esoft.project.ui.gui.Actors;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import pt.ipp.isep.dei.esoft.project.application.controller.RegisterUserController;
import pt.ipp.isep.dei.esoft.project.application.controller.authorization.AuthenticationController;
import pt.ipp.isep.dei.esoft.project.repository.Repositories;
import pt.ipp.isep.dei.esoft.project.ui.gui.Controller.SceneController;
import pt.isep.lei.esoft.auth.AuthFacade;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UnregisteredUserUI {
    public Button doLogout;

    private Stage stage;
    public TextField nameField;
    public TextField emailField;
    public Button btnRegisterUser;

    private final AuthFacade authenticationFacade = Repositories.getInstance().getAuthenticationRepository().getAuthenticationFacade();
    private final RegisterUserController controller = new RegisterUserController();
    public void registerUser(ActionEvent actionEvent) throws IOException {
        String username = emailField.getText();
        String email = nameField.getText();
        if (isValidEmail(email) && isValidName(username) && !authenticationFacade.existsUser(email)) {
            showConfirmationWindow(username, email);
            SceneController.loadMainMenuScene(actionEvent);

        
        } else if (authenticationFacade.existsUser(email)) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Warning");
            alert.setHeaderText(null);
            alert.setContentText("There is already a user with that email.");
            alert.showAndWait();
        } else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Warning");
            alert.setHeaderText(null);
            alert.setContentText("Invalid name or email format.");
            alert.showAndWait();
        }
    }

    @FXML
    private void doLogout(ActionEvent actionEvent) throws IOException {
        SceneController.loadMainMenuScene(actionEvent);

    }
    private void showConfirmationWindow(String userName, String userEmail) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirm your Data ");
        alert.setHeaderText("Do you want to submit your user data ?");
        alert.setContentText("\n\n"
                + "Name: " + userName + "\n"
                + "Email adress: " + userEmail);

        Stage stage = (Stage) alert.getDialogPane().getScene().getWindow();
        stage.setAlwaysOnTop(true);

        alert.showAndWait().ifPresent(response -> {
            if (response == ButtonType.OK) {
                String userPassword = controller.generatePassword();
                controller.writeFile(null, userPassword);
                controller.sendEmailToUser(userEmail);
                showSuccessWindow();
                authenticationFacade.addUser(userName,userEmail,userPassword);
                authenticationFacade.addUserWithRole(userName,userEmail,userPassword,AuthenticationController.ROLE_CLIENT);
                controller.createUser(userName, userEmail, userPassword, AuthenticationController.ROLE_CLIENT);
                controller.addUserWithRole(userName, userEmail, userPassword, AuthenticationController.ROLE_CLIENT);
            }
        });
    }

    private void showSuccessWindow() {

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
      ;
        alert.setTitle("Success");
        alert.setHeaderText(" User successfully registered!");
        alert.setContentText("A password for your login was sent to your email address.");

        Stage stage = (Stage) alert.getDialogPane().getScene().getWindow();
        stage.setAlwaysOnTop(true);

        alert.showAndWait();

    }

    /**
    Validation Section, validating the two input parameters (name and email)
     */
    private boolean isValidEmail (String email){
        String emailRegex = ("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$");
        Pattern pattern = Pattern.compile(emailRegex);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }
    private boolean isValidName(String name) {
        if (name == null || name.trim().isEmpty()) {
            return false;
        }
        if (!name.matches("[a-zA-Z\\s]+")) {  //validating by checking if is only is a-z characters
            return false;
        }
        return true;
    }
}
