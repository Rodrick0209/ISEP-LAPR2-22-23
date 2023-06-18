package pt.ipp.isep.dei.esoft.project.ui.gui.Utils;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.MenuItem;
import javafx.stage.Stage;
import pt.ipp.isep.dei.esoft.project.ui.gui.Controller.SceneController;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class DivideAllStoreIntoTwoSubsetsUI implements Initializable {


    public MenuItem backToAgentMenu;
    public MenuItem doLogout;
    public MenuItem sortInAscendingOrder;
    public MenuItem sortInDescendingOrder;
    public MenuItem backToNetworkManagerMenu;

    public void initialize(URL url, ResourceBundle resourceBundle) {
        // Configure the table columns


    }

    @FXML
    private void getBackToNetworkManagerMenu(ActionEvent actionEvent) throws IOException {
        Stage stage = (Stage) ((MenuItem) actionEvent.getSource()).getParentPopup().getOwnerWindow();
        SceneController.switchToSceneOnMenuBarButtonClick(stage, "/fxml/ActorsUI.fxml/NetworkManagerUI.fxml");

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

