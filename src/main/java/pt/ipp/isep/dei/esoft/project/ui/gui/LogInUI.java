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
import pt.ipp.isep.dei.esoft.project.repository.Repositories;
import pt.isep.lei.esoft.auth.AuthFacade;
import pt.isep.lei.esoft.auth.UserSession;
import pt.isep.lei.esoft.auth.domain.model.User;
import pt.isep.lei.esoft.auth.domain.store.UserStore;
import pt.isep.lei.esoft.auth.mappers.dto.UserDTO;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

public class LogInUI {

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

        if (authenticationFacade.existsUser(email)) {
            UserSession currentUsersession = authenticationFacade.doLogin(email, password);   //get user from session
            if (currentUsersession.isLoggedInWithRole(AuthenticationController.ROLE_AGENT)) {   //role validation
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/AgentUI.fxml"));
                stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
                Parent root = fxmlLoader.load();
                Scene agentScene = new Scene(root);
                stage.setScene(agentScene);
                stage.show();
            } else if (currentUsersession.isLoggedInWithRole(AuthenticationController.ROLE_NETWORK_MANAGER)) {   //role validation
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/NetworkManagerUI.fxml"));
                stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
                Parent root = fxmlLoader.load();
                Scene agentScene = new Scene(root);
                stage.setScene(agentScene);
                stage.show();

            } else if (currentUsersession.isLoggedInWithRole(AuthenticationController.ROLE_CLIENT)) {   //role validation
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/ClientUI.fxml"));
                stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
                Parent root = fxmlLoader.load();
                Scene agentScene = new Scene(root);
                stage.setScene(agentScene);
                stage.show();

            } else if (currentUsersession.isLoggedInWithRole(AuthenticationController.ROLE_STORE_MANAGER)) {   //role validation
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/StoreManagerUI.fxml"));
                stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
                Parent root = fxmlLoader.load();
                Scene agentScene = new Scene(root);
                stage.setScene(agentScene);
                stage.show();

            } else {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Warning");
                alert.setHeaderText(null);
                alert.setContentText("Invalid email or the user does not exist.");
                alert.showAndWait();
            }
        }
    }
}
