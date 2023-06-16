package pt.ipp.isep.dei.esoft.project.ui.gui.Utils;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import pt.ipp.isep.dei.esoft.project.repository.AuthenticationRepository;
import pt.ipp.isep.dei.esoft.project.ui.gui.Controller.SceneController;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ListAllPropertiesUI implements Initializable {
    public Button doLogout;
    private Stage stage;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    @FXML
    private void doLogout(ActionEvent actionEvent) throws IOException {
        SceneController.loadMainMenuScene(actionEvent);
    }
}
