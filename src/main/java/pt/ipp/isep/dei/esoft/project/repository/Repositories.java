package pt.ipp.isep.dei.esoft.project.repository;

public class Repositories {

    private static final Repositories instance = new Repositories();
    OrganizationRepository organizationRepository = new OrganizationRepository();
    AgencyRepository agencyRepository = new AgencyRepository();
    RoleRepository roleRepository = new RoleRepository();

    AuthenticationRepository authenticationRepository = new AuthenticationRepository();

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
}
