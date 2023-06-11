package pt.ipp.isep.dei.esoft.project.ui.gui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class MainMenuUI {

    @FXML
    private Button btnShowDevelopmentTeam;

    @FXML
    private Button btnLogIn;

    @FXML
    private Button btnSignUp;

    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    public void onLogInButton(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(LogInUI.class.getResource("src/main/resources/fxml/LogIn.fxml")));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setTitle("Log In");
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void onSignUpButton(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(RegisterUserUI.class.getResource("src/main/resources/fxml/RegisterUser.fxml")));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setTitle("Sign Up");
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void onShowDevolopmentTeamButton(ActionEvent event) throws IOException{
        Parent root = FXMLLoader.load(Objects.requireNonNull(ShowDevelopmentTeamUI.class.getResource("src/main/resources/fxml/ShowDevelopmentTeam.fxml")));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setTitle("Show Development Team");
        stage.setScene(scene);
        stage.show();
    }

}

