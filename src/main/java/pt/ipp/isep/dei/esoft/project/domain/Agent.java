package pt.ipp.isep.dei.esoft.project.domain;

import java.util.Objects;

/**
 * The type Agent.
 */
public class Agent{
    private String name;
    private final String email;
    private int ccNumber;
    private int taxNumber;
    private String address;
    private String phoneNumber;
    private Role role;
    private Agency agency;

    /**
     * Instantiates a new Agent.
     *
     * @param name        the name
     * @param email       the email
     * @param ccNumber    the cc number
     * @param taxNumber   the tax number
     * @param address     the address
     * @param phoneNumber the phone number
     * @param role        the role
     * @param agency      the agency
     */
    public Agent(String name, String email, int ccNumber, int taxNumber, String address, String phoneNumber, Role role, Agency agency){
        this.name = name;
        if(!email.contains("@")){
            throw new IllegalArgumentException("Invalid email address");
        } else {
            this.email = email;
        }
        this.ccNumber = ccNumber;
        this.taxNumber = taxNumber;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.role = role;
        this.agency = agency;
    }

    /**
     * Instantiates a new Agent.
     *
     * @param email the email
     */
    public Agent(String email){
        if(!email.contains("@")){
            throw new IllegalArgumentException("Invalid email address");
        } else {
            this.email = email;
        }
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Agent)) {
            return false;
        }
        Agent agent = (Agent) o;
        return email.equals(agent.email);
    }

    public int hashCode() {
        return Objects.hash(email);
    }

    /**
     * Has email boolean.
     *
     * @param email the email
     * @return the boolean
     */
    public boolean hasEmail(String email) { return email.equalsIgnoreCase(this.email); }


    public Agent clone() {
        return new Agent(this.name, this.email, this.ccNumber, this.taxNumber, this.address, this.phoneNumber, this.role, this.agency ).clone();
    }
}
