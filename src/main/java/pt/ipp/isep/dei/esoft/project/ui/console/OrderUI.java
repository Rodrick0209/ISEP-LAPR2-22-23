package pt.ipp.isep.dei.esoft.project.ui.console;

import pt.ipp.isep.dei.esoft.project.application.controller.OrderController;
import pt.ipp.isep.dei.esoft.project.domain.Announcement;
import pt.ipp.isep.dei.esoft.project.domain.Order;
import pt.ipp.isep.dei.esoft.project.ui.console.utils.Utils;

import java.util.Comparator;
import java.util.List;

/**
 * The type Order ui.
 */
public class OrderUI implements Runnable {

    /**
     * The Order controller.
     */
    OrderController orderController = new OrderController();


    @Override
    public void run() {
        int announementId = displayAnnouncementsAndSelectAnnouncementById();
        Order orderSelected = displayAndSelectOrderFromSpecificAnnouncement(announementId);
        acceptOrder(announementId, orderSelected);
        System.out.println("Order was accepted with success!");
    }

    /**
     * Sort by oldest date.
     *
     * @param list the list
     */
    public static void sortByOldestDate(List<Announcement> list) {
        list.sort(Comparator.comparing(Announcement::getDate));
    }

    /**
     * Sort by highest price.
     *
     * @param list the list
     */
    public static void sortByHighestPrice(List<Order> list) {
        list.sort(Comparator.comparing(Order::getOrderValue).reversed());
    }

    private int displayAnnouncementsAndSelectAnnouncementById() {
        List<Announcement> announcements = orderController.getAnnouncementsList();
        sortByOldestDate(announcements);
        int answer = Utils.showAndSelectIndex(announcements, "Select your announcement:\n");
        return announcements.get(answer).getAnnouncementId();
    }

    private Order displayAndSelectOrderFromSpecificAnnouncement(int announcementId) {
        Announcement announcement = orderController.getAnnouncementById(announcementId);
        List<Order> orders = announcement.getAnnouncementOrdersAvailable();
        sortByHighestPrice(orders);
        int answer = Utils.showAndSelectIndex(orders, "Select the order: ");
        return announcement.getOrderById(answer);
    }



    private void acceptOrder(int announcementId, Order acceptedOrder) {
        boolean answer = Utils.confirm("Accept order (type yes or no)");
        if (answer) {
            orderController.acceptOrder(announcementId, acceptedOrder);
        } else {
            orderController.declineOrder(announcementId, acceptedOrder);
        }
    }
}
