package pt.ipp.isep.dei.esoft.project.ui;

import pt.ipp.isep.dei.esoft.project.application.controller.authorization.AuthenticationController;
import pt.ipp.isep.dei.esoft.project.domain.*;
import pt.ipp.isep.dei.esoft.project.repository.*;

public class Bootstrap implements Runnable {

    //Add some task categories to the repository as bootstrap
    public void run() {
        addRoles();
        addAgencies();
        addUsers();
        addEmployees();
        addProperties();
        addTypeBusiness();
        addPropertyTypes();
    }

    private void addEmployees(){
        EmployeeRepository employeeRepository = Repositories.getInstance().getEmployeeRepository();
        employeeRepository.add(new Employee("admin@this.app"));
        employeeRepository.add(new Employee("owner@this.app"));
        employeeRepository.add(new Employee("storemanager@this.app"));
        employeeRepository.add(new Employee("agent@this.app"));
    }
    

    private void addAgencies() {
        //TODO: add bootstrap Agencies here

        //get agency repository
        AgencyRepository agencyRepository = Repositories.getInstance().getAgencyRepository();
        agencyRepository.add(new Agency(1234, "Agency Name", "Power Street", "abc@gmail.com", "(567) 456-2345",new Employee("admin@this.app")));
    }
    private void addProperties(){
       // TODO: add boostrap Properties
    
    // get agency Proprety
    
    PropertyRepository propertyRepository = Repositories.getInstance().getPropertyRepository();
    propertyRepository.add(new Land(new PropertyType("Land"), 123, "Lol Street", 23, new Owner("owner@this.app")));
    propertyRepository.add(new Apartment(new PropertyType("Apartment"), 123, "Lmao Street", 23,new Owner("owner@this.app") , 3, 3, 1, false, true));

    }

    private void addRoles() {
        //TODO: add bootstrap Roles here

        //get role repository
        RoleRepository roleRepository = Repositories.getInstance().getRoleRepository();
        roleRepository.add(new Role("Agent"));
    }

    private void addUsers() {
        //TODO: add Authentication users here: should be created for each user in the organization
        AuthenticationRepository authenticationRepository = Repositories.getInstance().getAuthenticationRepository();
        authenticationRepository.addUserRole(AuthenticationController.ROLE_ADMIN, AuthenticationController.ROLE_ADMIN);
        authenticationRepository.addUserRole(AuthenticationController.ROLE_AGENT, AuthenticationController.ROLE_AGENT);
        authenticationRepository.addUserRole(AuthenticationController.ROLE_OWNER, AuthenticationController.ROLE_OWNER);

        authenticationRepository.addUserWithRole("Main Administrator", "admin@this.app", "admin", AuthenticationController.ROLE_ADMIN);
        authenticationRepository.addUserWithRole("Agent", "agent@this.app", "agent", AuthenticationController.ROLE_AGENT);
        authenticationRepository.addUserWithRole("Owner", "owner@this.app", "owner", AuthenticationController.ROLE_OWNER);
    }

    private void addTypeBusiness(){
        TypeBusinessRepository typeBusinessRepository = Repositories.getInstance().getTypeBusinessRepository();

        typeBusinessRepository.add(new TypeBusiness("Sale"));
        typeBusinessRepository.add(new TypeBusiness("Rent"));
    }

    private void addPropertyTypes(){
        PropertyTypeRepository propertyTypeRepository = Repositories.getInstance().getPropertyTypeRepository();

        propertyTypeRepository.add(new PropertyType("Land"));
        propertyTypeRepository.add(new PropertyType("Apartment"));
        propertyTypeRepository.add(new PropertyType("House"));
    }


}
