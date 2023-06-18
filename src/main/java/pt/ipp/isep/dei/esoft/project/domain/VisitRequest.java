package pt.ipp.isep.dei.esoft.project.domain;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;

public class VisitRequest implements Serializable {

    private final Announcement announcement;
    private final String userName;

    private final String phoneNumber;

    private Date visitDate;

    private final int [][] timeSlot;
    private final String message;
    private final Employee agent;

    public VisitRequest(Announcement announcement, String userName, String phoneNumber, Date visitDate, int[][] timeSlot, String message, Employee agent) {
        this.announcement = announcement;
        this.userName = userName;
        this.phoneNumber = phoneNumber;
        this.visitDate = visitDate;
        //SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        this.timeSlot = timeSlot;
        this.message = message;
        this.agent = agent ;
    }

    public int[][] getTimeSlot() {
    return timeSlot;
    }

    public Announcement getAnnouncement(){ return announcement; }

    @Override
    public String toString() {
        return "\nVisitRequest: " +
                "\nAnnouncement: " + announcement +
                "\nUserName: " + userName  +
                "\nPhoneNumber: " + phoneNumber +
                "\nVisit date: " + visitDate +
                "\nTimeSlot: " +timeSlot +
                "\nMessage: " + message +
                "\nAgent:  " + agent;

    }

    public Employee getAgent() {
        return agent;
    }



    public Date getDate() {
        return visitDate;
    }



}
