package pt.ipp.isep.dei.esoft.project.application.controller;

import pt.ipp.isep.dei.esoft.project.domain.FileWriter;
import pt.ipp.isep.dei.esoft.project.domain.PasswordGenerator;
import pt.ipp.isep.dei.esoft.project.domain.SendEmail;
import pt.ipp.isep.dei.esoft.project.repository.AuthenticationRepository;
import pt.ipp.isep.dei.esoft.project.repository.Repositories;
import pt.ipp.isep.dei.esoft.project.ui.console.utils.Files;

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
        String fileName = Files.path + "emailUser.txt";
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

    public String generatePassword(){
        PasswordGenerator passwordGenerator = new PasswordGenerator();
        return passwordGenerator.generatePassword();
    }

    public boolean addUserWithRole(String name, String email, String pwd, String roleId){
        return getAuthenticationRepository().addUserWithRole(name, email, pwd, roleId);
    }

    public void sendEmailToUser(String email){
        SendEmail.sendEmailToUser(email);
    }
}
