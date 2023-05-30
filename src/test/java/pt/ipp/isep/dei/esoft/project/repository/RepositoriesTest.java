package pt.ipp.isep.dei.esoft.project.repository;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RepositoriesTest {

    @Test
    void testGetInstance() {
        Repositories instance = Repositories.getInstance();
        assertNotNull(instance);
    }

    @Test
    void testGetOrganizationRepository() {
        Repositories instance = Repositories.getInstance();
//        assertNotNull(instance.getOrganizationRepository());
    }

    @Test
    void testGetRoleRepository() {
        Repositories instance = Repositories.getInstance();
        assertNotNull(instance.getRoleRepository());
    }

    @Test
    void testGetAgencyRepository(){
        Repositories instance = Repositories.getInstance();
        assertNotNull(instance.getAgencyRepository());
    }

    @Test
    void testGetPropertyRepository(){
        Repositories instance = Repositories.getInstance();
        assertNotNull(instance.getPropertyRepository());
    }


}