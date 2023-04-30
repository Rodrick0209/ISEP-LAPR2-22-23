package pt.ipp.isep.dei.esoft.project.application.controller;

import pt.ipp.isep.dei.esoft.project.domain.*;
import pt.ipp.isep.dei.esoft.project.repository.AuthenticationRepository;
import pt.ipp.isep.dei.esoft.project.repository.OrganizationRepository;
import pt.ipp.isep.dei.esoft.project.repository.PropertyRepository;
import pt.ipp.isep.dei.esoft.project.repository.Repositories;
import pt.isep.lei.esoft.auth.domain.model.Email;

import java.util.List;
import java.util.Optional;

public class PublishAnnouncementController {
    private OrganizationRepository organizationRepository;
    private AuthenticationRepository authenticationRepository;
    private PropertyRepository propertyRepository;

    public PublishAnnouncementController() {

    }

    public PublishAnnouncementController(OrganizationRepository organizationRepository, AuthenticationRepository authenticationRepository, PropertyRepository propertyRepository){
        this.organizationRepository = organizationRepository;
        this.authenticationRepository = authenticationRepository;
        this.propertyRepository = propertyRepository;
    }

    private OrganizationRepository getOrganizationRepository(){
        if(organizationRepository == null){
            Repositories repositories = Repositories.getInstance();
            organizationRepository = repositories.getOrganizationRepository();
        }
        return organizationRepository;
    }

    private AuthenticationRepository getAuthenticationRepository() {
        if (authenticationRepository == null) {
            Repositories repositories = Repositories.getInstance();
            authenticationRepository = repositories.getAuthenticationRepository();
        }
        return authenticationRepository;
    }

    private PropertyRepository getPropertyRepository(){
        if (propertyRepository == null) {
            Repositories repositories = Repositories.getInstance();
            propertyRepository = repositories.getPropertyRepository();
        }
        return propertyRepository;
    }

    public Optional<Announcement> createAnnouncement(Location location, String description, int commission){
        Property property = getPropertyByLocation(location);

        Employee agent = getAgentFromSession();
        Optional<Organization> organization = getOrganizationRepository().getOrganizationByEmployee(agent);

        Optional<Announcement> newAnnouncement = Optional.empty();
        if(organization.isPresent()){
            newAnnouncement = organization.get().createAnnouncement(property, description, commission, agent);
        }
        return newAnnouncement;
    }

    private Property getPropertyByLocation(Location location) {
        return getPropertyRepository().getPropertyByLocation(location);
    }

    private Employee getAgentFromSession() {
        Email email = getAuthenticationRepository().getCurrentUserSession().getUserId();
        return new Employee(email.getEmail());
    }

    public List<Property> getProperties(){return getPropertyRepository().getProperties();}
}
