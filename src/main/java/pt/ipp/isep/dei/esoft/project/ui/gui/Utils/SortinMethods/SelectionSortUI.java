package pt.ipp.isep.dei.esoft.project.ui.gui.Utils.SortinMethods;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.stage.Stage;
import pt.ipp.isep.dei.esoft.project.ui.gui.Controller.SceneController;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class SelectionSortUI implements Initializable {
    @FXML
    public MenuItem doLogout;
    @FXML
    public MenuItem backToStoreManagerMenu;
    @FXML
    public Button multipleRegressionButton;
    public Button simpleRegressionButton;
    public MenuItem backToAnalyeDeals;
    public Button SelectionSortButton;
    public Button BubbleSortButton;

    @FXML
    private Label label;
    @FXML
    private DatePicker beginDatePicker;
    @FXML
    private DatePicker endDatePicker;
    @FXML
    private Button submitButton;

    private Stage stage;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }




    @FXML
    public void doLogout(ActionEvent actionEvent) throws IOException {
        SceneController.loadMainMenuScene(actionEvent);
    }
    @FXML
    private void getBackToNetworkManagerMenu(ActionEvent actionEvent) throws IOException {
        Stage stage = (Stage) ((MenuItem) actionEvent.getSource()).getParentPopup().getOwnerWindow();
        SceneController.switchToSceneOnMenuBarButtonClick(stage, "/fxml/ActorsUI.fxml/StoreManagerUI.fxml");

    }


    @FXML
    private void switchToBubbleSortUI(ActionEvent actionEvent) throws IOException {
        SceneController.switchToSceneOnButtonClick(actionEvent, "/fxml/Utils.fxml/SimpleRegressionUI.fxml");
    }

    @FXML
    private void switchToSelectionSort(ActionEvent actionEvent) throws IOException {
        SceneController.switchToSceneOnButtonClick(actionEvent, "/fxml/Utils.fxml/AnalyseDeals/MultipleRegressionUI.fxml");
    }



}
