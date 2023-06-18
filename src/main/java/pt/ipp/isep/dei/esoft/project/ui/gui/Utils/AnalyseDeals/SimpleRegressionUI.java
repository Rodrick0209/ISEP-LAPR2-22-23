package pt.ipp.isep.dei.esoft.project.ui.gui.Utils.AnalyseDeals;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.ScatterChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.*;
import javafx.stage.Stage;
import org.apache.commons.math3.stat.regression.SimpleRegression;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import pt.ipp.isep.dei.esoft.project.domain.LinearRegression;
import pt.ipp.isep.dei.esoft.project.ui.gui.Actors.StoreManagerUI;
import pt.ipp.isep.dei.esoft.project.ui.gui.Controller.SceneController;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class SimpleRegressionUI implements Initializable {

    private XSSFWorkbook dealsFile = StoreManagerUI.getDealsFile();

    public RadioMenuItem areaItem;
    public RadioMenuItem bathroomsItem;
    public RadioMenuItem bedroomsItem;
    public RadioMenuItem parkingItem;
    public RadioMenuItem distanceItem;
    private SimpleRegression simpleRegression = new SimpleRegression();
    @FXML
    private ScatterChart<Double, Double> scatterChart;

    public MenuItem doLogout;
;
    public MenuItem backToStoreManagerMenu;
  
    public Button predictPriceButton;
    public MenuItem backToChoosingRegression;

    @FXML
    private Label label;

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

    @FXML
    private TextField inputTextField;




    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
    }

    private void fillScatterChartSimpleRegression(double[][] regressionData) {
        scatterChart.getData().clear();
        XYChart.Series<Double, Double> series = new XYChart.Series<>();
        for (int i = 0; i < regressionData.length; i++) {
            double xValue = regressionData[i][0];
            double yValue = regressionData[i][1];
            series.getData().add(new XYChart.Data<>(xValue, yValue));
        }
        scatterChart.getData().add(series);
    }

    @FXML
    void handleSimpleRegressionMenuItem(ActionEvent event) throws IOException {
        areaItem.setSelected(false);
        distanceItem.setSelected(false);
        bedroomsItem.setSelected(false);
        bathroomsItem.setSelected(false);
        parkingItem.setSelected(false);

        RadioMenuItem selectedOption = (RadioMenuItem) event.getSource();
        selectedOption.setSelected(true);

        if (selectedOption.equals(areaItem)) {
            handleSpecificSimpleRegressionItem("Predict price based on area: ", 0);
        } else if (selectedOption.equals(distanceItem)) {
            handleSpecificSimpleRegressionItem("Predict price based on distance center: ", 1);
        } else if (selectedOption.equals(bedroomsItem)) {
            handleSpecificSimpleRegressionItem("Predict price based on number of bedrooms: ", 2);
        } else if (selectedOption.equals(bathroomsItem)) {
            handleSpecificSimpleRegressionItem("Predict price based on number of bathrooms: ", 3);
        } else if (selectedOption.equals(parkingItem)) {
            handleSpecificSimpleRegressionItem("Predict price based on number of parking spaces: ", 4);
        }
    }

    private void handleSpecificSimpleRegressionItem(String label1Text, int columnIndex) throws IOException {
        double[][] regressionData = LinearRegression.getDataSimpleRegression(dealsFile, columnIndex);
        simpleRegression.addData(regressionData);
        fillScatterChartSimpleRegression(regressionData);
        setStatisticsForSimpleRegression();
        predictPriceButton.setOnAction(actionEvent -> {
            double inputedValue = Double.parseDouble(inputTextField.getText());
            double predictedValue = simpleRegression.predict(inputedValue);
            label.setText(String.valueOf("Predicted price: " + predictedValue));
        });
    }

    private void setStatisticsForSimpleRegression() {
        statistic1.setText("R²: " + simpleRegression.getRSquare());
        statistic2.setText("Slope: " + simpleRegression.getSlope());
        statistic3.setText("Significance: " + simpleRegression.getSignificance());
        statistic4.setText("Confidence interval slope: " + simpleRegression.getSlopeConfidenceInterval());
        statistic5.setText("Intercept: " + simpleRegression.getIntercept());
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


    public void getBackToAlyseDealsMenu(ActionEvent actionEvent) throws IOException{
        Stage stage = (Stage) ((MenuItem) actionEvent.getSource()).getParentPopup().getOwnerWindow();
        SceneController.switchToSceneOnMenuBarButtonClick(stage, "/fxml/Utils-fxml/AnalyseAllDealsUI.fxml");
    }

    public void predictPrice(ActionEvent actionEvent) {
        String textField = inputTextField.getText();
        Double numericValue = Double.parseDouble(textField);
        label.setText(String.valueOf(simpleRegression.predict(numericValue)));
    }
}
