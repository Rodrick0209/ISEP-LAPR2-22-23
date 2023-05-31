package pt.ipp.isep.dei.esoft.project.domain;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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

    private List<Order> announcementOrders = new ArrayList<>(); // initialize the empty list

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

    public Announcement() {
        this.announcementId = announcmentIdCounter++;
    }

    public Announcement(Request request, Commission commission, Date date) {
        this.request = request;
        this.commission = commission;
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        try {
            this.date = sdf.parse(sdf.format(date));
        } catch (ParseException e) {
            throw new IllegalArgumentException("Invalid date format");
        }
    }

    public void addOrder(Order orderToAdd) {
        announcementOrders.add(orderToAdd);
    }


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

