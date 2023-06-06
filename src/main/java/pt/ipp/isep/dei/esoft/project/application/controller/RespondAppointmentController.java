package pt.ipp.isep.dei.esoft.project.application.controller;
import javafx.fxml.FXML;
import javafx.scene.control.Label;



public class RespondAppointmentController {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to Real Estate USA");
    }
}
