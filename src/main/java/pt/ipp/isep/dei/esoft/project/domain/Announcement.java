package pt.ipp.isep.dei.esoft.project.domain;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * The type Announcement.
 */
public class Announcement implements Serializable, Comparable<Announcement>{

    private static int announcmentIdCounter = 0;
    private int announcementId;
    private Request request;
    private Commission commission;
    private Date date;
    private List<Order> announcementOrdersAvailable = new ArrayList<>(); // initialize the empty list

    private List<Order> announcementOrdersAccepted = new ArrayList<>();

    /**
     * Instantiates a new Announcement.
     *
     * @param request    the request
     * @param commission the commission
     */
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

    /**
     * Instantiates a new Announcement.
     *
     * @param request    the request
     * @param commission the commission
     * @param date       the date
     */
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

    /**
     * Instantiates a new Announcement.
     */
    public Announcement() {
        this.announcementId = announcmentIdCounter++;
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

    /**
     * Decline order.
     *
     * @param order the order
     */
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


    /**
     * Gets announcement id.
     *
     * @return the announcement id
     */
    public int getAnnouncementId() {
        return announcementId;
    }

    /**
     * Gets request.
     *
     * @return the request
     */
    public Request getRequest() {
        return request;
    }

    /**
     * Gets commission.
     *
     * @return the commission
     */
    public Commission getCommission() {
        return commission;
    }

    /**
     * Gets date.
     *
     * @return the date
     */
    public Date getDate() {
        return date;
    }

    @Override
    public String toString() {
        return "\nId:" + announcementId +
                "\n" + request.getProperty().toString() +
                "\nType of Business:" + request.getTypeBusiness().toString() +
                "\nDate of announcement: " + date;
    }

    @Override
    public int compareTo(Announcement o) {
        return this.getDate().compareTo(o.getDate());
    }

}

