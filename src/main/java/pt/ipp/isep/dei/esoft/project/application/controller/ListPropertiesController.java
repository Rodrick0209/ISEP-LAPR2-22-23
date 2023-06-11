package pt.ipp.isep.dei.esoft.project.application.controller;

import pt.ipp.isep.dei.esoft.project.domain.Announcement;
import pt.ipp.isep.dei.esoft.project.repository.AnnouncementRepository;
import pt.ipp.isep.dei.esoft.project.repository.Repositories;

import java.util.Collections;
import java.util.List;

public class ListPropertiesController {
    private AnnouncementRepository announcementRepository;

    public ListPropertiesController(){
        getAnnouncementRepository();
    }

    public ListPropertiesController(AnnouncementRepository announcementRepository) {
        this.announcementRepository = announcementRepository;
    }

    private AnnouncementRepository getAnnouncementRepository(){
        if(announcementRepository == null){
            Repositories repositories = Repositories.getInstance();
            announcementRepository = repositories.getAnnouncementRepository();
        }
        return announcementRepository;
    }

    public List<Announcement> getAnnouncements() {
        return getAnnouncementRepository().getAnnouncements();
    }

    public List<Announcement> sortAnnouncementsByMostRecentDate(){
        Collections.sort(getAnnouncements());
        return getAnnouncements();
    }

    public List<Announcement> sortAnnouncementByOldestDate(){
        getAnnouncements().sort(Collections.reverseOrder());
        return getAnnouncements();
    }

}

