package pt.ipp.isep.dei.esoft.project.ui;

import pt.ipp.isep.dei.esoft.project.application.controller.OrderController;
import pt.ipp.isep.dei.esoft.project.application.controller.authorization.AuthenticationController;
import pt.ipp.isep.dei.esoft.project.domain.*;
import pt.ipp.isep.dei.esoft.project.repository.*;
import pt.isep.lei.esoft.auth.domain.model.Email;

import java.text.SimpleDateFormat;
import java.util.*;


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
        addOwner();
        addRequests();
        addAnnouncementsAndOrders();
        addVisit();
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
        propertyRepository.add(new Land(new PropertyType("Land"), 123, "Lol Street ,Porto, Portugal, 12345", 23, new Owner("owner@this.app")));
        propertyRepository.add(new Apartment(new PropertyType("Apartment"), 123, "God Street ,Porto, Portugal, 12345", 23, 3, 3, 1, false, true, new Owner("owner@this.app")));
        propertyRepository.add(new House(new PropertyType("House"), 90, "Rua Professor Laurentino Monteiro, Póvoa de Varzim, Porto, 14490", 37, 3, 2, 1, true, true, true, true, "N", new Owner("owner@this.app")));
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
        UserRepository userRepository = Repositories.getInstance().getUserRepository();
        authenticationRepository.addUserRole(AuthenticationController.ROLE_ADMIN, AuthenticationController.ROLE_ADMIN);
        authenticationRepository.addUserRole(AuthenticationController.ROLE_AGENT, AuthenticationController.ROLE_AGENT);
        authenticationRepository.addUserRole(AuthenticationController.ROLE_OWNER, AuthenticationController.ROLE_OWNER);
        authenticationRepository.addUserRole(AuthenticationController.ROLE_CLIENT, AuthenticationController.ROLE_CLIENT);
        authenticationRepository.addUserRole(AuthenticationController.ROLE_NETWORK_MANAGER, AuthenticationController.ROLE_NETWORK_MANAGER);
        authenticationRepository.addUserRole(AuthenticationController.ROLE_STORE_MANAGER, AuthenticationController.ROLE_STORE_MANAGER);

        authenticationRepository.addUserWithRole("Main Administrator", "admin@this.app", "admin", AuthenticationController.ROLE_ADMIN);
        userRepository.add(new User("Main Administrator", "admin@this.app", "admin", AuthenticationController.ROLE_ADMIN));
        authenticationRepository.addUserWithRole("Agent", "agent@this.app", "agent", AuthenticationController.ROLE_AGENT);
        userRepository.add(new User("Agent", "agent@this.app", "agent", AuthenticationController.ROLE_AGENT));
        authenticationRepository.addUserWithRole("Owner", "owner@this.app", "owner", AuthenticationController.ROLE_OWNER);
        userRepository.add(new User("Owner", "owner@this.app", "owner", AuthenticationController.ROLE_OWNER));
        authenticationRepository.addUserWithRole("Client", "client@this.app", "client", AuthenticationController.ROLE_CLIENT);
        userRepository.add(new User("Client", "client@this.app", "client", AuthenticationController.ROLE_CLIENT));
        authenticationRepository.addUserWithRole("Network manager", "networkmanager@this.app", "networkmanager", AuthenticationController.ROLE_NETWORK_MANAGER);
        userRepository.add(new User("Network manager", "networkmanager@this.app", "networkmanager", AuthenticationController.ROLE_NETWORK_MANAGER));
        authenticationRepository.addUserWithRole("Store manager", "storemanager@this.app", "storemanager", AuthenticationController.ROLE_STORE_MANAGER);
        userRepository.add(new User("Store manager", "storemanager@this.app", "storemanager", AuthenticationController.ROLE_STORE_MANAGER));

    }

    private void addTypeBusiness() {
        TypeBusinessRepository typeBusinessRepository = Repositories.getInstance().getTypeBusinessRepository();

        typeBusinessRepository.add(new TypeBusiness("Sale"));
        typeBusinessRepository.add(new TypeBusiness("Sell"));
        typeBusinessRepository.add(new TypeBusiness("Rent"));
    }

    private void addPropertyTypes() {
        PropertyTypeRepository propertyTypeRepository = Repositories.getInstance().getPropertyTypeRepository();
        propertyTypeRepository.add(new PropertyType("Land"));
        propertyTypeRepository.add(new PropertyType("Apartment"));
        propertyTypeRepository.add(new PropertyType("House"));
    }

    private void  addRequests() {
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

    private void addAnnouncementsAndOrders() {
        AnnouncementRepository announcementRepository = Repositories.getInstance().getAnnouncementRepository();
        OrderRepository orderRepository = Repositories.getInstance().getOrderRepository();

        PropertyType propertyType1 =  new PropertyType("Land");
        Property property1 = new Land(propertyType1, 123, "Lol Street, Porto, Portugal, 12345", 23, new Owner("owner@this.app"));
        TypeBusiness typeBusiness1 = new TypeBusiness("Sale");
        Owner owner1 = new Owner("owner@this.app");
        Request request1 = new Request(property1,typeBusiness1 , 4500, owner1);
        Date date1 = new Date(2023, 6, 15);
        Commission commission1 = new Commission("Percentage Commission", 12);
        Announcement announcement = new Announcement(request1, commission1, date1);
        announcementRepository.add(announcement);

        // Create an order and add it to the order repository
        Client client1 = new Client("client@this.app");
        //Date date1 = new Date(2023,6 , 17);
        Date date2 = new Date();


        Order order1 = new Order(500, date1, client1);
        Order order2 = new Order(1000, date2, client1);


        orderRepository.addOrder(order1);
        orderRepository.addOrder(order2);

    }





    private void addVisit() {
        Owner owner1 = new Owner("Joao", 1234567, "1234567", "joao@this.app", "1234567");
        Property land1 = new Land(new PropertyType("Land"), 150, "Rua Professor Laurentino Monteiro, Póvoa de Varzim ,Porto, 12345",12, owner1 );
        Request request1 = new Request(land1 , new TypeBusiness("Sale") , 120000, owner1);
        Commission commission1 = new Commission("percentage", 5);
        Date visitDate1 = new Date(123, 6, 23);
        Date visitDate2 = new Date(123, 8, 19);
        PropertyType propertyType1 = new PropertyType("Land");
        Announcement announcement1 = new Announcement(request1, commission1);
        Owner owner2 = new Owner("joao", 1234567,"12345678", "joao@this.app", "12345678" );
        Property property1 = new Property(propertyType1, 150, "Rua Professor Laurentino Monteiro, Póvoa de Varzim ,Porto, 12345", 12,owner2 );
        Request request2 =new Request(property1, new TypeBusiness("Sell"), 135000 , owner2);
        Announcement announcement2 = new Announcement(request2, new Commission("percentage", 5));
        Employee agent1 = new Employee("agent@this.app");
        int[][] timeslot = new int[15][18];
        VisitRequest visitRequest1 = new VisitRequest(announcement2,"Pedro", "123456789", visitDate1 , new int[16][18] , "I want to visit this property", agent1);
        VisitRequest visitRequest2 = new VisitRequest(announcement1, "Tiago" , "1234242142141" , visitDate2, new int[15][19] , "I want to visit this land please", agent1);
        Repositories.getInstance().getVisitRepository().addVisit1(visitRequest1);
        Repositories.getInstance().getVisitRepository().addVisit1(visitRequest2);

    }

}


