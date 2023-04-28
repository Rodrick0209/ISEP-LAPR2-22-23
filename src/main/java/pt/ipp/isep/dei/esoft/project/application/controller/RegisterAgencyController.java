package pt.ipp.isep.dei.esoft.project.application.controller;

import pt.ipp.isep.dei.esoft.project.domain.Agency;
import pt.ipp.isep.dei.esoft.project.domain.Employee;
import pt.ipp.isep.dei.esoft.project.domain.Organization;
import pt.ipp.isep.dei.esoft.project.repository.AuthenticationRepository;
import pt.ipp.isep.dei.esoft.project.repository.OrganizationRepository;
import pt.ipp.isep.dei.esoft.project.repository.Repositories;
import pt.isep.lei.esoft.auth.domain.model.Email;

import java.util.Optional;

public class RegisterAgencyController {
    private OrganizationRepository organizationRepository;
    private AuthenticationRepository authenticationRepository;

    public RegisterAgencyController() {
        getOrganizationRepository();
        getAuthenticationRepository();
    }

    public RegisterAgencyController(OrganizationRepository organizationRepository, AuthenticationRepository authenticationRepository){
        this.organizationRepository = organizationRepository;
        this.authenticationRepository = authenticationRepository;
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

    public Optional<Agency> createAgency(int id, String designation, String location, String emailAddress, String phoneNumber){

        Employee administrator = getAdministratorFromSession();
        Optional<Organization> organization = getOrganizationRepository().getOrganizationByEmployee(administrator);
        Optional<Agency> newAgency = Optional.empty();
        if(organization.isPresent()){
            newAgency = organization.get().createAgency(id, designation, location, emailAddress, phoneNumber, administrator);
        }
        return newAgency;
    }

    private Employee getAdministratorFromSession() {
        Email email = getAuthenticationRepository().getCurrentUserSession().getUserId();
        return new Employee(email.getEmail());
    }
}
