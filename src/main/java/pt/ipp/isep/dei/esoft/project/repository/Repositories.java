package pt.ipp.isep.dei.esoft.project.repository;

import pt.ipp.isep.dei.esoft.project.domain.Order;

import java.io.Serializable;

/**
 * The type Repositories.
 */
public class Repositories implements Serializable {

    private static final Repositories instance = new Repositories();


    /**
     * The Agency repository.
     */
    AgencyRepository agencyRepository = new AgencyRepository();
    /**
     * The Role repository.
     */
    RoleRepository roleRepository = new RoleRepository();

    /**
     * The Property repository.
     */
    PropertyRepository propertyRepository = new PropertyRepository();

    /**
     * The Authentication repository.
     */
    AuthenticationRepository authenticationRepository = new AuthenticationRepository();

    /**
     * The Property type repository.
     */
    PropertyTypeRepository propertyTypeRepository = new PropertyTypeRepository();

    /**
     * The Owner repository.
     */
    OwnerRepository ownerRepository = new OwnerRepository();

    /**
     * The Type business repository.
     */
    TypeBusinessRepository typeBusinessRepository = new TypeBusinessRepository();
    /**
     * The Employee repository.
     */
    EmployeeRepository employeeRepository = new EmployeeRepository();

    /**
     * The Request repository.
     */
    RequestRepository requestRepository = new RequestRepository();

    /**
     * The Announcement repository.
     */
    AnnouncementRepository announcementRepository = new AnnouncementRepository();

    /**
     * The Visit repository.
     */
    VisitRepository visitRepository =  new VisitRepository();

    OrderRepository orderRepository= new OrderRepository();

    ClientRepository clientRepository = new ClientRepository();
    DealRepository dealRepository = new DealRepository();

    private Repositories() {
    }

    /**
     * Gets instance.
     *
     * @return the instance
     */
    public static Repositories getInstance() {
        return instance;
    }

    public OrderRepository getOrderRepository() {
        return orderRepository;
    }


    /**
     * Gets agency repository.
     *
     * @return the agency repository
     */
    public AgencyRepository getAgencyRepository() {
        return agencyRepository;
    }

    /**
     * Gets role repository.
     *
     * @return the role repository
     */
    public RoleRepository getRoleRepository() {
        return roleRepository;
    }

    /**
     * Gets authentication repository.
     *
     * @return the authentication repository
     */
    public AuthenticationRepository getAuthenticationRepository() { return authenticationRepository; }

    /**
     * Gets property repository.
     *
     * @return the property repository
     */
    public PropertyRepository getPropertyRepository() { return propertyRepository; }

    /**
     * Gets property type repository.
     *
     * @return the property type repository
     */
    public PropertyTypeRepository getPropertyTypeRepository() {
        return propertyTypeRepository;
    }

    /**
     * Gets owner repository.
     *
     * @return the owner repository
     */
    public OwnerRepository getOwnerRepository() { return ownerRepository; }

    /**
     * Gets employee repository.
     *
     * @return the employee repository
     */
    public EmployeeRepository getEmployeeRepository() { return employeeRepository; }

    /**
     * Gets type business repository.
     *
     * @return the type business repository
     */
    public TypeBusinessRepository getTypeBusinessRepository() {
        return typeBusinessRepository;
    }

    /**
     * Gets request repository.
     *
     * @return the request repository
     */
    public RequestRepository getRequestRepository() {
        return requestRepository;
    }

    /**
     * Gets announcement repository.
     *
     * @return the announcement repository
     */
    public AnnouncementRepository getAnnouncementRepository() {
        return announcementRepository;
    }

    /**
     * Gets visit repository.
     *
     * @return the visit repository
     */
    public VisitRepository getVisitRepository() {
        return visitRepository;
    }

    public ClientRepository getClientRepository() {return clientRepository;}

    public DealRepository getDealRepository() {
        return dealRepository;
    }

    private Repositories(AgencyRepository agencyRepository, RoleRepository roleRepository, PropertyRepository propertyRepository, AuthenticationRepository authenticationRepository, PropertyTypeRepository propertyTypeRepository, OwnerRepository ownerRepository, TypeBusinessRepository typeBusinessRepository, EmployeeRepository employeeRepository, RequestRepository requestRepository, AnnouncementRepository announcementRepository, VisitRepository visitRepository, ClientRepository clientRepository, DealRepository dealRepository) {
        this.agencyRepository = agencyRepository;
        this.roleRepository = roleRepository;
        this.propertyRepository = propertyRepository;
        this.authenticationRepository = authenticationRepository;
        this.propertyTypeRepository = propertyTypeRepository;
        this.ownerRepository = ownerRepository;
        this.typeBusinessRepository = typeBusinessRepository;
        this.employeeRepository = employeeRepository;
        this.requestRepository = requestRepository;
        this.announcementRepository = announcementRepository;
        this.visitRepository = visitRepository;
        this.clientRepository = clientRepository;
        this.dealRepository = dealRepository;
    }

    public Repositories clone(){
        return new Repositories(agencyRepository, roleRepository, propertyRepository, authenticationRepository, propertyTypeRepository, ownerRepository, typeBusinessRepository, employeeRepository, requestRepository, announcementRepository, visitRepository, clientRepository, dealRepository);
    }
}

