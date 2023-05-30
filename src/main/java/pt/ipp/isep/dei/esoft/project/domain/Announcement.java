package pt.ipp.isep.dei.esoft.project.domain;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

/**
 * The type Announcement.
 */
public class Announcement {
    private final Request request;
    private final Commission commission;
    private final Date date;

    public Announcement(Request request, Commission commission, Date date) {
        this.request = request;
        this.commission = commission;
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        String formattedDate = sdf.format(date);
        try {
            this.date = sdf.parse(formattedDate);
        } catch (ParseException e) {
            throw new IllegalArgumentException("Invalid date format");
        }
    }

    @Override
    public String toString() {
        return "Announcement{" +
                "request=" + request +
                ", commission=" + commission +
                ", date=" + date +
                '}';
    }
}