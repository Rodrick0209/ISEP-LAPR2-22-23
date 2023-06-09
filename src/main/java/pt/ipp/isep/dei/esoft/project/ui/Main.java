package pt.ipp.isep.dei.esoft.project.ui;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import pt.ipp.isep.dei.esoft.project.ui.console.menu.MainMenuUI;


public class Main extends Application  {

    public static void main(String[] args) {
        //launch(args);

        Bootstrap bootstrap = new Bootstrap();
        bootstrap.run();

        try {
            MainMenuUI menu = new MainMenuUI();
            menu.run();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


@FXML
    public void start(Stage stage) throws Exception {
        Parent parent = FXMLLoader.load(getClass().getResource("/fxml/test.fxml"));
        stage.setScene(new Scene(parent));
        stage.show();
    }

}










