package pt.ipp.isep.dei.esoft.project.domain;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;

/**
 * The type Visit request.
 */
public class VisitRequest implements Serializable {

    private final Announcement announcement;
    private final String userName;

    private final String phoneNumber;

    private Date visitDate;

    private final int [][] timeSlot;
    private final String message;
    private final Employee agent;

    /**
     * Instantiates a new Visit request.
     *
     * @param announcement the announcement
     * @param userName     the user name
     * @param phoneNumber  the phone number
     * @param visitDate    the visit date
     * @param timeSlot     the time slot
     * @param message      the message
     * @param agent        the agent
     */
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

    /**
     * Get time slot int [ ] [ ].
     *
     * @return the int [ ] [ ]
     */
    public int[][] getTimeSlot() {
    return timeSlot;
    }

    /**
     * Get announcement announcement.
     *
     * @return the announcement
     */
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

    /**
     * Gets agent.
     *
     * @return the agent
     */
    public Employee getAgent() {
        return agent;
    }


    /**
     * Gets date.
     *
     * @return the date
     */
    public Date getDate() {
        return visitDate;
    }



}
