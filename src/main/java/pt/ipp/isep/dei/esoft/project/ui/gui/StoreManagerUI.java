package pt.ipp.isep.dei.esoft.project.ui.gui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import pt.ipp.isep.dei.esoft.project.repository.AuthenticationRepository;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class StoreManagerUI implements Initializable {
    public Button doLogout;
    private Stage stage;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    @FXML
    private void doLogout(ActionEvent actionEvent) throws IOException {
        AuthenticationRepository authenticationRepository = new AuthenticationRepository();
        authenticationRepository.getCurrentUserSession().doLogout();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/mainMenu.fxml"));
        stage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        Parent root = fxmlLoader.load();
        Scene agentScene = new Scene(root);
        stage.setScene(agentScene);
        stage.show();
    }
}
