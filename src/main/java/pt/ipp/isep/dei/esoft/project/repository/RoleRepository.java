package pt.ipp.isep.dei.esoft.project.repository;

import pt.ipp.isep.dei.esoft.project.domain.Role;

import java.util.*;

public class RoleRepository {

    private final List<Role> roles = new ArrayList<>();

    public Role getRoleByName(String roleName){
        Role newRole = new Role(roleName);
        Role role = null;
        if(roles.contains(role)){
            role = roles.get(roles.indexOf(newRole));
        }
        return role;
    }

    public Optional<Role> add(Role role){

        Optional<Role> newRole = Optional.empty();
        boolean operationSuccess = false;

        if(validateRole(role)){
            newRole = Optional.of(role.clone());
            operationSuccess = roles.add(newRole.get());
        }

        if(!operationSuccess){
            newRole = Optional.empty();
        }
        return newRole;
    }

    private boolean validateRole(Role role){
        return (!roles.contains(role));
    }

    public List<Role> getRoles(){
        return List.copyOf(roles);
    }
    ;

}
