package pt.ipp.isep.dei.esoft.project.application.controller;

import pt.ipp.isep.dei.esoft.project.domain.Announcement;
import pt.ipp.isep.dei.esoft.project.domain.PropertyType;
import pt.ipp.isep.dei.esoft.project.repository.AnnouncementRepository;
import pt.ipp.isep.dei.esoft.project.repository.Repositories;
import pt.ipp.isep.dei.esoft.project.domain.Property;
import pt.ipp.isep.dei.esoft.project.repository.PropertyRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;


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


        private PropertyRepository propertyRepository;



        public List<Property> listProperties(String propertyType, String propertyArea, String propertyLocation, String distance) {
            List<Property> properties = propertyRepository.getAllProperties();
            List<Property> filteredProperties = new ArrayList<>();

            for (Property property : properties) {
                boolean matchesType = propertyType.isEmpty() || property.getType().equals(PropertyType.valueOf(propertyType.toUpperCase()));
                boolean matchesArea = propertyArea.isEmpty() || String.valueOf(property.getArea()).equalsIgnoreCase(propertyArea);
                boolean matchesLocation = propertyLocation.isEmpty() || property.getLocation().equalsIgnoreCase(propertyLocation);
                boolean matchesDistance = distance.isEmpty() || String.valueOf(property.getDistance()).equalsIgnoreCase(distance);


                if (matchesType && matchesArea && matchesLocation && matchesDistance) {
                    filteredProperties.add(property);
                }
            }


            return filteredProperties;
        }
    }




