package pt.ipp.isep.dei.esoft.project.application.controller;

import pt.ipp.isep.dei.esoft.project.domain.Announcement;
import pt.ipp.isep.dei.esoft.project.repository.AnnouncementRepository;
import pt.ipp.isep.dei.esoft.project.repository.Repositories;

import java.util.ArrayList;
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

    public List<Announcement> sortAnnouncementsByRecentDate(){
        List<Announcement> announcements = getAnnouncements();
        List<Announcement> announcementsClone = new ArrayList<>(announcements);
        Collections.sort(announcementsClone);
        return announcementsClone;
    }

    public List<Announcement> sortAnnouncementsByOldestDate(){
        List<Announcement> announcements = getAnnouncements();
        List<Announcement> announcementsClone = new ArrayList<>(announcements);
        announcementsClone.sort(Collections.reverseOrder());
        return announcementsClone;
    }

}

