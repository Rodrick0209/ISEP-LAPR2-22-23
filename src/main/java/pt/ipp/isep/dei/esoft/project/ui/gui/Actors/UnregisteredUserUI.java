package pt.ipp.isep.dei.esoft.project.ui.gui.Actors;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import pt.ipp.isep.dei.esoft.project.ui.gui.Controller.SceneController;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UnregisteredUserUI {
    public Button doLogout;

    private Stage stage;
    public TextField nameField;
    public TextField emailField;
    public Button btnRegisterUser;

    public void registerUser(ActionEvent actionEvent) {
        String email = nameField.getText();
        String Username = emailField.getText();
        if (isValidEmail(email) & Username != null) {


        } else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Warning");
            alert.setHeaderText(null);
            alert.setContentText("Invalid email or Name.");
            alert.showAndWait();
        }
  //  } catch (IllegalArgumentException e;) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Warning");
        alert.setHeaderText(null);
        alert.setContentText("Invalid email format.");
        alert.showAndWait();
        }



    @FXML
    private void doLogout(ActionEvent actionEvent) throws IOException {
        SceneController.loadMainMenuScene(actionEvent);

    }
    private boolean isValidEmail (String email){
        String emailRegex = ("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$");
        Pattern pattern = Pattern.compile(emailRegex);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }
}
