package pt.ipp.isep.dei.esoft.project.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class Organization {

    private final String description;
    List<Administrator> administrators = new ArrayList<>();
    List<Employee> employees = new ArrayList<>();

    public Optional<Employee> createEmployee(String name, String email, int ccNumber, int taxNumber, String address, Role role, Agency agency, Administrator administrator) {
        Optional<Employee> optionalValue = Optional.empty();

        Employee employee = new Employee(name, email, ccNumber, taxNumber, address, role, agency, administrator);

        if (addEmployee(employee)) {
            optionalValue = Optional.of(employee);
        }
        return optionalValue;
    }

    public boolean administrates(Administrator administrator){
        return administrators.contains(administrator);
    }

    public boolean administratorHasEmail(String email) {
        boolean result = false;
        for(Administrator administrator : administrators ) {
            if (administrator.hasEmail(email)) {
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


    private boolean validateEmployee(Employee employee) {
        return employeesDoNotContain(employee);
    }

    private boolean employeesDoNotContain(Employee employee) {
        return !employees.contains(employee);
    }

    //Clone organization
    public Organization clone() {
        Organization clone = new Organization(this.description);
        for (Administrator in : this.administrators) {
            clone.administrators.add(in.clone());
        }
        for (Employee in : this.employees) {
            clone.employees.add(in.clone());
        }
        return clone;
    }
}
