package pt.ipp.isep.dei.esoft.project.domain;

import java.io.Serializable;
import java.util.Objects;

public class User implements Serializable {
    private String name;
    private String email;
    private String pwd;
    private String role;

    public User(String name, String email, String pwd, String role) {
        this.name = name;
        this.email = email;
        this.pwd = pwd;
        this.role = role;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPwd() {
        return pwd;
    }

    public String getRole() {
        return role;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(name, user.name) && Objects.equals(email, user.email) && Objects.equals(pwd, user.pwd) && Objects.equals(role, user.role);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, email, pwd, role);
    }

    public User clone(){
        return new User(name, email, pwd, role);
    }
}
