package pt.ipp.isep.dei.esoft.project.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

public class Deal implements Serializable {
    private final Announcement announcement;
    private final Date dateOfSale;
    private final Agency agency;

    public Deal(Announcement announcement, Date dateOfSale, Agency agency) {
        this.announcement = announcement;
        this.dateOfSale = dateOfSale;
        this.agency = agency;
    }

    public Announcement getAnnouncement() {
        return announcement;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Deal deal = (Deal) o;
        return announcement.equals(deal.announcement);
    }

    public Agency getAgency() {
        return agency;
    }

    @Override
    public int hashCode() {
        return Objects.hash(announcement);
    }



    public Deal clone(){
        return new Deal(this.announcement, this.dateOfSale, this.agency);
}

    public String toString(){
        return "" + announcement.toString() +
               "\nDate of Sale: " + dateOfSale +
               "\nAgency assigned " + agency.toString();
    }
}
