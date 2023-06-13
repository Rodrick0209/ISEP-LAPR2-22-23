package pt.ipp.isep.dei.esoft.project.domain;

import pt.ipp.isep.dei.esoft.project.repository.AuthenticationRepository;
import pt.ipp.isep.dei.esoft.project.repository.Repositories;
import pt.ipp.isep.dei.esoft.project.repository.UserRepository;
import pt.ipp.isep.dei.esoft.project.ui.console.utils.Files;
import pt.isep.lei.esoft.auth.mappers.dto.UserDTO;

import java.io.*;
import java.util.List;
import java.util.Scanner;

public class Database {

    public static void saveData() {
        Repositories repositories = Repositories.getInstance().clone();
        try {
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(Files.pathSER + "data.ser"));
            out.writeObject(repositories);
            out.close();;
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void readData() {
        AuthenticationRepository authenticationRepository = Repositories.getInstance().getAuthenticationRepository();

        try {
           ObjectInputStream in = new ObjectInputStream(new FileInputStream(Files.pathSER + "data.ser"));
           Repositories repositories = (Repositories) in.readObject();
           in.close();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        UserRepository userRepository = Repositories.getInstance().getUserRepository();
        List<User> users = userRepository.getUsers();
        for (User u: users){
            authenticationRepository.addUserWithRole(u.getName(), u.getEmail(), u.getPwd(), u.getRole());
        }
    }
}