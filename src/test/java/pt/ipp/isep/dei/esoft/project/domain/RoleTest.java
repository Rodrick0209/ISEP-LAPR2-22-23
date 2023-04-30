package pt.ipp.isep.dei.esoft.project.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RoleTest {

    @Test
    void ensureCreateRoleWorks(){
        Role role = new Role("Role");
    }

    @Test
    void testEqualsSameObject(){
        Role role = new Role("Role");
        assertEquals(role, role);
    }

    @Test
    void testEqualsDifferentClass(){
        Role role = new Role("Role");
        assertNotEquals(role, new Object());
    }

    @Test
    void testEqualsNull(){
        Role role = new Role("Role");
        assertNotEquals(role, null);
    }

    @Test
    void testEqualsDifferentObject(){
        Role role = new Role("Role");
        Role role1 = new Role("Role1");
        assertNotEquals(role, role1);
    }

    @Test
    void testEqualsSameObjectDifferentName(){
        Role role = new Role("Role");
        Role role1 = new Role("Role1");
        assertNotEquals(role, role1);
    }

    @Test
    void testEqualsSameObjectSameName(){
        Role role = new Role("Role");
        Role role1 = new Role("Role");
        assertEquals(role, role1);
    }

    @Test
    void testHashCodeSameObject(){
        Role role = new Role("Role");
        assertEquals(role.hashCode(), role.hashCode());
    }

    @Test
    void testHashCodeDifferentObject(){
        Role role = new Role("Role");
        Role role1 = new Role("Role1");
        assertNotEquals(role.hashCode(), role1.hashCode());
    }

    @Test
    void ensureGetNameWorks() {
        Role role = new Role("Role");
        assertEquals("Role", role.getName());
    }

    @Test
    void ensureCloneWorks() {
        Role role = new Role("Role");
        Role clone = role.clone();
        assertEquals(role, clone);
    }

}