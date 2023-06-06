package pt.ipp.isep.dei.esoft.project.repository;

import pt.ipp.isep.dei.esoft.project.domain.Role;

import java.io.Serializable;
import java.util.*;

/**
 * The type Role repository.
 */
public class RoleRepository implements Serializable {

    private final List<Role> roles = new ArrayList<>();

    /**
     * Get role by name role.
     *
     * @param roleName the role name
     * @return the role
     */
    public Role getRoleByName(String roleName){
        Role role = null;
        for(Role r: roles){
            if(r.getName().equalsIgnoreCase(roleName)){
                role = r;
            }
        }
        return role;
    }

    /**
     * Add optional.
     *
     * @param role the role
     * @return the optional
     */
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

    /**
     * Get roles list.
     *
     * @return the list
     */
    public List<Role> getRoles(){
        return List.copyOf(roles);
    }

}
