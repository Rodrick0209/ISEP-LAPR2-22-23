package pt.ipp.isep.dei.esoft.project.ui.gui.Actors;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.stage.Stage;
import pt.ipp.isep.dei.esoft.project.ui.gui.Controller.SceneController;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class NetworkManagerUI implements Initializable {
    public MenuItem doLogout;
    public MenuItem ViewBookingRequests;
    public Button btnRegisterVisit;
    public Button btnListBookingRequests;
    public Button btnPublishAnnouncement;

    private Stage stage;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {


    }

    @FXML
    private void doLogout(ActionEvent actionEvent) throws IOException {
        Stage stage = (Stage) ((MenuItem) actionEvent.getSource()).getParentPopup().getOwnerWindow();
        SceneController.switchToSceneOnMenuBarButtonClick(stage, "/fxml/MainMenuUI.fxml");

    }

    @FXML
    public void onPublishinAnnoucement(ActionEvent actionEvent) throws IOException {
        SceneController.switchToSceneOnButtonClick(actionEvent, "/fxml/Utils.fxml/ListAllBookingRequestsUI.fxml");
    }

    @FXML
    public void onListBookingRequests(ActionEvent actionEvent) throws IOException {
        SceneController.switchToSceneOnButtonClick(actionEvent, "/fxml/Utils.fxml/ListAllBookingRequestsUI.fxml");
    }

    @FXML
    public void onViewBookingRequests(ActionEvent actionEvent) throws IOException {

        Stage stage = (Stage) ((MenuItem) actionEvent.getSource()).getParentPopup().getOwnerWindow();
        SceneController.switchToSceneOnMenuBarButtonClick(stage, "/fxml/Utils.fxml/ViewAllBookingRequestsUI.fxml");
    }



    @FXML
    public void onRegisterVisit(ActionEvent actionEvent) throws IOException {
        SceneController.switchToSceneOnButtonClick(actionEvent, "/fxml/Utils.fxml/RegisterVisitUI.fxml");
    }
}


