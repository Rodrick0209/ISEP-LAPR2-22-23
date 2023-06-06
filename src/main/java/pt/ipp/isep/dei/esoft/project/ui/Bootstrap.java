package pt.ipp.isep.dei.esoft.project.ui;

import pt.ipp.isep.dei.esoft.project.application.controller.PublishAnnouncementController;
import pt.ipp.isep.dei.esoft.project.application.controller.authorization.AuthenticationController;
import pt.ipp.isep.dei.esoft.project.domain.*;
import pt.ipp.isep.dei.esoft.project.repository.*;
import pt.isep.lei.esoft.auth.domain.model.Email;

import java.util.Calendar;
import java.util.Date;
import java.util.List;


public class Bootstrap implements Runnable {
    private Employee agent = null;


    //Add some task categories to the repository as bootstrap
    public void run() {
        addRoles();
        addAgencies();
        addUsers();
        addEmployees();
        addProperties();
        addTypeBusiness();
        addPropertyTypes();
        addOwner();
        addRequests();
        addAnnouncements();
        //addVisit();
    }

    private void addOwner() {
        OwnerRepository ownerRepository = Repositories.getInstance().getOwnerRepository();
        ownerRepository.add(new Owner("owner@this.app"));
    }

    private void addEmployees() {
        EmployeeRepository employeeRepository = Repositories.getInstance().getEmployeeRepository();
        employeeRepository.add(new Employee("admin@this.app"));
        employeeRepository.add(new Employee("storemanager@this.app"));
        employeeRepository.add(new Employee("agent@this.app"));
    }

    private void addAgencies() {
        //TODO: add bootstrap Agencies here

        //get agency repository
        AgencyRepository agencyRepository = Repositories.getInstance().getAgencyRepository();
        agencyRepository.add(new Agency(1234, "Agency Name", "Power Street", "realestateagency@gmail.com", "(567) 456-2345", new Employee("admin@this.app")));
    }

    private void addProperties() {
        // TODO: add boostrap Properties


        // get agency Proprety

        PropertyRepository propertyRepository = Repositories.getInstance().getPropertyRepository();
        propertyRepository.add(new Land(new PropertyType("Land"), 123, new Location("Lol Street", "Porto", "Portugal", 12345), 23, new Owner("owner@this.app")));
        propertyRepository.add(new Apartment(new PropertyType("Apartment"), 123, new Location("God Street", "Porto", "Portugal", 12345), 23, 3, 3, 1, false, true, new Owner("owner@this.app")));
        propertyRepository.add(new House(new PropertyType("House"), 90, new Location("Rua Professor Laurentino Monteiro", "Póvoa de Varzim", "Porto", 14490), 37, 3, 2, 1, true, true, true, true, "N", new Owner("owner@this.app")));
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
        authenticationRepository.addUserRole(AuthenticationController.ROLE_CLIENT, AuthenticationController.ROLE_CLIENT);


        authenticationRepository.addUserWithRole("Main Administrator", "admin@this.app", "admin", AuthenticationController.ROLE_ADMIN);
        authenticationRepository.addUserWithRole("Agent", "agent@this.app", "agent", AuthenticationController.ROLE_AGENT);
        authenticationRepository.addUserWithRole("Owner", "owner@this.app", "owner", AuthenticationController.ROLE_OWNER);
        authenticationRepository.addUserWithRole("Client", "client@this.app", "client", AuthenticationController.ROLE_CLIENT);

    }

    private void addTypeBusiness() {
        TypeBusinessRepository typeBusinessRepository = Repositories.getInstance().getTypeBusinessRepository();

        typeBusinessRepository.add(new TypeBusiness("Sell"));
        typeBusinessRepository.add(new TypeBusiness("Rent"));
    }

    private void addPropertyTypes() {
        PropertyTypeRepository propertyTypeRepository = Repositories.getInstance().getPropertyTypeRepository();
        propertyTypeRepository.add(new PropertyType("Land"));
        propertyTypeRepository.add(new PropertyType("Apartment"));
        propertyTypeRepository.add(new PropertyType("House"));
    }

    private void addRequests() {
        RequestRepository savedRequests = Repositories.getInstance().getRequestRepository();
       Owner owner = new Owner("owner@gmail.com");
        Property property = new Property(200);
        TypeBusiness typeBusiness = new TypeBusiness("Sale");


        Request request1 = new Request(property, typeBusiness, 500, owner);
        savedRequests.add(request1);
    }

    /*
        Repositories.getInstance().getAnnouncementRepository().addAnnouncement(new Announcement(new Request(new House( new PropertyType("House") , 120, new Location("Rua Professor Laurentino Monteiro", "Póvoa de Varzim", "Porto", 12345), 12, 3, 2, 1, true, false, true, true, "N", new Owner("owner@this.app")), new TypeBusiness("Sell") ,130000, new Owner("owner@this.app")), new Commission("percentage", 5), new Date(2023,05,31)));
        Announcement announcement = new Announcement(new Request(new House( new PropertyType("House") , 120, new Location("Rua Professor Laurentino Monteiro", "Póvoa de Varzim", "Porto", 12345), 12, 3, 2, 1, true, false, true, true, "N", new Owner("owner@this.app")), new TypeBusiness("Sell") ,130000, new Owner("owner@this.app")), new Commission("percentage" , 5), new Date(2023,05,31));
        announcementRepository.addAnnouncement(announcement);

     */

    private void addAnnouncements() {
        AnnouncementRepository announcementRepository = Repositories.getInstance().getAnnouncementRepository();
        List<Announcement> announcements = announcementRepository.getAnnouncements();

        Email orderClientEmail = new Email("joao@this.app");
        Client orderClient = new Client("Joao", 919919919, orderClientEmail);
        Order order1 = new Order(5000, orderClient);
        Order order2 = new Order(3000, orderClient);
        Date announcementDate = new Date(2023, Calendar.JUNE, 23);
        Announcement announcement1 = new Announcement(null, null, announcementDate);
        Announcement announcement2 = new Announcement(null, null);
        Announcement announcement = new Announcement(new Request( new Land ( new PropertyType("Land"), 120, new Location("rua Professor Laurentino Monteiro", "Póvoa", "Porto", 12345) , 1.3, new Owner("owner@this.app")), new TypeBusiness("Sell"), 130000 ,new Owner("owner@this.app")), new Commission("Percentage", 5), announcementDate);
        Announcement announcement3 = new Announcement(new Request( new Land ( new PropertyType("Land"), 134, new Location("rua António Costa", "Póvoa", "Porto", 43236) , 2.7, new Owner("owner@this.app")), new TypeBusiness("Sell"), 150000 ,new Owner("owner@this.app")), new Commission("Percentage", 5), announcementDate);
        announcements.add(announcement);
        announcements.add(announcement3);
        announcement1.addOrder(order1);
        announcement1.addOrder(order2);

    }

    /*private void addVisit() {
        VisitRepository visitRepository = Repositories.getInstance().getVisitRepository();

        VisitRequest visitRequest;
        visitRequest = new VisitRequest( new Announcement(new Request(new House( new PropertyType("House") , 120, new Location("Rua Professor Laurentino Monteiro", "Póvoa de Varzim", "Porto", 12345), 12, 3, 2, 1, true, false, true, true, "N", new Owner("owner@this.app")), new TypeBusiness("Sell") ,130000, new Owner("owner@this.app")), new Commission("percentage" , 5), new Date(2023,05,31)),"Owner1" , "932414522", "31/05" , 15-16 , "I want to visit this porperty.");

        visitRepository.addRequests(visitRequest);
    }*/

}


