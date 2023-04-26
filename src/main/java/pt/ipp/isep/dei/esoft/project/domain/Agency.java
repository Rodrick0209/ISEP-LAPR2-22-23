package pt.ipp.isep.dei.esoft.project.domain;

import java.util.Objects;

public class Agency {

    private final int id;
    private String designation;

    private String location;
    private String emailAddress;
    private String phoneNumber;

    public Agency(int id){
        this.id = id;
    }

    public Agency(int id, String designation, String location, String emailAddress, String phoneNumber){
        this.id = id;
        this.designation = designation;
        this.location = location;
        this.emailAddress = emailAddress;
        this.phoneNumber = phoneNumber;
    }

    public boolean equals(Object o){
        if (this == o){
            return true;
        }
        if(!(o instanceof Agency)){
            return false;
        }
        Agency that = (Agency) o;
        return id == that.id;
    }

    public int getID(){return id;}

    public int hashCode() { return Objects.hash(id); }

    public Agency clone (){ return new Agency(this.id); }
}
