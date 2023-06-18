package pt.ipp.isep.dei.esoft.project.ui.console;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.stage.Stage;
import pt.ipp.isep.dei.esoft.project.application.controller.ListPropertiesController;
import pt.ipp.isep.dei.esoft.project.domain.Announcement;
import pt.ipp.isep.dei.esoft.project.ui.console.utils.Utils;
import pt.ipp.isep.dei.esoft.project.ui.gui.Controller.SceneController;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ListPropertiesUI implements Runnable{
    private final ListPropertiesController controller = new ListPropertiesController();
    public Button ListAllPropertiesButton;
    public MenuItem doLogout;

    @Override
    public void run() {
        selectSortingElement();
    }

    public ListPropertiesController getController() {
        return controller;
    }

    private void showAnnouncements(){
        List<Announcement> announcements = controller.getAnnouncements();
        Utils.showList(announcements, "Properties");
    }

    private void selectSortingElement() {
        showAnnouncements();
        List<String> sortOptions = new ArrayList<>();
        sortOptions.add("Most recent date - Oldest date");
        sortOptions.add("Oldest date - Most recent date");
        int answer = Utils.showAndSelectIndex(sortOptions, "Select your sorting option: \n");
        if (answer == 1) {
            getController().sortAnnouncementsByRecentDate();
            selectSortingElement();
        } else {
            if (answer == 2) {
                getController().sortAnnouncementsByOldestDate();
                selectSortingElement();
            }
        }
    }
    @FXML
    private void doLogout(ActionEvent actionEvent) throws IOException {
        Stage stage = (Stage) ((MenuItem) actionEvent.getSource()).getParentPopup().getOwnerWindow();
        SceneController.switchToSceneOnMenuBarButtonClick(stage, "/fxml/MainMenuUI.fxml");

    }
}
