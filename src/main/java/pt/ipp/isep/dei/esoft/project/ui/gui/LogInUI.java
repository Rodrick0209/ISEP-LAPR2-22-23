package pt.ipp.isep.dei.esoft.project.ui.gui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import pt.ipp.isep.dei.esoft.project.application.controller.authorization.AuthenticationController;
import pt.ipp.isep.dei.esoft.project.repository.AuthenticationRepository;
import pt.ipp.isep.dei.esoft.project.repository.Repositories;
import pt.isep.lei.esoft.auth.AuthFacade;
import pt.isep.lei.esoft.auth.UserSession;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LogInUI {

    public Button btnLogout;
    private Stage stage;
    private AuthFacade authenticationFacade = Repositories.getInstance().getAuthenticationRepository().getAuthenticationFacade();

    @FXML
    private Button btnLogIn;

    @FXML
    private PasswordField passwordField;

    @FXML
    private TextField emailField;

    @FXML
    private void doLogin(ActionEvent actionEvent) throws IOException {
        String email = emailField.getText();
        String password = passwordField.getText();

        try {
            if (authenticationFacade.existsUser(email) && isValidEmail(email)) {
                UserSession currentUsersession = authenticationFacade.doLogin(email, password);   //get user from session
                if (currentUsersession.isLoggedInWithRole(AuthenticationController.ROLE_AGENT)) {   //role validation
                    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/ActorsUI.fxml/AgentUI.fxml"));
                    stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
                    Parent root = fxmlLoader.load();
                    Scene agentScene = new Scene(root);
                    stage.setScene(agentScene);
                    stage.show();
                } else if (currentUsersession.isLoggedInWithRole(AuthenticationController.ROLE_NETWORK_MANAGER)) {   //role validation
                    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/ActorsUI.fxml/NetworkManagerUI.fxml"));
                    stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
                    Parent root = fxmlLoader.load();
                    Scene agentScene = new Scene(root);
                    stage.setScene(agentScene);
                    stage.show();

                } else if (currentUsersession.isLoggedInWithRole(AuthenticationController.ROLE_CLIENT)) {   //role validation
                    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/ActorsUI.fxml/ClientUI.fxml"));
                    stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
                    Parent root = fxmlLoader.load();
                    Scene agentScene = new Scene(root);
                    stage.setScene(agentScene);
                    stage.show();

                } else if (currentUsersession.isLoggedInWithRole(AuthenticationController.ROLE_STORE_MANAGER)) {   //role validation
                    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/ActorsUI.fxml/StoreManagerUI.fxml"));
                    stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
                    Parent root = fxmlLoader.load();
                    Scene agentScene = new Scene(root);
                    stage.setScene(agentScene);
                    stage.show();
                }
            } else {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Warning");
                alert.setHeaderText(null);
                alert.setContentText("Invalid email or the user does not exist.");
                alert.showAndWait();
            }
        } catch (IllegalArgumentException e) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Warning");
            alert.setHeaderText(null);
            alert.setContentText("Invalid email format.");
            alert.showAndWait();
        }
    }
    private void doLogout(ActionEvent actionEvent) throws IOException {
        AuthenticationRepository authenticationRepository = new AuthenticationRepository();
        authenticationRepository.getCurrentUserSession().doLogout();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/mainMenu.fxml"));
        stage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        Parent root = fxmlLoader.load();
        Scene agentScene = new Scene(root);
        stage.setScene(agentScene);
        stage.show();
    }

    private boolean isValidEmail (String email){
        String emailRegex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
        Pattern pattern = Pattern.compile(emailRegex);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }
}

