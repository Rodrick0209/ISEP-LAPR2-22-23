package pt.ipp.isep.dei.esoft.project.ui.gui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.stage.Stage;
import pt.ipp.isep.dei.esoft.project.domain.Database;
import pt.ipp.isep.dei.esoft.project.ui.Bootstrap;
import pt.ipp.isep.dei.esoft.project.ui.console.MainConsole;

import javax.xml.crypto.Data;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MainGUI extends Application implements Initializable {

    public static void main(String[] args) {
        Database.saveData();
        Bootstrap bootstrap = new Bootstrap();
        bootstrap.run();
        Database.readData();
        launch(args);
        Database.saveData();
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MainConsole.class.getResource("/fxml/MainMenuUI.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        primaryStage.setTitle("Real Estate USA App");
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}


