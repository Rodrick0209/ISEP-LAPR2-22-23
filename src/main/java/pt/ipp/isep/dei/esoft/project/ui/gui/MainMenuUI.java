package pt.ipp.isep.dei.esoft.project.ui.gui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

/**
 * The type Main menu ui.
 */
public class MainMenuUI {
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnShowDevelopmentTeam;

    @FXML
    private Button btnLogIn;

    @FXML
    private Button btnSignUp;
    @FXML
    private Button btnListAllProperties;
    private Button btnSubmit;
    @FXML
    private TextField emailField;


    private Stage stage;
    private Scene mainScene;
    private Scene loginScene;
    private Parent root;


    /**
     * On login button.
     *Switches to login scene
     * @param event the event
     * @throws IOException the io exception
     */

    @FXML
    public void onLoginButton(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(LogInUI.class.getResource("/fxml/LogIn.fxml")));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        mainScene = new Scene(root);
        stage.setTitle("Real Estate USA App");
        stage.setScene(mainScene);
        stage.show();

    }



    /**
     * On list all properties button.
     *
     * @param event the event
     * @throws IOException the io exception
     */
    @FXML
    public void onListAllPropertiesButton(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(LogInUI.class.getResource("/fxml/ListAllProperties.fxml")));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        mainScene = new Scene(root);
        stage.setTitle("Real Estate USA App");
        stage.setScene(mainScene);
        stage.show();
    }

    /**
     * On sign up button.
     *
     * @param event the event
     * @throws IOException the io exception
     */
    @FXML
    public void onSignUpButton(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(UnregisteredUserUI.class.getResource("/fxml/RegisterUser.fxml")));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        mainScene = new Scene(root);
        stage.setTitle("Real Estate USA App");
        stage.setScene(mainScene);
        stage.show();
    }

    /**
     * On show development team button.
     *
     * @param event the event
     * @throws IOException the io exception
     */
    @FXML
    public void onShowDevelopmentTeamButton(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(ShowDevelopmentTeamUI.class.getResource("/fxml/ShowDevelopmentTeam.fxml")));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        mainScene = new Scene(root);
        stage.setTitle("Real Estate USA App");
        stage.setScene(mainScene);
        stage.show();
    }






    @FXML
        void initialize() {

            assert btnListAllProperties != null : "fx:id=\"btnListAllProperties\" was not injected: check your FXML file 'MainMenuUI.fxml'.";
            assert btnLogIn != null : "fx:id=\"btnLogIn\" was not injected: check your FXML file 'MainMenuUI.fxml'.";
            assert btnShowDevelopmentTeam != null : "fx:id=\"btnShowDevelopmentTeam\" was not injected: check your FXML file 'MainMenuUI.fxml'.";
            assert btnSignUp != null : "fx:id=\"btnSignUp\" was not injected: check your FXML file 'MainMenuUI.fxml'.";

        }

    }

