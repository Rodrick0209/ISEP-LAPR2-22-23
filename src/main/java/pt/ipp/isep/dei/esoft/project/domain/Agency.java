package pt.ipp.isep.dei.esoft.project.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * The type Agency.
 */
public class Agency implements Serializable {

    private final int id;
    private String designation;
    private String location;
    private String emailAddress;
    private String phoneNumber;
    private Employee administrator;
    private List<Property> properties;

    /**
     * Instantiates a new Agency.
     *
     * @param id the id
     */
    public Agency(int id){
        this.id = id;
    }


    /**
     * Instantiates a new Agency.
     *
     * @param id            the id
     * @param designation   the designation
     * @param location      the location
     * @param emailAddress  the email address
     * @param phoneNumber   the phone number
     * @param administrator the administrator
     */
    public Agency(int id, String designation, String location, String emailAddress, String phoneNumber, Employee administrator){
        this.id = id;
        this.designation = designation;
        this.location = location;
        this.emailAddress = emailAddress;
        this.phoneNumber = phoneNumber;
        this.administrator = administrator;
        this.properties = new ArrayList<>();
    }

    public void addProperty(Property property){
        properties.add(property);
    }

    public int getPropertyCount(){
        return properties.size();
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

    /**
     * Get id int.
     *
     * @return the int
     */
    public int getID(){return id;}

    /**
     * Gets designation.
     *
     * @return the designation
     */
    public String getDesignation() {return designation;}

    public int hashCode() { return Objects.hash(id); }

    public String toString(){
        return String.format("Agency nº%d%n" +
                "Name: %s%n" +
                "Location: %s%n" +
                "Email Address: %s%n" +
                "Phone Number: %s%n"
                , this.id, this.designation, this.location, this.emailAddress, this.phoneNumber);
    }

    public Agency clone(){ return new Agency(this.id, this.designation, this.location, this.emailAddress, this.phoneNumber, this.administrator); }


}
