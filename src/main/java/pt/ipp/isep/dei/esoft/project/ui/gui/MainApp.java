package pt.ipp.isep.dei.esoft.project.ui.gui;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import pt.ipp.isep.dei.esoft.project.domain.Database;
import pt.ipp.isep.dei.esoft.project.ui.Bootstrap;
import pt.ipp.isep.dei.esoft.project.ui.console.menu.MainMenuUI;

import java.util.Scanner;

public class MainApp extends Application {
@FXML
    public static void main(String[] args) {

        Database.saveData();
        Bootstrap bootstrap = new Bootstrap();
        bootstrap.run();
        Database.readData();


        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            System.out.println("\nSelect how you want to run the application:");
            System.out.println("1 - Console");
            System.out.println("2 - JavaFX\n\n");
            System.out.println("0 - Cancel");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    runConsole();
                    break;
                case 2:
                    launch(args);
                    break;
                case 0:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        } while (choice != 0);

        Database.saveData();
    }

    private static void runConsole() {


        try {
            pt.ipp.isep.dei.esoft.project.ui.console.menu.MainMenuUI menu = new MainMenuUI();
            menu.run();
        } catch (Exception e) {
            e.printStackTrace();
        }
        Database.saveData();
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/MainMenuUI.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        primaryStage.setTitle("Real Estate USA App");
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();
    }
}
