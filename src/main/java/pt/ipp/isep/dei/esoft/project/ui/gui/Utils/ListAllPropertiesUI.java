package pt.ipp.isep.dei.esoft.project.ui.gui.Utils;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import pt.ipp.isep.dei.esoft.project.application.controller.ListPropertiesController;
import pt.ipp.isep.dei.esoft.project.domain.Property;
import pt.ipp.isep.dei.esoft.project.ui.gui.Controller.SceneController;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class ListAllPropertiesUI implements Initializable {
    @FXML
    public Button ListAllPropertiesButton;
    @FXML
    public MenuItem doLogout;
    @FXML
    private ListView<Property> propertiesListView;
    @FXML
    private TextField propertyTypeTextField;
    @FXML
    private TextField propertyAreaTextField;
    @FXML
    private TextField propertyLocationTextField;
    @FXML
    private TextField distanceTextField;


    private ListPropertiesController listPropertiesController;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        listPropertiesController = new ListPropertiesController();


    }

    @FXML
    private void listProperties(ActionEvent actionEvent) {
        String propertyType = propertyTypeTextField.getText();
        String propertyArea = propertyAreaTextField.getText();
        String propertyLocation = propertyLocationTextField.getText();
        String distance = distanceTextField.getText();

        List<Property> filteredProperties = listPropertiesController.listProperties(propertyType, propertyArea, propertyLocation, distance);
        ObservableList<Property> observableList = FXCollections.observableArrayList(filteredProperties);
        propertiesListView.setItems(observableList);
    }
    @FXML
    private void doLogout(ActionEvent actionEvent) throws IOException {
        Stage stage = (Stage) ((MenuItem) actionEvent.getSource()).getParentPopup().getOwnerWindow();
        SceneController.switchToSceneOnMenuBarButtonClick(stage, "/fxml/MainMenuUI.fxml");

    }


}
