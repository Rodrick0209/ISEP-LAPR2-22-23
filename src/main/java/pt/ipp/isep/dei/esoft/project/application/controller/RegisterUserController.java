package pt.ipp.isep.dei.esoft.project.application.controller;

import pt.ipp.isep.dei.esoft.project.domain.*;
import pt.ipp.isep.dei.esoft.project.repository.AuthenticationRepository;
import pt.ipp.isep.dei.esoft.project.repository.Repositories;
import pt.ipp.isep.dei.esoft.project.repository.UserRepository;
import pt.ipp.isep.dei.esoft.project.ui.console.utils.Files;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Optional;

/**
 * The type Register user controller.
 */
public class RegisterUserController implements FileWriter {
    private AuthenticationRepository authenticationRepository;
    private UserRepository userRepository;

    /**
     * Instantiates a new Register user controller.
     */
    public RegisterUserController(){
        getAuthenticationRepository();
    }

    /**
     * Instantiates a new Register user controller.
     *
     * @param authenticationRepository the authentication repository
     */
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

    private UserRepository getUserRepository(){
        if(userRepository == null){
            Repositories repositories = Repositories.getInstance();
            userRepository = repositories.getUserRepository();
        }
        return userRepository;
    }

    public void writeFile(VisitRequest visitRequest, String pwd) {
        String fileName = Files.pathTXT + "emailUser.txt";
        try {
            PrintWriter pw = new PrintWriter(fileName);
            pw.println("Welcome to Real State USA! Your password to login in this application is:");
            pw.println();
            pw.println(pwd);
            pw.println();
            pw.println("Real State USA Ltd.");
            pw.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }
    }

    public Optional<User> createUser(String name, String email, String pwd, String role){
        Optional<User> newUser = Optional.empty();
        if(getUserRepository() != null){
            newUser = getUserRepository().createUser(name, email, pwd, role);
        }
        return newUser;
    }

    /**
     * Generate password string.
     *
     * @return the string
     */
    public String generatePassword(){
        PasswordGenerator passwordGenerator = new PasswordGenerator();
        return passwordGenerator.generatePassword();
    }

    /**
     * Add user with role boolean.
     *
     * @param name   the name
     * @param email  the email
     * @param pwd    the pwd
     * @param roleId the role id
     * @return the boolean
     */
    public boolean addUserWithRole(String name, String email, String pwd, String roleId){
        return getAuthenticationRepository().addUserWithRole(name, email, pwd, roleId);
    }

    /**
     * Send email to user.
     *
     * @param email the email
     */
    public void sendEmailToUser(String email){
        SendEmail.sendEmailToUser(email);
    }
}
