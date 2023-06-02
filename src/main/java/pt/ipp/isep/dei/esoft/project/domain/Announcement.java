package pt.ipp.isep.dei.esoft.project.domain;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

/**
 * The type Announcement.
 */
public class Announcement {

    private static int announcmentIdCounter = 0;
    private int announcementId;
    private Request request;
    private Commission commission;
    private Date date;
    private List<Order> announcementOrdersAvailable = new ArrayList<>(); // initialize the empty list

    private List<Order> announcementOrdersAccepted = new ArrayList<>();

    public Announcement(Request request, Commission commission) {
        this.request = request;
        this.commission = commission;
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        try {
            this.date = sdf.parse(sdf.format(new Date()));
        } catch (ParseException e) {
            throw new IllegalArgumentException("Invalid date format");
        }
        this.announcementId = announcmentIdCounter++;

    }

    public Announcement(Request request, Commission commission, Date date) {
        this.announcementId = announcmentIdCounter++;
        this.request = request;
        this.commission = commission;
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        try {
            this.date = sdf.parse(sdf.format(date));
        } catch (ParseException e) {
            throw new IllegalArgumentException("Invalid date format");
        }
    }

    public Order getOrderById(int orderId) {
        Order orderToGet = null;
        for (Order order: this.announcementOrdersAvailable) {
            if (order.getOrderId() == orderId) {
                orderToGet = order;
            }
        }
        return orderToGet;
    }

    public Announcement() {
        this.announcementId = announcmentIdCounter++;
    }



    public List<Order> getAnnouncementOrdersAvailable() {
        return announcementOrdersAvailable;
    }

    public List<Order> getAnnouncementOrdersAccepted() {
        return announcementOrdersAccepted;
    }

    public void addOrder(Order orderToAdd) {
        announcementOrdersAvailable.add(orderToAdd);
    }

    public void acceptOrder(Order order) {
        announcementOrdersAvailable.remove(order);
        announcementOrdersAccepted.add(order);
        Client orderClient = order.getClient();
        orderClient.addEmail("Your offer was accepted.");
        Iterator<Order> iterator = this.announcementOrdersAvailable.iterator();
        while (iterator.hasNext()) {
            Order orderI = iterator.next();
            iterator.remove();
            orderI.getClient().addEmail("The property you had an order on was sold.");
        }
    }

    public void declineOrder(Order order) {
        announcementOrdersAvailable.remove(order);
    }

    /*public Order getOrderByEmail(String clientEmail) {
        Order orderToGet = null;
        List<Order> orders = this.announcementOrdersAvailable;
        for (Order order: orders) {
            if (order.getClientEmail().equals(clientEmail)) {
                orderToGet = order;
            }
        }
        return orderToGet;
    }*/


    public int getAnnouncementId() {
        return announcementId;
    }

    public Request getRequest() {
        return request;
    }

    public Commission getCommission() {
        return commission;
    }

    public Date getDate() {
        return date;
    }

    @Override
    public String toString() {
        return "Announcement{" +
                "announcementId=" + announcementId +
                ", request=" + request +
                ", commission=" + commission +
                ", date=" + date +
                '}';
    }
}

