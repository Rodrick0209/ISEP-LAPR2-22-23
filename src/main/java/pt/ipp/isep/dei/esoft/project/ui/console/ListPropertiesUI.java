package pt.ipp.isep.dei.esoft.project.ui.console;

import pt.ipp.isep.dei.esoft.project.application.controller.ListPropertiesController;
import pt.ipp.isep.dei.esoft.project.domain.Announcement;
import pt.ipp.isep.dei.esoft.project.ui.console.utils.Utils;

import java.util.ArrayList;
import java.util.List;

public class ListPropertiesUI implements Runnable{
    private final ListPropertiesController controller = new ListPropertiesController();

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

}
