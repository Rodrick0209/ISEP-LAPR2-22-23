package pt.ipp.isep.dei.esoft.project.application.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.awt.event.ActionEvent;
import java.io.IOException;

public class MainMenuController {

    @FXML
    private Button btnShowDevelopmentTeam;

    @FXML
    private Button btnLogIn;

    @FXML
    private Button btnSignUp;

    private Stage stage;
    private Scene scene;
    private Parent root;

    public void onLogInButton(ActionEvent logInEvent) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("src/main/resources/main menu.fxml"));
        stage = (Stage)((Node)logInEvent.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
    }

}

