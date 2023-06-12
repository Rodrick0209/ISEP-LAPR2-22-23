package pt.ipp.isep.dei.esoft.project.ui.console;

import pt.ipp.isep.dei.esoft.project.application.controller.ListPropertiesController;
import pt.ipp.isep.dei.esoft.project.domain.Announcement;
import pt.ipp.isep.dei.esoft.project.ui.console.utils.Utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ListPropertiesUI implements Runnable{
    private final ListPropertiesController controller = new ListPropertiesController();

    @Override
    public void run() {
        selectSortingElement();
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
        int answer = Utils.showAndSelectIndex(sortOptions, "Select your sorting option: ");
        if (answer == 1) {
            sortAnnouncementsByMostRecentDate();
        } else {
            if (answer == 2) sortAnnouncementByOldestDate();
        }
    }

    private void sortAnnouncementsByMostRecentDate(){
        List<Announcement> announcements = controller.getAnnouncements();
        List<Announcement> announcementsClone = new ArrayList<>(announcements);
        Collections.sort(announcementsClone);
        showAnnouncements();
    }

    private void sortAnnouncementByOldestDate(){
        List<Announcement> announcements = controller.getAnnouncements();
        List<Announcement> announcementsClone = new ArrayList<>(announcements);
        announcementsClone.sort(Collections.reverseOrder());
        showAnnouncements();
    }
}
