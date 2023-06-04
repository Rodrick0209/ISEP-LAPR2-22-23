package pt.ipp.isep.dei.esoft.project.domain;

import pt.isep.lei.esoft.auth.domain.model.Email;

import java.util.ArrayList;
import java.util.List;

/**
 * The type Client.
 */
public class Client {

    private static int clientIdCounter = 0;
    private int clientId;
    private String clientName;
    private int phoneNumber;
    private Email clientEmail;
    /**
     * The Mailbox.
     */
    List<String> mailbox = new ArrayList<>();

    //for testing purposes

    /**
     * Instantiates a new Client.
     */
    public Client() {

    }

    /**
     * Instantiates a new Client.
     *
     * @param clientName  the client name
     * @param phoneNumber the phone number
     * @param clientEmail the client email
     */
    public Client(String clientName, int phoneNumber, Email clientEmail) {
        this.clientName = clientName;
        this.phoneNumber = phoneNumber;
        this.clientEmail = clientEmail;
    }

    /**
     * Add email.
     *
     * @param emailToAdd the email to add
     */
    public void addEmail(String emailToAdd) {
        mailbox.add(emailToAdd);
    }

    /**
     * Gets client name.
     *
     * @return the client name
     */
    public String getClientName() {
        return clientName;
    }

    /**
     * Sets client name.
     *
     * @param clientName the client name
     */
    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    /**
     * Gets phone number.
     *
     * @return the phone number
     */
    public int getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * Sets phone number.
     *
     * @param phoneNumber the phone number
     */
    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    /**
     * Gets client email.
     *
     * @return the client email
     */
    public Email getClientEmail() {
        return clientEmail;
    }

    /**
     * Sets client email.
     *
     * @param clientEmail the client email
     */
    public void setClientEmail(Email clientEmail) {
        this.clientEmail = clientEmail;
    }

    /**
     * Gets client id.
     *
     * @return the client id
     */
    public int getClientId() {
        return clientId;
    }
}
