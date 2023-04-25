package pt.ipp.isep.dei.esoft.project.domain;

import java.util.Objects;

public class Employee {
    private final String name;
    private final String email;
    private final int ccNumber;
    private final int taxNumber;
    private final String address;
    private final Role role;
    private final Agency agency;
    private final Administrator administrator;


    public Employee(String name, String email, int ccNumber, int taxNumber, String address, Role role, Agency agency, Administrator administrator){
        this.name = name;
        this.email = email;
        this.ccNumber = ccNumber;
        this.taxNumber = taxNumber;
        this.address = address;
        this.role = role;
        this.agency = agency;
        this.administrator = administrator;
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Employee)) {
            return false;
        }
        Employee employee = (Employee) o;
        return administrator.equals(employee.administrator);
    }

    public int hashCode() {
        return Objects.hash(administrator);
    }

    public Employee clone() {
        return new Employee(this.name, this.email, this.ccNumber, this.taxNumber, this.address, this.role, this.agency, this.administrator);
    }
}
