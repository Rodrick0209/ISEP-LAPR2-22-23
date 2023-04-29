package pt.ipp.isep.dei.esoft.project.application.controller;

import pt.ipp.isep.dei.esoft.project.domain.*;
import pt.ipp.isep.dei.esoft.project.repository.*;
import pt.isep.lei.esoft.auth.domain.model.Email;


import java.util.List;
import java.util.Optional;

public class RegisterEmployeeController {
    private OrganizationRepository organizationRepository;
    private RoleRepository roleRepository;
    private AgencyRepository agencyRepository;
    private AuthenticationRepository authenticationRepository;

    public RegisterEmployeeController(){
        getOrganizationRepository();
        getAgencyRepository();
        getRoleRepository();
        getAuthenticationRepository();
    }

    public RegisterEmployeeController(OrganizationRepository organizationRepository, RoleRepository roleRepository, AgencyRepository agencyRepository, AuthenticationRepository authenticationRepository){
        this.organizationRepository = organizationRepository;
        this.agencyRepository = agencyRepository;
        this.roleRepository = roleRepository;
        this.authenticationRepository = authenticationRepository;
    }

    private OrganizationRepository getOrganizationRepository(){
        if(organizationRepository == null){
            Repositories repositories = Repositories.getInstance();
            organizationRepository = repositories.getOrganizationRepository();
        }
        return organizationRepository;
    }
    private AgencyRepository getAgencyRepository() {
        if(agencyRepository == null){
            Repositories repositories = Repositories.getInstance();
            agencyRepository = repositories.getAgencyRepository();
        }
        return agencyRepository;
    }

    private RoleRepository getRoleRepository() {
        if(roleRepository == null){
            Repositories repositories = Repositories.getInstance();
            roleRepository = repositories.getRoleRepository();
        }
        return roleRepository;
    }

    private AuthenticationRepository getAuthenticationRepository(){
        if(authenticationRepository == null){
            Repositories repositories = Repositories.getInstance();
            authenticationRepository = repositories.getAuthenticationRepository();
        }
        return authenticationRepository;
    }


    public Optional<Employee> createEmployee(String name, String email, int ccNumber, int taxNumber, String address, String phoneNumber, String roleName, int agencyID){
        Agency agency = getAgencyByID(agencyID);
        Role role = getRoleByName(roleName);

        Employee administrator = getAdministratorFromSession();
        Optional<Organization> organization = getOrganizationRepository().getOrganizationByEmployee(administrator);

        Optional<Employee> newEmployee = Optional.empty();
        if(organization.isPresent()){
            newEmployee = organization.get().createEmployee(name, email, ccNumber, taxNumber, address, phoneNumber, role, agency, administrator);
        }
        return newEmployee;
    }

    private Employee getAdministratorFromSession() {
        Email email = getAuthenticationRepository().getCurrentUserSession().getUserId();
        return new Employee(email.getEmail());
    }

    private Agency getAgencyByID(int agencyID){
        return getAgencyRepository().getAgencyByID(agencyID);
    }

    private Role getRoleByName(String roleName){
        return getRoleRepository().getRoleByName(roleName);
    }

    public List<Agency> getAgencies(){
        return getAgencyRepository().getAgencies();
    }

    public List<Role> getRoles(){
        return getRoleRepository().getRoles();
    }
}