package pt.ipp.isep.dei.esoft.project.domain;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class OrganizationTest {

    @Test
    void testEqualsSameObject() {
        Organization organization = new Organization("Organization Description");
        assertEquals(organization, organization);
    }

    @Test
    void testEqualsDifferentClass() {
        Organization organization = new Organization("Organization Description");
        assertNotEquals(organization, new Object());
    }

    @Test
    void testEqualsNull() {
        Organization organization = new Organization("Organization Description");
        assertNotEquals(null, organization);
    }

    @Test
    void testEqualsDifferentObject() {
        Organization organization = new Organization("Organization Description");
        Organization organization1 = new Organization("Organization Description");
        assertEquals(organization, organization1);
    }


    @Test
    void testHashCodeSameObject() {
        Organization organization = new Organization("Organization Description");
        assertEquals(organization.hashCode(), organization.hashCode());
    }

    @Test
    void testHashCodeDifferentObject() {
        Organization organization = new Organization("Organization Description");
        Organization organization1 = new Organization("Organization Description");
        assertEquals(organization.hashCode(), organization1.hashCode());
    }

    @Test
        //same hashcode
    void testHashCodeSameObjectSameDescription() {
        Organization organization = new Organization("Organization Description");
        Organization organization1 = new Organization("Organization Description");
        assertEquals(organization.hashCode(), organization1.hashCode());
    }

    @Test
    void ensureHashCodeFailsForDifferentDescriptions() {
        Organization organization = new Organization("Organization Description");
        Organization organization1 = new Organization("Organization Description1");
        assertNotEquals(organization.hashCode(), organization1.hashCode());
    }

    @Test
    void ensureEqualsFailsForDifferentObjectType() {
        Organization organization = new Organization("Organization Description");
        Organization organization1 = new Organization("Organization Description1");
        assertNotEquals(organization, organization1);
    }

    @Test
    void ensureEqualsFailsWhenComparingNull() {
        Organization organization = new Organization("Organization Description");
        assertNotEquals(organization, null);
    }

    @Test
    void ensureEqualsSuccessWhenComparingSameObject() {
        Organization organization = new Organization("Organization Description");
        assertEquals(organization, organization);
    }


    @Test
    void ensureEmploysFails() {
        Organization organization = new Organization("Organization Description");
        Employee employee = new Employee("employee@this.app");

        assertFalse(organization.employs(employee));
    }

    @Test
    void ensureEmploysSuccess() {
        Organization organization = new Organization("Organization Description");
        Employee employee = new Employee("employee@this.app");
        organization.addEmployee(employee);
        assertTrue(organization.employs(employee));
    }

    @Test
    void ensureAnyEmployeeHasEmailFails() {
        Organization organization = new Organization("Organization Description");
        Employee employee = new Employee("employee@this.app");
        organization.addEmployee(employee);
        assertFalse(organization.anyEmployeeHasEmail("employee1@this.app"));
    }

    @Test
    void ensureAnyEmployeeHasEmailWorks() {
        Organization organization = new Organization("Organization Description");
        Employee employee = new Employee("employee@this.app");
        organization.addEmployee(employee);
        assertTrue(organization.anyEmployeeHasEmail("employee@this.app"));
    }

    @Test
    void ensureAddDuplicateEmployeeFails() {
        Organization organization = new Organization("Organization Description");
        Employee employee = new Employee("employee@this.app");
        assertTrue(organization.addEmployee(employee));
        assertFalse(organization.addEmployee(employee));
    }

    @Test
    void ensureAddDuplicateAgencyFails() {
        Organization organization = new Organization("Organization Description");
        Agency agency = new Agency(123);
        assertTrue(organization.addAgency(agency));
        assertFalse(organization.addAgency(agency));
    }

    @Test
    void ensureAddDuplicateAnnouncementFails(){
        Organization organization = new Organization("Organization Description");
        Employee agent = new Employee("agent@this.app");
        List<String> photos = new ArrayList<>();
        photos.add("abc");
        Location location = new Location("Property Street", "Property city", "Property district");
        Property property = new Property(location);

        Announcement announcement = new Announcement(property, "Announcement Description", 123, agent);
        assertTrue(organization.addAnnouncement(announcement));
        assertFalse(organization.addAnnouncement(announcement));
    }
    @Test
    void ensureAddEmployeeWorks() {
        Organization organization = new Organization("Organization Description");
        Employee employee = new Employee("employee@this.app");
        assertTrue(organization.addEmployee(employee));
    }

    @Test
    void ensureAddAgencyWorks() {
        Organization organization = new Organization("Organization Description");
        Agency agency = new Agency(123);
        assertTrue(organization.addAgency(agency));
    }

    @Test
    void ensureAddAnnouncementWorks() {
        Organization organization = new Organization("Organization Description");
        Employee agent = new Employee("agent@this.app");
        List<String> photos = new ArrayList<>();
        photos.add("abc");
        Location location = new Location("Property Street", "Property city", "Property district");
        Property property = new Property(location);

        Announcement announcement = new Announcement(property, "Announcement description", 123, agent);
        assertTrue(organization.addAnnouncement(announcement));
    }

    @Test
    void ensureCloneWorks() {
        Organization organization = new Organization("Organization Description");
        Employee administrator = new Employee("admin@this.app");
        organization.addEmployee(administrator);
        Employee agent = new Employee("agent@this.app");
        List<String> photos = new ArrayList<>();
        photos.add("abc");
        Location location = new Location("Property Street", "Property city", "Property district");
        Property property = new Property(location);
        organization.addEmployee(agent);
        Agency agency = new Agency(123);
        organization.addAgency(agency);
        Announcement announcement = new Announcement(property, "Announcement Description", 123, agent);
        organization.addAnnouncement(announcement);
        Role role = new Role("Role");
        organization.createEmployee("Employee Name", "employee@this.app", 123, 123, "Employee Address", "(567) 643-3457", role, agency, administrator);
        organization.createAgency(123, "Agency Name", "Agency Location", "agency@this.app", "(563) 642-4621", administrator );
        organization.createAnnouncement(property, "Announcement Description", 123, agent);
        Organization clone = organization.clone();
        assertEquals(organization, clone);
    }

    @Test
    void testThatCreateEmployeeWorks() {
        Organization organization = new Organization("Organization Description");
        Employee administrator = new Employee("admin@this.app");
        Role role = new Role("Role");
        Agency agency = new Agency(123);

        Employee expected = new Employee("Employee Name", "employee@this.app", 123, 123, "Employee Address", "(456) 643-3456", role, agency, administrator);
        Optional<Employee> employee = organization.createEmployee("Employee Name", "employee@this.app", 123, 123, "Employee Address", "(456) 643-3456", role, agency, administrator);

        assertNotNull(employee);
        assertTrue(employee.isPresent());
        assertEquals(expected, employee.get());
    }

    @Test
    void ensureAddingDuplicateEmployeeFails(){
        Organization organization = new Organization("Organization Description");
        Employee administrator = new Employee("admin@this.app");
        Role role = new Role("Role");
        Agency agency = new Agency(123);

        Optional<Employee> employee = organization.createEmployee("Employee Name", "employee@this.app", 123, 123, "Employee Address", "(456) 643-3456", role, agency, administrator);
        Optional<Employee> duplicateEmployee = organization.createEmployee("Employee Name", "employee@this.app", 123, 123, "Employee Address", "(456) 643-3456", role, agency, administrator);

        assertTrue(duplicateEmployee.isEmpty());
    }

    @Test
    void testThatCreateAnnouncementWorks() {
        Organization organization = new Organization("Organization Description");
        Employee agent = new Employee("agent@this.app");
        List<String> photos = new ArrayList<>();
        photos.add("abc");
        Location location = new Location("Property Street", "Property city", "Property district");
        Property property = new Property(location);

        Announcement expected = new Announcement(property, "Announcement Description", 1234, agent);
        Optional<Announcement> announcement = organization.createAnnouncement(property, "Announcement Description", 1234, agent);

        assertNotNull(announcement);
        assertTrue(announcement.isPresent());
        assertEquals(expected, announcement.get());
    }

    @Test
    void ensureAddingDuplicateAnnouncementFails(){
        Organization organization = new Organization("Organization Description");
        Employee agent = new Employee("agent@this.app");
        List<String> photos = new ArrayList<>();
        photos.add("abc");
        Location location = new Location("Property Street", "Property city", "Property district");
        Property property = new Property(location);

        Optional<Announcement> announcement = organization.createAnnouncement(property, "Announcement Description", 1234, agent);
        Optional<Announcement> duplicateAnnouncement = organization.createAnnouncement(property, "Announcement Description", 1234, agent);

        assertTrue(duplicateAnnouncement.isEmpty());
    }

    @Test
    void testThatCreateAgencyWorks() {
        Organization organization = new Organization("Organization Description");
        Employee administrator = new Employee("admin@this.app");

        Agency expected = new Agency(123, "Agency Name", "Agency Location", "agency@this.app", "(654) 456-4321", administrator);
        Optional<Agency> agency = organization.createAgency(123, "Agency Name", "Agency Location", "agency@this.app", "(654) 456-4321", administrator);

        assertNotNull(agency);
        assertTrue(agency.isPresent());
        assertEquals(expected, agency.get());
    }

    @Test
    void ensureAddingDuplicateAgencyFails(){
        Organization organization = new Organization("Organization Description");
        Employee administrator = new Employee("admin@this.app");

        Optional<Agency> agency = organization.createAgency(123, "Agency Name", "Agency Location", "agency@this.app", "(654) 456-4321", administrator);
        Optional<Agency> duplicateAgency = organization.createAgency(123, "Agency Name", "Agency Location", "agency@this.app", "(654) 456-4321", administrator);

        assertTrue(duplicateAgency.isEmpty());
     }

}