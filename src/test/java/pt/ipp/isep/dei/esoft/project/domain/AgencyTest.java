package pt.ipp.isep.dei.esoft.project.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AgencyTest {

    @Test
    void ensureAgencyIsCreatedSuccessfully(){
        Employee administrator = new Employee("admin@this.app");
        Agency agency = new Agency(120, "Agency Name", "Agency Location", "agency@this.app", "(456) 456-3456", administrator);
    }

    @Test
    void ensureAgencyDesignationNotHaveMoreThan40Characters(){
        Employee administrator = new Employee("admin@this.app");

        assertThrows(IllegalArgumentException.class,() -> new Agency(123, "Agency Designation having more than 40 characters", "Agency Location", "agency@this.app", "(567) 456-3456", administrator));
    }

    @Test
    void ensureAgencyEmailValid(){
        Employee administrator = new Employee("admin@this.app");

        assertThrows(IllegalArgumentException.class,() -> new Agency(123, "Agency Name", "Agency Location", "agency.this.app", "(567) 456-3456", administrator));
    }


    @Test
    void testEqualsSameObject() {
        Employee administrator = new Employee("admin@this.app");

        Agency agency = new Agency(120, "Agency Name", "Agency Location", "agency@this.app", "(456) 456-3456", administrator);
        assertEquals(agency, agency);
    }

    @Test
    void testEqualsDifferentClass(){
        Employee administrator = new Employee("admin@this.app");

        Agency agency = new Agency(120, "Agency Name", "Agency Location", "agency@this.app", "(456) 456-3456", administrator);
        assertNotEquals(agency, new Object());
    }

    @Test
    void testEqualsNull(){
        Employee administrator = new Employee("admin@this.app");

        Agency agency = new Agency(120, "Agency Name", "Agency Location", "agency@this.app", "(456) 456-3456", administrator);
        assertNotEquals(agency, null);
    }

    @Test
    void testEqualsDifferentObject(){
        Employee administrator = new Employee("admin@this.app");

        Agency agency = new Agency(120, "Agency Name", "Agency Location", "agency@this.app", "(456) 456-3456", administrator);
        Agency agency1 = new Agency(121, "Agency Name1", "Agency Location1", "agency1@this.app", "(698) 567-3475", administrator);
        assertNotEquals(agency, agency1);
    }

    @Test
    void testEqualsSameObjectDifferentID(){
        Employee administrator = new Employee("admin@this.app");

        Agency agency = new Agency(120, "Agency Name", "Agency Location", "agency@this.app", "(456) 456-3456", administrator);
        Agency agency1 = new Agency(121, "Agency Name", "Agency Location", "agency@this.app", "(456) 456-3456", administrator);
        assertNotEquals(agency, agency1);
    }

    @Test
    void testEqualsSameObjectSameID(){
        Employee administrator = new Employee("admin@this.app");

        Agency agency = new Agency(120, "Agency Name", "Agency Location", "agency@this.app", "(456) 456-3456", administrator);
        Agency agency1 = new Agency(120, "Agency Name", "Agency Location", "agency@this.app", "(456) 456-3456", administrator);
        assertEquals(agency, agency1);
    }

    @Test
    void testHashCodeSameObject() {
        Employee administrator = new Employee("admin@this.app");

        Agency agency = new Agency(120, "Agency Name", "Agency Location", "agency@this.app", "(456) 456-3456", administrator);
        assertEquals(agency.hashCode(), agency.hashCode());
    }

    @Test
    void testHashCodeDifferentObject() {
        Employee administrator = new Employee("admin@this.app");

        Agency agency = new Agency(120, "Agency Name", "Agency Location", "agency@this.app", "(456) 456-3456", administrator);
        Agency agency1 = new Agency(121, "Agency Name1", "Agency Location1", "agency1@this.app", "(698) 567-3475", administrator);
        assertNotEquals(agency.hashCode(), agency1.hashCode());
    }

    @Test
    void ensureCloneWorks() {
        Employee administrator = new Employee("admin@this.app");

        Agency agency = new Agency(120, "Agency Name", "Agency Location", "agency@this.app", "(456) 456-3456", administrator);
        Agency clone = agency.clone();
        assertEquals(agency, clone);
    }

    @Test
    void ensureGetIDWorks() {
        Employee administrator = new Employee("admin@this.app");

        Agency agency = new Agency(120, "Agency Name", "Agency Location", "agency@this.app", "(456) 456-3456", administrator);
        assertEquals(120, agency.getID());
    }

    @Test
    void ensureGetDesignationWorks() {
        Employee administrator = new Employee("admin@this.app");

        Agency agency = new Agency(120, "Agency Name", "Agency Location", "agency@this.app", "(456) 456-3456", administrator);
        assertEquals("Agency Name", agency.getDesignation());
    }
}