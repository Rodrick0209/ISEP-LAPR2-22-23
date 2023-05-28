package pt.ipp.isep.dei.esoft.project.application.controller;

import pt.ipp.isep.dei.esoft.project.domain.Agency;
import pt.ipp.isep.dei.esoft.project.domain.Employee;
import pt.ipp.isep.dei.esoft.project.repository.AgencyRepository;
import pt.ipp.isep.dei.esoft.project.repository.AuthenticationRepository;
import pt.ipp.isep.dei.esoft.project.repository.Repositories;
import pt.isep.lei.esoft.auth.domain.model.Email;

import java.util.Optional;

public class RegisterAgencyController {
    private AuthenticationRepository authenticationRepository;

    private AgencyRepository agencyRepository;

    public RegisterAgencyController() {
        getAuthenticationRepository();
        getAgencyRepository();
    }

    public RegisterAgencyController(AuthenticationRepository authenticationRepository, AgencyRepository agencyRepository){
        this.authenticationRepository = authenticationRepository;
        this.agencyRepository = agencyRepository;
    }

    private AuthenticationRepository getAuthenticationRepository() {
        if (authenticationRepository == null) {
            Repositories repositories = Repositories.getInstance();
            authenticationRepository = repositories.getAuthenticationRepository();
        }
        return authenticationRepository;
    }

    private AgencyRepository getAgencyRepository(){
        if (agencyRepository == null){
            Repositories repositories = Repositories.getInstance();
            agencyRepository = repositories.getAgencyRepository();
        }
        return agencyRepository;
    }

    public Optional<Agency> createAgency(int id, String designation, String location, String emailAddress, String phoneNumber){

        Employee administrator = getAdministratorFromSession();
        Optional<Agency> newAgency = Optional.empty();
        if(getAgencyRepository() != null){
            newAgency = getAgencyRepository().createAgency(id, designation, location, emailAddress, phoneNumber, administrator);
        }
        return newAgency;
    }

    private Employee getAdministratorFromSession() {
        Email email = getAuthenticationRepository().getCurrentUserSession().getUserId();
        return new Employee(email.getEmail());
    }
}
