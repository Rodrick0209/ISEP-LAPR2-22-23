package pt.ipp.isep.dei.esoft.project.ui.gui.Utils;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.stage.Stage;
import pt.ipp.isep.dei.esoft.project.ui.gui.Controller.SceneController;

import java.io.IOException;
import java.net.URL;
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
        SceneController.switchToSceneOnMenuBarButtonClick(stage, "/fxml/ActorsUI-fxml/AgentUI.fxml");

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

