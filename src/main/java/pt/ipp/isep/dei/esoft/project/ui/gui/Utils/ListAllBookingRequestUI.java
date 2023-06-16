package pt.ipp.isep.dei.esoft.project.ui.gui.Utils;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import pt.ipp.isep.dei.esoft.project.ui.gui.Controller.SceneController;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ListAllBookingRequestUI implements Initializable {

    public Button doLogout;

    private Stage stage;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    @FXML
    private void doLogout(ActionEvent actionEvent) throws IOException {
        SceneController.loadMainMenuScene(actionEvent);

    }

    public void onListBookingRequests(ActionEvent actionEvent) throws IOException {
        SceneController.switchToSceneOnButtonClick(actionEvent,"/fxml/Utils.fxml/ListAllBookingRequestUI.fxml");
    }

    public void onViewBookingRequests(ActionEvent actionEvent) {
    }

    public void onRegisterVisit(ActionEvent actionEvent) {
    }
}
