package pt.ipp.isep.dei.esoft.project.domain;

import java.io.Serializable;
import java.util.Objects;

/**
 * The type Owner.
 */
public class Owner implements Serializable {
    private String name;
    private int ccNumber;
    private String  taxNumber;
    private final String emailAddress;
    private String phoneNumber;

    /**
     * Instantiates a new Owner.
     *
     * @param name         the name
     * @param ccNumber     the cc number
     * @param taxNumber    the tax number
     * @param emailAddress the email address
     * @param phoneNumber  the phone number
     */
    public Owner(String name, int ccNumber, String taxNumber, String emailAddress, String phoneNumber) {
        this.name = name;
        this.ccNumber = ccNumber;
        this.taxNumber = taxNumber;
        int count = 0;
        for (char c : emailAddress.toCharArray()) {
            if (c == '@') {
                count++;
            }
        }
        if (count != 1) {
            throw new IllegalArgumentException("Invalid email address");
        } else this.emailAddress = emailAddress;
        this.phoneNumber = phoneNumber;
    }

    /**
     * Instantiates a new Owner.
     *
     * @param emailAddress the email address
     */
    public Owner(String emailAddress) {
        int count = 0;
        for (char c : emailAddress.toCharArray()) {
            if (c == '@') {
                count++;
            }
        }
        if (count != 1) {
            throw new IllegalArgumentException("Invalid email address");
        } else this.emailAddress = emailAddress;
    }

    /**
     * Get email address string.
     *
     * @return the string
     */
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

    @Override
    /*public String toString() {
        return "Owner{" +
                "name='" + name + '\'' +
                ", ccNumber=" + ccNumber +
                ", taxNumber='" + taxNumber + '\'' +
                ", emailAddress='" + emailAddress + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }*/


    public Owner clone(){return new Owner(this.name, this.ccNumber, this.taxNumber, this.emailAddress, this.phoneNumber);
    }

    @Override
    public String toString() {
        return "emailAddress:" + emailAddress ;
    }
}
