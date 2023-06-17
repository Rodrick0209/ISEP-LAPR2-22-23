package pt.ipp.isep.dei.esoft.project.ui.gui.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import pt.ipp.isep.dei.esoft.project.repository.AuthenticationRepository;
import pt.isep.lei.esoft.auth.UserSession;
import pt.isep.lei.esoft.auth.domain.model.User;
import pt.isep.lei.esoft.auth.domain.model.UserRole;
import pt.isep.lei.esoft.auth.domain.store.UserRoleStore;
import pt.isep.lei.esoft.auth.domain.store.UserStore;
import pt.isep.lei.esoft.auth.mappers.UserMapper;
import pt.isep.lei.esoft.auth.mappers.UserRoleMapper;
import pt.isep.lei.esoft.auth.mappers.dto.UserDTO;
import pt.isep.lei.esoft.auth.mappers.dto.UserRoleDTO;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

public class SceneController {

    @FXML
    public static void loadMainMenuScene(ActionEvent actionEvent) throws IOException {
        AuthenticationRepository authenticationRepository = new AuthenticationRepository();
        authenticationRepository.getCurrentUserSession().doLogout();
        FXMLLoader fxmlLoader = new FXMLLoader(SceneController.class.getResource("/fxml/mainMenuUI.fxml"));
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        Parent root = fxmlLoader.load();
        Scene agentScene = new Scene(root);
        stage.setScene(agentScene);
        stage.show();
    }

    public static void switchToSceneOnButtonClick(ActionEvent actionEvent, String sceneName) throws IOException {
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(SceneController.class.getResource(sceneName));
        Parent root = fxmlLoader.load();
        Scene agentScene = new Scene(root);
        stage.setScene(agentScene);
        stage.show();
    }

    public static void switchToSceneOnMenuBarButtonClick(Stage sourceNode, String sceneName) throws IOException {
        Stage stage = (Stage) sourceNode.getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(SceneController.class.getResource(sceneName));
        try {
            Parent root = fxmlLoader.load();
            Scene agentScene = new Scene(root);
            stage.setScene(agentScene);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private UserSession userSession = new UserSession();
    private UserRoleStore roles = new UserRoleStore();
    private UserStore users = new UserStore();

    public SceneController(UserStore users) {
        this.users = users;
    }

    public boolean addUserRole(String id, String description) {
        UserRole role = this.roles.create(id, description);
        return this.roles.add(role);
    }

    public boolean existsRole(String id) {
        return this.roles.exists(id);
    }

    public boolean removeRole(String id) {
        Optional<UserRole> found = this.roles.getById(id);
        return found.isPresent() ? this.roles.remove((UserRole) found.get()) : false;
    }

    public List<UserRoleDTO> getUserRoles() {
        UserRoleMapper mapper = new UserRoleMapper();
        return mapper.toDTO(this.roles.getAll());
    }

    public Optional<UserRoleDTO> getRole(String id) {
        Optional<UserRole> found = this.roles.getById(id);
        if (found.isPresent()) {
            UserRoleMapper mapper = new UserRoleMapper();
            return Optional.of(mapper.toDTO((UserRole) found.get()));
        } else {
            return Optional.empty();
        }
    }

    public boolean changeUserRoleDescription(String id, String description) {
        Optional<UserRole> found = this.roles.getById(id);
        if (found.isPresent()) {
            UserRole role = (UserRole) found.get();
            return role.changeDescription(description);
        } else {
            return false;
        }
    }

    public boolean addUser(String name, String email, String pwd) {
        User user = this.users.create(name, email, pwd);
        return this.users.add(user);
    }

    public boolean addUserWithRole(String name, String email, String pwd, String roleId) {
        Optional<UserRole> roleResult = this.roles.getById(roleId);
        if (!roleResult.isPresent()) {
            return false;
        } else {
            User user = this.users.create(name, email, pwd);
            user.addRole((UserRole) roleResult.get());
            return this.users.add(user);
        }
    }

    public boolean addUserWithRoles(String name, String email, String pwd, String[] rolesId) {
        User user = this.users.create(name, email, pwd);
        String[] var6 = rolesId;
        int var7 = rolesId.length;

        for (int var8 = 0; var8 < var7; ++var8) {
            String roleId = var6[var8];
            Optional<UserRole> roleResult = this.roles.getById(roleId);
            if (roleResult.isPresent()) {
                user.addRole((UserRole) roleResult.get());
            }
        }

        return this.users.add(user);
    }

    public boolean existsUser(String email) {
        return this.users.exists(email);
    }

    public boolean removeUser(String email) {
        Optional<User> found = this.users.getById(email);
        return found.isPresent() ? this.users.remove((User) found.get()) : false;
    }

    public List<UserDTO> getUsers() {
        UserMapper mapper = new UserMapper();
        return mapper.toDTO(this.users.getAll());
    }

    public List<UserDTO> getUsersWithRole(String roleId) {
        UserMapper mapper = new UserMapper();
        return mapper.toDTO(this.users.getAllWithRole(roleId));
    }

    public Optional<UserDTO> getUser(String email) {
        Optional<User> found = this.users.getById(email);
        if (found.isPresent()) {
            UserMapper mapper = new UserMapper();
            return Optional.of(mapper.toDTO((User) found.get()));
        } else {
            return Optional.empty();
        }
    }

    public boolean updateUser(UserDTO dto) {
        Optional<User> found = this.users.getById(dto.getId());
        if (found.isPresent()) {
            User user = (User) found.get();
            String oldName = user.getName();
            if (user.changeName(dto.getName())) {
                List<UserRole> roles = new ArrayList();
                Iterator var6 = dto.getRoles().iterator();

                while (var6.hasNext()) {
                    UserRoleDTO roleDto = (UserRoleDTO) var6.next();
                    Optional<UserRole> roleResult = this.roles.getById(roleDto.getId());
                    if (roleResult.isPresent()) {
                        roles.add((UserRole) roleResult.get());
                    }
                }

                if (user.changeRoles(roles)) {
                    return true;
                }

                user.changeName(oldName);
            }
        }

        return false;
    }

    public UserSession doLogin(String email, String password) {
        Optional<User> result = this.users.getById(email);
        if (result.isPresent()) {
            User user = (User) result.get();
            if (user.hasPassword(password)) {
                this.userSession = new UserSession(user);
            }
        }

        return this.userSession;
    }

    public void doLogout() {
        this.userSession.doLogout();
    }

    public UserSession getCurrentUserSession() {
        return this.userSession;
    }


}









