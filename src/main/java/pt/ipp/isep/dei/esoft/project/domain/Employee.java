package pt.ipp.isep.dei.esoft.project.domain;

import java.util.Objects;

public class Employee {
    private String name;
    private final String email;
    private int ccNumber;
    private int taxNumber;
    private String address;
    private String phoneNumber;
    private Role role;
    private Agency agency;
    private Employee administrator;

    public Employee(String name, String email, int ccNumber, int taxNumber, String address, String phoneNumber, Role role, Agency agency, Employee administrator){
        this.name = name;
        if(!email.contains("@")){
            throw new IllegalArgumentException("Invalid email address");
        } else {
            this.email = email;
        }
        this.ccNumber = ccNumber;
        this.taxNumber = taxNumber;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.role = role;
        this.agency = agency;
        this.administrator = administrator;
    }

    public Employee(String email){
        if(!email.contains("@")){
            throw new IllegalArgumentException("Invalid email address");
        } else {
            this.email = email;
        }
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

    public int hashCode() {
        return Objects.hash(email);
    }

    public boolean hasEmail(String email) { return email.equalsIgnoreCase(this.email); }


    public Employee clone() {
        return new Employee(this.email);
    }
}
