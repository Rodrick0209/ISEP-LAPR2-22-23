package pt.ipp.isep.dei.esoft.project.repository;

import pt.ipp.isep.dei.esoft.project.domain.Announcement;
import pt.ipp.isep.dei.esoft.project.domain.Commission;
import pt.ipp.isep.dei.esoft.project.domain.Request;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

/**
 * The type Annoucements request repository.
 */
public class AnnouncementRepository implements Serializable {

    private final List<Announcement> announcements = new ArrayList<>();

    public Announcement getAnnouncementById(int announcementId) {
        Announcement announcementReturn = null;
        for (Announcement announcement: announcements) {
            if (announcement.getAnnouncementId() == announcementId) {
                announcementReturn = announcement;
            }
        }
        return announcementReturn;
    }

    public Optional<Announcement> createAnnouncement(Request request, Commission commission){
        Optional<Announcement> optionalValue = Optional.empty();
        Announcement announcement = new Announcement(request, commission);

        if(addAnnouncement(announcement)){
            optionalValue = Optional.of(announcement);
        }
        return optionalValue;
    }

    public Optional<Announcement> createAnnouncementWithInputDate(Request request, Commission commission, Date date){
        Optional<Announcement> optionalValue = Optional.empty();

        Announcement announcement = new Announcement(request, commission);

        if(addAnnouncement(announcement)){
            optionalValue = Optional.of(announcement);
        }
        return optionalValue;
    }

    public boolean addAnnouncement(Announcement announcement){
        boolean operationSuccess = false;
        if(validateAnnouncement(announcement)){
            operationSuccess = announcements.add(announcement);
        }
        return operationSuccess;
    }

    private boolean validateAnnouncement(Announcement announcement){ return !announcements.contains(announcement);}

    public List<Announcement> getAnnouncements() {
        return announcements;
    }
}
