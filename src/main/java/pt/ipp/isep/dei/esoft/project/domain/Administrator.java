package pt.ipp.isep.dei.esoft.project.domain;

import java.util.Objects;

public class Administrator {
    private final String email;

    public Administrator(String email){ this.email = email; }

    public boolean hasEmail(String email){ return email.equalsIgnoreCase(this.email); }

    @Override
    public boolean equals(Object o) {
        if(this == o){
            return true;
        }
        if(!(o instanceof Administrator)){
            return false;
        }
        Administrator administrator = (Administrator) o;
        return email.equals(administrator.email);
    }

    public int hashCode() { return Objects.hash(email); }

    public Administrator clone(){return new Administrator(this.email);}
}
