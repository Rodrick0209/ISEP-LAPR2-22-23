package pt.ipp.isep.dei.esoft.project.repository;

public class Repositories {

    private static final Repositories instance = new Repositories();
    OrganizationRepository organizationRepository = new OrganizationRepository();
    AgencyRepository agencyRepository = new AgencyRepository();
    RoleRepository roleRepository = new RoleRepository();

    PropertyRepository propertyRepository = new PropertyRepository();

    AuthenticationRepository authenticationRepository = new AuthenticationRepository();

    PropertyTypeRepository propertyTypeRepository = new PropertyTypeRepository();

    private Repositories() {
    }

    public static Repositories getInstance() {
        return instance;
    }
    public OrganizationRepository getOrganizationRepository(){ return organizationRepository; }

    public AgencyRepository getAgencyRepository() {
        return agencyRepository;
    }

    public RoleRepository getRoleRepository() {
        return roleRepository;
    }

    public AuthenticationRepository getAuthenticationRepository() { return authenticationRepository; }

    public PropertyRepository getPropertyRepository() { return propertyRepository; }

    public PropertyTypeRepository getPropertyTypeRepository() {
        return propertyTypeRepository;
    }
}
