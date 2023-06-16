package pt.ipp.isep.dei.esoft.project.ui.gui.Controller;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class testController {

    @FXML
    private Button button;

    @FXML
    private Label label;

    @FXML
    void buttonPressed(ActionEvent event) {
        this.label.setText("hey");
    }

}

