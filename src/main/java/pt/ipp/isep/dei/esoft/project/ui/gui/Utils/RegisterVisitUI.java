package pt.ipp.isep.dei.esoft.project.ui.gui.Utils;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.stage.Stage;
import pt.ipp.isep.dei.esoft.project.ui.gui.Controller.SceneController;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ResourceBundle;

/**
 * The type Register visit ui.
 */
public class RegisterVisitUI implements Initializable {


    /**
     * The Back to agent menu.
     */
    public MenuItem backToAgentMenu;
    /**
     * The Opinion text area.
     */
    public TextArea opinionTextArea;
    /**
     * The Classification combo box.
     */
    public ComboBox <String>classificationComboBox;
    /**
     * The Visit duration.
     */
    public ComboBox <String>visitDuration;
    /**
     * The Visit date.
     */
    public DatePicker visitDate;
    /**
     * The Visit time.
     */
    public ComboBox  <String>visitTime;
    /**
     * The Do logout.
     */
    public MenuItem doLogout;



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        visitDate.setEditable(false);


    }


    @FXML
    private void getBackToAgentMenu(ActionEvent actionEvent) throws IOException {
        Stage stage = (Stage) ((MenuItem) actionEvent.getSource()).getParentPopup().getOwnerWindow();
        SceneController.switchToSceneOnMenuBarButtonClick(stage, "/fxml/ActorsUI-fxml/AgentUI.fxml");

    }
    @FXML
    private void doLogout(ActionEvent actionEvent) throws IOException {
        Stage stage = (Stage) ((MenuItem) actionEvent.getSource()).getParentPopup().getOwnerWindow();
        SceneController.switchToSceneOnMenuBarButtonClick(stage, "/fxml/MainMenuUI.fxml");
    }

    /**
     * Onregister visit.
     *
     * @param actionEvent the action event
     */
    @FXML
    public void onregisterVisit(ActionEvent actionEvent) throws  IOException{
        try {
            LocalDate selectedDate = visitDate.getValue();
            LocalTime selectedTime = visitTime.getValue() != null ? LocalTime.parse(visitTime.getValue().toString()) : null;
            if (selectedTime == null) {
                showAlert(Alert.AlertType.ERROR, "Error", "Invalid Time", "Please select a visit time.");
                return; // exit the method early
            }
            LocalDateTime selectedDateTime = LocalDateTime.of(selectedDate, selectedTime);
            // rest of your code...
            LocalDate currentDate = LocalDate.now();
            String opinion = opinionTextArea.getText();
            String selectedDuration = visitDuration.getValue().toString();

            if (selectedDuration.isEmpty() || opinion.isEmpty()) {
                showAlert(Alert.AlertType.ERROR, "Error", "Incomplete Form", "Please fill in all the required fields.");
            } else if (selectedDate.isAfter(currentDate)) {
                showAlert(Alert.AlertType.ERROR, "Error", "Invalid Date", "Please select a past or current date.");
            } else {
                int letterCount = countLetters(opinion);
                if (letterCount < 200) {
                    showAlert(Alert.AlertType.ERROR, "Error", "Invalid Opinion", "The opinion must have at least 200 letters.");
                } else {
                    // Proceed with registering the visit
                    // ...
                    showConfirmationWindow(actionEvent);
                }
            }
        } catch (NullPointerException e) {
            // Handle the NullPointerException here
            // For example, display an error message or log the exception
            e.printStackTrace();
        }
    }




    private int countLetters(String text) {
            int count = 0;
            for (char c : text.toCharArray()) {
                if (Character.isLetter(c)) {
                    count++;
                }
            }
            return count;
        }





        private void showConfirmationWindow(ActionEvent actionEvent)throws IOException {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Visit Submission Confirmation");
            alert.setHeaderText("Do you want to submit the visit opinion?");
            alert.setContentText("Your Request has the following dates:\n\n");

            Stage stage = (Stage) alert.getDialogPane().getScene().getWindow();
            stage.setAlwaysOnTop(true);

            alert.showAndWait().ifPresent(response -> {
                if (response == ButtonType.OK) {

                    showSuccessWindow();
                    try {
                        SceneController.switchToSceneOnButtonClick(actionEvent, "/fxml/ActorsUI-fxml/AgentUI.fxml");
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                    ;
                }
            });
        }



        private void showSuccessWindow() {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Success");
            alert.setHeaderText("Visit opinion Submitted");
            alert.setContentText("Your opinion about the business has been successfully submitted.");

            Stage stage = (Stage) alert.getDialogPane().getScene().getWindow();
            stage.setAlwaysOnTop(true);

            alert.showAndWait();


        }

        private void showAlert(Alert.AlertType alertType, String title, String headerText, String contentText) {
            Alert alert = new Alert(alertType);
            alert.setTitle(title);
            alert.setHeaderText(headerText);
            alert.setContentText(contentText);

            Stage stage = (Stage) alert.getDialogPane().getScene().getWindow();
            stage.setAlwaysOnTop(true);

            alert.showAndWait();
        }
    }




