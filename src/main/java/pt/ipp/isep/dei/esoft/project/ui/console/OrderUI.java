package pt.ipp.isep.dei.esoft.project.ui.console;

import pt.ipp.isep.dei.esoft.project.application.controller.OrderController;
import pt.ipp.isep.dei.esoft.project.domain.Announcement;
import pt.ipp.isep.dei.esoft.project.ui.console.utils.Utils;

import java.util.List;

public class OrderUI implements Runnable {

    OrderController orderController = new OrderController();


    @Override
    public void run() {
        displayAnnouncementsAndSelectAnnouncementById();
    }

    private int displayAnnouncementsAndSelectAnnouncementById() {
        List<Announcement> announcements = orderController.getAnnouncementsList();
        int answer = Utils.showAndSelectIndex(announcements, "Select your announcement:\n");

        return announcements.get(answer).getAnnouncementId();

    }

    private void submitOrNot() {
        boolean answer = Utils.confirm("publish Announcement? (type yes or no)");
        if (answer) {

        }
    }
}
