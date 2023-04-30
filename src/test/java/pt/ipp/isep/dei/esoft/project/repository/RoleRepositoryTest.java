package pt.ipp.isep.dei.esoft.project.repository;

import org.junit.jupiter.api.Test;
import pt.ipp.isep.dei.esoft.project.domain.Role;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class RoleRepositoryTest {
    @Test
    void getRoleByNameEmptyList(){
        RoleRepository roleRepository = new RoleRepository();
        String roleName = "Role";
        assertThrows(IllegalArgumentException.class, () -> roleRepository.getRoleByName(roleName));
    }

    @Test
    void getRoleByNameNullList() {
        RoleRepository roleRepository = new RoleRepository();
        String roleName = "Role";
        assertThrows(IllegalArgumentException.class, () -> roleRepository.getRoleByName(roleName));
    }

    @Test
    void ensureNewRoleSuccessfullyAdded(){
        RoleRepository roleRepository = new RoleRepository();
        String roleName = "Role";
        Role role = new Role(roleName);
        roleRepository.add(role);
    }

    @Test
    void ensureGetRoleForExistingRole(){
        RoleRepository roleRepository = new RoleRepository();
        String roleName = "Role";
        Role role = new Role(roleName);
        roleRepository.add(role);
        Role role1 = roleRepository.getRoleByName(roleName);
        assertEquals(role, role1);
    }

    @Test
    void ensureGetRoleFailsForNonExistingRole(){
        RoleRepository roleRepository = new RoleRepository();
        String roleName = "Role";
        Role role = new Role(roleName);
        roleRepository.add(role);
        String roleName1 = "Role1";
        assertThrows(IllegalArgumentException.class, () -> roleRepository.getRoleByName(roleName1));
    }

    @Test
    void ensureGetRolesReturnsAnImmutableList(){
        RoleRepository roleRepository = new RoleRepository();
        String roleName = "Role";
        Role role = new Role(roleName);
        roleRepository.add(role);

        assertThrows(UnsupportedOperationException.class, () -> roleRepository.getRoles().add(new Role("Role1")));
    }

    @Test
    void ensureGetRolesReturnsTheCorrectList(){
        RoleRepository roleRepository = new RoleRepository();
        String roleName = "Role";
        Role role = new Role(roleName);
        roleRepository.add(role);
        int expectedSize = 1;

        int size = roleRepository.getRoles().size();

        assertEquals(expectedSize, size);
        assertEquals(role, roleRepository.getRoles().get(size - 1));
    }

    @Test
    void ensureAddingDuplicateRoleFails(){
        RoleRepository roleRepository = new RoleRepository();
        Role role = new Role("Role");
        roleRepository.add(role);

        Optional<Role> duplicateRole = roleRepository.add(role);

        assertTrue(duplicateRole.isEmpty());
    }

    @Test
    void ensureAddingDifferentRolesWorks(){
        RoleRepository roleRepository = new RoleRepository();
        Role role = new Role("Role");
        Role role1 = new Role("Role1");
        roleRepository.add(role);

        Optional<Role> result = roleRepository.add(role1);

        assertEquals(role1, result.get());
    }

}