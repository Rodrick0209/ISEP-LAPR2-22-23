package pt.ipp.isep.dei.esoft.project.domain;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

public class VisitRequest implements Serializable {

    private Announcement announcement;
    private String userName;

    private String phoneNumber;

    private Date date;

    private int [][] timeSlot;
    private String message;

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
}
