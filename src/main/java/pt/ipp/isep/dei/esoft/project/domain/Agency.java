package pt.ipp.isep.dei.esoft.project.domain;

import java.util.Objects;

public class Agency implements Comparable<Agency> {

    private final int id;
    private String designation;
    private String location;
    private String emailAddress;
    private String phoneNumber;
    private Employee administrator;

    public Agency(int id){
        this.id = id;
    }


    public Agency(int id, String designation, String location, String emailAddress, String phoneNumber, Employee administrator){
        this.id = id;
        if(designation.replace(" ", "").length() > 40){
            throw new IllegalArgumentException("Agency Designation is longer than 40 characters");
        } else {
            this.designation = designation;
        }
        this.location = location;
        int count = 0;
        for (char c : emailAddress.toCharArray()) {
            if (c == '@') {
                count++;
            }
        }
        if (count != 1) {
            throw new IllegalArgumentException("Invalid email address");
        } else this.emailAddress = emailAddress;
        if(!phoneNumber.contains("(") && !phoneNumber.contains(")") && !phoneNumber.contains("-")){
            throw new IllegalArgumentException("Invalid Phone Number");
        } else {
            this.phoneNumber = phoneNumber;
        }
        this.administrator = administrator;
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

    public int compareTo(Agency o) {
        return Integer.compare(this.id, o.getID());
    }
}
