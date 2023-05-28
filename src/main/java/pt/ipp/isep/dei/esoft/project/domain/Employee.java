package pt.ipp.isep.dei.esoft.project.domain;

import java.util.Objects;

/**
 * The type Employee.
 */
public class Employee {
    private String name;
    private final String email;
    private int ccNumber;
    private String taxNumber;
    private String address;
    private String phoneNumber;
    private Role role;
    private Agency agency;
    private Employee administrator;

    private static final String initialString = "n/a";
    private static final String initialEmailString = "test@this.app";
    private static final int initialValue = 0;
    private static final Role initialRole = new Role("n/a");

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
        return new Employee(this.email);
    }
}
