package pt.ipp.isep.dei.esoft.project.domain;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * The type Announcement.
 */
public class Announcement {

    private static int announcmentIdCounter = 1;
    private int announcementId;
    private final Request request;
    private final Commission commission;
    private final Date date;

    public Announcement(Request request, Commission commission) {
        this.request = request;
        this.commission = commission;
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        try {
            this.date = sdf.parse(sdf.format(new Date()));
        } catch (ParseException e) {
            throw new IllegalArgumentException("Invalid date format");
        }

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

    @Override
    public String toString() {
        return "\nREQUEST: " + request +
                "\nCommission: " + commission +
                "\nDate: " + date ;
    }

    public Announcement(int announcementId, Request request, Commission commission) {
        this.request = request;
        this.commission = commission;
        this.date = new Date();
        this.announcementId = announcmentIdCounter++;
    }
}

