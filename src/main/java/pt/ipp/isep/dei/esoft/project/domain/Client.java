package pt.ipp.isep.dei.esoft.project.domain;

import pt.isep.lei.esoft.auth.domain.model.Email;

import java.util.ArrayList;
import java.util.List;

public class Client {

    private static int clientIdCounter = 0;
    private int clientId;
    private String clientName;
    private int phoneNumber;
    private Email clientEmail;
    List<String> mailbox = new ArrayList<>();

    public Client(String clientName, int phoneNumber, Email clientEmail) {
        this.clientName = clientName;
        this.phoneNumber = phoneNumber;
        this.clientEmail = clientEmail;
    }

    public void addEmail(String emailToAdd) {
        mailbox.add(emailToAdd);
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Email getClientEmail() {
        return clientEmail;
    }

    public void setClientEmail(Email clientEmail) {
        this.clientEmail = clientEmail;
    }

    public int getClientId() {
        return clientId;
    }
}
