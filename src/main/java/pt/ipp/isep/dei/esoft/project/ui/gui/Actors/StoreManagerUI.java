package pt.ipp.isep.dei.esoft.project.ui.gui.Actors;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.MenuItem;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import pt.ipp.isep.dei.esoft.project.ui.gui.Controller.SceneController;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class StoreManagerUI implements Initializable {
    public MenuItem doLogout;



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {


    }

    @FXML
    private void doLogout(ActionEvent actionEvent) throws IOException {
        Stage stage = (Stage) ((MenuItem) actionEvent.getSource()).getParentPopup().getOwnerWindow();
        SceneController.switchToSceneOnMenuBarButtonClick(stage, "/fxml/MainMenuUI.fxml");

    }


    @FXML
    public void onAnalyseDeals(ActionEvent actionEvent) throws IOException {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Select your CSV file");
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("CSV files", "*.csv"));

        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        File selectedFile = fileChooser.showOpenDialog(stage);

        if (selectedFile != null) {
            // Process the selected file
            System.out.println("Selected File: " + selectedFile.getAbsolutePath());

            // You can pass the selected file to the next scene or perform further operations with it
            // For example, you can pass the file path to the AnalyseAllDealsUI controller

            // Switch to the next scene
            SceneController.switchToSceneOnButtonClick(actionEvent, "/fxml/Utils.fxml/AnalyseAllDealsUI.fxml");
        }
    }


}










