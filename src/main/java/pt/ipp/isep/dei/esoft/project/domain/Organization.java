package pt.ipp.isep.dei.esoft.project.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class Organization {

    private final String description;
    List<Employee> employees = new ArrayList<>();

    List<Agency> agencies = new ArrayList<>();

    List<Announcement> announcements = new ArrayList<>();

    public Optional<Employee> createEmployee(String name, String email, int ccNumber, int taxNumber, String address, String phoneNumber, Role role, Agency agency, Employee administrator) {
        Optional<Employee> optionalValue = Optional.empty();

        Employee employee = new Employee(name, email, ccNumber, taxNumber, address, phoneNumber, role, agency, administrator);

        if (addEmployee(employee)) {
            optionalValue = Optional.of(employee);
        }
        return optionalValue;
    }

    public Optional<Announcement> createAnnouncement(Property property, String description, double commission, Employee agent){
        Optional<Announcement> optionalValue = Optional.empty();

        Announcement announcement = new Announcement(property, description, commission, agent);

        if(addAnnouncement(announcement)) {
            optionalValue = Optional.of(announcement);
        }
        return optionalValue;
    }

    public Optional<Agency> createAgency(int id, String designation, String location, String emailAddress, String phoneNumber, Employee administrator) {
        Optional<Agency> optionalValue = Optional.empty();

        Agency agency = new Agency(id, designation, location, emailAddress, phoneNumber, administrator);

        if(addAgency(agency)){
            optionalValue = Optional.of(agency);
        }
        return optionalValue;
    }

    public boolean employs(Employee employee){
        return employees.contains(employee);
    }

    public boolean employeeHasEmail(String email) {
        boolean result = false;
        for(Employee employee : employees ) {
            if (employee.hasEmail(email)) {
                result = true;
            }
        }
        return result;
    }

    public Organization(String description){
        this.description = description;
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Organization)) {
            return false;
        }
        Organization that = (Organization) o;
        return description.equals(that.description);
    }

    public int hashCode() {
        return Objects.hash(description);
    }

    //add employee to organization
    public boolean addEmployee(Employee employee) {
        boolean success = false;
        if (validateEmployee(employee)) {
            success = employees.add(employee);
        }
        return success;
    }

    public boolean addAnnouncement(Announcement announcement) {
        boolean success = false;
        if (validateAnnouncement(announcement)) {
            success = announcements.add(announcement);
        }
        return success;
    }

    public boolean addAgency(Agency agency) {
        boolean success = false;
        if(validateAgency(agency)) {
            success = agencies.add(agency);
        }
        return success;
        }


    private boolean validateEmployee(Employee employee) {
        return employeesDoNotContain(employee);
    }

    private boolean employeesDoNotContain(Employee employee) {
        return !employees.contains(employee);
    }

    private boolean validateAnnouncement(Announcement announcement){ return announcementDoNotContain(announcement);}

    private boolean announcementDoNotContain(Announcement announcement){ return !announcements.contains(announcement);}

    private boolean validateAgency(Agency agency) { return agenciesDoNotContain(agency); }

    private boolean agenciesDoNotContain(Agency agency) { return !agencies.contains(agency);}

    //Clone organization
    public Organization clone() {
        Organization clone = new Organization(this.description);
        for (Agency in : this.agencies){
            clone.agencies.add(in.clone());
        }
        for (Announcement in: this.announcements){
            clone.announcements.add(in.clone());
        }
        for (Employee in : this.employees) {
            clone.employees.add(in.clone());
        }
        return clone;
    }
}
