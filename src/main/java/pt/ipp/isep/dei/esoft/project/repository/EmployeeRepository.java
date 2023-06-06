package pt.ipp.isep.dei.esoft.project.repository;

import pt.ipp.isep.dei.esoft.project.domain.Agency;
import pt.ipp.isep.dei.esoft.project.domain.Employee;
import pt.ipp.isep.dei.esoft.project.domain.Role;

import java.io.Serializable;
import java.util.*;

public class EmployeeRepository implements Serializable {
    private final List<Employee> employees = new ArrayList<>();

    public Employee getEmployeeByEmail(String employeeEmail){
        Employee employee = null;
        for(Employee e : employees){
            if(e.getEmail().equalsIgnoreCase(employeeEmail)){
                employee = e;
            }
        }
        if (employee == null){
            throw new IllegalArgumentException("Employee not found");
        }
        return employee;
    }

    public Optional<Employee> add(Employee employee){
        Optional<Employee> newEmployee = Optional.empty();
        boolean operationSuccess = false;

        if(validateEmployee(employee)){
            newEmployee = Optional.of(employee.clone());
            operationSuccess = employees.add(newEmployee.get());
        }

        if(!operationSuccess){
            newEmployee = Optional.empty();
        }
        return newEmployee;
    }

    public Optional<Employee> createEmployee(String name, String email, int ccNumber, String taxNumber, String address, String phoneNumber, Role role, Agency agency, Employee administrator){
        Optional<Employee> optionalValue = Optional.empty();

        Employee employee = new Employee(name, email, ccNumber, taxNumber, address, phoneNumber, role, agency, administrator);

        if(addEmployee(employee)){
            optionalValue = Optional.of(employee);
        }
        return optionalValue;
    }

    public boolean addEmployee(Employee employee){
        boolean operationSuccess = false;
        if(validateEmployee(employee)){
            operationSuccess = employees.add(employee);
        }
        return operationSuccess;
    }

    private boolean validateEmployee(Employee employee){return !employees.contains(employee);}

    public List<Employee> getEmployee() {
        return List.copyOf(employees);
    }
}
