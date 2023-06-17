package pt.ipp.isep.dei.esoft.project.ui.gui.Utils;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import jdk.dynalink.NoSuchDynamicMethodException;
import pt.ipp.isep.dei.esoft.project.ui.gui.Controller.SceneController;
import pt.ipp.isep.dei.esoft.project.ui.gui.Domain.BookingRequest;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDateTime;
import java.util.List;
import java.util.ResourceBundle;

public class ViewAllBookingRequestsUI implements Initializable {


    public MenuItem backToAgentMenu;
    public MenuItem doLogout;
    public MenuItem sortInAscendingOrder;
    public MenuItem sortInDescendingOrder;

    public void initialize(URL url, ResourceBundle resourceBundle) {
        // Configure the table columns


    }

    @FXML
    private void getBackToAgentMenu(ActionEvent actionEvent) throws IOException {
        Stage stage = (Stage) ((MenuItem) actionEvent.getSource()).getParentPopup().getOwnerWindow();
        SceneController.switchToSceneOnMenuBarButtonClick(stage, "/fxml/ActorsUI.fxml/AgentUI.fxml");

    }

    @FXML
    private void doLogout(ActionEvent actionEvent) throws IOException {
        Stage stage = (Stage) ((MenuItem) actionEvent.getSource()).getParentPopup().getOwnerWindow();
        SceneController.switchToSceneOnMenuBarButtonClick(stage, "/fxml/MainMenuUI.fxml");

    }

    public void sortInAscendingOrder(ActionEvent actionEvent) {
    }

    public void sortInAscendingOrdert(ActionEvent actionEvent) {
    }
}

