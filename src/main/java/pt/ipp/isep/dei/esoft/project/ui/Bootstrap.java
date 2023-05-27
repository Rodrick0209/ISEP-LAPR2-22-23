package pt.ipp.isep.dei.esoft.project.ui;

import pt.ipp.isep.dei.esoft.project.application.controller.authorization.AuthenticationController;
import pt.ipp.isep.dei.esoft.project.domain.*;
import pt.ipp.isep.dei.esoft.project.repository.*;

public class Bootstrap implements Runnable {

    private PropertyType House;
    PropertyType Land;
    private TypeBusinessRepository typeBusinessRepository;

    //Add some task categories to the repository as bootstrap
    public void run() {
        addRoles();
        addAgencies();
        addOrganization();
        addUsers();
        addProperties();
        addAgent();
        addTypeBusiness();
        addPropertyType();
    }

    private void addAgent() {
        EmployeeRepository employeeRepository = Repositories.getInstance().getEmployeeRepository();

        employeeRepository.add(new Employee ("Peter","peter@this.app",1234567,123456, "Rua Professor Laurentino Monteiro","9657825",new Role("Agent"),new Agency(123123,"Agency2","s",12312), new Employee("agent@this.app")));
        employeeRepository.add(new Employee ("John","john@this.app",1232323,232323, "Rua Manuel António Costa","9657825",new Role("Agent"),new Agency(191919,"Agency 2","s",12312), new Employee("agent@this.app")));

    }

    private void addOrganization() {
        //TODO: add organizations bootstrap here
        //get organization repository
        OrganizationRepository organizationRepository = Repositories.getInstance().getOrganizationRepository();
        Organization organization = new Organization("This Company");
        organization.addEmployee(new Employee("admin@this.app"));
        organization.addEmployee(new Employee("agent@this.app"));
        organizationRepository.add(organization);

    }
    

    private void addAgencies() {
        //TODO: add bootstrap Agencies here

        //get agency repository
        AgencyRepository agencyRepository = Repositories.getInstance().getAgencyRepository();
        Role owner = new Role("Marco");
        Agency agency = new Agency(123123,"Agency","s",12312);
        Employee employee = new Employee("employee@this.app");
        agencyRepository.add(new Agency(1234, "Agency Name 1", "Power Street", "abc@gmail.com", "(567) 456-2345",new Employee( "name", "admin@this.app", 1212434, 123124, "address", "phoneNumber", owner,  agency,  employee)));
        agencyRepository.add(new Agency ( 1244, "Agency Name 2","Tower Street","abc@gmail.com","(334) 459-9874",new Employee("name","agent@this.app",1220403,123453,"adress","phonenumber",owner,agency,employee)));
    }
    private void addProperties(){
       // TODO: add boostrap Properties
    
    // get agency Proprety
    
    PropertyRepository propertyRepository = Repositories.getInstance().getPropertyRepository();


        //propertyRepository.add(new Land( Land, 123, "Lol Street", 23, new Owner("owner@this.app")));

    }

    private void addRoles() {
        //TODO: add bootstrap Roles here

        //get role repository
        RoleRepository roleRepository = Repositories.getInstance().getRoleRepository();
        roleRepository.add(new Role("Agent"));
        roleRepository.add(new Role("Client"));

    }

    private void addUsers() {
        //TODO: add Authentication users here: should be created for each user in the organization
        AuthenticationRepository authenticationRepository = Repositories.getInstance().getAuthenticationRepository();
        authenticationRepository.addUserRole(AuthenticationController.ROLE_ADMIN, AuthenticationController.ROLE_ADMIN);
        authenticationRepository.addUserRole(AuthenticationController.ROLE_AGENT, AuthenticationController.ROLE_AGENT);
        authenticationRepository.addUserRole(AuthenticationController.ROLE_OWNER, AuthenticationController.ROLE_OWNER);
        authenticationRepository.addUserRole(AuthenticationController.ROLE_CLIENT, AuthenticationController.ROLE_CLIENT);

        authenticationRepository.addUserWithRole("Main Administrator", "admin@this.app", "admin", AuthenticationController.ROLE_ADMIN);
        authenticationRepository.addUserWithRole("Agent", "agent@this.app", "agent", AuthenticationController.ROLE_AGENT);
        authenticationRepository.addUserWithRole("Owner", "owner@this.app", "owner", AuthenticationController.ROLE_OWNER);
        authenticationRepository.addUserWithRole("Client" , "client@this.app", "client", AuthenticationController.ROLE_CLIENT);
    }

    private void addTypeBusiness(){
        typeBusinessRepository = Repositories.getInstance().getTypeBusinessRepository();

        typeBusinessRepository.add(new TypeBusiness("Sell"));
        typeBusinessRepository.add(new TypeBusiness("Rent"));
    }

    private void addPropertyType(){
        PropertyTypeRepository propertyTypeRepository = Repositories.getInstance().getPropertyTypeRepository();

        propertyTypeRepository.addPropertyTypes(new PropertyType("Land"));
        propertyTypeRepository.addPropertyTypes(new PropertyType("Apartment"));
        propertyTypeRepository.addPropertyTypes(new PropertyType("House"));

    }


}
