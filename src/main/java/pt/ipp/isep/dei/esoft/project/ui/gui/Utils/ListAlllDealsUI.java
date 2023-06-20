package pt.ipp.isep.dei.esoft.project.ui.gui.Utils;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.stage.Stage;
import pt.ipp.isep.dei.esoft.project.ui.gui.Controller.SceneController;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ListAlllDealsUI implements Initializable {
    @FXML
    public MenuItem doLogout;
    @FXML
    public MenuItem backToStoreManagerMenu;
    @FXML
    public Button SelectionSortButton;
    @FXML
    public Button BubbleSortButton;
    public Button SelectionSortMethodButton;
    public Button BubbleSortMethodButton;
    public Label label;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }




    @FXML
    public void doLogout(ActionEvent actionEvent) throws IOException {
        Stage stage = (Stage) ((MenuItem) actionEvent.getSource()).getParentPopup().getOwnerWindow();
        SceneController.switchToSceneOnMenuBarButtonClick(stage, "/fxml/MainMenuUI.fxml");
    }
    @FXML
    private void getBackToNetworkManagerMenu(ActionEvent actionEvent) throws IOException {
        Stage stage = (Stage) ((MenuItem) actionEvent.getSource()).getParentPopup().getOwnerWindow();
        SceneController.switchToSceneOnMenuBarButtonClick(stage, "/fxml/ActorsUI-fxml/NetworkManagerUI.fxml");

    }


    @FXML
    private void switchToBubbleSortUI(ActionEvent actionEvent) throws IOException {
        SceneController.switchToSceneOnButtonClick(actionEvent, "/fxml/Utils-fxml/SortingMethods.fxml/BubbleSort.fxml");
    }

    @FXML
    private void switchToSelectionSort(ActionEvent actionEvent) throws IOException {
        SceneController.switchToSceneOnButtonClick(actionEvent, "/fxml/Utils-fxml/SortingMethods.fxml/SelectionSort.fxml");
    }


    public void switchToSelectionSortUI(ActionEvent actionEvent) {
    }

    public void getBackToStoreManagerMenu(ActionEvent actionEvent) {
    }
}
