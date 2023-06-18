package pt.ipp.isep.dei.esoft.project.ui.gui.Actors;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.MenuItem;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import pt.ipp.isep.dei.esoft.project.ui.gui.Controller.SceneController;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class StoreManagerUI implements Initializable {

    private static XSSFWorkbook dealsFile;
    public MenuItem doLogout;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    public static XSSFWorkbook getDealsFile() {
        return dealsFile;
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
            XSSFWorkbook fileToReturn = convertCSVToWorkbook(selectedFile);
            dealsFile = fileToReturn;
            SceneController.switchToSceneOnButtonClick(actionEvent, "/fxml/Utils.fxml/AnalyseAllDealsUI.fxml");



        }
    }

    private XSSFWorkbook convertCSVToWorkbook(File csvFile) throws IOException {
        XSSFWorkbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("Sheet1");

        try (BufferedReader reader = new BufferedReader(new FileReader(csvFile))) {
            String line;
            int rowNum = 0;

            while ((line = reader.readLine()) != null) {
                if (rowNum > 0) { // Ignore the first row
                    Row row = sheet.createRow(rowNum - 1);

                    String[] cells = line.split(";");

                    org.apache.poi.ss.usermodel.Cell cell8 = row.createCell(0);
                    cell8.setCellValue(Double.parseDouble(cells[7]));

                    org.apache.poi.ss.usermodel.Cell cell10 = row.createCell(1);
                    cell10.setCellValue(Double.parseDouble(cells[9]));

                    org.apache.poi.ss.usermodel.Cell cell11 = row.createCell(2);
                    cell11.setCellValue(Double.parseDouble(cells[10]));

                    org.apache.poi.ss.usermodel.Cell cell12 = row.createCell(3);
                    cell12.setCellValue(Double.parseDouble(cells[11]));

                    org.apache.poi.ss.usermodel.Cell cell13 = row.createCell(4);
                    cell13.setCellValue(Double.parseDouble(cells[12]));

                    org.apache.poi.ss.usermodel.Cell cell20 = row.createCell(5);
                    cell20.setCellValue(Double.parseDouble(cells[19]));
                }

                rowNum++;
            }
        }
        return workbook;
    }
}










