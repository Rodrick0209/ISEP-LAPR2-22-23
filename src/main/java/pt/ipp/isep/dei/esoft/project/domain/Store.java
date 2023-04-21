package pt.ipp.isep.dei.esoft.project.domain;

public class Store {
    private final Integer id;
    private final String designation;
    private final String location;
    private final String emailAddress;
    private final String phoneNumber;
    private final Administrator administrator;

    public Store(Integer id, String designation, String location, String emailAddress, String phoneNumber, Administrator administrator)
    {
        this.id = id;
        this.designation = designation;
        this.location = location;
        this.emailAddress = emailAddress;
        this.phoneNumber = phoneNumber;
        this.administrator = administrator;
    }
}
