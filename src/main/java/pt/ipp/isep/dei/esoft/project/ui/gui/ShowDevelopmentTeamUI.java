package pt.ipp.isep.dei.esoft.project.ui.gui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import pt.ipp.isep.dei.esoft.project.ui.gui.Controller.SceneController;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ShowDevelopmentTeamUI implements Initializable {
    public Button doLogout;
    private Stage stage;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    @FXML
    private void getBackToMainMenu(ActionEvent actionEvent) throws IOException {
        SceneController.loadMainMenuScene(actionEvent);

    }
}
