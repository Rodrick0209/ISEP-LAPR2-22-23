package pt.ipp.isep.dei.esoft.project.ui.gui.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import pt.ipp.isep.dei.esoft.project.repository.AuthenticationRepository;

import java.io.IOException;

public class SceneController {

    @FXML
    public static void loadMainMenuScene(ActionEvent actionEvent) throws IOException {
        AuthenticationRepository authenticationRepository = new AuthenticationRepository();
        authenticationRepository.getCurrentUserSession().doLogout();
        FXMLLoader fxmlLoader = new FXMLLoader(SceneController.class.getResource("/fxml/mainMenu.fxml"));
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        Parent root = fxmlLoader.load();
        Scene agentScene = new Scene(root);
        stage.setScene(agentScene);
        stage.show();
    }

    public static void switchToSceneOnButtonClick(ActionEvent actionEvent, String sceneName)throws IOException{
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(SceneController.class.getResource(sceneName));
        Parent root = fxmlLoader.load();
        Scene agentScene = new Scene(root);
        stage.setScene(agentScene);
        stage.show();
    }
    public static void switchToSceneOnMenuBarButtonClick(Stage sourceNode, String sceneName) throws IOException {
        Stage stage = (Stage) sourceNode.getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(SceneController.class.getResource(sceneName));
        try {
            Parent root = fxmlLoader.load();
            Scene agentScene = new Scene(root);
            stage.setScene(agentScene);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}


