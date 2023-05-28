package pt.ipp.isep.dei.esoft.project.application.controller;

import pt.ipp.isep.dei.esoft.project.domain.*;
import pt.ipp.isep.dei.esoft.project.repository.*;
import pt.isep.lei.esoft.auth.domain.model.Email;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public class PublishAnnouncementController {
    private AuthenticationRepository authenticationRepository;
    private RequestRepository requestRepository;

    private PropertyRepository propertyRepository;
    private AnnouncementRepository announcementRepository;

    public PublishAnnouncementController() {
        getAuthenticationRepository();
        getPropertyRepository();
        getRequestRepository();
        getAnnouncementRepository();
    }

    public PublishAnnouncementController(AuthenticationRepository authenticationRepository, PropertyRepository propertyRepository, RequestRepository requestRepository, AnnouncementRepository announcementRepository){
        this.authenticationRepository = authenticationRepository;
        this.propertyRepository = propertyRepository;
        this.requestRepository = requestRepository;
        this.announcementRepository = announcementRepository;
    }

    private AuthenticationRepository getAuthenticationRepository() {
        if (authenticationRepository == null) {
            Repositories repositories = Repositories.getInstance();
            authenticationRepository = repositories.getAuthenticationRepository();
        }
        return authenticationRepository;
    }

    private RequestRepository getRequestRepository(){
        if (requestRepository == null) {
            Repositories repositories = Repositories.getInstance();
            requestRepository = repositories.getRequestRepository();
        }
        return requestRepository;
    }

    private PropertyRepository getPropertyRepository(){
        if(propertyRepository == null) {
            Repositories repositories = Repositories.getInstance();
            propertyRepository = repositories.getPropertyRepository();
        }
        return propertyRepository;
    }

    private AnnouncementRepository getAnnouncementRepository(){
        if(announcementRepository == null){
            Repositories repositories = Repositories.getInstance();
            announcementRepository = repositories.getAnnouncementRepository();
        }
        return announcementRepository;
    }

    public Optional<Announcement> createAnnouncement(Location propertyLocation, Commission commission, Date date){
        Property property = getPropertyByLocation(propertyLocation);
        Request request = getRequestByProperty(property);


        Optional<Announcement> newAnnouncement = Optional.empty();
        if(getAnnouncementRepository() != null){
            newAnnouncement = getAnnouncementRepository().createAnnouncement(request, commission, date);
        }
        return newAnnouncement;
    }

    private Request getRequestByProperty(Property property){
        return getRequestRepository().getRequestByProperty(property);
    }

    private Property getPropertyByLocation(Location propertyLocation){
        return getPropertyRepository().getPropertyByLocation(propertyLocation);
    }

    private Employee getAgentFromSession() {
        Email email = getAuthenticationRepository().getCurrentUserSession().getUserId();
        return new Employee(email.getEmail());
    }

    public List<Request> getRequests(){
        return getRequestRepository().getRequests();
    }

}
