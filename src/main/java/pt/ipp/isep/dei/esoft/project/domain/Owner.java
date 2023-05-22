package pt.ipp.isep.dei.esoft.project.domain;

import java.util.Objects;

public class Owner {
    private String name;
    private int ccNumber;
    private String taxNumber;
    private final String emailAddress;
    private String phoneNumber;

    public Owner(String name, int ccNumber, String taxNumber, String emailAddress, String phoneNumber) {
        this.name = name;
        this.ccNumber = ccNumber;
        this.taxNumber = taxNumber;
        if (!emailAddress.contains("@")) {
            throw new IllegalArgumentException("Invalid email address");
        } else {
            this.emailAddress = emailAddress;
        }
        this.phoneNumber = phoneNumber;
    }

    public Owner(String emailAddress) {
        if (!emailAddress.contains("@")) {
            throw new IllegalArgumentException("Invalid email address");
        } else {
            this.emailAddress = emailAddress;
        }
    }

    public String getEmailAddress(){ return emailAddress; }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Owner)) {
            return false;
        }
        Owner owner = (Owner) o;
        return emailAddress.equals(owner.emailAddress);
    }

    public int hashCode(){
        return Objects.hash(emailAddress);
    }

    public Owner clone(){return new Owner(this.name, this.ccNumber, this.taxNumber, this.emailAddress, this.phoneNumber);}
}