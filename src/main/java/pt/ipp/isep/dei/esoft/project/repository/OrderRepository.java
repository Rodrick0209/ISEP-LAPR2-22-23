package pt.ipp.isep.dei.esoft.project.repository;

import pt.ipp.isep.dei.esoft.project.domain.Client;
import pt.ipp.isep.dei.esoft.project.domain.Order;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class OrderRepository implements Serializable {
    private final List<Order> announcementOrdersAvailable = new ArrayList<>(); // initialize the empty list

    private final List<Order> announcementOrdersAccepted = new ArrayList<>();
    /**
     * Gets order by id.
     *
     * @param orderId the order id
     * @return the order by id
     */

    public Order getOrderById(int orderId) {
        Order orderToGet = null;
        for (Order order : this.announcementOrdersAvailable) {
            if (order.getOrderId() == orderId) {
                orderToGet = order;
            }
        }
        return orderToGet;
    }



    public void declineOrder(Order order) {
        announcementOrdersAvailable.remove(order);
    }

    /**
     * Gets announcement orders available.
     *
     * @return the announcement orders available
     */
    public List<Order> getAnnouncementOrdersAvailable() {
        return announcementOrdersAvailable;
    }

    /**
     * Gets announcement orders accepted.
     *
     * @return the announcement orders accepted
     */
    public List<Order> getAnnouncementOrdersAccepted() {
        return announcementOrdersAccepted;
    }

    /**
     * Add order.
     *
     * @param orderToAdd the order to add
     */
    public void addOrder(Order orderToAdd) {
        announcementOrdersAvailable.add(orderToAdd);
    }

    /**
     * Accept order.
     *
     * @param order the order
     */
    public void acceptOrder(Order order) {
        if (order != null) {
            announcementOrdersAvailable.remove(order);
            announcementOrdersAccepted.add(order);
            Client orderClient = order.getClient();
            if (orderClient != null) {
                orderClient.addEmail("Your offer was accepted.");
            }
            Iterator<Order> iterator = this.announcementOrdersAvailable.iterator();
            while (iterator.hasNext()) {
                Order orderI = iterator.next();
                iterator.remove();
                Client clientI = orderI.getClient();
                if (clientI != null) {
                    clientI.addEmail("The property you had an order on was sold.");
                }
            }
        }
    }



}
