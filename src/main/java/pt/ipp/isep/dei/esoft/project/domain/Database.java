package pt.ipp.isep.dei.esoft.project.domain;

import pt.ipp.isep.dei.esoft.project.repository.Repositories;
import pt.ipp.isep.dei.esoft.project.ui.console.utils.Files;

import java.io.*;

public class Database {

    public static void writeFile() {
        Repositories repositories = Repositories.getInstance().clone();
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(Files.path + "data.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOutputStream);
            out.writeObject(repositories);
            out.close();
            fileOutputStream.close();
        } catch (IOException e) {
            throw new IllegalArgumentException("Error. Data not found.");
        }
    }

    public static void readFile() {
        try {
            FileInputStream fileInputStream = new FileInputStream(Files.path + "data.ser");
            ObjectInputStream in = new ObjectInputStream(fileInputStream);
            Repositories repositories = (Repositories) in.readObject();
            in.close();
            fileInputStream.close();
        } catch (IOException | ClassNotFoundException e) {
            throw new IllegalArgumentException("Error. Data not found.");
        }
    }
}