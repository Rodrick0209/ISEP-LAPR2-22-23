/*
package pt.ipp.isep.dei.esoft.project.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeTest {

    @Test
    void ensureCreateEmployeeWorks(){
        Role role = new Role("Role");
        Agency agency = new Agency(124, "Agency Name", "Power Street, F");
        Employee administrator = new Employee("admin@this.app");

        Employee employee = new Employee("Employee Name", "employee@this.app", 1234, 1234, "Employee address", "(557) 543-2356", role, agency, administrator);
    }

    @Test
    void ensureEmployeeEmailValid(){
        Role role = new Role("Role");
        Agency agency = new Agency(124, "Agency Name", "Power Street, F");
        Employee administrator = new Employee("admin@this.app");

        assertThrows(IllegalArgumentException.class, () -> new Employee("Employee Name", "employee.this.app", 1234, 1234, "Employee address", "(557) 543-2356", role, agency, administrator));
    }

    @Test
    void testEqualsSameObject(){
        Role role = new Role("Role");
        Agency agency = new Agency(124, "Agency Name", "Power Street, F");
        Employee administrator = new Employee("admin@this.app");

        Employee employee = new Employee("Employee Name", "employee@this.app", 1234, 1234, "Employee address", "(557) 543-2356", role, agency, administrator);
        assertEquals(employee, employee);
    }

    @Test
    void testEqualsDifferentClass(){
        Role role = new Role("Role");
        Agency agency = new Agency(124, "Agency Name", "Power Street, F");
        Employee administrator = new Employee("admin@this.app");

        Employee employee = new Employee("Employee Name", "employee@this.app", 1234, 1234, "Employee address", "(557) 543-2356", role, agency, administrator);
        assertNotEquals(employee, new Object());
    }

    @Test
    void testEqualsNull(){
        Role role = new Role("Role");
        Agency agency = new Agency(124, "Agency Name", "Power Street, F");
        Employee administrator = new Employee("admin@this.app");

        Employee employee = new Employee("Employee Name", "employee@this.app", 1234, 1234, "Employee address", "(557) 543-2356", role, agency, administrator);
        assertNotEquals(employee, null);
    }

    @Test
    void testEqualsDifferentObject(){
        Role role = new Role("Role");
        Agency agency = new Agency(124, "Agency Name", "Power Street, F");
        Employee administrator = new Employee("admin@this.app");

        Employee employee = new Employee("Employee Name", "employee@this.app", 1234, 1234, "Employee address", "(557) 543-2356", role, agency, administrator);
        Employee employee1 = new Employee("Employee Name1", "employee1@this.app", 12345, 12345, "Employee address1", "(567) 577-4531", role, agency, administrator);

        assertNotEquals(employee, employee1);
    }

    @Test
    void testEqualsSameObjectDifferentEmail(){
        Role role = new Role("Role");
        Agency agency = new Agency(124, "Agency Name", "Power Street, F");
        Employee administrator = new Employee("admin@this.app");

        Employee employee = new Employee("Employee Name", "employee@this.app", 1234, 1234, "Employee address", "(557) 543-2356", role, agency, administrator);
        Employee employee1 = new Employee("Employee Name", "employee1@this.app", 1234, 1234, "Employee address", "(557) 543-2356", role, agency, administrator);

        assertNotEquals(employee, employee1);
    }

    @Test
    void testEqualsSameObjectSameEmail(){
        Role role = new Role("Role");
        Agency agency = new Agency(124, "Agency Name", "Power Street, F");
        Employee administrator = new Employee("admin@this.app");

        Employee employee = new Employee("Employee Name", "employee@this.app", 1234, 1234, "Employee address", "(557) 543-2356", role, agency, administrator);
        Employee employee1 = new Employee("Employee Name", "employee@this.app", 1234, 1234, "Employee address", "(557) 543-2356", role, agency, administrator);

        assertEquals(employee, employee1);
    }

    @Test
    void testHashCodeSameObject(){
        Role role = new Role("Role");
        Agency agency = new Agency(124, "Agency Name", "Power Street, F");
        Employee administrator = new Employee("admin@this.app");

        Employee employee = new Employee("Employee Name", "employee@this.app", 1234, 1234, "Employee address", "(557) 543-2356", role, agency, administrator);
        assertEquals(employee.hashCode(), employee.hashCode());
    }

    @Test
    void testHashCodeDifferentObject(){
        Role role = new Role("Role");
        Agency agency = new Agency(124, "Agency Name", "Power Street, F");
        Employee administrator = new Employee("admin@this.app");

        Employee employee = new Employee("Employee Name", "employee@this.app", 1234, 1234, "Employee address", "(557) 543-2356", role, agency, administrator);
        Employee employee1 = new Employee("Employee Name1", "employee1@this.app", 12345, 12345, "Employee address1", "(567) 577-4531", role, agency, administrator);
        assertNotEquals(employee.hashCode(), employee1.hashCode());
    }

    @Test
    void testHasEmailWorks(){
        Role role = new Role("Role");
        Agency agency = new Agency(124, "Agency Name", "Power Street, F");
        Employee administrator = new Employee("admin@this.app");

        Employee employee = new Employee("Employee Name", "employee@this.app", 1234, 1234, "Employee address", "(557) 543-2356", role, agency, administrator);
        String employeeEmail = "EMPLOYEE@THIS.APP";
        assertTrue(employee.hasEmail(employeeEmail));
    }

    @Test
    void testHasEmailFails(){
        Role role = new Role("Role");
        Agency agency = new Agency(124, "Agency Name", "Power Street, F");
        Employee administrator = new Employee("admin@this.app");

        Employee employee = new Employee("Employee Name", "employee@this.app", 1234, 1234, "Employee address", "(557) 543-2356", role, agency, administrator);
        String employeeEmail = "EMPLOYEEE@THIS.APP";
        assertFalse(employee.hasEmail(employeeEmail));
    }

    @Test
    void ensureCloneWorks() {
        Role role = new Role("Role");
        Agency agency = new Agency(124, "Agency Name", "Power Street, F");
        Employee administrator = new Employee("admin@this.app");

        Employee employee = new Employee("Employee Name", "employee@this.app", 1234, 1234, "Employee address", "(557) 543-2356", role, agency, administrator);
        Employee clone = employee.clone();
        assertEquals(employee, clone);
    }
}*/
