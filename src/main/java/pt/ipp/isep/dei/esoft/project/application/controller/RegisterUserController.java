package pt.ipp.isep.dei.esoft.project.application.controller;

import pt.ipp.isep.dei.esoft.project.domain.FileWriter;
import pt.ipp.isep.dei.esoft.project.domain.PasswordGenerator;
import pt.ipp.isep.dei.esoft.project.repository.AuthenticationRepository;
import pt.ipp.isep.dei.esoft.project.repository.Repositories;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class RegisterUserController implements FileWriter {
    private AuthenticationRepository authenticationRepository;

    public RegisterUserController(){

    }

    public RegisterUserController(AuthenticationRepository authenticationRepository) {
        this.authenticationRepository = authenticationRepository;
    }

    private AuthenticationRepository getAuthenticationRepository(){
        if(authenticationRepository == null){
            Repositories repositories = Repositories.getInstance();
            authenticationRepository = repositories.getAuthenticationRepository();
        }
        return authenticationRepository;
    }

    public void writeFile(String email, String pwd) {
        String fileName = "password.txt";
        try {
            PrintWriter pw = new PrintWriter(fileName);
            pw.printf("Role: User%n" +
                    "Email: %s%n" +
                    "Password: %s%n", email, pwd);
            pw.println();
            pw.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }
    }

    public String generatePassword(){
        PasswordGenerator passwordGenerator = new PasswordGenerator();
        return passwordGenerator.generatePassword();
    }

    public boolean addUserWithRole(String name, String email, String pwd, String roleId){
        return getAuthenticationRepository().addUserWithRole(name, email, pwd, roleId);
    }

}
