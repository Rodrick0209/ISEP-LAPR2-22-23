package pt.ipp.isep.dei.esoft.project.ui.gui.Utils.AnalyseDeals;

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

public class MultipleRegressionUI implements Initializable {

    public MenuItem doLogout;
;
    public MenuItem backToStoreManagerMenu;
  
    public Button predictPriceButton;

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
    private void getBackToStoreManagerMenu(ActionEvent actionEvent) throws IOException {
        Stage stage = (Stage) ((MenuItem) actionEvent.getSource()).getParentPopup().getOwnerWindow();
        SceneController.switchToSceneOnMenuBarButtonClick(stage, "/fxml/ActorsUI.fxml/StoreManagerUI.fxml");

    }

    public void buttonPressed(ActionEvent actionEvent) {
    }

    public void onPredictPirceButton(ActionEvent actionEvent) {
    }
}
