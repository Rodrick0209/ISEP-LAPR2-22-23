package pt.ipp.isep.dei.esoft.project.ui.gui.Utils.SortinMethods;

import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.stage.Stage;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import pt.ipp.isep.dei.esoft.project.application.controller.ImportInformationController;
import pt.ipp.isep.dei.esoft.project.application.controller.ListDealsController;
import pt.ipp.isep.dei.esoft.project.domain.Deal;
import pt.ipp.isep.dei.esoft.project.ui.gui.Actors.StoreManagerUI;
import pt.ipp.isep.dei.esoft.project.ui.gui.Controller.SceneController;

import java.io.IOException;
import java.net.URL;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;

public class BubbleSortUI implements Initializable {
    @FXML
    public MenuItem doLogout;
    @FXML
    public MenuItem backToStoreManagerMenu;
    @FXML
    public Button multipleRegressionButton;
    public Button simpleRegressionButton;
    @FXML
    public MenuItem backToAnalyeDeals;
    public Button SelectionSortButton;
    public Button BubbleSortButton;
    public Label subtitle;
    public Button ascendingOrderButton;
    public Button desceningOrderButton;
    public MenuItem backToChooseingSortingMethod;
    @FXML
    private ListView<Deal> sortAscendingList;
    @FXML
    private ListView<Deal> sortDescendingList;


    @FXML
    private Label label;


    private Stage stage;
    private XSSFWorkbook dealsFile = StoreManagerUI.getDealsFile();
    private ListDealsController listDealsController;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        listDealsController = new ListDealsController();

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

    public void sortDescending(ActionEvent actionEvent) throws IOException {
        List<Deal> deals = listDealsController.bubbleSortDescending();
        ObservableList<Deal> listData = FXCollections.observableList(deals);
        if (sortDescendingList != null) {
            sortDescendingList.setItems(listData);

        }

    }

    @FXML
    public void sortAscending(ActionEvent actionEvent) throws IOException {


        List<Deal> deals = listDealsController.bubbleSortAscending();
        ObservableList<Deal> listData = FXCollections.observableList(deals);
        if (sortAscendingList != null) {
            sortAscendingList.setItems(listData);

        }

    }

    @FXML
    public void getBackToChoosingSortingMethod(ActionEvent actionEvent) throws  IOException{
        Stage stage = (Stage) ((MenuItem) actionEvent.getSource()).getParentPopup().getOwnerWindow();
        SceneController.switchToSceneOnMenuBarButtonClick(stage, "/fxml/Utils-fxml/SortingMethods.fxml/ChooseTheSortingMethod.fxml");

    }
}




