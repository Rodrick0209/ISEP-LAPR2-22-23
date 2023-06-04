package pt.ipp.isep.dei.esoft.project.domain;

import java.util.Comparator;
import java.util.Objects;

/**
 * The type Employee.
 */
public class Employee {
    private final String name;
    private final String email;
    private final int ccNumber;
    private final String taxNumber;
    private final String address;
    private final String phoneNumber;
    private Role role;
    private Agency agency;
    private Employee administrator;

    private static final String initialString = "n/a";
    private static final int initialValue = 0;

    /**
     * Instantiates a new Employee.
     *
     * @param name          the name
     * @param email         the email
     * @param ccNumber      the cc number
     * @param taxNumber     the tax number
     * @param address       the address
     * @param phoneNumber   the phone number
     * @param role          the role
     * @param agency        the agency
     * @param administrator the administrator
     */
    public Employee(String name, String email, int ccNumber, String taxNumber, String address, String phoneNumber, Role role, Agency agency, Employee administrator){
        this.name = name;
        int count = 0;
        for (char c : email.toCharArray()) {
            if (c == '@') {
                count++;
            }
        }
        if (count != 1) {
            throw new IllegalArgumentException("Invalid email address");
        } else this.email = email;
        this.ccNumber = ccNumber;
        this.taxNumber = taxNumber;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.role = role;
        this.agency = agency;
        this.administrator = administrator;
    }

    /**
     * Instantiates a new Employee.
     *
     * @param email the email
     */
    public Employee(String email){
        this.name = initialString;
        int count = 0;
        for (char c : email.toCharArray()) {
            if (c == '@') {
                count++;
            }
        }
        if (count != 1) {
            throw new IllegalArgumentException("Invalid email address");
        } else this.email = email;
        this.ccNumber = initialValue;
        this.taxNumber = initialString;
        this.address = initialString;
        this.phoneNumber = initialString;
    }



    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Employee)) {
            return false;
        }
        Employee employee = (Employee) o;
        return email.equals(employee.email);
    }

    /**
     * Gets email.
     *
     * @return the email
     */
    public String getEmail() { return email;}

    public int hashCode() {
        return Objects.hash(email);
    }

    /**
     * Has email boolean.
     *
     * @param email the email
     * @return the boolean
     */
    public boolean hasEmail(String email) { return email.equalsIgnoreCase(this.email); }


    public Employee clone() {
        return new Employee(this.name, this.email, this.ccNumber, this.taxNumber, this.address, this.phoneNumber, this.role, this.agency, this.administrator);
    }

    /**
     * Gets name.
     *
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Compare to int.
     *
     * @param o the o
     * @return the int
     */
    public int compareTo(Employee o) {
        return this.name.compareTo(o.getName());
    }


    /**
     * Gets agency.
     *
     * @return the agency
     */
    public Agency getAgency() {
        return agency;
    }


    /**
     * Add announcements.
     */
    public void addAnnouncements() {

    }
}
