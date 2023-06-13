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
    private final int announcementId;
    private Request request;
    private Commission commission;
    private Date date;


    /**
     * Instantiates a new Announcement.
     *
     * @param request    the request
     * @param commission the commission
     */
    public Announcement(Request request, Commission commission) {
        this.announcementId = announcmentIdCounter++;
        this.request = request;
        this.commission = commission;
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        try {
            this.date = sdf.parse(sdf.format(new Date()));
        } catch (ParseException e) {
            throw new IllegalArgumentException("Invalid date format");
        }

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
     * Instantiates a new Announcement.
     */
    public Announcement() {
        this.announcementId = announcmentIdCounter++;
    }




    /**
     * Decline order.
     *
     * @param order the order
     */


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
        return "\nId: " + announcementId +
                "\n" + request.getProperty().toString() +
                "Type of Business: " + request.getTypeBusiness().toString() +
                "\nPrice: " + request.getPrice() +
                "\nDate of announcement: " + date;
    }

    @Override
    public int compareTo(Announcement o) {
        return this.getDate().compareTo(o.getDate());
    }

    public Announcement clone(){
        return new Announcement(this.request, this.commission, this.date);
    }

}

