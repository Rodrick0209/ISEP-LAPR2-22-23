package pt.ipp.isep.dei.esoft.project.repository;

import pt.ipp.isep.dei.esoft.project.application.controller.CreateRequestController;

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

    VisitRepository visitRepository =  new VisitRepository();

    private Repositories() {
    }

    private Repositories(AgencyRepository agencyRepository, RoleRepository roleRepository, PropertyRepository propertyRepository, AuthenticationRepository authenticationRepository, PropertyTypeRepository propertyTypeRepository, OwnerRepository ownerRepository, TypeBusinessRepository typeBusinessRepository, EmployeeRepository employeeRepository, RequestRepository requestRepository, AnnouncementRepository announcementRepository, VisitRepository visitRepository) {
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
    }

    /**
     * Gets instance.
     *
     * @return the instance
     */
    public static Repositories getInstance() {
        return instance;
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

    public VisitRepository getVisitRepository() {
        return visitRepository;
    }

    @Override
    public Repositories clone()  {
        return new Repositories(this.agencyRepository, this.roleRepository, this.propertyRepository, this.authenticationRepository, this.propertyTypeRepository, this.ownerRepository, this.typeBusinessRepository, this.employeeRepository, this.requestRepository, this.announcementRepository, this.visitRepository);
    }
}

