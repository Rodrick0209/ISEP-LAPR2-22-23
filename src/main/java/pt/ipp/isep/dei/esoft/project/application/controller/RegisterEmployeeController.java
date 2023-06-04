package pt.ipp.isep.dei.esoft.project.application.controller;

import pt.ipp.isep.dei.esoft.project.domain.*;
import pt.ipp.isep.dei.esoft.project.repository.*;
import pt.ipp.isep.dei.esoft.project.ui.console.utils.Files;
import pt.isep.lei.esoft.auth.AuthFacade;
import pt.isep.lei.esoft.auth.domain.model.Email;


import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Optional;

public class RegisterEmployeeController implements FileWriter{
    private AgencyRepository agencyRepository;
    private RoleRepository roleRepository;
    private AuthenticationRepository authenticationRepository;

    private EmployeeRepository employeeRepository;

    public RegisterEmployeeController(){
        getAgencyRepository();
        getRoleRepository();
        getAuthenticationRepository();
    }

    public RegisterEmployeeController(RoleRepository roleRepository, AgencyRepository agencyRepository, AuthenticationRepository authenticationRepository){
        this.roleRepository = roleRepository;
        this.agencyRepository = agencyRepository;
        this.authenticationRepository = authenticationRepository;
    }

    private EmployeeRepository getEmployeeRepository(){
        if(employeeRepository == null){
            Repositories repositories = Repositories.getInstance();
            employeeRepository = repositories.getEmployeeRepository();
        }
        return employeeRepository;
    }
    private AgencyRepository getAgencyRepository() {
        if(agencyRepository == null){
            Repositories repositories = Repositories.getInstance();
            agencyRepository = repositories.getAgencyRepository();
        }
        return agencyRepository;
    }

    private RoleRepository getRoleRepository() {
        if(roleRepository == null){
            Repositories repositories = Repositories.getInstance();
            roleRepository = repositories.getRoleRepository();
        }
        return roleRepository;
    }

    private AuthenticationRepository getAuthenticationRepository(){
        if(authenticationRepository == null){
            Repositories repositories = Repositories.getInstance();
            authenticationRepository = repositories.getAuthenticationRepository();
        }
        return authenticationRepository;
    }


    public Optional<Employee> createEmployee(String name, String email, int ccNumber, String taxNumber, String address, String phoneNumber, String roleName, int agencyID){
        Agency agency = getAgencyByID(agencyID);
        Role role = getRoleByName(roleName);

        Employee administrator = getAdministratorFromSession();

        Optional<Employee> newEmployee = Optional.empty();
        if(getEmployeeRepository() != null){
            newEmployee = getEmployeeRepository().createEmployee(name, email, ccNumber, taxNumber, address, phoneNumber, role, agency, administrator);
        }
        return newEmployee;
    }

    private Employee getAdministratorFromSession() {
        Email email = getAuthenticationRepository().getCurrentUserSession().getUserId();
        return new Employee(email.getEmail());
    }

    private Agency getAgencyByID(int agencyID){
        return getAgencyRepository().getAgencyByID(agencyID);
    }

    private Role getRoleByName(String roleName){
        return getRoleRepository().getRoleByName(roleName);
    }

    public List<Agency> getAgencies(){
        return getAgencyRepository().getAgencies();
    }

    public List<Role> getRoles(){
        return getRoleRepository().getRoles();
    }

    public boolean addUserWithRole(String name,String email, String pwd, String roleId){
        return getAuthenticationRepository().addUserWithRole(name, email, pwd, roleId);
    }

    public String generatePassword(){
        PasswordGenerator passwordGenerator = new PasswordGenerator();
        return passwordGenerator.generatePassword();
    }

    public void writeFile(String email, String pwd) {
        String fileName = Files.path + "emailEmployee.txt";
        try {
            PrintWriter pw = new PrintWriter(fileName);
            pw.printf("Welcome to Real State USA! Your password to login in this application is:");
            pw.println();
            pw.println(pwd);
            pw.println();
            pw.println("Real State USA Ltd.");
            pw.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }
    }

    public void sendEmailToEmployee(String email){
        SendEmail.sendEmailToEmployee(email);
    }
}