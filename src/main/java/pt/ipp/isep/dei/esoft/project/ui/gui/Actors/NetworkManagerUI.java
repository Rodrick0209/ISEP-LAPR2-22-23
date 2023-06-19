package pt.ipp.isep.dei.esoft.project.ui.gui.Actors;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import pt.ipp.isep.dei.esoft.project.application.controller.ImportInformationController;
import pt.ipp.isep.dei.esoft.project.ui.gui.Controller.SceneController;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class NetworkManagerUI implements Initializable {
    public MenuItem doLogout;
    public MenuItem ViewBookingRequests;
    public Button btnRegisterVisit;
    public Button btnListBookingRequests;
    public Button btnPublishAnnouncement;
    private ImportInformationController importInformationController;
    public Button DivideStoresIntoTwoSubstetsButton;

    private static XSSFWorkbook dealsFile;

    private Stage stage;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        importInformationController = new ImportInformationController();
    }

    @FXML
    private void doLogout(ActionEvent actionEvent) throws IOException {
        Stage stage = (Stage) ((MenuItem) actionEvent.getSource()).getParentPopup().getOwnerWindow();
        SceneController.switchToSceneOnMenuBarButtonClick(stage, "/fxml/MainMenuUI.fxml");

    }


    @FXML
    public void onDivideTheStoresIntoTwoSubstets(ActionEvent actionEvent) throws IOException {
        SceneController.switchToSceneOnButtonClick(actionEvent, "/fxml/Utils-fxml/DivideAllStoreIntoTwoSubsets.fxml");
    }


    /**
     * On list all deals.
     *
     * @param actionEvent the action event
     * @throws IOException the io exception
     */
    public void onListAllDeals(ActionEvent actionEvent) throws IOException {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Select your CSV file");
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("CSV files", "*.csv"));

        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        File selectedFile = fileChooser.showOpenDialog(stage);

        if (selectedFile != null) {

            boolean operationSuccess = importInformationController.readFile(selectedFile);//reads and saves file data(deals)
            if (operationSuccess) {

                SceneController.switchToSceneOnButtonClick(actionEvent, "/fxml/Utils-fxml/ListAllDeals.fxml");

            } else {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Warning");
                alert.setHeaderText(null);
                alert.setContentText("Invalid File format.");
                alert.showAndWait();


            }
        }
    }





    }



