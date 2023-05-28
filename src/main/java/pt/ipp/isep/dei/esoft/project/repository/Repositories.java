package pt.ipp.isep.dei.esoft.project.repository;

/**
 * The type Repositories.
 */
public class Repositories {

    private static final Repositories instance = new Repositories();
    /**
     * The Organization repository.
     */

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

    OwnerRepository ownerRepository = new OwnerRepository();

    TypeBusinessRepository typeBusinessRepository = new TypeBusinessRepository();
    EmployeeRepository employeeRepository = new EmployeeRepository();

    RequestRepository requestRepository = new RequestRepository();

    AnnouncementRepository announcementRepository = new AnnouncementRepository();

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

    /**
     * Get organization repository organization repository.
     *
     * @return the organization repository
     */

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

    public OwnerRepository getOwnerRepository() { return ownerRepository; }

    public EmployeeRepository getEmployeeRepository() { return employeeRepository; }

    public TypeBusinessRepository getTypeBusinessRepository() {
        return typeBusinessRepository;
    }

    public RequestRepository getRequestRepository() {
        return requestRepository;
    }

    public AnnouncementRepository getAnnouncementRepository() {
        return announcementRepository;
    }
}

