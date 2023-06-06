package pt.ipp.isep.dei.esoft.project.application.controller;

import pt.ipp.isep.dei.esoft.project.domain.Announcement;
import pt.ipp.isep.dei.esoft.project.domain.Order;
import pt.ipp.isep.dei.esoft.project.repository.AnnouncementRepository;
import pt.ipp.isep.dei.esoft.project.repository.AuthenticationRepository;
import pt.ipp.isep.dei.esoft.project.repository.Repositories;

import java.util.List;

/**
 * The type Order controller.
 */
public class OrderController {

    private AuthenticationRepository authenticationRepository = null;
    private AnnouncementRepository announcementRepository = null;

    private AuthenticationRepository getAuthenticationRepository() {
        if (authenticationRepository == null) {
            Repositories repositories = Repositories.getInstance();
            authenticationRepository = repositories.getAuthenticationRepository();
        }
        return authenticationRepository;
    }

    private AnnouncementRepository getAnnouncementRepository() {
        if (announcementRepository == null) {
            Repositories repositories = Repositories.getInstance();
            announcementRepository = repositories.getAnnouncementRepository();
        }
        return announcementRepository;
    }

    /**
     * Gets announcement by id.
     *
     * @param announcementId the announcement id
     * @return the announcement by id
     */
    public Announcement getAnnouncementById(int announcementId) {
        return getAnnouncementRepository().getAnnouncementById(announcementId);
    }

    /**
     * Accept order.
     *
     * @param announcementId the announcement id
     * @param acceptedOrder  the accepted order
     */
    public void acceptOrder(int announcementId, Order acceptedOrder) {
        Announcement announcement = getAnnouncementById(announcementId);
        announcement.acceptOrder(acceptedOrder);

    }

    /**
     * Decline order.
     *
     * @param announcementId the announcement id
     * @param declinedOrder  the declined order
     */
    public void declineOrder(int announcementId, Order declinedOrder) {
        Announcement announcement = getAnnouncementById(announcementId);
        announcement.declineOrder(declinedOrder);

    }

    /**
     * Gets announcements list.
     *
     * @return the announcements list
     */
    public List<Announcement> getAnnouncementsList() {
        return getAnnouncementRepository().getAnnouncements();
    }



}
