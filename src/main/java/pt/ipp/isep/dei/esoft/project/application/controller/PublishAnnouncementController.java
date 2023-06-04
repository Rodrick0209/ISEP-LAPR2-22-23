package pt.ipp.isep.dei.esoft.project.application.controller;

import pt.ipp.isep.dei.esoft.project.domain.*;
import pt.ipp.isep.dei.esoft.project.repository.*;
import pt.isep.lei.esoft.auth.domain.model.Email;

import java.util.Date;
import java.util.List;
import java.util.Optional;

/**
 * The type Publish announcement controller.
 */
public class PublishAnnouncementController {
    private AuthenticationRepository authenticationRepository;
    private RequestRepository requestRepository;

    private PropertyRepository propertyRepository;
    private AnnouncementRepository announcementRepository;

    /**
     * Instantiates a new Publish announcement controller.
     */
    public PublishAnnouncementController() {
        getAuthenticationRepository();
        getPropertyRepository();
        getRequestRepository();
        getAnnouncementRepository();
    }

    /**
     * Instantiates a new Publish announcement controller.
     *
     * @param authenticationRepository the authentication repository
     * @param propertyRepository       the property repository
     * @param requestRepository        the request repository
     * @param announcementRepository   the announcement repository
     */
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

    /**
     * Create announcement optional.
     *
     * @param requestId  the request id
     * @param commission the commission
     * @return the optional
     */
    public Optional<Announcement> createAnnouncement(int requestId, Commission commission){

        Request request = getRequestById(requestId);


        Optional<Announcement> newAnnouncement = Optional.empty();
        if(getAnnouncementRepository() != null){
            newAnnouncement = getAnnouncementRepository().createAnnouncement(request, commission);
        }
        return newAnnouncement;
    }



    private Property getPropertyByLocation(Location propertyLocation){
        return getPropertyRepository().getPropertyByLocation(propertyLocation);
    }

    private Employee getAgentFromSession() {
        Email email = getAuthenticationRepository().getCurrentUserSession().getUserId();
        return new Employee(email.getEmail());
    }

    /**
     * Get requests list.
     *
     * @return the list
     */
    public List<Request> getRequests(){
        return getRequestRepository().getRequests();
    }

    /**
     * Get announcement list .
     *
     * @return the list
     */
    public List <Announcement> getAnnouncement(){
        return getAnnouncementRepository().getAnnouncements();
    }
    private Request getRequestById(int requestId){
        return getRequestRepository().getRequestById(requestId);
    }

}
