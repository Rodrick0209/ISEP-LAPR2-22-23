package pt.ipp.isep.dei.esoft.project.ui.gui.Utils.AnalyseDeals;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.stage.Stage;
import org.apache.commons.math4.legacy.stat.regression.OLSMultipleLinearRegression;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import pt.ipp.isep.dei.esoft.project.domain.LinearRegression;
import pt.ipp.isep.dei.esoft.project.ui.gui.Actors.StoreManagerUI;
import pt.ipp.isep.dei.esoft.project.ui.gui.Controller.SceneController;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MultipleRegressionUI implements Initializable {

    private XSSFWorkbook dealsFile = StoreManagerUI.getDealsFile();

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

    @FXML
    private Label statistic1;
    @FXML
    private Label statistic2;
    @FXML
    private Label statistic3;
    @FXML
    private Label statistic4;
    @FXML
    private Label statistic5;

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
        SceneController.switchToSceneOnMenuBarButtonClick(stage, "/fxml/ActorsUI-fxml/StoreManagerUI.fxml");
    }

    @FXML
    public void handleViewMultipleRegression(ActionEvent actionEvent) {
        OLSMultipleLinearRegression multipleRegression = new OLSMultipleLinearRegression();
        double[] dependentVariable = LinearRegression.getDependentVariable(dealsFile);
        double[][] independentVariable = LinearRegression.getIndependentVariables(dealsFile);
        multipleRegression.newSampleData(dependentVariable, independentVariable);
        statistic1.setText("Error variance: " + multipleRegression.estimateErrorVariance());
        statistic2.setText("R² adjusted: " + multipleRegression.calculateAdjustedRSquared());
        statistic3.setText("R²: " + multipleRegression.calculateRSquared());
        statistic4.setText("Regressand variance: " + multipleRegression.estimateRegressandVariance());
    }

}
