package pt.ipp.isep.dei.esoft.project.repository;

import pt.ipp.isep.dei.esoft.project.domain.Client;
import pt.ipp.isep.dei.esoft.project.domain.CurrentSession;
import pt.isep.lei.esoft.auth.domain.model.Email;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ClientRepository implements Serializable {

    private final List<Client> clients = new ArrayList<>();

    public Client getClientByEmail(String clientEmailAddress){
        Client client = null;
        for(Client o : clients) {
            if(o.getEmailAddress().equals(new Email(clientEmailAddress))){
                client = o;
            }
        }
        if(client == null){
            throw new IllegalArgumentException("Owner not found");
        }
        return client;
    }

    public Optional<Client> add(Client client){

        Optional<Client> newClient = Optional.empty();
        boolean operationSuccess = false;

        if(validateClient(client)){
            newClient = Optional.of(client.clone());
            operationSuccess = clients.add(newClient.get());
        }

        if(!operationSuccess){
            newClient = Optional.empty();
        }
        return newClient;
    }

    public Optional<Client> createClient(String name, Email emailAddress, int phoneNumber){
        Optional<Client> optionalValue = Optional.empty();

        Client client = new Client(name, phoneNumber, emailAddress);

        if(addClient(client)) {
            optionalValue = Optional.of(client);
        }
        return optionalValue;
    }

    public boolean addClient(Client client) {
        boolean success = false;
        if(validateClient(client)) {
            success = clients.add(client);
        }
        return success;
    }

    private boolean validateClient(Client client){return !clients.contains(client); }

    public List<Client> getClients() {return clients;}


    public Client getClient(){
        Client user1 = null;
        List<Client> people = getClients();
        for (Client user: people){
            if (user.getEmailAddress().equals(CurrentSession.getEmail())){
                user1 = user;
            }
        }
        return user1;
    }


}
