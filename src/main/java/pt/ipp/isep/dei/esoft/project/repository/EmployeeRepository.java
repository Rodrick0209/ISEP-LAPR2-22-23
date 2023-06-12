package pt.ipp.isep.dei.esoft.project.repository;

import pt.ipp.isep.dei.esoft.project.domain.Agency;
import pt.ipp.isep.dei.esoft.project.domain.Agent;
import pt.ipp.isep.dei.esoft.project.domain.Employee;
import pt.ipp.isep.dei.esoft.project.domain.Role;
import java.util.stream.Collectors;

import java.util.*;

/**
 * The type Employee repository.
 */
public class EmployeeRepository {
    private final List<Employee> employees = new ArrayList<>();

    /**
     * Get employee by email employee.
     *
     * @param employeeEmail the employee email
     * @return the employee
     */
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

    /**
     * Add optional.
     *
     * @param employee the employee
     * @return the optional
     */
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

    /**
     * Create employee optional.
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
     * @return the optional
     */
    public Optional<Employee> createEmployee(String name, String email, int ccNumber, String taxNumber, String address, String phoneNumber, Role role, Agency agency, Employee administrator){
        Optional<Employee> optionalValue = Optional.empty();

        Employee employee = new Employee(name, email, ccNumber, taxNumber, address, phoneNumber, role, agency, administrator);

        if(addEmployee(employee)){
            optionalValue = Optional.of(employee);
        }
        return optionalValue;
    }

    /**
     * Add employee boolean.
     *
     * @param employee the employee
     * @return the boolean
     */
    public boolean addEmployee(Employee employee){
        boolean operationSuccess = false;
        if(validateEmployee(employee)){
            operationSuccess = employees.add(employee);
        }
        return operationSuccess;
    }

    private boolean validateEmployee(Employee employee){return !employees.contains(employee);}

    /**
     * Gets employee.
     *
     * @return the employee
     */
    public List<Employee> getEmployee() {
        return List.copyOf(employees);
    }


    /*public List<String> getAgent() {
        List<Employee> filteredAgents = employees.stream()
                .filter(name -> name.startsWith("A"))
                .collect(Collectors.toList());

        System.out.println("Filtered Agents:");
        for (String  : filteredAgents) {
            System.out.println(name);
    }*/
}
