package pt.ipp.isep.dei.esoft.project.ui.gui.Utils;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import pt.ipp.isep.dei.esoft.project.ui.gui.Controller.SceneController;
import pt.ipp.isep.dei.esoft.project.ui.gui.Domain.BookingRequest;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class ListAllBookingRequestUI implements Initializable {

    public ComboBox beginHourComboBox;
    public ComboBox endHourComboBox;
    public MenuItem doLogout;
    public MenuItem ViewBookingRequests;
    public MenuItem backToAgentMenu;
    @FXML
    private TableView<BookingRequest> tableView;
    @FXML
    private TableColumn<BookingRequest, LocalDateTime> beginDateColumn;
    @FXML
    private TableColumn<BookingRequest, LocalDateTime> endDateColumn;

    private List<BookingRequest> bookingRequests = new ArrayList<>();



    @FXML
    private Label label;
    @FXML
    private DatePicker beginDatePicker;
    @FXML
    private DatePicker endDatePicker;
    @FXML
    private Button submitButton;
    @FXML
    private Stage currentStage;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        beginDatePicker.setEditable(false);
        endDatePicker.setEditable(false);
    }


    @FXML
    private void onSubmitButton(ActionEvent actionEvent) {
        LocalDate beginDate = beginDatePicker.getValue();
        LocalDate endDate = endDatePicker.getValue();
        LocalTime beginTime = LocalTime.parse((String) beginHourComboBox.getValue());
        LocalTime endTime = LocalTime.parse((String) endHourComboBox.getValue());

        if (beginDate != null && endDate != null) {
            LocalDateTime beginDateTime = LocalDateTime.of(beginDate, beginTime);
            LocalDateTime endDateTime = LocalDateTime.of(endDate, endTime);

            if (endDateTime.isBefore(beginDateTime)) {
                showAlert(AlertType.ERROR, "Error", "Invalid Dates", "The end date  cannot be earlier than the begin date .");
                return;
            }

            if (beginDateTime.isBefore(LocalDateTime.now())) {
                showAlert(AlertType.ERROR, "Error", "Invalid Begin Date ", "Please select a valid begin date .");
                return;
            }

            // Create a new BookingRequest object in case of sucess
            BookingRequest newBookingRequest = new BookingRequest(beginDateTime, endDateTime);

            // Add the new booking request to the bookingRequests list sucess
            bookingRequests.add(newBookingRequest);

            // Display confirmation window
            showConfirmationWindow(beginDateTime, endDateTime);
        } else {
            // Display an error message if either begin date or end date is not selected
            showAlert(AlertType.ERROR, "Error", "Incomplete Selection", "Please select both begin date and end date.");
        }
    }




    private void showConfirmationWindow(LocalDateTime beginDate, LocalDateTime endDate) {
        Alert alert = new Alert(AlertType.CONFIRMATION);
        alert.setTitle("Booking Request Confirmation");
        alert.setHeaderText("Do you want to submit the Booking Request ?");
        alert.setContentText("Your Request has the following dates:\n\n"
                + "Begin Date: " + beginDate.toString() + "\n"
                + "End Date: " + endDate.toString());

        Stage stage = (Stage) alert.getDialogPane().getScene().getWindow();
        stage.setAlwaysOnTop(true);

        alert.showAndWait().ifPresent(response -> {
            if (response == ButtonType.OK) {

                showSuccessWindow();
            }
        });
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

    private void showSuccessWindow() {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Success");
        alert.setHeaderText("Booking Request Submitted");
        alert.setContentText("Your booking request has been successfully submitted.");

        Stage stage = (Stage) alert.getDialogPane().getScene().getWindow();
        stage.setAlwaysOnTop(true);

        alert.showAndWait();

    }

    private void showAlert(AlertType alertType, String title, String headerText, String contentText) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(headerText);
        alert.setContentText(contentText);

        Stage stage = (Stage) alert.getDialogPane().getScene().getWindow();
        stage.setAlwaysOnTop(true);

        alert.showAndWait();
    }
}
