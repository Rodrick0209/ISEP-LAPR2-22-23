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


    /**
     *
     * @param name the name inputted
     * @param email the email inputted
     * @param ccNumber the cc number inputted
     * @param taxNumber the tax number inputted
     * @param address the address inputted
     * @param phoneNumber the phone number inputted
     * @param role the role selected
     * @param agency the agency selected
     * @param administrator the administrator from session
     * @return employee registered on a list
     */
    public Optional<Employee> createEmployee(String name, String email, int ccNumber, int taxNumber, String address, String phoneNumber, Role role, Agency agency, Employee administrator) {
        Optional<Employee> optionalValue = Optional.empty();

        Employee employee = new Employee(name, email, ccNumber, taxNumber, address, phoneNumber, role, agency, administrator);

        if (addEmployee(employee)) {
            optionalValue = Optional.of(employee);
        }
        return optionalValue;
    }

    /**
     *
     * @param land the property selected
     * @param description the description inputted
     * @param commission the commission inputted
     * @param agent the agent from session
     * @return announcement created on a list
     */
    public Optional<Announcement> createAnnouncement(Property land, String description, double commission, Employee agent){
        Optional<Announcement> optionalValue = Optional.empty();

        Announcement announcement = new Announcement(land, description, commission, agent);

        if(addAnnouncement(announcement)) {
            optionalValue = Optional.of(announcement);
        }
        return optionalValue;
    }

    public Optional<Announcement> createAnnouncement(Property land, String description, Commission commission, Employee agent){
        Optional<Announcement> optionalValue = Optional.empty();

        Announcement announcement = new Announcement(land, description, commission, agent);

        if(addAnnouncement(announcement)) {
            optionalValue = Optional.of(announcement);
        }
        return optionalValue;
    }
    /**
     *
     * @param id the id inputted
     * @param designation the designation inputted
     * @param location the location inputted
     * @param emailAddress the email address inputted
     * @param phoneNumber the phone number inputted
     * @param administrator the administrator from session
     * @return agency registered on a list
     */
    public Optional<Agency> createAgency(int id, String designation, String location, String emailAddress, String phoneNumber, Employee administrator) {
        Optional<Agency> optionalValue = Optional.empty();

        Agency agency = new Agency(id, designation, location, emailAddress, phoneNumber, administrator);

        if(addAgency(agency)){
            optionalValue = Optional.of(agency);
        }
        return optionalValue;
    }

    /**
     *
     * @param employee the employee registered/added
     * @return if the employee is contained in the list of employees of the organization
     */
    public boolean employs(Employee employee){
        return employees.contains(employee);
    }

    /**
     *
     * @param email the email inputted
     * @return if the employee registered/added has this email
     */
    public boolean anyEmployeeHasEmail(String email) {
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

    /**
     *
     * @param employee the employee registered/added
     * @return if the employee is added in the list of employees
     */
    public boolean addEmployee(Employee employee) {
        boolean success = false;
        if (validateEmployee(employee)) {
            success = employees.add(employee);
        }
        return success;
    }

    /**
     *
     * @param announcement the announcement created/added
     * @return if the announcement is added in the list of announcements
     */
    public boolean addAnnouncement(Announcement announcement) {
        boolean success = false;
        if (validateAnnouncement(announcement)) {
            success = announcements.add(announcement);
        }
        return success;
    }

    /**
     *
     * @param agency the agency registered/added
     * @return if the agency is added in the list of agencies
     */
    public boolean addAgency(Agency agency) {
        boolean success = false;
        if(validateAgency(agency)) {
            success = agencies.add(agency);
        }
        return success;
        }


    /**
     *
     * @param employee the employee registered/added
     * @return if employee registered is valid
     */
    private boolean validateEmployee(Employee employee) {
        return employeesDoNotContain(employee);
    }

    /**
     *
     * @param employee the employee registered/added
     * @return if employee registered is not contained on the list of employees
     */
    private boolean employeesDoNotContain(Employee employee) {
        return !employees.contains(employee);
    }


    /**
     *
     * @param announcement the announcement created/added
     * @return if announcement created is valid
     */
    private boolean validateAnnouncement(Announcement announcement){ return announcementDoNotContain(announcement);}

    /**
     *
     * @param announcement the announcement created/added
     * @return if announcement created is not contained on the list of announcements
     */
    private boolean announcementDoNotContain(Announcement announcement){ return !announcements.contains(announcement);}

    /**
     *
     * @param agency the agency registered/added
     * @return if agency registered is valid
     */
    private boolean validateAgency(Agency agency) { return agenciesDoNotContain(agency); }

    /**
     *
     * @param agency the agency registered/added
     * @return if agency registered is not contained on the list of agencies
     */
    private boolean agenciesDoNotContain(Agency agency) { return !agencies.contains(agency);}

    /**
     *
     * @return clone of organization
     */
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
