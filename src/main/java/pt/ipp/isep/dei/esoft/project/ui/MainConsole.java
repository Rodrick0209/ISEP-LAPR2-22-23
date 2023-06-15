package pt.ipp.isep.dei.esoft.project.ui;

import pt.ipp.isep.dei.esoft.project.domain.Database;
import pt.ipp.isep.dei.esoft.project.ui.console.menu.MainMenuUI;



public class MainConsole {
    public static void main(String[] args) {

        Database.saveData();
        Bootstrap bootstrap = new Bootstrap();
        bootstrap.run();
        Database.readData();

        try {
            MainMenuUI menu = new MainMenuUI();
            menu.run();
        } catch (Exception e) {
            e.printStackTrace();
        }
        Database.saveData();
    }



}










