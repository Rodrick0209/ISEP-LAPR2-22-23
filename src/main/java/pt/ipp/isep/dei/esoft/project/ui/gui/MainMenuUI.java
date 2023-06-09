package pt.ipp.isep.dei.esoft.project.ui.gui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import pt.ipp.isep.dei.esoft.project.application.controller.MainMenuController;

import java.awt.event.ActionEvent;
import java.io.IOException;

public class MainMenuUI extends Application {

    private final MainMenuController controller = new MainMenuController();

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("src/main/resources/main menu.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        primaryStage.setTitle("Real Estate USA App");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void onLogInButton(ActionEvent actionEvent) throws IOException{
        controller.onLogInButton(actionEvent);
    }
}
