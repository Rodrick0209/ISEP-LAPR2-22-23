package pt.ipp.isep.dei.esoft.project.domain;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

public class VisitRequest implements Serializable {

    private final Announcement announcement;
    private final String userName;

    private final String phoneNumber;

    private Date date;

    private final int [][] timeSlot;
    private final String message;
    private Employee agent;

    public VisitRequest(Announcement announcement, String userName, String phoneNumber, Date date, int[][] timeSlot, String message) {
        this.announcement = announcement;
        this.userName = userName;
        this.phoneNumber = phoneNumber;
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        this.timeSlot = timeSlot;
        this.message = message;
    }


    public int[][] getTimeSlot() {
    return getTimeSlot();
    }

    public Announcement getAnnouncement(){ return announcement; }

    @Override
    public String toString() {
        return "VisitRequest: " +
                "\nAnnouncement: " + announcement +
                "\nUserName: " + userName  +
                "\nPhoneNumber: " + phoneNumber +
                "\nDate: " + date +
                "\nTimeSlot: " + timeSlot +
                "\nMessage: " + message;

    }

    public Employee getAgent() {
        return agent;
    }



    public Date getDate() {
        return date;
    }
}
