package pt.ipp.isep.dei.esoft.project.domain;

import java.util.Objects;

public class Agent{
    private String name;
    private String email;
    private int ccNumber;
    private int taxNumber;
    private String address;
    private String phoneNumber;
    private Role role;
    private Agency agency;

    public Agent(String name, String email, int ccNumber, int taxNumber, String address, String phoneNumber, Role role, Agency agency){
        this.name = name;
        this.email = email;
        this.ccNumber = ccNumber;
        this.taxNumber = taxNumber;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.role = role;
        this.agency = agency;
    }

    public Agent(String email){
        this.email = email;
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

    public boolean hasEmail(String email) { return email.equalsIgnoreCase(this.email); }

    public Employee clone() {
        return new Agent(this.name, this.email, this.ccNumber, this.taxNumber, this.address, this.phoneNumber, this.role, this.agency ).clone();
    }
}
