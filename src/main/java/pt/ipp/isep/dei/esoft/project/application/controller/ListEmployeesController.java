package pt.ipp.isep.dei.esoft.project.application.controller;

import pt.ipp.isep.dei.esoft.project.domain.Employee;
import pt.ipp.isep.dei.esoft.project.repository.AgencyRepository;
import pt.ipp.isep.dei.esoft.project.repository.EmployeeRepository;
import pt.ipp.isep.dei.esoft.project.repository.Repositories;

import java.util.Comparator;
import java.util.List;

public class ListEmployeesController {

    private EmployeeRepository employeeRepository;

    private AgencyRepository agencyRepository;

    public ListEmployeesController() {
    }

    public ListEmployeesController(EmployeeRepository employeeRepository, AgencyRepository agencyRepository) {
        this.employeeRepository = employeeRepository;
        this.agencyRepository = agencyRepository;
    }

    public EmployeeRepository getEmployeeRepository() {
        if(employeeRepository == null){
            Repositories repositories = Repositories.getInstance();
            employeeRepository = repositories.getEmployeeRepository();
        }
        return employeeRepository;
    }

    public AgencyRepository getAgencyRepository() {
        if(agencyRepository == null){
            Repositories repositories = Repositories.getInstance();
            agencyRepository = repositories.getAgencyRepository();
        }
        return agencyRepository;
    }

    public List<Employee> getEmployeesSortedByAgencyAndName() {
        return getEmployeeRepository().getEmployeesSortedByAgencyAndName();
    }

    public List<Employee> getEmployees(){
        return getEmployeeRepository().getEmployees();
    }
}
