package pt.ipp.isep.dei.esoft.project.domain;

import java.util.List;
import java.util.Optional;

public class Company {
    private String description;
    private Administrator administrator;

    public boolean administrates(Administrator administrator) { return this.administrator.equals(administrator); }
    public Company(String description){
        this.description = description;
    }

    public Optional<Store> registerStore (Integer id, String designation, String location, String emailAddress, String phoneNumber, Administrator administrator){
        Store store = new Store(id, designation, location, emailAddress, phoneNumber, administrator);

        addStore(store);

        return store;
    }

    private boolean addStore(Store store){
        return true;
    }

}
