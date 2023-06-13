package pt.ipp.isep.dei.esoft.project.repository;

import pt.ipp.isep.dei.esoft.project.domain.User;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UserRepository implements Serializable {
    private final List<User> users = new ArrayList<>();

    public Optional<User> createUser(String name, String email, String pwd, String role){
        Optional<User> optionalValue = Optional.empty();

        User user = new User(name, email, pwd, role);
        if(addUser(user)){
            optionalValue = Optional.of(user);
        }
        return optionalValue;
    }

    public Optional<User> add(User user){
        Optional<User> newUser = Optional.empty();
        boolean operationSuccess = false;
        if(validateUser(user)){
            newUser = Optional.of(user.clone());
            operationSuccess = users.add(newUser.get());
        }
        if(!operationSuccess){
            newUser = Optional.empty();
        }
        return newUser;
    }

    public boolean addUser(User user){
        boolean operationSuccess = false;
        if(validateUser(user)){
            operationSuccess = users.add(user);
        }
        return operationSuccess;
    }

    private boolean validateUser(User user){
        return !users.contains(user);
    }

    public List<User> getUsers(){
        return List.copyOf(users);
    }
}
